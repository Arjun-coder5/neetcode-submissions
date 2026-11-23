class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for(int stone : stones){
            list.add(stone);
        }
        while(list.size()>1){
            Collections.sort(list);
            int last = list.size()-1;
            int first = list.get(last);
            int second = list.get(last-1);
            int diff = first-second;
            list.remove(last);
            list.remove(last-1);
            if(diff!=0){
                list.add(diff);
            }
        }
       return list.isEmpty() ? 0 : list.get(0);
    }
}
