//有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
// 
//
// 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你不能重新排序
//或删除 s 中的任何数字。你可以按 任何 顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯 👍 782 👎 0


package editor.cn;

import com.sun.deploy.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

public class RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new RestoreIpAddresses().new Solution();
//        System.out.println("1234".lastIndexOf('1'));
        System.out.println(solution.restoreIpAddresses("5525511135"));
        System.out.println(solution.restoreIpAddresses("2552551113"));
//        System.out.println(solution.restoreIpAddresses("0000"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            LinkedList<String> input = new LinkedList<>();
            input.add(s);
            backtrace(4, input);
            return res;
        }

        List<String> res = new LinkedList<>();

        //123.4.5.6
        void backtrace(int num, LinkedList<String> trace) {
            if (trace.size() == num) {
                res.add(join(trace));
                return;
            }
            String lastStr = trace.getLast();
            for (int i = 1; i < lastStr.length(); i++) {
                String one = lastStr.substring(0, i);
                String two = lastStr.substring(i);
                if ((one.startsWith("0") && one.length() > 1) ||
                        Long.parseLong(one) > 255 ||
                        (trace.size() + 1 == num && ((Long.parseLong(two) > 255) ||
                                (two.startsWith("0") && two.length() > 1)))
                ) {
                    continue;
                }
                {
                    trace.removeLast();
                    trace.add(lastStr.substring(0, i));
                    trace.add(lastStr.substring(i));
                }
                backtrace(num, trace);
                {
                    trace.removeLast();
                    trace.removeLast();
                    trace.add(lastStr);
                }
            }
        }

        String join(List<String> s) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.size(); i++) {
                stringBuilder.append(s.get(i));
                if (i != s.size() - 1)
                    stringBuilder.append(".");
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}