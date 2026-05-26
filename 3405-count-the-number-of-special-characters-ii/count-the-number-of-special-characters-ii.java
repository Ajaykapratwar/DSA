class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int ans = 0;
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        Arrays.fill(arr1, -1);
        Arrays.fill(arr2, -1);

        int i = 0;
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                arr1[ch - 'a'] = i;
            } else if (Character.isUpperCase(ch)) {
                if (arr2[ch - 'A'] == -1) {
                    arr2[ch - 'A'] = i;
                }
            }
            i++;
        }

        for(int j = 0; j < 26; j++) {
            if(arr1[j] != -1 && arr2[j] != -1 && arr1[j] < arr2[j]) ans++;
        }

        return ans;
    }
}