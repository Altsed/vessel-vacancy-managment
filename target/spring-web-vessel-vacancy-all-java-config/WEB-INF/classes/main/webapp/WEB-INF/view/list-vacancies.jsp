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
    <title>Vacancies</title>
    <link type="text/css"
        rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2> Vacancies</h2>
        </div>
    </div>
    <div id="container">
        <div id="content">
            <!-- add buttom to add vacancy-->
            <input type="button" value="view Vessels"
                   onclick="window.location.href='vessels'; return false"/>
            <input type="button" value="view Positions"
                   onclick="window.location.href='positions'; return false"/>

            <input type="button" value="Add Vacancy"
                   onclick="window.location.href='showFormForAddVacancy'; return false"/>


            <!-- add html table -->
            <table>
                <tr>
                    <th>Vessel</th>
                    <th>Status</th>
                    <th>Position</th>
                    <th>Duration, days</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="tempVacancy" items="${vacancies}" >
                    <!-- construct update link with customer id -->
                    <c:url var="updateLink" value="/vacancies/showFormForUpdateVacancy">
                        <c:param name="vacancyId" value="${tempVacancy.id}" />
                    </c:url>
                    <c:url var="deleteLink" value="/vacancies/deleteVacancy">
                        <c:param name="vacancyId" value="${tempVacancy.id}" />
                    </c:url>
                    <tr>
                        <td>${tempVacancy.vessel.name}</td>
                        <td>
                            <c:choose>
                                <c:when test="${tempVacancy.status == false}">
                                    not active
                                </c:when>
                                <c:otherwise>
                                    active
                                </c:otherwise>
                            </c:choose>


                        </td>
                        <td>${tempVacancy.position.name}</td>
                        <td>${tempVacancy.durationOfContract}</td>
                        <td>
                            <a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure to delete this Vacancy ?'))) return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</body>
</html>
