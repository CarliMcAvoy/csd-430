<%--
  Created by IntelliJ IDEA.
  User: Howlb
  Date: 6/21/2026
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Form Results</title>
    <link rel="stylesheet" href="connect/Module3Results.css" type="text/css">
</head>

<%--Capture user inputs and assign them to variables--%>
<%
    String firstName = request.getParameter("first");
    String lastName = request.getParameter("last");
    String emailAddress = request.getParameter("email");
    String phoneNumber = request.getParameter("telephone");
    String dateOfBirth = request.getParameter("dob");
%>

<body>
    <h1>User Information</h1>
    <table>
        <tbody>
            <tr>
                <td>First Name:</td>
                <td><%=firstName%></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><%=lastName%></td>
            </tr>
            <tr>
                <td>Email Address:</td>
                <td><%=emailAddress%></td>
            </tr>
            <tr>
                <td>Phone Number:</td>
                <td><%=phoneNumber%></td>
            </tr>
            <tr>
                <td>Date of Birth:</td>
                <td><%=dateOfBirth%></td>
            </tr>
        </tbody>
    </table>
</body>
</html>
