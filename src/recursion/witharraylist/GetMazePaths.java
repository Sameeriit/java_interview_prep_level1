package recursion.witharraylist;
import java.util.*;

public class GetMazePaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<String> paths = getMazePaths(1,1,n,m);
        System.out.println(paths);
    }
    //ic ->initial row ,ic -> initial column, dr and dc is initial row and column
    public static ArrayList<String> getMazePaths(int ir, int ic, int dr,int dc){
        if(ir == dr && ic == dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        ArrayList<String> pathsH = new ArrayList<>();
        ArrayList<String> pathsV  = new ArrayList<>();

        if(ic < dc){
            pathsH =  getMazePaths(ir,ic+1,dr,dc);

        }
        if(ir < dr){
            pathsV = getMazePaths(ir+1,ic,dr,dc);
        }


        ArrayList<String> paths = new ArrayList<>();

        for(String path : pathsH){
            paths.add("h" + path);
        }
        for(String path : pathsV){
            paths.add("v" + path);

        }
        return paths;

    }
}
