package 二分法.e278;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int begin = 1;
        int end = n;
        int mid;
        int result = 0;
        while(begin <= end){
            mid = (begin + end) >>> 1;
            if(isBadVersion(mid)){
                result = mid;
                end = mid - 1;
            }else{
                begin = mid + 1;
            }
        }
        return result;
    }
}