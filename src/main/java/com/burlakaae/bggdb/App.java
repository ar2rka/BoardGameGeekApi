package com.burlakaae.bggdb;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, URISyntaxException, ParserConfigurationException, SAXException {
        //countQuery("q");
        bggApi bggApi = new bggApi();
        String body = bggApi.query(174430);
        String answer = bggApi.xmlParser(body);
        System.out.println(answer);
}

    private static Integer countQuery(String table) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","");
        Connection conn = DriverManager.getConnection(url, props);

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM bgg.boardgame");
        while (rs.next())
        {
            System.out.println(rs.getString("year_published"));
        }
        rs.close();
        st.close();
        return 1;
    }
}