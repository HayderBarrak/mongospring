package guru.springframework.jenkins;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.DatatypeConverter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
@SpringBootApplication
public class test {

    public static void main(String[] args) {
        try {
            URL url = new URL ("http://localhost:9090/job/maven%20project/build"); // Jenkins URL localhost:8080, job named 'test'
            String user = "admin"; // username
            String pass = "1171f01e6561d833974893a71af7d3df62"; // password or API token
            String authStr = user +":"+  pass;
            String encoding = DatatypeConverter.printBase64Binary(authStr.getBytes("utf-8"));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = connection.getInputStream();
            BufferedReader in   =
                    new BufferedReader (new InputStreamReader (content));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}



