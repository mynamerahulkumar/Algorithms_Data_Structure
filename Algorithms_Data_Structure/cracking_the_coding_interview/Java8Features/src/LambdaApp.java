

@FunctionalInterface
interface  Cab{ // functional interface has exactly one method
   // void bookcab(); // by default abstract public
  //  void bookcab(String source,String destination);
    double bookcab(String source,String destination);
}
//class Uberx implements  Cab{
//    @Override
//    public void bookcab() {
//        System.out.println("Uberx arriving soon");
//    }
//}

public class LambdaApp {
    public int instanceVar=10;// we can use this variable in lambda expression also
    static  int sVar=100;
    public static void main(String[] args) {
        // 1st method
//        Cab cab=new Uberx();//polymorphic statement
//        cab.bookcab();//

        // 2nd method
        // anonymyous class implementation
//        Cab cab =new Cab() {
//            @Override
//            public void bookcab() {
//                System.out.println("Uberx arriving soon");
//            }
//        };
//        cab.bookcab();

        // 3rd using lambda expression ->always works with function interfaces means it will have only one fn
//        Cab cab=()->{
//            System.out.println("Uberx arriving soon");
//        };
//        cab.bookcab();

        // lambda expression using parameter
        Cab cab=(sourc,destination)->{
            System.out.println("Uberx arriving soon from "+sourc+" to "+destination);
            // we can use the variable which is outside lambda expression
           // System.out.println(instanceVar);
            System.out.println(LambdaApp.sVar);
            int localvar=10;
            return 850.12;
        };
        double fare=cab.bookcab("India","Ireland");
        System.out.println("total fare will be="+fare);

    }


}
