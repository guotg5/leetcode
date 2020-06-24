import java.util.ArrayDeque;
import java.util.Deque;

public class Balancedstringsplit {

    public int balancedstringsplit(String s) {
        int result = 0;
        Deque<String> l = new ArrayDeque<>();
        Deque<String> r = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            String c = s.charAt(i)+"";
            if("R".equals(c)){
                r.push(c);
            }else{
                l.push(c);
            }
            if(l.size()==r.size()){
                result++;
                l.clear();
                r.clear();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Balancedstringsplit().balancedstringsplit("RLRRLLRLRL"));
    }
}
