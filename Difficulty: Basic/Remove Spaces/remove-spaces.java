class Solution {
    public static String removeSpaces(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
        if (c != ' ') {
            sb.append(c);
        }
    }
    return sb.toString();
}
}