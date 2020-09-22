USE adlister_db;

CREATE TABLE users (
                       id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                       username VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       password VARCHAR(20) NOT NULL,
                       PRIMARY KEY (id)
);

CREATE TABLE ads (
                     id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                     user_id INT UNSIGNED DEFAULT NULL,
                     title VARCHAR(50) NOT NULL,
                     description VARCHAR(250),
                     PRIMARY KEY (id),
                     FOREIGN KEY (user_id) REFERENCES users (id)
);