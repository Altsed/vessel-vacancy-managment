<%--
  Created by IntelliJ IDEA.
  User: SEVEN-WORK
  Date: 10.06.2020
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Vacancy</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-vacancy-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Add New Vacancy</h2>
    </div>
</div>

<div id="container">
    <h3>Save Vacancy</h3>

    <form:form action="saveVacancy" modelAttribute="vacancy" method="post">
        <!-- need to associate this data with customer id-->

        <table>
            <tbody>
            <tr>
                <td><label> Vessel: </label></td>
                <td>
                    <form:select path="vessel.id">
                            <form:options items="${vessels}" itemValue="id" itemLabel="name"/>

                    </form:select>
                </td>



            </tr>
            <tr>
                <td><label> Status: </label></td>
                <td><form:select path="status">
                    <form:option value="false" label="not active" />
                    <form:option value="true" label="active" />
                </form:select></td>
            </tr>
            <tr>
            <td><label> Position: </label></td>
                <td>
                    <form:select path="position.id">
                        <form:options items="${positions}" itemValue="id" itemLabel="name"/>

                </form:select>

                </td>
            </tr>
            <tr>
                <td><label> Duration, days: </label></td>
                <td><form:input path="durationOfContract"></form:input></td>
            </tr>

            <tr>
                <td><label>  </label></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
            </tbody>
        </table>

    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/vacancies/list">Back to List</a>
    </p>
</div>
</body>
</html>