/*Sample code to read in test cases:
public class Main {
    public static void main (String[] args) {
    ...
    File file = new File(args[0]);
    BufferedReader in = new BufferedReader(new FileReader(file));
    String line;
    while ((line = in.readLine()) != null) {
        String[] lineArray = line.split("\s");
        if (lineArray.length > 0) {
            //Process line of input Here
        }
    }
  }
}
*/
import java.io.*;
public class Main {
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                StringBuffer sb = new StringBuffer(line);
                int len = sb.length();
                if(len == 1){
                    if(sb.charAt(0)!='0'){
                        System.out.println(line+"0");
                    }
                    //continue;
                }
                int i = 0;
                for(i = len - 2; i >=0; i--){
                    if(sb.charAt(i) >= sb.charAt(i+1)){
                        continue;
                    }
                    else{
                        int index = len-1;
                        char c = sb.charAt(i);
                        while(sb.charAt(index) <= c){
                            index--;
                        }
                        char temp = sb.charAt(index);
                        sb.setCharAt(index, c);
                        sb.setCharAt(i, temp);
                        System.out.println(sb.substring(0,i+1)+new StringBuffer(sb.substring(i+1,len)).reverse());
                        break;
                    }
                }
                if(i == -1){
                    int index = len-1;
                    while(sb.charAt(index)=='0'){
                        index--;
                    }
                    char temp = sb.charAt(index);
                    sb.setCharAt(index, '0');
                    System.out.println(temp +""+ sb.reverse());
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
