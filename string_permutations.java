import java.io.*;
import java.util.*;
public class Main{
    public static void FindSolution(StringBuffer sb, ArrayList<String> res, char[] token, boolean[] flag){
        if(sb.length() == token.length){
            res.add(new String(sb));
            return;
        }
        for(int i = 0; i < token.length; i++){
            if(flag[i]){
                flag[i] = false;
                sb.append(token[i]);
                FindSolution(sb, res, token, flag);
                sb.deleteCharAt(sb.length()-1);
                flag[i] = true;
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner = null;
        try{
            scanner = new Scanner(new File(args[0]));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            char[] token = line.toCharArray();
            Arrays.sort(token);
            ArrayList<String> result = new ArrayList<String>();
            boolean[] flag = new boolean[token.length];
            Arrays.fill(flag, true);
            StringBuffer sb = new StringBuffer();
            FindSolution(sb, result, token, flag);
            for(int i = 0; i < result.size(); i++){
                System.out.print(result.get(i));
                if(i == result.size() - 1){
                    System.out.print("\n");
                }
                else{
                    System.out.print(",");
                }
            }
        }
    }
}
