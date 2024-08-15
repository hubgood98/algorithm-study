package com.study.regx;

import java.io.Console;
import java.io.InputStream;
import java.io.InputStreamReader;

public class homework {
    
    public static void main(String[] args) {
        Console console = System.console();

        System.out.println("command : ");
        String line = console.readLine();
        while(true)
        {
            if(line.equals("종료"))
            {
                break;
            }
            else if(line.equals("도움말"))
            {
                
            }
            System.out.println("input command : "+line);
        }
      
    }
}
