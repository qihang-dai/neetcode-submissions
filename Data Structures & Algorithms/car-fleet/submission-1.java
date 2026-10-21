class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> speedMap = new HashMap();
        for(int i = 0; i < speed.length; i++){
            speedMap.put(position[i], speed[i]);
        }
        Arrays.sort(position);
        Stack<Double> stack = new Stack();
        for(int i = position.length - 1; i >= 0; i--){
            double x = Double.valueOf(target - position[i])/ Double.valueOf(speedMap.get(position[i]));
            // System.out.println("pos:" + position[i] + " x: " + x );
            if(!stack.isEmpty() && x <= stack.peek()){
                continue;
            }else{
                stack.push(x);
                // System.out.println("inStack: " + stack.peek());

            }
        }
        return stack.size();
    }
}
