class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Character,Integer> map = new HashMap<>();
        for(char task : tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }
        for(int freq : map.values()){
            maxHeap.offer(freq);
        }
         Queue<int[]> q = new LinkedList<>();
         int time = 1;
         while(!maxHeap.isEmpty()||!q.isEmpty()){
            if(!q.isEmpty()&&q.peek()[1]<=time){
               int[] curr = q.poll();
               maxHeap.offer(curr[0]);
            }
            if(maxHeap.isEmpty()){
                time = q.peek()[1];
                continue;
            }
            int freq = maxHeap.poll();
            freq--;
            if(freq>0){
                q.offer(new int[]{freq,time+n+1});
            }
            time++;
         }

        return time-1;
    }
}
