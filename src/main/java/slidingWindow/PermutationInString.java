class PermutationInString {
    //O(26*n)
    //sliding window, compare frequency hashmaps of s1 and for each window of size s1.length() in s2
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        //initialize frequency map for s1
        for(int i = 0; i < s1.length(); i++){
            map1.merge(s1.charAt(i), 1, (v1, v2) -> v1 + v2);
        }
        Map<Character, Integer> map2 = new HashMap<>();
        //sliding window for s2, compare hashmaps when window size == s1.length()
        int l = 0;
        for(int r = 0; r < s2.length(); r++){
            char c = s2.charAt(r);
            map2.merge(c, 1, (v1, v2) -> v1 + v2);
            if(r - l == s1.length() - 1){
                if(map1.equals(map2)){
                    return true;
                }
                else{
                    map2.compute(s2.charAt(l), (key, val) -> val - 1);
                    if(map2.get(s2.charAt(l))  == 0){
                        map2.remove(s2.charAt(l));
                    }
                    l++;
                }
            }
        }
        return false;
    }
}