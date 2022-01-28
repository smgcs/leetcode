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
import java.util.LinkedList;
import java.util.List;

public class EightQueensLcci {
    public static void main(String[] args) {
        Solution solution = new EightQueensLcci().new Solution();
        System.out.println(solution.generateQueen(4));
        System.out.println(solution.solveNQueens(4));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<String> container = generateQueen(n);
            backtrace(container, new LinkedList<>());
            return res;
        }

        List<List<String>> res = new LinkedList<>();

        void backtrace(List<String> container, LinkedList<String> trace) {
            if (trace.size() == container.size()) {
                res.add(new LinkedList<>(trace));
                return;
            }
            for (int i = 0; i < container.size(); i++) {
                if (conflict(trace, container.get(i), i) || trace.contains(container.get(i))){
                    continue;
                }
                trace.add(container.get(i));
                backtrace(container, trace);
                trace.removeLast();
            }

        }

        boolean conflict(LinkedList<String> selected, String current, int cid) {
            for (int i = 0; i < selected.size(); i++) {
                int x = selected.get(i).indexOf("Q") - current.indexOf("Q");
                int y = i - cid;
                if ((x == y) || (x == -1 * y) || (x == 0)){
                    return true;
                }
            }
            return false;
        }

        public List<String> generateQueen(int length) {
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < length; j++) {
                    if (j == i) {
                        stringBuilder.append('Q');
                    } else {
                        stringBuilder.append('.');
                    }
                }
                res.add(stringBuilder.toString());
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}