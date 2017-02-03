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
	public void print(String str){
		System.out.println(str);
	}
	public void printTable(ArrayList<String> input){
		for (String line: input) {
			print(line);
			System.out.println();
		}
	}
}