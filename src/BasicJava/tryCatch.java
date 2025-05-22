package BasicJava;

public class tryCatch {

    static int numb(){
        try {
            System.out.println("in try");
            return 0;

        }
        catch(Exception e){
            return 1;
        }
        finally {
            //System.out.println("in finally");
            return 2;

        }
    }

    public static void main(String[] args) {
        System.out.println(numb());
    }
}
