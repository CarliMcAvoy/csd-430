<%--
  Created by IntelliJ IDEA.
  User: Howlb
  Date: 7/5/2026
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SQL Connection</title>
</head>
<body>
<h1>Movies Database</h1>

<jsp:useBean id="database" class="Module6Bean.MovieBean"/>

<p>Create New Record</p>
<%
    if(request.getMethod().equals("GET")){
        out.print(database.formGetCreate("Module6.jsp"));
    }
%>

<%
    if(request.getMethod().equals("POST")) {
        database.createRecord(request.getParameter("title"),
                request.getParameter("year"),
                request.getParameter("rating"),
                request.getParameter("director"),
                request.getParameter("producer"));

        out.println("<br />");
    }
%>


<p>Update Record</p>
<%
    if(request.getMethod().equals("GET")){
        out.print(database.formGetUpdate("Module6.jsp"));
    }
%>

<%
    if(request.getMethod().equals("POST")) {
        database.updateRecord(request.getParameter("title"),
                request.getParameter("year"),
                request.getParameter("rating"),
                request.getParameter("director"),
                request.getParameter("producer"));

        out.println("<br />");
    }
%>


<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Year</th>
        <th>Rating</th>
        <th>Director</th>
        <th>Producer</th>
    </tr>
    </thead>
    <tbody>

    <tr>
        <td>

            <%

                out.print(database.readAll());

            %></td>
    </tr>
    </tbody>
</table>

</body>
</html>
