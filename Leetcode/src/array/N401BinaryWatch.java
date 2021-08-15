package array;


import java.util.ArrayList;
import java.util.List;

/*
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
Each LED represents a zero or one, with the least significant bit on the right.
For example, the below binary watch reads "4:51"
* */
public class N401BinaryWatch {

    private int[] all = {1,2,4,8,1,2,4,8,16,32};
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<String>();
        helperFun(list, num, 0, 0, 0);
        return list;
    }

    void helperFun(List<String> list, int num, int hour, int minute, int index) {
        if (hour > 11 || minute > 59) {
            return;
        }
        if (num == 0) {
            String answer = "";
            if (minute < 10) {
                answer = hour + ":0" + minute;
            } else {
                answer = hour + ":" + minute;
            }
            list.add(answer);
        }
        for (int i=index; i<10; i++) {
            if (i < 4) {
                helperFun(list, num-1, hour+all[i], minute, i+1);
            } else {
                helperFun(list, num-1, hour, minute+all[i], i+1);
            }
        }
    }
    //二进制表暴力破解法
    public List<String> bruteforce(int turnedOn){
        //用二进制来实现 因为很显然此处都是二进制数字 bitCount可以查询二进制的1的个数 1 2 4 8 16 32 都是二进制最高位为1的数字
        List<String> list = new ArrayList<String>();
        for (int i=0; i<12; i++) {
            for (int j=0; j<60; j++) {
                if (Integer.bitCount(i)+Integer.bitCount(j) == turnedOn) {
                    String answer = "";
                    if (j < 10) {
                        answer = i + ":0" + j;
                    } else {
                        answer = i + ":" + j;
                    }
                    list.add(answer);
                }
            }
        }
        return list;
    }
}
