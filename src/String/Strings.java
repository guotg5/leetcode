package String;

public class Strings {

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

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     * 限制：
     * 0 <= s 的长度 <= 10000
     **/
    public String replaceSpace(String s) {
        if(s.length() == 0) return s;
        if(s.length() == 1 && s.equals(" ")) return "%20";

        int spaceNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') spaceNum++;
        }

        if(spaceNum != 0) {
            char[] arr = new char[s.length() + 2 * spaceNum];
            int index = arr.length - 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                if(s.charAt(i) == ' ') {
                    arr[index--] = '0';
                    arr[index--] = '2';
                    arr[index--] = '%';
                } else {
                    arr[index--] = s.charAt(i);
                }
            }

            return new String(arr);
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Strings().replaceSpace("We are happy."));
    }
}
