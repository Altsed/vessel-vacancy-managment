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
                    <th>Action</th>
                </tr>


                <c:forEach var="tempVessel" items="${vessels}" >
                    <!-- construct update link with customer id -->
                    <c:url var="updateLink" value="/vacancies/showFormForUpdateVessel">
                        <c:param name="vesselId" value="${tempVessel.id}" />
                    </c:url>
                    <c:url var="deleteLink" value="/vacancies/deleteVessel">
                        <c:param name="vesselId" value="${tempVessel.id}" />
                    </c:url>
                    <tr>
                        <td>${tempVessel.name}</td>
                        <td>${tempVessel.vesselType}</td>
                        <td>${tempVessel.engineType}</td>
                        <td>${tempVessel.enginePower}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                            onclick="if (!(confirm('Are you sure to delete this Vessel ? ' +
                             'All vacancies with this Vessel will be deleted too!'))) return false">Delete</a>
                        </td>
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
