import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class UrlLoader {

    /**
     *
     * @param newURL the URL that I want to get the text from
     * @return all the text in a string
     */
    public static String theUrlLoader(String newURL) {

        URL url = null;

        {
            try {
                url = new URL(newURL);
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            }
        }

        InputStream inStream = null;

        {
            try {
                inStream = url.openStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputStreamReader inStreamReader = new InputStreamReader(inStream, Charset.forName("UTF-8"));

        int data = 0;

        {
            try {
                data = inStreamReader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String loadedURL = "";

        {
            try {
                while (data != -1) {
                    char theChar = (char) data;
                    //System.out.print(theChar);
                    loadedURL += theChar;
                    data = inStreamReader.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return loadedURL;
    }

}
