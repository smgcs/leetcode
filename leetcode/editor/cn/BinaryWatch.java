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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryWatch {
    public static void main(String[] args) {
        Solution solution = new BinaryWatch().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        LinkedList<Integer> integers = new LinkedList<>();
        public Solution() {
            for (int i = 0; i < 6; i++) {
                this.integers.add(1 << i);
            }
        }

        public List<String> readBinaryWatch(int turnedOn) {
            LinkedList<String> res = new LinkedList<>();
            if (turnedOn < 1 || turnedOn > 8) {
                return res;
            }
            final int hourNumMax = 3;
            final int hourMax = 11;
            final int minuteNumMax = 5;
            final int minuteMax = 59;
            for (int i = 1; i <= hourNumMax; i++) {
                if (turnedOn - i > minuteNumMax || turnedOn - i < 0) {
                    break;
                }
                List<String> hourList =this.find(hourMax, i);
                List<String> minuteList = this.find(minuteMax, turnedOn-i);
                for (String hour : hourList) {
                    for (String minute : minuteList) {
                        res.add(hour+":"+minute);
                    }
                }
            }

            return res;
        }
        List<String> find(int max, int num){
            ArrayList<String> res = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < num; i++) {
                if (sum + this.integers.get(i) > max){

                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}