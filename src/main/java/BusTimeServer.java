import com.google.gson.Gson;
import org.glassfish.jersey.media.multipart.FormDataParam;
import spark.QueryParamsMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

import static spark.Spark.*;

/**
 * Created by uderekhsieh on 6/14/17.
 */
public class BusTimeServer {
    static String bus_route = "bus_route";
    static String bus_agency = "bus_agency";

    public static void main(String[] args) {
        externalStaticFileLocation("/Users/derekhsieh/Projects/bus_web_hook/src/main/resources/");
        get("/hello", (req, res) -> "Hello World");


        post("/test",((request, response) -> {
            System.out.println("Here");
            QueryParamsMap queryMap = request.queryMap();
            String agency = queryMap.get(bus_agency).value();
            String routes = getJsonFromUrl(String.format("http://webservices.nextbus.com/service/publicJSONFeed?command=routeList&a=%s", agency));
            return routes;
        }));

    }

    private static String getJsonFromUrl(String link) throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL(link);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
