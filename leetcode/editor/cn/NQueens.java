//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1159 👎 0


package editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
    public List<List<String>> solveNQueens(int n) {

        //    }
//        public List<List<String>> solveNQueens(int n) {
//            List<List<String>> sol = new ArrayList<>();
//            return sol;
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
                if (conflict(trace, container.get(i), i) || trace.contains(container.get(i))) {
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
                if ((x == y) || (x == -1 * y) || (x == 0)) {
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