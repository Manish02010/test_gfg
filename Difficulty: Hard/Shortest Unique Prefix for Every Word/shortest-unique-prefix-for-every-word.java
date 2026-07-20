import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    static class TrieNode {
        // Use HashMap to allocate space only for characters that actually exist
        Map<Character, TrieNode> children = new HashMap<>();
        int freq = 0;
    }

    public ArrayList<String> findPrefixes(String[] arr) {
        TrieNode root = new TrieNode();

        for (String word : arr) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                current.children.putIfAbsent(ch, new TrieNode());
                current = current.children.get(ch);
                current.freq++;
            }
        }

        ArrayList<String> result = new ArrayList<>(arr.length);
        for (String word : arr) {
            TrieNode current = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                prefix.append(ch);
                current = current.children.get(ch);
                if (current.freq == 1) {
                    break;
                }
            }
            result.add(prefix.toString());
        }

        return result;
    }
}

