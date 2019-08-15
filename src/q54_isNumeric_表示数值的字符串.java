public class q54_isNumeric_表示数值的字符串 {
    /**
     * 思路1：写两个判断函数，一个判断是否为正常的数isNum，另一个判断是否为正常的整数isInteger
     *
     * 当字符数组中没有e或者E时，调用isNum判断返回结构；
     * 当字符数组中有e或者E时，记录其下标index，该下标将字符数组分割为左右两部分，左部分调用isNum进行判断；右部分调用isInteger进行判断
     * @param str
     * @return
     */
    public boolean isNumeric1(char[] str) {
        if (str == null || str.length == 0) return false;
        String s = str.toString();
        int numE = 0;
        int nume = 0;
        int EIndex = -1;
        int eIndex = -1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'E') {
                if (numE == 1) return false;
                numE++;
                EIndex = i;
            }
            if (str[i] == 'e') {
                if (nume == 1) return false;
                nume++;
                eIndex = i;
            }
        }
        if (nume == 0 && numE == 0) {
            return isNum(str);
        }
        if (nume == 1 && numE == 1) return false;
        int index = (EIndex != -1) ? EIndex : eIndex;
        char[] before = String.valueOf(str).substring(0, index).toCharArray();
        char[] after = String.valueOf(str).substring(index + 1).toCharArray();
        boolean beforeAns = false;
        boolean afterAns = false;
        if (before.length == 0 || isNum(before)) beforeAns = true;
        if (after.length != 0 && isInteger(after)) afterAns = true;
        return beforeAns && afterAns;
    }

    private boolean isNum(char[] str) {
        boolean hasPoint = false;
        int len = str.length;
        boolean hasSymbol = false;
        for (int i = 0; i < len; i++) {
            int temp = str[i];
            if (temp >= '0' && temp <= '9') continue;
            if (temp == '+' || temp == '-') {
                if (hasSymbol || i != 0) return false;
                hasSymbol = true;
                continue;
            }
            if (temp == '.') {
                if (hasPoint) return false;
                hasPoint = true;
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean isInteger(char[] str) {
        int len = str.length;
        boolean hasSymbol = false;
        for (int i = 0; i < len; i++) {
            int temp = str[i];
            if (temp >= '0' && temp <= '9') continue;
            if (temp == '+' || temp == '-') {
                if (hasSymbol || i != 0) return false;
                hasSymbol = true;
                continue;
            }
            if (temp == '.')
                return false;
        }
        return true;
    }


    /**
     * 思路2：因为思路1较为繁琐，代码量较大，因此使用思路2进行优化
     * 主要分析 ‘E/e’、‘+/-’、'.'出现的时机，O(n）时间复杂度搞定
     *
     * ‘E/e’：出现次数不能>=2;不能出现在最后一位；
     * ‘+/-’：只能出现在第一位或者‘E/e’后面一位；
     * ‘.’：出现次数不能>=2;不能出现在‘E/e’后面
     * @param str
     * @return
     */
    public boolean isNumeric2(char[] str) {
        if(str==null||str.length==0) return false;
        boolean hasPoint=false;
        boolean hasE=false;
        for(int i=0;i<str.length;i++){
            char temp=str[i];
            if(temp>='0'&&temp<='9') continue;
            if(temp=='E'||temp=='e'){
                if(i==str.length-1||hasE) return false;
                hasE=true;
                continue;
            }
            if(temp=='.')
            {
                if(hasPoint||hasE) return false;
                hasPoint=true;
                continue;
            }
            if(temp=='+'||temp=='-'){
                if(i!=0&& (str[i-1]!='E'&&str[i-1]!='e'))
                    return false;
                continue;
            }
            return false;
        }
        return true;
    }
}
