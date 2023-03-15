class Solution {
    public long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                result[i] = num + 1;
                continue;
            }
            String binary = Long.toBinaryString(num);
            String[] split = binary.split("0");
            String last = split[split.length - 1];
            result[i] = num + Long.valueOf(1L << (last.length() - 1));
        }
//        System.out.println(Arrays.toString(result));
        return result;
    }
}