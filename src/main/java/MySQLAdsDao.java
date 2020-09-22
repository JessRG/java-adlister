import com.mysql.jdbc.Driver;

import java.sql.*;


import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) throws SQLException {
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public List<Ad> all() throws SQLException {
        List<Ad> allAds = new ArrayList<>();
        String query = "SELECT * FROM ads";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while(rs.next()) {
            allAds.add(
                    new Ad(
                            rs.getLong("id"), rs.getLong("user_id"),
                            rs.getString("title"), rs.getString("description")
                    )
            );
        }
        return allAds;
    }

    @Override
    public Long insert(Ad ad) throws SQLException {
        Statement stmt = connection.createStatement();
        String query = String.format("INSERT INTO ads (user_id, title, description) VALUES (%d, '%s', '%s')",
                ad.getUserId(), ad.getTitle(), ad.getDescription());
        stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();

        long res = 0;
        if (rs.next()) {
            res = rs.getLong(1);
        }

        return res;
    }
}
