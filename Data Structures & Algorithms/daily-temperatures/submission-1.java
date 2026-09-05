class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        // 1. Keep popping while current > top from stack, keep track of i
        // 2. insert into the stack

        for (int i=0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] top = stack.pop();
                ans[top[1]] = i - top[1];

            }

            stack.push(new int[]{temperatures[i], i});
        }
        return ans;
    }
}
