class Solution {
    public int maxPerimeter(int[] arr) {
        // code here
        Arrays.sort(arr);
        
        for(int i=arr.length-1; i>=2; i--){
            int a = arr[i];
            int b = arr[i-1];
            int c = arr[i-2];
            
            if(b+c > a) {
                return a+b+c;
            }
        }
        
        return -1;
    }
}