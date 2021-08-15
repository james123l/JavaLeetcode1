package array.dp;

/*The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character.
Then for each group, say the number of characters, then say the character.
 To convert the saying into a digit string, replace the counts with a number and concatenate every saying.
Given a positive integer n, return the nth term of the count-and-say sequence.*/


public class N38CountandSay {
    /**
     * 需要理解题意
     * @param n
     * @return
     */
    public String myCountAndSay(int n) {
        //初始化n=1
        StringBuilder res = new StringBuilder("1");
        if(n==1) return res.toString();
        //外层循环控制n
        for (int i = 1; i < n; i++) {
            StringBuilder pre = res;
            res = new StringBuilder();
            int count =1;
            char curchar = pre.charAt(0);
            //内层循环控制遍历字符串长度：如果遇到不同字符则拼接 相同的则计数
            for (int j = 1; j < pre.length(); j++) {
                if(pre.charAt(j)==curchar){
                    count++;
                }else{
                    res.append(count).append(curchar);
                    count = 1;
                    curchar = pre.charAt(j);
                }
            }
            res.append(count).append(curchar);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        N38CountandSay countandSay = new N38CountandSay();
        System.out.println(countandSay.myCountAndSay(4));
    }
}
