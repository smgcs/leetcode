//二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
// 
//
// 
// 例如，下面的二进制手表读取 "3:25" 。 
// 
//
// 
//
// （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0 
//Unported (CC BY-SA 3.0) ） 
//
// 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。 
//
// 小时不会以零开头： 
//
// 
// 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。 
// 
//
// 分钟必须由两位数组成，可能会以零开头： 
//
// 
// 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：turnedOn = 1
//输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
// 
//
// 示例 2： 
//
// 
//输入：turnedOn = 9
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= turnedOn <= 10 
// 
// Related Topics 位运算 回溯 👍 342 👎 0


package editor.cn;

import java.util.LinkedList;
import java.util.List;

public class BinaryWatch{
    public static void main(String[] args) {
        Solution solution = new BinaryWatch().new Solution();
//        System.out.println(solution.find(60, 0, 6));
//        System.out.println(solution.find(12, 0, 4));
        solution.readBinaryWatch(6);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public List<String> readBinaryWatch(int turnedOn) {

        public List<String> readBinaryWatch(int turnedOn) {
            LinkedList<String> res = new LinkedList<>();
            if (turnedOn < 0 || turnedOn > 8) {
                return res;
            }
            final int hourNumMax = 3;
            final int hourMax = 12;
            final int hourTotal = 4;
            final int minuteNumMax = 5;
            final int minuteMax = 60;
            final int minuteTotal = 6;
            for (int i = 0; i <= hourNumMax; i++) {
                if (turnedOn - i > minuteNumMax || turnedOn - i < 0) {
                    continue;
                }
                List<Integer> hourList = this.find(hourMax, i, hourTotal);
                List<Integer> minuteList = this.find(minuteMax, turnedOn - i, minuteTotal);
                for (Integer hour : hourList) {
                    for (Integer minute : minuteList) {
                        String v = hour + ":";
                        if (minute < 10)
                            v += "0";
                        res.add(v+minute);
                    }
                }
            }

            return res;
        }

        List<Integer> find(int max, int num, int total) {
            Bt bt = new Bt();
            int[] l = new int[total];
            for (int i = 0; i < total; i++) {
                l[i] = 1<<i;
            }
            bt.backtrack(max, num, l, new LinkedList<>());
            return bt.result;
        }

        class Bt {
            List<Integer> result = new LinkedList<>();

            void backtrack(int max, int num, int[] list, LinkedList<Integer> trace) {
                if (trace.size() == num && sum(trace) < max) {
                    if (!result.contains(sum(trace)))
                        result.add(sum(trace));
                    return;
                }
                for (int l : list) {
                    if (trace.contains(l) || l + sum(trace) > max)
                        continue;
                    trace.add(l);
                    backtrack(max, num, list, trace);
                    trace.removeLast();
                }
            }

            int sum(LinkedList<Integer> input) {
                int s = 0;
                for (Integer integer : input) {
                    s += integer;
                }
                return s;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}