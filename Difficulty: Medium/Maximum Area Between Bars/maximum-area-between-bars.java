import java.util.List;

class Solution {
    public int maxArea(List<Integer> height) {
        int left = 0;
        int right = height.size() - 1;
        int maxArea = 0;
        
        while (left < right) {
            int hLeft = height.get(left);
            int hRight = height.get(right);
            
            // Calculate the number of bars strictly between them
            int width = right - left - 1;
            
            // Calculate current area
            int currentArea = Math.min(hLeft, hRight) * width;
            
            // Keep track of the maximum area found so far
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the shorter bar
            if (hLeft < hRight) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
