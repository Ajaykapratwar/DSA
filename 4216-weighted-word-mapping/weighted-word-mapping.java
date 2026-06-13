class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < words.length; i++) {
            int sum = 0;
            for(char ch: words[i].toCharArray()) {
                int idx = ch - 'a';
                sum += weights[idx];
            }
            sum %= 26;

            if (sum < 0) {
                sum += 26;
            }

            char temp = (char) ('z'-sum);
            sb.append(temp);
        }
        return sb.toString();
    }
}