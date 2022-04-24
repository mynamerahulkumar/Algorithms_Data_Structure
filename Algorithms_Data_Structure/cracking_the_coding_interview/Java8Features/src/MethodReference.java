
interface  Calculator{
    void add(int n1,int n2);
}
class  CalC{
    public  static void addSomething(int num1,int num2){ // it has same parameter as interface
        System.out.println("num1+num2="+(num1+num2));
    }
    public  void letsadd(int num1,int num2){
        System.out.println("num1+num2="+(num1+num2));
    }
}

interface  Messanger{
    Message getMessage(String msg);
}
class Message{
    Message(String msg){
        System.out.println("Message is "+msg);
    }
}

public class MethodReference {
        public static void main(String[] args) {
           // CalC.addSomething(20,10);

            //1 .Referring to a static method
            Calculator cRef=CalC::addSomething;// method reference
            cRef.add(11,14);


            //2.For non static method we need to create the object first
            CalC calC=new CalC();
            Calculator cRef1=calC::letsadd;
            cRef1.add(20,30);

            // 3 using constructor interface
            Messanger mRef=Message::new;
            mRef.getMessage("Search the candle instead of cursing darkness");

        }

}
