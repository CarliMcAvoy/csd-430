<%--
  Created by IntelliJ IDEA.
  User: Howlb
  Date: 6/28/2026
  Time: 1:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>JavaBean Implementation</title>

</head>
<body>

    <jsp:useBean id="bean" class="Java.Module4Bean"/>

    <h1>"Spirited Away" by Studio Ghibli</h1>
    <br>
    <h2>Information Table</h2>

    <table>
        <thead>
        <tr>
            <th>Character</th>
            <th>Role</th>
            <th>Voice Actor</th>
        </tr>
        </thead>
        <tbody>

        <tr>
            <td><jsp:getProperty name="bean" property="name"/></td>
            <td><jsp:getProperty name="bean" property="role"/></td>
            <td><jsp:getProperty name="bean" property="actor"/></td>
        </tr>
        
        </tbody>
    </table>



</body>
</html>
