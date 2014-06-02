import java.io.*;
import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String line;
	    boolean[] flag = new boolean[255];
		try{
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));

	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.split(",");
	            Arrays.fill(flag, true);
	            String s = lineArray[0].trim();
	            String t = lineArray[1].trim();
	            for(int i = 0; i < t.length(); i++){
	            	flag[(int)(t.charAt(i))] = false;
	            }
	            StringBuffer sb = new StringBuffer();
	            for(int i = 0; i < s.length(); i++){
	            	char c = s.charAt(i);
	            	if(flag[(int)c]){
	            		sb.append(c);
	            	}
	            }
	            System.out.println(sb);
	        }
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	}
}
