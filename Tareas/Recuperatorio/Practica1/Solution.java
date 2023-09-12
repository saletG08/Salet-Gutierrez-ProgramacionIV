package Recuperatorio.Practica1;

public class Solution {
    public String solution(int A, int B) {
        StringBuilder result = new StringBuilder();
        while (A > 0 || B > 0) {
            if (A > B) {
                if (result.length() >= 2 && result.charAt(result.length() - 1)
                        == 'a' && result.charAt(result.length() - 2) == 'a') {
                    result.append('b');
                    B--;
                } else {
                    result.append('a');
                    A--;
                }
            } else {
                if (result.length() >= 2 && result.charAt(result.length() - 1)
                        == 'b' && result.charAt(result.length() - 2) == 'b') {
                    result.append('a');
                    A--;
                } else {
                    result.append('b');
                    B--;
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int A = 1;
        int B = 4;
        Solution s = new Solution();
        String result = s.solution(A, B);
        System.out.println(result);
    }
}
