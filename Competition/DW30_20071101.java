/**
 * 双周赛30-2020-07-11 第1题 	1507. 转变日期格式
 */

package LeetcodeJava.Competition;

public class DW30_20071101 {
    public static void main(String[] args) {
        String date = "26th May 1960";
//        String date = "6th Jun 1933";
//        String date = "20th Oct 2052";
        DW30_20071101 obj = new DW30_20071101();
        System.out.println(obj.reformatDate(date));
    }

    public String reformatDate(String date) {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        StringBuilder ans = new StringBuilder();
//        for(int i = 0;i<date.length();i++){
//
//        }
        int i = 0;
        while(date.charAt(i)<='9' && date.charAt(i)>='0'){
            ans.append(date.charAt(i));
            i++;
        }
        if(i<2) ans.insert(0,0);
        ans.insert(0,'-');
        i+=3;

        String month = date.substring(i,i+3);
        for(int j=0;j<months.length;j++){
            if(month.equals(months[j])){
                if((j+1)>=10){
                    ans.insert(0,j+1);
                }else{
                    ans.insert(0,j+1);
                    ans.insert(0,0);
                }
                break;
            }
        }
        ans.insert(0,'-');
        i++;

        ans.insert(0,date.substring(i+3,i+7));

        return ans.toString();
    }

}
