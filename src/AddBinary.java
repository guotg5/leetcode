import java.util.ArrayDeque;
import java.util.Deque;

public class AddBinary {
    public String addBinary(String a, String b) {
        String result = "";
        Deque<Integer> ad = new ArrayDeque<Integer>();
        Deque<Integer> bd = new ArrayDeque<Integer>();
        Deque<Integer> cd = new ArrayDeque<Integer>();
        a.chars().mapToObj(i -> Integer.valueOf((char)i+"")).forEach(ad::push);
        b.chars().forEach(i -> bd.push(Integer.valueOf((char)i+"")));
        int jin = 0;

        while(!(ad.isEmpty()&&bd.isEmpty())){
            int a1 = 0;
            int b1=0;
            if(!ad.isEmpty())a1=ad.pop();
            if(!bd.isEmpty())b1=bd.pop();
            cd.push(a1^b1^jin);
            jin = a1+b1+jin>1?1:0;
        }
        if(jin==1){
            cd.push(jin);
        }
        while(!cd.isEmpty()){
            result+=cd.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("10101","110"));
    }
}
