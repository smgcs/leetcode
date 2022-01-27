//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 数组 回溯 👍 117 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.List;

class EightQueensLcci {
    public static void main(String[] args) {
        Solution solution = new EightQueensLcci().new Solution();
//        System.out.println(solution.generateQueen(8, 3));
        System.out.println(solution.solveNQueens(4));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> sol = new ArrayList<>();
            List<String> qList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                qList.add(generateQueen(n, i));
            }
            for (int i = 0; i < n; i++) {
                ArrayList<String> aList = new ArrayList<>();
                int offset = 0;
                boolean toInsert = false;
                while (aList.size() < n && offset < n) {
                    String waitToInsert = qList.get(offset);
                    for (int j = 0; j < aList.size(); j++) {
                        if (conflict(aList.get(j), waitToInsert, j, offset)) {
                            break;
                        }
                        if (j == aList.size() - 1) {
                            toInsert = true;
                        }
                    }
                    if (toInsert || aList.size() == 0) {
                        aList.add(waitToInsert);
                    }
                    offset++;
                }
                if (aList.size() == n) {
                    sol.add(aList);
                }
            }
            return sol;
        }

        public boolean conflict(String font, String back, int fontIndex, int backIndex) {
            int x = font.indexOf("Q") - back.indexOf("Q");
            int y = fontIndex - backIndex;
            return ((x == y) || (x == -1 * y) || (x == 0));
        }

        public String generateQueen(int length, int index) {
            if (length < index) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                if (i == index) {
                    stringBuilder.append('Q');
                } else {
                    stringBuilder.append('.');
                }
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}