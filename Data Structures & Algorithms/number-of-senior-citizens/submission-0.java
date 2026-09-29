class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            int tenth = detail.charAt(11) - '0';
            int oneth = detail.charAt(12) - '0';
            int age = tenth * 10 + oneth;

            if (age > 60) count++;
        }
        return count;
    }
}