<%--
  Created by IntelliJ IDEA.
  User: SEVEN-WORK
  Date: 28.05.2020
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vessels</title>
    <link type="text/css"
        rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2> Vessels </h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <!-- add buttom to add vacancy-->

            <input type="button" value="Add Vessel"
                   onclick="window.location.href='showFormForAddVessel'; return false"/>

           <!-- add html table -->
            <table>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Engine type</th>
                    <th>Engine power</th>
                </tr>
                <c:forEach var="tempVessel" items="${vessels}" >
                    <tr>
                        <td>${tempVessel.name}</td>
                        <td>${tempVessel.vesselType}</td>
                        <td>${tempVessel.engineType}</td>
                        <td>${tempVessel.enginePower}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <p>
        <a href="${pageContext.request.contextPath}/vacancies/list">Back to Vacancies</a>
    </p>
</body>
</html>
