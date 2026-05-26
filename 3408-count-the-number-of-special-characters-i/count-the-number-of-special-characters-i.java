

class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int ans = 0;
        
        boolean[] arr1 = new boolean[26];
        boolean[] arr2 = new boolean[26];

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                arr1[ch - 'a'] = true;
            } else if (Character.isUpperCase(ch)) {
                arr2[ch - 'A'] = true;
            }
        }

        for(int i = 0; i < 26; i++) {
            if(arr1[i] == true && arr2[i] == true) ans++;
        }

        return ans;
    }
}