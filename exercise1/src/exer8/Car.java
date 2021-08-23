package exer8;
 /**
  * 有一个Car类，有属性temperature（温度），车内有Air（空调），
  * 有吹风的功能flow，Air会监视车内的温度，如果温度超过40度则吹冷气。
  * 如果温度低于0度则吹暖气，如果在这之间则关掉空调。实例化具有不同温度的Car对象，
  * 调用空调的flow方法，测试空调吹的风是否正确
  *
  * @author: 86173
  * @date: 2021/4/20 10:50
  */
public class Car {

     public static void main(String[] args) {

         Car c1 = new Car();
         c1.temperature = 20;
         Air air = c1.new Air();
         air.flow();


     }

    public  double temperature;


     class Air{
        public void flow(){
            if(temperature > 40){
                System.out.println("吹冷风");
            }else if (temperature < 0){
                System.out.println("吹暖风");
            }else{
                System.out.println("空调关闭");
            }
        }

    }
}


