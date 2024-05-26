class LongestUniqueSubstring {
    //Sliding window
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++){
            //if right pointer is already in set than increment and remove the left pointer values until the duplicate from left is removed
            //effectively slides window start to one past the left duplicate
            while(set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res = res < r - l + 1 ? r - l + 1 : res;
        }
        return res;
    }
}