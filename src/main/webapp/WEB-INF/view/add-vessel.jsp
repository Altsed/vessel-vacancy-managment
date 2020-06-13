<%--
  Created by IntelliJ IDEA.
  User: SEVEN-WORK
  Date: 10.06.2020
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri ="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Vessel</title>
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
        <h2>Add New Vessel</h2>
    </div>
</div>

<div id="container">
    <h3>Save Vessel</h3>

    <form:form action="saveVessel" modelAttribute="vessel" method="post">
        <!-- need to associate this data with customer id-->

        <table>
            <tbody>
            <tr>
                <td><label> Name: </label></td>
                <td><form:input path="name"></form:input></td>
            </tr>
            <tr>
                <td><label> Type Of Vessel: </label></td>
                <td><form:input path="vesselType"></form:input></td>
            </tr>
            <tr>
                <td><label> Type of Engine: </label></td>
                <td><form:input path="engineType"></form:input></td>
            </tr>
            <tr>
                <td><label> Engine Power, hp: </label></td>
                <td><form:input path="enginePower"></form:input></td>
            </tr>

            <tr>
                <td><label>  </label></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
            </tbody>
        </table>

    </form:form>

    <p>
        <a href="${pageContext.request.contextPath}/vacancies/vessels">Back to List</a>
    </p>
</div>
</body>
</html>