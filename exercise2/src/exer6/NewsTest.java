package exer6;

import java.util.ArrayList;
import java.util.ListIterator;

/**
  * 创建LinkedList实例化对象，练习具有队列特点的方法
  *
  * 按要求实现下列问题：
  * 1)封装一个新闻类，包含标题和内容属性，提供get、set方法，重写toString方法，打印对象时只打印标题；（10分）
  *
  * 2)只提供一个带参数的构造器，实例化对象时，只初始化标题；并且实例化两个对象：
  * 新闻一：中国多地遭雾霾笼罩空气质量再成热议话题
  * 新闻二：春节临近北京“卖房热”
  *
  * 3)将新闻对象添加到ArrayList集合中，并且使用ListIterator倒序遍历；
  *
  * 4)在遍历集合过程中，对新闻标题进行处理，超过15字的只保留前14个，然后在后边加“…”
  *
  * 5)在控制台打印遍历出经过处理的新闻标题；
  * @author: 86173
  * @date: 2021/4/23 21:26
  */
public class NewsTest {
     public static void main(String[] args) {

         New new1 = new New("中国多地遭雾霾笼罩空气质量再成热议话题");
         New new2 = new New("春节临近北京“卖房热”");

         ArrayList list = new ArrayList();
         list.add(new1);
         list.add(new2);

         ListIterator it = list.listIterator();
         for(it = list.listIterator();it.hasNext();){
             it.next();
         }
         for(;it.hasPrevious();){
             Object obj = it.previous();
             New news = (New)obj;

             if(news.getTitle().length() > 15){
                 System.out.println(news.getTitle().substring(0,14));
             }else{
                 System.out.println(news.getTitle());
             }


//             System.out.println(it.previous());
         }

     }


}

class New{

    private String title;
    private String detail;

    public New(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                '}';
    }
}