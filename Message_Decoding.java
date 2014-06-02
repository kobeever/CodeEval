import java.io.*;
import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    String line;
		try{
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));

	        while ((line = in.readLine()) != null) {
	            int index = Math.min(line.indexOf('1'), line.indexOf('0'));
	            String header = line.substring(0, index);
	            String message = line.substring(index);
	            Map<String, Character> map = new HashMap<String, Character>();
	            int grade = 1;
	            int i = 0;
	            int token = 0;
	            String pattern = "%1s";
	            while(i < header.length()){
	            	String key = String.format(pattern, Integer.toBinaryString(token));
	            	map.put(key.replace(' ','0'), header.charAt(i));
	            	i++;
	            	token++;
	            	if((token + 1) == (1<<grade)){
	            		token = 0;
	            		grade++;
	            		pattern = "%"+grade+"s";
	            	}
	            }
	            i = 0;
	            StringBuffer sb = new StringBuffer();
	            while(i < message.length()){
	            	if(message.substring(i, i+3).equals("000")){
	            		break;
	            	}
	            	int count = Integer.parseInt(message.substring(i,i+3), 2);
	            	i+=3;
	            	String t;
	            	while(true){	     
	            		t = message.substring(i, i+count);
	            		i+=count;
	            		if(t.contains("0")){
	            			sb.append(map.get(t));
	            		}
	            		else{
	            			break;
	            		}
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
