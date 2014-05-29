import java.io.*;
import java.util.*;
public class Main {
    public static void main (String[] args) {
    	Scanner inputScanner = null;
		try {
			inputScanner = new Scanner(new File(args[0]));
		}
		catch (Exception e) {
			System.err.println("Invalid file input");
		}
        ArrayList<Integer> fibonacci = new ArrayList<Integer>();
        fibonacci.add(1);
        fibonacci.add(1);
        while (inputScanner.hasNextLine()) {
            int n = Integer.parseInt(inputScanner.nextLine());
            if(n==0){
            	System.out.println(0);
            }
            else if(n < fibonacci.size()){
                System.out.println(fibonacci.get(n-1));
            }
            else{
                for(int i = fibonacci.size(); i < n; i++){
                    fibonacci.add(fibonacci.get(i-2) + fibonacci.get(i-1));
                }
                System.out.println(fibonacci.get(fibonacci.size()-1));
            }
        }
    }
}