class ValidPalindrome {
    //two pointer O(n)
    public boolean isPalindrome(String s) {
        //two pointers
        int start = 0;
        int end = s.length() - 1;
        s = s.toLowerCase();
        while(end > start){
            //skip non alpha numeric characters instead of removing in place
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
                continue;
            }
            //skip non alpha numeric characters instead of removing in place
            else if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
                continue;
            }
            //check mirrored equality
            else if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}