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
    public static void main( String[] args ) throws IOException, URISyntaxException, ParserConfigurationException, SAXException, SQLException, ClassNotFoundException {
        bggApi bggApi = new bggApi();
        String body = bggApi.query(174430);
        String answer = bggApi.xmlParser(body).toString();
        System.out.println(answer);
        Dao.insertItem(bggApi.xmlParser(body));
    }
}
