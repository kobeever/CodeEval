import java.io.*;
import java.util.*;
public class Main {
    public static void main (String[] args) {
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(args[0]));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            int[] helper = new int[255];
            Arrays.fill(helper, -1);
            for(int i = 0; i < line.length(); i++){
                int c = (int)line.charAt(i);
                if(helper[c] >= 0){
                    helper[c] = -2;
                }
                else if(helper[c] == 0){
                    helper[c] = i;
                }
            }
            int index = Integer.MAX_VALUE;
            int min = -1;
            for(int i = 0; i < 255; i++){
            	if(helper[i] >= 0 && helper[i]<index){
            		index = helper[i];
            		min = i;
            	}
            }
            if(min!=-1){
            	System.out.println((char)min);
            }
        }
    }
}
