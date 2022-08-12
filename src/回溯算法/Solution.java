package 回溯算法;


public class Solution {

//    给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
//    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//    例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
//
//    输入：board = [["A","B","C","E"],
//                  ["S","F","C","S"],
//                  ["A","D","E","E"]],
//         word = "ABCCED"
//    输出：true
    public boolean exist(char[][] board, String word) {
        int[][] temp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(word.charAt(0) == board[i][j]) {
                    temp[i][j] = 1;
                    if(existRecursion(board, word, 0, i, j, temp)) return true;
                    temp[i][j] = 0;
                }
            }
        }
        return false;
    }

    //  1
    //4 from 2
    //  3
    //[["A","B","C","E"],
    // ["S","F","C","S"],
    // ["A","D","E","E"]]
    //"SEE"
    public boolean existRecursion(char[][] board, String word, int index, int x, int y, int[][] temp) {
        if(index++ == word.length() - 1) return true;

        //上
        if(x - 1 >= 0 && temp[x-1][y] != 1 && board[x-1][y] == word.charAt(index)) {
            temp[x-1][y] = 1;
            if(existRecursion(board, word, index, x-1, y, temp)) {
                return true;
            }
            temp[x-1][y] = 0;
        }
        //右
        if(y + 1 < board[0].length && temp[x][y+1] != 1 && board[x][y+1] == word.charAt(index)) {
            temp[x][y+1] = 1;
            if(existRecursion(board, word, index, x, y+1, temp)) {
                return true;
            }
            temp[x][y+1] = 0;
        }
        //下
        if(x + 1 < board.length && temp[x+1][y] != 1 && board[x+1][y] == word.charAt(index)) {
            temp[x+1][y] = 1;
            if(existRecursion(board, word, index, x+1, y, temp)) {
                return true;
            }
            temp[x+1][y] = 0;
        }
        //左
        if(y - 1 >= 0 && temp[x][y-1] != 1 && board[x][y-1] == word.charAt(index)) {
            temp[x][y-1] = 1;
            if(existRecursion(board, word, index, x, y - 1, temp)) {
                return true;
            }
            temp[x][y-1] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE");
    }
}
