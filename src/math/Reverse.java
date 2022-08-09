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

    /**
     * result   n
     * 0        0
     * 1        1
     * f(n-1)+f(n-2) n
     * 递归会有重复计算
     * 0 1 1 2 3
     *
     **/
    public static int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;

        int n1 = 1;
        int n2 = 0;
        int result = 0;
        for (int i = 2; i <= n; i++) {
            System.out.print(n1 + n2 + " ");
            result = (n1 + n2) % 1000000007;
            n2 = n1;
            n1 = result;
        }
        return result;
    }

    public static int fibonacciDG(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        int result = fibonacciDG(n-1)+fibonacciDG(n-2);
        return result;
    }

    public static void main(String[] args) {
        fibonacci(45);
        System.out.println();
        for (int i = 2; i <= 45; i++) {
            System.out.print(fibonacciDG(i)+ " ");
        }
    }

}