package StackAndQueue;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InfixConversion {
    public static void  main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> optr = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if(ch == '('){
                optr.push(ch);

            }else if((ch >= '0'&& ch <= '9')||(ch >= 'a' && ch <='z')||(ch >= 'A' && ch <= 'Z')){
                postfix.push(ch + "");
                prefix.push(ch + "");

            }else if(ch == ')'){
                while(optr.peek() != '('){
                    operation(optr,postfix,prefix);
                }
                optr.pop();

            }else if( ch == '+' || ch == '-'|| ch == '*'|| ch == '/'){
                while(optr.size() > 0 && optr.peek() != '(' && precedence(ch) <= precedence(optr.peek())){
                    operation(optr,postfix,prefix);
                }
                optr.push(ch);
            }

        }
        while(optr.size() > 0){
            operation(optr,postfix,prefix);
        }
        System.out.println(postfix.pop());
        System.out.println(prefix.pop());

    }
    public static int precedence( char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        }else if(ch == '*' || ch == '/'){
            return 2;
        }else{
            return 0;
        }
    }

    public static void operation(Stack<Character> ops, Stack<String> postfix,Stack<String> prefix){

        char op = ops.pop();
        String postv2 = postfix.pop();
        String postv1 = postfix.pop();
        String postv =  postv1 + postv2 + op;
        postfix.push(postv);



        String prev2 = prefix.pop();
        String prev1 = prefix.pop();
        String prev =  op + prev1 + prev2;
        prefix.push(prev);
    }

}
