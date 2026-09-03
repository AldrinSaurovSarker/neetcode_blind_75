public class Solution {
    List<Integer> list = new ArrayList<>();

    public String encode(List<String> strs) {
        StringBuilder code = new StringBuilder();

        for (String s : strs) {
            if (list.size() == 0) {
                list.add(s.length());
            } else {
                list.add(list.get(list.size() - 1) + s.length());
            }
            code.append(s);
        };
        return code.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();

        int begin = 0;
        for (int end : list) {
            strs.add(str.substring(begin, end));
            begin = end;
        }

        return strs;
    }
}
