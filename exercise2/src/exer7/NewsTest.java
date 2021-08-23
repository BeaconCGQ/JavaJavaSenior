package exer7;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

/**
  * 封装一个新闻类，包含标题、作者、新闻内容和发布时间，新闻标题如下：
  * 新闻一：中国多地遭雾霾笼罩空气质量再成热议话题
  * 新闻二：民进党台北举行“火大游行”
  * 新闻三：春节临近北京“卖房热”
  * 新闻四：春节临近北京“卖房热”
  * 完成如下要求（共50分，每小题10分）：
  * 1）完成对新闻类的设计，要求在初始化新闻类对象时 ，通过构造传参的形式对新闻标题赋值，并要求实例化四个对象，标题内容如题。
  * 2）要求打印新闻对象时，直接打印新闻标题；
  * 3）要求使用equals方法比较新闻时，只要标题相同，就认为是同一新闻，请输出新闻一与新闻二的比较结果，新闻三与新闻四的比较结果。
  * 4）将新闻对象存入HashSet集合中，并且遍历集合，打印新闻类对象；
  * 5）打印集合中新闻数量。
  *
  * @author: 86173
  * @date: 2021/4/24 19:53
  */
public class NewsTest {
    public static void main(String[] args) {

        News new1 = new News("新闻一");
        News new2 = new News("新闻二");
        News new3 = new News("新闻三");
        News new4 = new News("新闻四");
        new1.setTitle("中国多地遭雾霾笼罩空气质量再成热议话题");
        new2.setTitle("民进党台北举行“火大游行”");
        new3.setTitle("春节临近北京“卖房热”");
        new4.setTitle("春节临近北京“卖房热”");

        System.out.println(new1);

        System.out.println(new1.equals(new2));

        HashSet<News> set = new HashSet<>();
        set.add(new1);
        set.add(new2);
        set.add(new3);
        set.add(new4);

        for(News n : set){
            System.out.println(n);
        }

        System.out.println(set.size());
    }

}

class News{

    private String title;
    private String author;
    private String details;
    private Date date;

    public News() {
    }

    public News(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public News(String title, String author, String details, Date date) {
        this.title = title;
        this.author = author;
        this.details = details;
        this.date = date;
    }


    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(getTitle(), news.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }
}