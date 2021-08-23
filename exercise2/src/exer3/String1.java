package exer3;

import java.util.ArrayList;
import java.util.List;

/**
  * 请编写一个 Application 实现如下功能：接受命令行中给出的一个字符串，先将该串原样输出，然后判断该串的第一个字母是否为大写，
  *    若是大写则统计该串中大写字母的个数，并将所有大写字母输出；否则输出信息串”第一个字母不是大写字母!”。
  * @author: 86173
  * @date: 2021/4/22 20:19
  */
public class String1 {
     public static void main(String[] args) {

             int count = 0;
             if(args.length > 0){
                 System.out.println(args[0]);
                 if('A'<= args[0].charAt(0) && args[0].charAt(0) <= 'Z'){
                     for(int i = 0; i < args[0].length(); i++){
                         if('A'<= args[0].charAt(0) && args[0].charAt(0) <= 'Z'){
                             System.out.print(args[0].charAt(i));
                             count++;
                         }
                     }
                     System.out.println(count);
             }else{
                     System.out.println("第一个字母不是大写字母！");
                 }


         }

     }

    /**
     * 获取两个字符串中最大相同子串。
     * @param str1
     * @param str2
     * @return
     */
         public static List<String> getMaxSubString(String str1,String str2){
             String maxStr = (str1.length() > str2.length())? str1 : str2;
             String minStr = (str1.length() < str2.length())? str1 : str2;
             int len = minStr.length();
             List<String> list = new ArrayList<>();
             for(int i = 0;i < len;i++){
                 for(int x = 0,y = len - i;y <= len;x++,y++){
                     String str = minStr.substring(x, y);
                     if(maxStr.contains(str)){
                         list.add(str);
                     }
                 }
                 if(list.size() != 0){
                     return list;
                 }
             }
             return null;

     }
}
