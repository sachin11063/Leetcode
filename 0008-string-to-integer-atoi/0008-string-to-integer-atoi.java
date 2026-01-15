class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        int i = 0;
        long result = 0;

        // Store Sign value
        if(s.length() == 0) return 0;

        if(s.charAt(0) == '-'){
            sign = -1;
            i++;
        }else if(s.charAt(0) == '+'){
            i++;
        }

        while(i < s.length()){
            char ch = s.charAt(i);
            if(ch < '0' || ch > '9') break; // Stop at non - numeric character

            result = result * 10 + (ch - '0');
            if(sign * result > Integer.MAX_VALUE) return Integer.MAX_VALUE; // to handle overflow
            if(sign * result < Integer.MIN_VALUE) return Integer.MIN_VALUE; // to handle underflow
            i++;
        }
        return (int) (sign * result);
    }
}