import java.io.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
	        File file = new File(args[0]);
	        BufferedReader in = new BufferedReader(new FileReader(file));
	        String line;
	        while ((line = in.readLine()) != null) {
	            String[] lineArray = line.split("\\s");
	            int temp = Integer.parseInt(lineArray[lineArray.length/2]);
	            for(int i = lineArray.length/2 - 1, j = lineArray.length/2+1; i >= 0;i--,j++) {
	                if(lineArray[i].equals("*")){
	                    temp *= Integer.parseInt(lineArray[j]);
	                }
	                else if(lineArray[i].equals("+")){
	                    temp += Integer.parseInt(lineArray[j]);
	                }
	                else{
	                    temp /= Integer.parseInt(lineArray[j]);
	                }
	            }
	            System.out.println(temp);
	        }
	    }
	    catch(Exception e){
	        e.printStackTrace();
	    }
	}
}
