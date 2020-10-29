package String;

import BinaryTree.BalancedBinaryTree;

import java.util.Stack;

class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<String> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();
        for (char c : S.toCharArray()){
            if(c == '#' && stack.size() > 0){
                stack.pop();
            }else if(c != '#'){
                stack.push(String.valueOf(c));
            }
        }
        for (char c : T.toCharArray()){
            if(c == '#' && stack1.size() > 0){
                stack1.pop();
            }else if(c != '#'){
                stack1.push(String.valueOf(c));
            }
        }
        while(!stack.isEmpty()&&!stack1.isEmpty()){
            if(!stack.pop().equals(stack1.pop())){
                return false;
            }
        }
        return stack.isEmpty()&&stack1.isEmpty();
    }

    public static void main(String[] args) {
        new BackspaceCompare().backspaceCompare("bxj##tw","bxo#j##tw");
    }
}