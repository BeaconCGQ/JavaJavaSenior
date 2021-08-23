package exer8;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
  * 1）试题内容如下：
  * (1)北京奥运是什么时间开幕的？
  *    A.2008-08-08  B. 2008-08-01
  * C.2008-10-01 D. 2008-07-08
  * ********************
  * (2)下列哪个国家不属于亚洲？
  *    A.沙特  B.印度 C.巴西  D.越南
  * ********************
  * (3)下列哪个国家最爱足球？
  *    A.刚果  B.越南 C.老挝  D.巴西
  * ********************
  * (4)下列哪种动物属于猫科动物？
  *    A.鬣狗  B.犀牛 C.大象 D.狮子
  * ********************
  *
  * 输入选择的答案（A、B、C、D）：A
  * @author: 86173
  * @date: 2021/4/25 22:36
  */
public class IOTest2 {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        ArrayList<Character> list = new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('D');

        BufferedWriter bw = new BufferedWriter(new FileWriter("shi.txt"));
        bw.write("1）试题内容如下：\n(1)北京奥运是什么时间开幕的？\nA.2008-08-08  B. 2008-08-01\nC.2008-10-01 D. 2008-07-08\n" +
                "********************\n(2)下列哪个国家不属于亚洲？\nA.沙特  B.印度 C.巴西  D.越南\n********************\n(3)下列哪个国家最爱足球？\n" +
                "A.刚果  B.越南 C.老挝  D.巴西\n********************");
        bw.close();
        int i =0,score= 0;
        BufferedReader br = new BufferedReader(new FileReader("shi.txt"));
        String data;
        while((data = br.readLine()) != null){
            while(data.charAt(0) != '*'){
                System.out.println(data);
                data = br.readLine();
            }
            System.out.println("输入选择的答案（A、B、C、D）：");
            InputStreamReader isr = new InputStreamReader(System.in);

            char c = (char) isr.read();
            if(list.get(i).equals(c)){
                score += 25;
            }
            i++;
        }

        System.out.println(score);
        br.close();
    }
}
