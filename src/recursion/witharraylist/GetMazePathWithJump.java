package recursion.witharraylist;
import java.util.*;

/**
 * problem get maze paths with jump means you can do any jump within the maze
 * solution
 * Author : Sameer Ahmad
 * date : 11/06/2022
 */

public class GetMazePathWithJump {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String> paths = getMazePathsWithJump(1,1,n,m);
        System.out.println(paths);

    }
    // ic -> initial col
    // ir -> initial row
    // dc -> destination col
    // dr -> destination row
    // hm -> horizontal move
    // vm -> vertical move
    // dm -> move size

    public static ArrayList<String> getMazePathsWithJump(int ir, int ic, int dr,int dc){

        if(dr == ir && dc== ic){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        if(dc < ic || dr < ir){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }


        ArrayList<String> paths = new ArrayList<>();

        // Horizontal path
        for(int hm = 1; hm <= dc-ic; hm++){
            ArrayList<String> hpaths = getMazePathsWithJump(ir,ic+hm,dr,dc);
            for(String path: hpaths){
                paths.add("h"+hm+path);  // here adding jump
            }
        }
        // vertical path
        for(int vm = 1; vm <= dr-ir; vm++){
            ArrayList<String> vpaths = getMazePathsWithJump(ir+vm,ic,dr,dc);
            for(String path: vpaths){
                paths.add("v"+vm+path); // here adding jump
            }
        }
        // diagonal move
        for(int dm = 1; dm <= dr-ir && dm <= dc-ic; dm++){
            ArrayList<String> dpaths = getMazePathsWithJump(ir+dm,ic+dm,dr,dc);
            for(String path : dpaths){
                paths.add("d"+dm+path);
            }
        }

        return paths;

    }

}
