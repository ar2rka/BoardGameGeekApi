package com.burlakaae.board_game_geek;

import com.burlakaae.board_game_geek.models.BoardGame;
import lombok.extern.log4j.Log4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

@Log4j
public class Dao {
    public static boolean insertItem(BoardGame boardGame) throws SQLException, ClassNotFoundException {
        Properties prop = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties")){
            prop.load(fileInputStream);
            log.info("config was read");
        } catch (FileNotFoundException e) {
            log.error("config wasn't found");
            e.printStackTrace();
        } catch (IOException e) {
            log.error("config wasn't read");
            e.printStackTrace();
        }

        String pgHost = prop.getProperty("pgHost");
        String pgLogin = prop.getProperty("pgLogin");
        String pgPassword = prop.getProperty("pgPassword");

        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://" + pgHost + "/postgres";
        Properties props = new Properties();
        props.setProperty("user", pgLogin);
        props.setProperty("password", pgPassword);
        Connection conn = DriverManager.getConnection(url, props);
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO bgg.boardgame_test VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
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
