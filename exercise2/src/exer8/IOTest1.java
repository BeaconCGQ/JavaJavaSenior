package exer8;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

/**
  * @description:
  * @author: 86173
  * @date: 2021/4/25 20:01
  */
public class IOTest1 {
    // 先将“欢迎您来北京尚硅谷学习，高薪就业”写入到文件”hello.txt”中，再读取该文件中的内容。
     @Test
    public void test1() throws IOException {

         File file = new File("hello.txt");

          FileWriter fw = new FileWriter(file);
          fw.write("欢迎您来北京尚硅谷学习，高薪就业");

         fw.close();


          FileReader fr = new FileReader(file);
          char[] cbuf = new char[5];
          int len;
          while((len = fr.read(cbuf)) != -1){

              String s = new String(cbuf,0,len);
              System.out.print(s);

          }

          fr.close();
     }

    @Test
            public void test5() throws IOException {

//编写程序向文本文件中写入自己的信息，格式为：姓名：XXX 性别：X 年龄：XX 班级：XXX，将该信息读出后显示的屏幕上后把文件删除。

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.dat"));


        oos.writeObject(new Student("cgq",'男',23));
        oos.flush();
        oos.writeObject(new Student("lxjj",'女',25));
        oos.flush();
        oos.close();

    }


    @Test
    public void test3() throws IOException, ClassNotFoundException {

         ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.dat"));

        Student s = (Student) ois.readObject();
        Student s1 = (Student) ois.readObject();

        System.out.println(s);

        System.out.println(s1);

    }

    @Test
    public void test2() throws IOException {

         //（字符流）读取一个文本文件，每行都追加一个“好”，在文件结尾再追加“完毕”。
      BufferedReader br = new BufferedReader(new FileReader("test.txt"));
      BufferedWriter bw = new BufferedWriter(new FileWriter("test2.txt"));
        ArrayList<String> list = new ArrayList<>();

      String data;
      while((data = br.readLine()) != null){
          data += "好";
          list.add(data);
      }
      for(int i = 0;i < list.size();i++){
          if(i == list.size() -1){
              list.set(i,list.get(i) + "完毕");
              bw.write(list.get(i));
              break;
          }else{
              bw.write(list.get(i));
              bw.newLine();
          }
      }
        br.close();
        bw.close();
    }

    @Test
    public void test7() throws IOException {
        //使用RandomAccessFile流将一个文本文件倒置读出。

        try{
            RandomAccessFile random=new RandomAccessFile("test.txt","rw");    //以随机读取方式打开文件
            random.seek(0);
            long m=random.length();               //m = 文件长度
            while (m >= 0){
                m--;                                      //每次循环m都减1,等于从后往前
                random.seek(m);                    //定位到文件中第m个字符
                int c=random.readByte();        //c被赋值为文件中第m个字符
                if(c<=255&&c>=0)  {
                    System.out.print((char)c);       //如果asc码<=255,>=0,则判断是个英文字符,直接打印.
                }
                else {                                   //如果不在asc码范围内,则判断是个汉字字符
                    m--;                                   //汉字字符是占2个字节的,所以m再退一个字节(m=m-1)

                    random.seek(m);
                    byte cc[]=new byte[2];
                    random.readFully(cc);               //cc被复制为文件中连续的两个字节
                    System.out.print(new String(cc)); //把cc转换为字符串,打印(这里会打印出汉字)
                }
            }
        }catch(IOException e){}
    }

        }





