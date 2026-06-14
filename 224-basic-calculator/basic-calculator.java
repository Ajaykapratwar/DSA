class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        int num = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '+') {
                sum += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                sum += sign * num;
                num = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(sum);
                stack.push(sign);
                
                sum = 0;
                sign = 1;
            } else if (ch == ')') {
                sum += sign * num;
                num = 0;
                
                sum *= stack.pop();
                sum += stack.pop();
            }
        }
        
        if (num != 0) {
            sum += sign * num;
        }
        
        return sum;
    }
}
