<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <form method="POST" action="/login.jsp">
        <label for="username">Username: </label>
        <input type="text" id="username" name="username" /><br/>
        <label for="password">Password: </label>
        <input type="password" id="password" name="password" />
        <button type="submit">Submit</button>
    </form>

    <% request.setAttribute("username", request.getParameter("username")); %>
    <% request.setAttribute("password", request.getParameter("password")); %>

    <c:choose>
        <c:when test="${username != null || password != null}">
            <%
                if(request.getParameter("username").equalsIgnoreCase("admin") && request.getParameter("password").equalsIgnoreCase("password")) {
                    response.sendRedirect("/profile.jsp");
                } else {
                    response.sendRedirect("/login.jsp");
                }
            %>
        </c:when>
        <c:otherwise>
        <%-- Need to figure out what to place here --%>
        </c:otherwise>
    </c:choose>


<%--    <%--%>
<%--        if(request.getParameter("username") == null && request.getParameter("password") == null) {--%>
<%--            response.getWriter().println("<h1>Incorrect username and password entry</h1>");--%>
<%--        } else {--%>
<%--            if(request.getParameter("username").equalsIgnoreCase("admin")--%>
<%--                    && request.getParameter("password").equalsIgnoreCase("password")) {--%>
<%--                response.sendRedirect("/profile.jsp");--%>
<%--            }--%>
<%--        }--%>
<%--    %>--%>
</body>
</html>
