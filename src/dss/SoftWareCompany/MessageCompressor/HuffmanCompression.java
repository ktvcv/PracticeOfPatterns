package dss.SoftWareCompany.MessageCompressor;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Anupan Chugh
 * taken from https://www.journaldev.com/23246/huffman-coding-algorithm
 */

public class HuffmanCompression implements ICompressionStrategy {
    private static final Map<Character, String> charPrefixHashMap = new HashMap<>();
    static HuffmanNode root;

    private static HuffmanNode buildTree(Map<Character, Integer> freq) {

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        Set<Character> keySet = freq.keySet();
        for (Character c : keySet) {

            HuffmanNode huffmanNode = new HuffmanNode();
            huffmanNode.data = c;
            huffmanNode.frequency = freq.get(c);
            huffmanNode.left = null;
            huffmanNode.right = null;
            priorityQueue.offer(huffmanNode);
        }
        assert priorityQueue.size() > 0;

        while (priorityQueue.size() > 1) {

            HuffmanNode x = priorityQueue.peek();
            priorityQueue.poll();

            HuffmanNode y = priorityQueue.peek();
            priorityQueue.poll();

            HuffmanNode sum = new HuffmanNode();

            assert y != null;
            sum.frequency = x.frequency + y.frequency;
            sum.data = '-';

            sum.left = x;

            sum.right = y;
            root = sum;

            priorityQueue.offer(sum);
        }

        return priorityQueue.poll();
    }


    private static void setPrefixCodes(HuffmanNode node, StringBuilder prefix) {

        if (node != null) {
            if (node.left == null && node.right == null) {
                charPrefixHashMap.put(node.data, prefix.toString());

            } else {
                prefix.append('0');
                setPrefixCodes(node.left, prefix);
                prefix.deleteCharAt(prefix.length() - 1);

                prefix.append('1');
                setPrefixCodes(node.right, prefix);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }

    }

    @Override
    public String zip(String plainText) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < plainText.length(); i++) {
            if (!freq.containsKey(plainText.charAt(i))) {
                freq.put(plainText.charAt(i), 0);
            }
            freq.put(plainText.charAt(i), freq.get(plainText.charAt(i)) + 1);
        }

        root = buildTree(freq);

        setPrefixCodes(root, new StringBuilder());
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            s.append(charPrefixHashMap.get(c));
        }

        return s.toString();
    }

    @Override
    public String unzip(String zippedText) {
        StringBuilder stringBuilder = new StringBuilder();

        HuffmanNode temp = root;

        for (int i = 0; i < zippedText.length(); i++) {
            int j = Integer.parseInt(String.valueOf(zippedText.charAt(i)));

            if (j == 0) {
                temp = temp.left;
                if (temp.left == null && temp.right == null) {
                    stringBuilder.append(temp.data);
                    temp = root;
                }
            }
            if (j == 1) {
                temp = temp.right;
                if (temp.left == null && temp.right == null) {
                    stringBuilder.append(temp.data);
                    temp = root;
                }
            }
        }
        return stringBuilder.toString();
    }

    static class HuffmanNode implements Comparable<HuffmanNode> {
        int frequency;
        char data;
        HuffmanNode left, right;

        public int compareTo(HuffmanNode node) {
            return frequency - node.frequency;
        }
    }
}
