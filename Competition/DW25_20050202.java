/**
 * 双周赛25-2020-05-02 第2题 1432. 改变一个整数能得到的最大差值
 */

package LeetcodeJava.Competition;

public class DW25_20050202 {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        int i=0;
        while (i<s.length() && s.charAt(i)=='9') {
            i++;
        }
        int a=0, b=0;
        if (i==s.length()){
            a = num;
            for(char c : s.toCharArray()){
                b = b*10 + 1;
            }
            return (a-b);
        }
        else{
            boolean notOne =false;
            int changeVal=s.charAt(0);

            for(char c : s.toCharArray()){
                if(c==s.charAt(i)){
                    a = a*10 + 9;
                }else{
                    a = a*10 + c-'0';
                }
            }
            if (s.charAt(0)!='1'){
                notOne = true;
            }else{
                changeVal = -1;
            }


            if(notOne){
                for(char c : s.toCharArray()){
                    if(changeVal==c){
                        b = b*10 + 1;
                    }
                    else{
                        b = b*10 + c-'0';
                    }
                }
            }else{
                int j=0;
                while(j<s.length()&&(s.charAt(j)==s.charAt(0)||s.charAt(j)=='0')) j++;
                if (j==s.length())  {
                    b=num;
                    return a-b;
                }
                else changeVal = s.charAt(j);
//                System.out.println(j);
                for(char c : s.toCharArray()){
                    if(changeVal==c){
                        b = b*10;
                    }
                    else{
                        b = b*10 + c-'0';
                    }
                }
            }


        }
//        System.out.println(a+" "+b);
        return a-b;
    }

    public static void main(String[] args) {
        int num = 9288;
        DW25_20050202 obj = new DW25_20050202();
        int solution = obj.maxDiff(num);
        System.out.println(solution);
    }
}
