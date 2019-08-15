/**
 * 思路：使用递归的思想
 * 每一步递归中都判断模式的第2位字符是不是‘*’
 * 1. 是‘*’，继续判断字符当前位和模式当前位是否相等（包含模式位为‘.’的情况）
 * 1.1 相等
 * 1.1.1 字符串下标不变，模式下标+2，代表匹配0次
 * 1.1.2 字符串下标+1，模式下标+2，代表匹配1次
 * 1.1.3 字符串下标+1，模式下标不变，代表匹配多次
 * <p>
 * 1.2 不相等则只有一种处理办法：字符串下标不变，模式下标+2
 * <p>
 * 2. 不是‘*’，继续判断字符当前位和模式当前位是否相等（包含模式位为‘.’的情况）
 * 2.1 不相等：直接返回false
 * 2.2 相等：则字符串下标+1，模式下标+1
 * <p>
 * <p>
 * 终止条件：
 * 字符串还没遍历完，模式已遍历完，则返回false；
 * 字符串和模式一起遍历完，则返回true；
 */
public class q53_match_正则表达式匹配 {
    private int slen;
    private int plen;

    public boolean match(char[] str, char[] pattern) {
        if ((str == null || str.length == 0) && (pattern == null && pattern.length == 0)) return true;
        this.slen = str.length;
        this.plen = pattern.length;
        return trace(str, 0, pattern, 0);
    }

    private boolean trace(char[] str, int sindex, char[] pattern, int pindex) {
        if (sindex == slen && pindex >= plen) return true;
        if (sindex < slen && pindex >= plen) return false;

        if (pindex + 1 < plen && pattern[pindex + 1] == '*') {
            //第二位字符是'*'
            if (sindex < slen && (str[sindex] == pattern[pindex] || pattern[pindex] == '.')) {
                return trace(str, sindex + 1, pattern, pindex + 2) || trace(str, sindex + 1, pattern, pindex)
                        || trace(str, sindex, pattern, pindex + 2);
            } else
                return trace(str, sindex, pattern, pindex + 2);
        } else {
            //第二位字符不是'*'
            if (sindex < slen && (str[sindex] == pattern[pindex] || pattern[pindex] == '.'))
                return trace(str, sindex + 1, pattern, pindex + 1);
            else
                return false;
        }
    }
}
