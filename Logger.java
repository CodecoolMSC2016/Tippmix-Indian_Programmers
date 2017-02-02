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
	public void printTeamTable(String[] input){
	int TeamNumber = 1;
	for(String elements:input){
	System.out.println(TeamNumber + ". " + elements);
	TeamNumber++;}
	

   // do something
}
		
}

