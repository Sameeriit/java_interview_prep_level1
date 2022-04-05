package ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class removePrime {

    public static boolean isPrime(int val){
        for(int div = 2; div*div <= val; div++){
            if(val % div == 0){
                return false;
            }

        }
        return true;

    }


    public static void solution(ArrayList<Integer>ls){
        for(int i = ls.size()-1; i>=0; i--){
            int val = ls.get(i);
            if(isPrime(val) == true){
                ls.remove(i);
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ls.add(sc.nextInt());
        }
        solution(ls);
        System.out.println(ls);

    }


}
