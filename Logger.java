public class Logger{
	
	public void print(String str, boolean newLine){
		if (newLine){
			System.out.println(str);
		}else {
			System.out.print(str);
		}
	}
	public void print(String str){
		System.out.print(str);
	}
}
