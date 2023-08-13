package ARRAY;

 public class Main {

     static class car{
        String Name ;
        int cost;
        car(){
            this.Name = Name;
            this.cost = cost;
        }
        void start(){
            System.out.println("starts");
        }

    }

    public static void main(String[] args){
        car Honda = new car();
        Honda.Name = "x11";
        System.out.println(Honda.Name);
        Honda.start();
    }

}
