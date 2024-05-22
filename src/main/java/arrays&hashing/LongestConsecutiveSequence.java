class LongestConsecutiveSequence {
    //O(nlogn)
    public int priorityQueue(int[] nums) {
        //base case
        if(nums.length == 0){
            return 0;
        }

        //add values to priority queue as it naturally orders elements
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            queue.offer(nums[i]);
        }


        int res = Integer.MIN_VALUE;
        int count = 1;
        while(queue.peek() != null){
            res = res < count ? count : res;
            int prev = queue.poll();
            if(queue.size() == 0){
                return res;
            }
            int next = queue.peek();
            if(prev == next){
                continue;
            }
            else if(prev == (next - 1)){
                count++;
            }
            else{
                count = 1;
            }
        }
        return res;
    }

    //O(n)
    public int set(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int res = 1;
        for(Integer i : set){
            int count = 1;
            //check if start of sequence
            if(!set.contains(i - 1)){
                while(set.contains(++i)){
                    count++;
                }
                res = res < count ? count : res;
            }
        }
        return res;
    }
}