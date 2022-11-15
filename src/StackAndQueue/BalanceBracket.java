package StackAndQueue;
import java.util.*;


public class BalanceBracket {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{'|| ch == '['){
                st.push(ch);
            }else if(ch == ')'){
                boolean val = handler(st,'(');
                if(val == false){
                    System.out.println(val);
                    return;
                }

            }else if(ch == '}'){
                boolean val = handler(st,'{');
                if(val == false){
                    System.out.println(val);
                    return;
                }

            }else if(ch == ']'){
                boolean val = handler(st,'[');
                if(val == false){
                    System.out.println(val);
                    return;
                }

            }else{

            }
        }
        if(st.size()== 0){
            System.out.println(true);

        }else{
            System.out.println(false);
        }
    }

    public static boolean handler(Stack<Character> st, char crossponding_ch){
        if(st.size() == 0){
            return false;
        }else if(st.peek() != crossponding_ch){
            return false;
        }else{
            st.pop();
            return true;
        }
    }
}
