public class TestHcl {
    public static void main(String[] args){
        //{1,2,3},{4,5},{6}}
       String  arr="{{133,2,3},{4,5},6}";
       String[] strArr=arr.split(",");
       for(int i=0;i<strArr.length;i++){
           strArr[i]=strArr[i].replaceAll("\\{","");
           strArr[i]=strArr[i].replaceAll("}","");
       }
        int res=0;
        for(int i=0;i<strArr.length;i++){
            String s=strArr[i];
            Integer a=Integer.valueOf(s);
            res+=a;

        }
        System.out.println(res);
    }
}
