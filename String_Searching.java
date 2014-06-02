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
            String[] arrays = line.split(",");
            String s = arrays[0];
            String t = arrays[1];
            boolean found = false;
            int j = 0;
            int lastStarS = -1;
            int lastStarT = -1;
            boolean hasStar = false;
            for(int i = 0; i < s.length(); i++){
            	if(found) break;
            	int ii = i;
            	j = 0;
            	while(ii < s.length() && j < t.length()){
            		if(t.charAt(j) == '*'){
            			hasStar = true;
            			lastStarS = ii;
            			j++;
            			lastStarT = j;
            		}
            		else if(s.charAt(ii)!=t.charAt(j)){
            			if(hasStar){
            				lastStarS++;
            				ii = lastStarS;
            				j = lastStarT;
            			}
            			else{
            				break;
            			}
            		}
            		else{
            			j++;
            			ii++;
            		}
            	}
            	if(j == t.length()){
            		found = true;
            	}
            }
            if(found){
            	System.out.println("true");
            }
            else{
            	System.out.println("false");
            }
            
        }
    }
}
