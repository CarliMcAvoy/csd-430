<%--
  Created by IntelliJ IDEA.
  User: Howlb
  Date: 6/13/2026
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>

<%-- Establish java imports --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="java.util.*" %>

<html>
<head>
    <link rel="stylesheet" href="connect/Module2.css" type="text/css">
    <title>Module 2.2 - Dynamic HTML Page</title>

</head>
<body>
    <div id="header">
        <h1>"Spirited Away" by Studio Ghibli</h1>
        <br>
        <h2>Information Table</h2>
    </div>

    <%-- Create source data for HTML table data --%>
    <%

        //Create class for data creation
        class Data {
            String name;
            String role;
            String actor;

            Data(String name, String role, String actor) {
                this.name = name;
                this.role = role;
                this.actor = actor;
            }

            public String getName() {
                return name;
            }

            public String getRole() {
                return role;
            }

            public String getActor() {
                return actor;
            }
        }

            //Create ArrayList for storing new data
            List<Data> dataList = new ArrayList<>();
            dataList.add(new Data("Chihiro", "Protagonist", "Daveigh Chase"));
            dataList.add(new Data("Yubaba", "Antagonist", "Suzanne Pleshette"));
            dataList.add(new Data("Zeniba", "Mentor", "Suzanne Pleshette"));
            dataList.add(new Data("Haku", "Deuteragonist", "Jason Marsden"));
            dataList.add(new Data("Boh", "Sidekick", "Tara Strong"));

    %>

    <div id="table">
        <table>
            <thead>
            <tr>
                <th>Character</th>
                <th>Role</th>
                <th>Voice Actor</th>
            </tr>
            </thead>
            <tbody>

                <%
                    //Initiate loop to insert all data from the List into a table
                    for (Data data : dataList){
                %>

                <tr>
                    <td><%= data.getName() %></td>
                    <td><%= data.getRole() %></td>
                    <td><%= data.getActor() %></td>
                </tr>

                <%
                //Close the loop
                    }
                %>

            </tbody>
        </table>
    </div>
</body>
</html>
