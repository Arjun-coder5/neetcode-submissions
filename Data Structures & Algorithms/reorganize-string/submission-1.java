class Solution {
    public String reorganizeString(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>(
            (a, b) -> map.get(b) - map.get(a)
        );

        for (char ch : map.keySet()) {

            if (map.get(ch) > (s.length() + 1) / 2) {
                return "";
            }

            pq.offer(ch);
        }

        StringBuilder ans = new StringBuilder();

        while (pq.size() > 1) {

            char first = pq.poll();
            char second = pq.poll();

            ans.append(first);
            ans.append(second);

            map.put(first, map.get(first) - 1);
            map.put(second, map.get(second) - 1);

            if (map.get(first) > 0) {
                pq.offer(first);
            }

            if (map.get(second) > 0) {
                pq.offer(second);
            }
        }

        if (!pq.isEmpty()) {
            ans.append(pq.poll());
        }

        return ans.toString();
    }
}