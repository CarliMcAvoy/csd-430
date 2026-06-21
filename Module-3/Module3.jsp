<%--
  Created by IntelliJ IDEA.
  User: Howlb
  Date: 6/21/2026
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Form</title>
    <link rel="stylesheet" href="connect/Module3.css" type="text/css">
</head>
<body>
    <h1>Subscription Form</h1>
    <form action="Module3Results.jsp" method="post">
        <table>
            <thead>
            <tr><th>New User Form</th></tr>
            </thead>
            <tbody>
                <tr>
                    <td>First Name:</td>
                    <td><input type="text" name="first" size="15" maxlength="30"/></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><input type="text" name="last" size="15" maxlength="50"/></td>
                </tr>
                <tr>
                    <td>Email Address:</td>
                    <td><input type="email" name="email" size="30" maxlength="50"/></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><input type="tel" name="telephone"/></td>
                </tr>
                <tr>
                    <td>Date of Birth:</td>
                    <td><input type="date" name="dob"/></td>
                </tr>
            </tbody>
        </table>

        <input type="reset" value="Clear" id="clear">
        <input type="submit" value="Submit Form" id="submit">

    </form>
</body>
</html>
