package com.burlakaae.board_game_geek;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.Properties;

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
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            Connection conn = DriverManager.getConnection(url, props);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Connection conn = DriverManager.getConnection(url, props);
        //в таких случаях рекомендуется использовать try with resources

        Statement st = conn.createStatement(); 
        ResultSet rs = st.executeQuery("SELECT * FROM bgg.boardgame");
        while (rs.next())
        {
            System.out.println(rs.getString("year_published"));
        }

        
        return 1;
    }
}
