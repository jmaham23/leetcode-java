class LongestRepeatingCharacterSubstring {
    public int characterReplacement(String s, int k) {
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int r = 0; r < s.length(); r++){
            //add letter to frequency hashmap
            map.merge(s.charAt(r), 1, (v1, v2) -> v1 + v2);
            //if window size minus most frequent character count for respective window
            //is less than or equal to k, then we know we are still in a valid window and can slide the right pointer
            if(r - l + 1 - Collections.max(map.values()) <= k){
                res = r - l + 1 > res ? r - l + 1 : res;
            }
            //else, we know the window is no longer valid, we must slide the left pointer after decrementing the
            //character count of the respective character at the left pointer
            else{
                map.compute(s.charAt(l), (key,v) -> v - 1);
                l++;
            }
        }
        return res;
    }

    //slightly more efficient solution that removes the need to find greatest value in map every iteration
    public int characterReplacement(String s, int k) {
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        //can remove the need to find the max frequency in map by storing the max frequency
        int maxFreq = 0;
        for(int r = 0; r < s.length(); r++){
            //add letter to frequency hashmap
            map.merge(s.charAt(r), 1, (v1, v2) -> v1 + v2);
            maxFreq = Math.max(map.get(s.charAt(r)), maxFreq);
            //if window size minus most frequent character count for respective window
            //is less than or equal to k, then we know we are still in a valid window and can slide the right pointer
            if(r - l + 1 - maxFreq <= k){
                res = r - l + 1 > res ? r - l + 1 : res;
            }
            //else, we know the window is no longer valid, we must slide the left pointer after decrementing the
            //character count of the respective character at the left pointer
            else{
                map.compute(s.charAt(l), (key,v) -> v - 1);
                l++;
            }
        }
        return res;
    }
}