package math;

class Reverse {
    public int reverse(int x) {
        char[] c = Integer.valueOf(x).toString().toCharArray();
        int begin = 0;
        int end = c.length-1;
        if(c[begin] == '-') begin++;
        while(begin<end){
            char temp = c[end];
            c[end] = c[begin];
            c[begin] = temp;
            begin++;
            end--;
        }
        return Integer.valueOf(String.valueOf(c));
    }

    public int reverse1(int x) {
        int y = 0;
        while (x != 0) {
            if (y > 214748364 || y < -214748364) {
                return 0;
            }
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }
}