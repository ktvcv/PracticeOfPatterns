package dss.SoftWareCompany.MessageCompressor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
taken from https://rosettacode.org/wiki/LZW_compression#Java
 */

public class LempelZivCompression implements ICompressionStrategy {

    private List<Integer> integers = new ArrayList<>();

    private List<Integer> getIntegers() {
        return integers;
    }

    private void setIntegers(List<Integer> integers) {
        this.integers = integers;
    }

    private static List<Integer> compress(String uncompressed) {
        // Build the dictionary.
        int dictSize = 256;
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for (int i = 0; i < 256; i++)
            dictionary.put("" + (char) i, i);

        String w = "";
        List<Integer> result = new ArrayList<Integer>();
        for (char c : uncompressed.toCharArray()) {
            String wc = w + c;
            if (dictionary.containsKey(wc))
                w = wc;
            else {
                result.add(dictionary.get(w));
                // Add wc to the dictionary.
                dictionary.put(wc, dictSize++);
                w = "" + c;
            }
        }

        // Output the code for w.
        if (!w.equals(""))
            result.add(dictionary.get(w));
        return result;
    }

    /**
     * Decompress a list of output ks to a string.
     */
    private static String decompress(List<Integer> compressed) {
        // Build the dictionary.
        int dictSize = 256;
        Map<Integer, String> dictionary = new HashMap<Integer, String>();
        for (int i = 0; i < 256; i++)
            dictionary.put(i, "" + (char) i);

        String w = "" + (char) (int) compressed.remove(0);
        StringBuffer result = new StringBuffer(w);
        for (int k : compressed) {
            String entry;
            if (dictionary.containsKey(k))
                entry = dictionary.get(k);
            else if (k == dictSize)
                entry = w + w.charAt(0);
            else
                throw new IllegalArgumentException("Bad compressed k: " + k);

            result.append(entry);

            // Add w+entry[0] to the dictionary.
            dictionary.put(dictSize++, w + entry.charAt(0));

            w = entry;
        }
        return result.toString();
    }

    @Override
    public String zip(String plainText) {
        setIntegers(compress(plainText));
        return integers.toString();
    }

    @Override
    public String unzip(String zippedText) {
        return decompress(integers);
    }
}
