package test;

import java.io.*;

public class third {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new FileReader("./src/test/server_logs.txt"));
            File f=new File("./src/test/urgent_errors.txt");
            f.createNewFile();
            FileWriter fw=new FileWriter(f,true);
            String line;
            while((line=br.readLine())!=null){
                if(line.contains("[ERROR]")){
                    fw.write(line+"\n");
                }
            }
            fw.close();
            br.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
