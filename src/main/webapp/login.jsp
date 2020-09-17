<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login"/>
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp"></jsp:include>
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
    </c:choose>

    <jsp:include page="partials/scripts.jsp"></jsp:include>
</body>
</html>
