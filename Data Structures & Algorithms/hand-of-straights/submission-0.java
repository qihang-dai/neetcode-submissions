class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        // TreeMap 自动按 key 排序，方便每次取最小牌
        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int h : hand) count.put(h, count.getOrDefault(h, 0) + 1);

        while (!count.isEmpty()) {
            int start = count.firstKey();          // 当前还剩的最小牌 → 这一组的起手
            for (int card = start; card < start + groupSize; card++) {
                // 这一组需要 card 这张牌。它存在吗？减一之后如果归零，怎么处理？
                // 你来填这三四行
                if(count.getOrDefault(card, 0) == 0) return false;
                count.put(card, count.get(card) - 1);
                if (count.get(card) == 0) count.remove(card);

            }
        }
        return true;
    }
}
