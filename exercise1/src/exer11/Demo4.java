package exer11;

public class Demo4 {
    public static void main(String[] args) {
        int[] arr ={1,1,1,1};
        try {
            for(int i = 0 ; i < 5;i++){
                System.out.println(arr[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            System.out.println("这是个异常，不是错误");
        }
    }
}
