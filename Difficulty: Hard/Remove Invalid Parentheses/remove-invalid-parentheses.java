import java.util.*;

class Solution {
    public List<String> validParenthesis(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> currentLevelValid = new HashSet<>();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (isValid(curr)) {
                    currentLevelValid.add(curr);
                    found = true;
                }

                // If we haven't found a valid string yet, keep generating the next level
                if (!found) {
                    for (int j = 0; j < curr.length(); j++) {
                        if (curr.charAt(j) != '(' && curr.charAt(j) != ')') continue;

                        String next = curr.substring(0, j) + curr.substring(j + 1);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }

            if (found) {
                result.addAll(currentLevelValid);
                Collections.sort(result);
                return result;
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') {
                if (count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }
}
