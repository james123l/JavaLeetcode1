package array.traceback;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
* */
public class N17LetterCombinationsofaPhoneNumber {
    private static final Map<Character, char[]> MAP = Map.of(
            '2', new char[]{'a', 'b', 'c'},
            '3', new char[]{'d', 'e', 'f'},
            '4', new char[]{'g', 'h', 'i'},
            '5', new char[]{'j', 'k', 'l'},
            '6', new char[]{'m', 'n', 'o'},
            '7', new char[]{'p', 'q', 'r', 's'},
            '8', new char[]{'t', 'u', 'v'},
            '9', new char[]{'w', 'x', 'y', 'z'}
    );
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if(digits.length() == 0) return res;
        StringBuilder stringBuilder = new StringBuilder();
        traceback(stringBuilder,digits,res,0);
        return res;
    }
    private void traceback(StringBuilder builder,String digits,List<String> res,int index){
        //if(index>digits.length()-1) return;
        if(index==digits.length()-1){    //说明不可以下一步递归,即当前位是最后一位
            for (char c: MAP.get(digits.charAt(index))) {
                builder.append(c);
                if(!res.contains(builder.toString())){
                    res.add(builder.toString());
                }
                builder.deleteCharAt(index);
            }
            return;
        }
        //可以进行下一步递归
        for (char c: MAP.get(digits.charAt(index))) {
            builder.append(c);
            traceback(builder,digits,res,index+1);
            builder.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        N17LetterCombinationsofaPhoneNumber number = new N17LetterCombinationsofaPhoneNumber();
        System.out.println(number.letterCombinations("235"));
    }
}
