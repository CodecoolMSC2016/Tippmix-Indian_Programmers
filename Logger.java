import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Logger{
	public static ArrayList<String> teamPairs;
	
	public void print(String str, boolean newLine){
		if (newLine){
			System.out.println(str);
		}else {
			System.out.print(str);
		}
	}

	public void generateHistory()
	{try{
    	PrintWriter writer = new PrintWriter("History.csv", "UTF-8");
    	for(String matches:teamPairs){
		writer.println(matches);
    		writer.close();
	}} catch (IOException e) {}
   // do something
}
		
}

