package math;

class SortedSquares {
    public int[] sortedSquares(int[] A) {
        int first = 0;
        int[] result = new int[A.length];
        while(first<A.length&&A[first]<0){
            first++;
        }
        int a = first;
        int b = first-1;
        int i = 0;
        while(a<A.length||b>-1){
            boolean usea = true;
            int index = a;
            if(a>=A.length || b>=0&&Math.abs(A[b])<Math.abs(A[a])){
                usea = false;
            }
            if(!usea){
               index = b--;
            }else{
                a++;
            }
            result[i++] = A[index] * A[index];
        }
        return result;
    }

    public static void main(String[] args) {
        new SortedSquares().sortedSquares(new int[]{});
    }
}