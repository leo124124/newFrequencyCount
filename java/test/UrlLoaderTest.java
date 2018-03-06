import org.junit.Test;

public class UrlLoaderTest {

    String loadedURL = UrlLoader.theUrlLoader("http://www.gutenberg.org/cache/epub/375/pg375.txt");

    /**
     *  Use a test to see if I get the text from the URL correctly
     */
    @Test
    public void getURLTest() {
        System.out.print(loadedURL);
    }

}
