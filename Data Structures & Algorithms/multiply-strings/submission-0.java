class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        if (num2.length() > num1.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int n = num2.length();

        String res = "0";
        for (int i = 0; i < n; i++) {
            String s = multiply(num1, num2.charAt(n - i - 1)) + "0".repeat(i);
            res = add(s, res);
        }
        return res;
    }

    public String multiply(String num1, Character ch) {
        char[] num2 = new char[num1.length()];
        int carry = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int val = (num1.charAt(i) - '0') * (ch - '0') + carry;
            carry = val / 10;
            num2[i] = (char) ((val % 10) + '0');
        }

        String res = new String(num2);
        return carry == 0 ? res : carry + res;
    }

    public String add(String num1, String num2) {
        int n = Math.max(num1.length(), num2.length());
        char[] num3 = new char[n];
        int carry = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int k = n - 1;

        while (k >= 0) {
            int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            int val = digit1 + digit2 + carry;
            carry = val / 10;
            num3[k] = (char) ((val % 10) + '0');

            i--;
            j--;
            k--;
        }

        String res = new String(num3);
        return carry == 0 ? res : carry + res;
    }
}
