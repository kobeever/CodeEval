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
    public static boolean isPalindrome(int num){
        char[] array = Integer.toString(num).toCharArray();
        int s = 0;
        int t = array.length - 1;
        while(s < t){
            if(array[s] != array[t]){
                return false;
            }
            s++;
            t--;
        }
        return true;
    }
    public static void main (String[] args) {
        try{
            File file = new File(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                int start = Integer.parseInt(lineArray[0]);
                int end = Integer.parseInt(lineArray[1]);
                int dp[][] = new int[end-start+2][2];
                dp[0][0] = 0;//even palindrome start from start - 1
                dp[0][1] = 0;//odd palindrome start from start - 1
                int sum = 0;
                for(int i = start; i <= end; i++){
                    if(isPalindrome(i)){
                        //even
                        dp[i-start+1][0] = dp[i-start][1];
                        //odd
                        dp[i-start+1][1] = dp[i-start][0] + 1;
                    }
                    else{
                        //even
                        dp[i-start+1][0] = dp[i-start][0] + 1;
                        //odd
                        dp[i-start+1][1] = dp[i-start][1];
                    }
                    sum+= dp[i-start+1][0];
                }
                System.out.println(sum);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
