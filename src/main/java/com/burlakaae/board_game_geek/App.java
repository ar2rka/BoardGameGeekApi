package com.burlakaae.board_game_geek;

import com.burlakaae.board_game_geek.models.BoardGame;
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
    public static void main( String[] args ) throws IOException, URISyntaxException, ParserConfigurationException, SAXException, SQLException, ClassNotFoundException {
        //countQuery("q");
        bggApi bggApi = new bggApi();
        String body = bggApi.query(174430);
        String answer = bggApi.xmlParser(body).toString();
        System.out.println(answer);
        insertItem(bggApi.xmlParser(body));
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

    public static boolean insertItem(BoardGame boardGame) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password","");
        Connection conn = DriverManager.getConnection(url, props);
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO bgg.boardgame_test VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, boardGame.getThing_id());
            ps.setString(2, boardGame.getThing_type());
            ps.setString(3, boardGame.getThing_name());
            ps.setString(4, boardGame.getYear_published());
            ps.setString(5, boardGame.getMin_players());
            ps.setString(6, boardGame.getMax_players());
            ps.setString(7, boardGame.getPlaying_time());
            ps.setString(8, boardGame.getMin_age());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
