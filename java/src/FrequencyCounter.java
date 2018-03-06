import java.util.HashMap;
import java.util.Map;

public class FrequencyCounter {
    public static void main (String args[]) {
        //Get the URL as a string
        String loadedURL = UrlLoader.theUrlLoader("http://www.gutenberg.org/cache/epub/375/pg375.txt");

        final int TEN = 10;

        //Strip out all the special signs and to lowercase
        loadedURL = loadedURL.toLowerCase();
        loadedURL = loadedURL.replace("(", "");
        loadedURL = loadedURL.replace(")", "");
        loadedURL = loadedURL.replace("[", "");
        loadedURL = loadedURL.replace("]", "");
        loadedURL = loadedURL.replace("{", "");
        loadedURL = loadedURL.replace("}", "");
        loadedURL = loadedURL.replace("#", "");
        loadedURL = loadedURL.replace("*", "");
        loadedURL = loadedURL.replace(",", "");
        loadedURL = loadedURL.replace(".", "");
        loadedURL = loadedURL.replace("!", "");
        loadedURL = loadedURL.replace("?", "");
        loadedURL = loadedURL.replace("%", "");
        loadedURL = loadedURL.replace("$", "");
        loadedURL = loadedURL.replace(":", "");
        loadedURL = loadedURL.replace(";", "");
        loadedURL = loadedURL.replace("\"", "");
        loadedURL = loadedURL.replace("\'", "");
        loadedURL = loadedURL.replace("--", " ");
        loadedURL = loadedURL.replace("/", " ");
        loadedURL = loadedURL.replace("\n", " ");
        // The statement that solved the empty string problem
        loadedURL = loadedURL.replace("\r", " ");
        // remove unicode characters
        loadedURL = loadedURL.replace("[^\\p{ASCII}]", "");

        //Use a map to store words
        Map<String, Integer> dictionary = new HashMap<>();

        //Count words
        String word = "";
        for (int index = 0; index < loadedURL.length(); index++) {
            //Keep adding letter to our temporary word variable
            if (loadedURL.charAt(index) != ' ') {
                word += loadedURL.charAt(index);
            } else {
                //Cut the string as a word when encounter a space and put it into the map
                if (!word.trim().equals("")) {
                    //Update a new value if the word already exists
                    if (dictionary.containsKey(word)) {
                        int oldValue = dictionary.get(word);
                        dictionary.put(word, oldValue + 1);
                    } else {
                        //Put the word into the map and set key value to 1
                        dictionary.put(word, 1);
                    }
                }

                //Reset the variable to empty string
                word = "";
            }
        }

        //Create and initialize two array to store the top 10 frequency words
        String[] topTenWord = new String[TEN];
        for (int index = 0; index < topTenWord.length; index++) {
            topTenWord[index] = "";
        }
        int[] topTenCount = new int[TEN];
        for (int index = 0; index < topTenCount.length; index++) {
            topTenCount[index] = 0;
        }

        //Loop to compare to the existing TOP10 array
        for (Map.Entry<String, Integer> entry : dictionary.entrySet()) {
            for (int index = 0; index < topTenCount.length; index++) {
                if (entry.getValue() > topTenCount[index] && !entry.getKey().equals("")) {
                    topTenCount[index] = entry.getValue();
                    topTenWord[index] = entry.getKey();

                    break;
                }
            }
        }

        //Output the result
        System.out.println("TOP 10 WORDS are:");
        for (int index = 0; index < topTenWord.length; index++) {
            System.out.println(topTenWord[index] + ": " + topTenCount[index] + " times");
        }
    }
}
