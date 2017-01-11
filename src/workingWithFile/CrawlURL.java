package workingWithFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CrawlURL {
    public String getContentByLink(String link) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(link);
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()))){
                String htmlLink;
                while ((htmlLink = bufferedReader.readLine()) != null){
                    stringBuilder.append(htmlLink);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
