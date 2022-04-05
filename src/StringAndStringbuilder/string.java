package StringAndStringbuilder;

public class string {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder("hello");
//        System.out.println(sb);
//
//
//        char ch = sb.charAt(0);
//        System.out.println(ch);
//
//        sb.setCharAt(0,'d');
//        System.out.println(sb);
        /**
        String str = "hello";
        System.out.println(str);
        char ch = str.charAt(3);
        System.out.println(ch); */

        int num = 100000;
        long start = System.currentTimeMillis();

//      StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < num; i++){
//            sb.append(i);
//        }
        String s = "";
        for(int i = 0 ; i < num; i++){
           s +=i;
         }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.println(duration);


    }
}
