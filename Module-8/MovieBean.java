package Module6Bean;

import java.sql.*;
import java.util.*;

public class MovieBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    java.sql.Connection conn;
    java.sql.Statement stmt;

    public MovieBean() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/csd430";
            conn = java.sql.DriverManager.getConnection(url + "user=student1&password=pass");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException cnfe) {

            System.out.print("SQL Exception" + cnfe);
        } catch (java.sql.SQLException sqle) {

            System.out.print("SQL Exception" + sqle);
        }
    }


    //DISPLAY TABLE DATA
    public String readAll() {

        StringBuilder dataStringBuilder = new StringBuilder();

        java.sql.ResultSet resultSet = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/csd430";
            conn = java.sql.DriverManager.getConnection(url + "user=student1&password=pass");
            stmt = conn.createStatement();
        } catch (ClassNotFoundException cnfe) {
            System.out.print("SQL Exception" + cnfe);
        } catch (java.sql.SQLException e) {
            System.out.print("SQL Exception" + e);
        }
        try {
            resultSet = stmt.executeQuery("SELECT * FROM carli_movies_data");
        } catch (java.sql.SQLException e) {
        }
        try{

            dataStringBuilder.append("<table border='1' bgcolor='FFFF00'>");

            while(resultSet.next()){

                dataStringBuilder.append("<tr>");

                for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++){

                    dataStringBuilder.append("<td>");
                    dataStringBuilder.append((resultSet.getString(i)).trim());
                    dataStringBuilder.append("</td>");
                }

                dataStringBuilder.append("</tr>");
            }

            dataStringBuilder.append("</table>");
        }
        catch(Exception e){

            System.out.print("<b>Exception.</b><br />");
            System.out.print(e);
        }

        return dataStringBuilder.toString();
    }


    //CREATE TABLE RECORD
    public void createRecord(String title, String year, String rating, String director, String producer){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/csd430";
            conn = java.sql.DriverManager.getConnection(url + "user=student1&password=pass");
            stmt = conn.createStatement();

        } catch (ClassNotFoundException cnfe) {
            System.out.print("SQL Exception" + cnfe);
        } catch (java.sql.SQLException e) {
            System.out.print("SQL Exception" + e);
        }

        try {

            String sql = "INSERT INTO carli_movies_data(movie_title, movie_year, movie_rating, movie_director, movie_producer)" +
                    "VALUES(?, ?, ?, ?, ?)";

            java.sql.PreparedStatement sqlStatement = conn.prepareStatement(sql);

            sqlStatement.setString(1, title );
            sqlStatement.setString(2, year );
            sqlStatement.setString(3, rating );
            sqlStatement.setString(4, director );
            sqlStatement.setString(5, producer );

            sqlStatement.executeUpdate();

            sqlStatement.close();
        }
        catch(java.sql.SQLException sqle) {

        }
    }


    //UPDATE RECORD
    public String updateRecord(String title, String year, String rating, String director, String producer){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/csd430";
            conn = java.sql.DriverManager.getConnection(url + "user=student1&password=pass");
            stmt = conn.createStatement();

        } catch (ClassNotFoundException cnfe) {
            System.out.print("SQL Exception" + cnfe);
        } catch (java.sql.SQLException e) {
            System.out.print("SQL Exception" + e);
        }

        String sql = "UPDATE carli_movies_data SET year = ?, rating = ?,  director = ?, producer = ? WHERE title = ?";

        try {
            java.sql.PreparedStatement sqlStatement = conn.prepareStatement(sql);

            sqlStatement.setString(1, title );
            sqlStatement.setString(2, year );
            sqlStatement.setString(3, rating );
            sqlStatement.setString(4, director );
            sqlStatement.setString(4, producer );

            sqlStatement.executeUpdate();
            stmt.close();
        }
        catch(java.sql.SQLException sqle){

            System.out.print("SQL Exception" + sqle);
        }

        return "Complete";

    }




    //
    //USER FORM CREATE INPUT
    public String formGetCreate(String requestURL) {

        StringBuilder dataStringBuilder = new StringBuilder();
        java.sql.ResultSet resultSet = null;



        //DB CONNECTION
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/csd430";
            conn = java.sql.DriverManager.getConnection(url + "user=student1&password=pass");
            stmt = conn.createStatement();

        } catch (ClassNotFoundException cnfe) {
            System.out.print("SQL Exception" + cnfe);
        } catch (java.sql.SQLException e) {
            System.out.print("SQL Exception" + e);
        }



        //CREATE TITLE FORM
        try {

            resultSet = stmt.executeQuery("SELECT DISTINCT movie_title FROM carli_movies_data ORDER BY movie_title ASC");
        } catch (java.sql.SQLException e) {

        }


        //OPEN FORM
        dataStringBuilder.append("<form method='post' action='" + requestURL + "'>");
        dataStringBuilder.append("<br /><br />");


        //OPEN TITLE
        dataStringBuilder.append("<label for='title'>Title</label>");
        dataStringBuilder.append("&nbsp&nbsp");
        dataStringBuilder.append("<input name='title' list='title'>");
        dataStringBuilder.append("<datalist id='title'>\n");

        try{
            while(resultSet.next()){

                dataStringBuilder.append("<option value='" + resultSet.getString(1) + "'>\n");
            }
        }
        catch(Exception e){
            System.out.print("<b>Exception.</b><br />");
            System.out.print(e);
        }

        dataStringBuilder.append("</datalist>");
        dataStringBuilder.append("</input>");
        dataStringBuilder.append("<br /><br />");



        //OPEN YEAR
        dataStringBuilder.append("<label for='year'>Year</label>");
        dataStringBuilder.append("&nbsp&nbsp");
        dataStringBuilder.append("<input type='text' name='year' maxlength='4'>");
        dataStringBuilder.append("<br /><br />");



        //OPEN RATING
        dataStringBuilder.append("<label for='rating'>Rating</label>");
        dataStringBuilder.append("&nbsp&nbsp");
        dataStringBuilder.append("<input type='text' name='rating' maxlength='4'>");
        dataStringBuilder.append("<br /><br />");



        //OPEN DIRECTOR
        try {

            resultSet = stmt.executeQuery("SELECT DISTINCT movie_director FROM carli_movies_data ORDER BY movie_director ASC");
        } catch (java.sql.SQLException e) {

        }


        dataStringBuilder.append("<label for='director'>Director</label>");
        dataStringBuilder.append("&nbsp&nbsp");
        dataStringBuilder.append("<input name='director' list='director'>");
        dataStringBuilder.append("<datalist id='director'>\n");

        try{
            while(resultSet.next()){

                dataStringBuilder.append("<option value='" + resultSet.getString(1) + "'>\n");
            }
        }
        catch(Exception e){
            System.out.print("<b>Exception.</b><br />");
            System.out.print(e);
        }

        dataStringBuilder.append("</datalist>");
        dataStringBuilder.append("</input>");
        dataStringBuilder.append("<br /><br />");



        //OPEN PRODUCER
        try {

            resultSet = stmt.executeQuery("SELECT DISTINCT movie_producer FROM carli_movies_data ORDER BY movie_producer ASC");
        } catch (java.sql.SQLException e) {

        }


        dataStringBuilder.append("<label for='producer'>Producer</label>");
        dataStringBuilder.append("&nbsp&nbsp");
        dataStringBuilder.append("<input name='producer' list='producer'>");
        dataStringBuilder.append("<datalist id='producer'>\n");

        try{
            while(resultSet.next()){

                dataStringBuilder.append("<option value='" + resultSet.getString(1) + "'>\n");
            }
        }
        catch(Exception e){
            System.out.print("<b>Exception.</b><br />");
            System.out.print(e);
        }

        dataStringBuilder.append("</datalist>");
        dataStringBuilder.append("</input>");
        dataStringBuilder.append("<br /><br />");


        //CLOSE FORM
        dataStringBuilder.append("<input type='submit' value='Submit'>");
        dataStringBuilder.append("</form>");

        return dataStringBuilder.toString();
    }




    //
    //USER UPDATE FORM
    public String formGetUpdate(String requestURL) {

        StringBuilder dataStringBuilder = new StringBuilder();
        java.sql.ResultSet resultSet = null;



        //DB CONNECTION
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/csd430";
            conn = java.sql.DriverManager.getConnection(url + "user=student1&password=pass");
            stmt = conn.createStatement();

        } catch (ClassNotFoundException cnfe) {
            System.out.print("SQL Exception" + cnfe);
        } catch (java.sql.SQLException e) {
            System.out.print("SQL Exception" + e);
        }



        try {

            resultSet = stmt.executeQuery("SELECT DISTINCT movie_title FROM carli_movies_data ORDER BY movie_title ASC");
        } catch (java.sql.SQLException e) {

        }


        //OPEN FORM
        dataStringBuilder.append("<form method='post' action='" + requestURL + "'>");
        dataStringBuilder.append("<br /><br />");


        //OPEN TITLE
        dataStringBuilder.append("<label for='title'>Title</label>");
        dataStringBuilder.append("&nbsp&nbsp");
        dataStringBuilder.append("<input name='title' list='title'>");
        dataStringBuilder.append("<datalist id='title'>\n");

        try{
            while(resultSet.next()){

                dataStringBuilder.append("<option value='" + resultSet.getString(1) + "'>\n");
            }
        }
        catch(Exception e){
            System.out.print("<b>Exception.</b><br />");
            System.out.print(e);
        }

        dataStringBuilder.append("</datalist>");
        dataStringBuilder.append("</input>");
        dataStringBuilder.append("<br /><br />");



        //OPEN YEAR
        try{

            resultSet = stmt.executeQuery("SELECT DISTINCT movie_year FROM carli_movies_data ORDER BY movie_year ASC");
        }
        catch(java.sql.SQLException e){

        }

        dataStringBuilder.append("<label for='year'>Year</label>\n");
        dataStringBuilder.append("&nbsp&nbsp \n");
        dataStringBuilder.append("<select name='year' id='year' maxlength='20'>\n");

        try {
            while(resultSet.next()) {
                dataStringBuilder.append("<option value=" + resultSet.getString(1) + ">" + resultSet.getString(1) + "</option>\n");
            }
        }
        catch(java.sql.SQLException e){
            dataStringBuilder.append("<br /><br />\n");
        }

        dataStringBuilder.append("</select>\n");
        dataStringBuilder.append("<br /><br />\n");




        //OPEN RATING
        try{

            resultSet = stmt.executeQuery("SELECT DISTINCT movie_rating FROM carli_movies_data ORDER BY movie_rating ASC");
        }
        catch(java.sql.SQLException e){

        }

        dataStringBuilder.append("<label for='rating'>Rating</label>\n");
        dataStringBuilder.append("&nbsp&nbsp \n");
        dataStringBuilder.append("<select name='rating' id='rating' maxlength='20'>\n");

        try {
            while(resultSet.next()) {
                dataStringBuilder.append("<option value=" + resultSet.getString(1) + ">" + resultSet.getString(1) + "</option>\n");
            }
        }
        catch(java.sql.SQLException e){
            dataStringBuilder.append("<br /><br />\n");
        }

        dataStringBuilder.append("</select>\n");
        dataStringBuilder.append("<br /><br />\n");




        //OPEN DIRECTOR
        try {

            resultSet = stmt.executeQuery("SELECT DISTINCT movie_director FROM carli_movies_data ORDER BY movie_director ASC");
        } catch (java.sql.SQLException e) {

        }


        dataStringBuilder.append("<label for='director'>Director</label>");
        dataStringBuilder.append("&nbsp&nbsp");
        dataStringBuilder.append("<input name='director' list='director'>");
        dataStringBuilder.append("<datalist id='director'>\n");

        try{
            while(resultSet.next()){

                dataStringBuilder.append("<option value='" + resultSet.getString(1) + "'>\n");
            }
        }
        catch(Exception e){
            System.out.print("<b>Exception.</b><br />");
            System.out.print(e);
        }

        dataStringBuilder.append("</datalist>");
        dataStringBuilder.append("</input>");
        dataStringBuilder.append("<br /><br />");



        //OPEN PRODUCER
        try {

            resultSet = stmt.executeQuery("SELECT DISTINCT movie_producer FROM carli_movies_data ORDER BY movie_producer ASC");
        } catch (java.sql.SQLException e) {

        }


        dataStringBuilder.append("<label for='producer'>Producer</label>");
        dataStringBuilder.append("&nbsp&nbsp");
        dataStringBuilder.append("<input name='producer' list='producer'>");
        dataStringBuilder.append("<datalist id='producer'>\n");

        try{
            while(resultSet.next()){

                dataStringBuilder.append("<option value='" + resultSet.getString(1) + "'>\n");
            }
        }
        catch(Exception e){
            System.out.print("<b>Exception.</b><br />");
            System.out.print(e);
        }

        dataStringBuilder.append("</datalist>");
        dataStringBuilder.append("</input>");
        dataStringBuilder.append("<br /><br />");


        //CLOSE FORM
        dataStringBuilder.append("<input type='submit' value='Submit'>");
        dataStringBuilder.append("</form>");

        return dataStringBuilder.toString();

    }




    //CLOSE CONNECTION
    public void closeConnection(){
        try {

            stmt.close();
            conn.close();
        }
        catch(java.sql.SQLException sqle){

            System.out.print("SQL Exception" + sqle);
        }
    }
}