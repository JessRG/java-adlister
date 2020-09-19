<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Welcome to my Ads Site!" />
    </jsp:include>
</head>
<body>
    <div class="container">
        <div class="row">
            <h1 class="col-12">Welcome to this Ads Site!</h1>
            <h2 class="col-12">Here is our list of Ads!</h2>
           <div class="container-fluid">
               <dl class="row mt-5">
                   <%--                <div class="" style="height: 5rem;">--%>
                   <c:forEach var="ad" items="${allAds}">
                       <div class="mb-3 d-flex col-12">
                           <dt class="col-sm-3">${ad.title}</dt>
                           <dd class="col-sm-9">${ad.description}</dd>
                       </div>
                   </c:forEach>
                   <%--                </div>--%>
               </dl>
           </div>
        </div>

    </div>

    <jsp:include page="../partials/scripts.jsp" />
</body>
</html>
