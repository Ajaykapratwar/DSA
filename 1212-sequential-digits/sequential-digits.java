class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        String digits = "123456789";
        int min = String.valueOf(low).length();

        for(int i = min; i <= 9; i++) {
            for(int j = 0; j < digits.length(); j++) {
                if(i+j <= digits.length()) {
                    int num = Integer.parseInt(digits.substring(j, i+j));
                    if(num > high) break;
                    if(num >= low) ans.add(num);
                }
            }
        }
        return ans;
    }
}