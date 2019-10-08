package com.burlakaae.board_game_geek;

import com.burlakaae.board_game_geek.models.BoardGame;
import com.burlakaae.board_game_geek.models.Item;
import com.burlakaae.board_game_geek.models.Items;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class bggApi {
     public String query (Integer id) throws URISyntaxException {
         String body = null;
         URI uri = new URIBuilder()
                 .setScheme("https")
                 .setHost("www.boardgamegeek.com")
                 .setPath("xmlapi2/thing")
                 .addParameter("id", id.toString())
                 .addParameter("type", "boardgame")
                 .addParameter("stats", "1")
                 .build();
         CloseableHttpClient httpclient = HttpClients.createDefault();
         HttpUriRequest httpGet = new HttpGet(uri);
         try (
                 CloseableHttpResponse response1 = httpclient.execute(httpGet)
         ) {
             body = EntityUtils.toString(response1.getEntity());
         } catch (
                 IOException e
         ) {
             e.printStackTrace();
         }
         return body;
     }

//     public String xmlParser (String body) throws ParserConfigurationException, IOException, SAXException {
//         DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//         InputSource is = new InputSource(new StringReader(body));
//         Document doc = dBuilder.parse(is);
//         //Element rootel = doc.getDocumentElement();
//         NodeList nodeList = doc.getElementsByTagName("name");
//         BoardGame boardGame = new BoardGame();
//         Element el = (Element) nodeList.item(0);
//         boardGame.setThing_name(el.getAttribute("value").toString());
//         boardGame.setThing_type(el.getAttribute("type").toString());
//         // el.getAttribute("type").toString();
//         return boardGame.toString();
//     }
    private static final String XML = "<items><item id=\"174430\"><thumbnail>https://cf.geekdo-images.com/</thumbnail></item></items>";

     public Items xmlParser2(String body) throws JsonProcessingException {
         ObjectMapper objectMapper = new XmlMapper();

         Items items = objectMapper.readValue(body, Items.class);
         System.out.println(items);
         return items;
     }
}
