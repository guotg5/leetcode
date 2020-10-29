package String;

public class AllString {

    public boolean isLongPressedName(String name, String typed) {
        char pre = ' ';
        int i = 0,j=0;
        while (i<name.length()&&j<typed.length()){
            if(name.charAt(i) == typed.charAt(j)){
                pre = name.charAt(i);
                j++;
                i++;
            }else if (pre == typed.charAt(j)){
                j++;
            }else{
                return false;
            }
        }
        return i==name.length()&&typed.length()==j;
    }
}
