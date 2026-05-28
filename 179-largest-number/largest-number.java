class Solution {
    public String largestNumber(int[] nums) {
        String result = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> (s2 + s1).compareTo(s1 + s2))
                .collect(Collectors.joining());

        return result.startsWith("0") ? "0" : result;
    }
}