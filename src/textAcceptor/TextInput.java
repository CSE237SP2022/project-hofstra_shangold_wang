package textAcceptor;

import java.util.ArrayList;
import java.util.Scanner;

public class TextInput {

	public Scanner input;
	public ArrayList<String> arguments;
	
	public TextInput() {
		this.input = new Scanner(System.in);
		this.arguments = new ArrayList<String>();
	}
	
//	public String getNextLineOfText() {
//				
//		if (input.hasNextLine()) {
//			String line = input.nextLine().toString();
//			return line;
//		}
//		return null;
//	}
//	
//	public String getNextArgument() {
//		
//		if (input.hasNext()) {
//			String line = input.next().toString();
//			return line;
//		}
//		return null;
//	}
	
	public ArrayList<String> getAllArguments() {
		String line = input.nextLine();
		String tempArgument = "";
		
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != ' ') {
				tempArgument += line.charAt(i);
//				System.out.println(tempArgument);
			} 
			
			if (line.charAt(i) == ' ' || (i + 1 == line.length())){
				this.arguments.add(tempArgument);
				tempArgument = "";
			}
		}
		
//		System.out.println(arguments);
		
//		this.input.close();
		return this.arguments;
	}
	
	
	
	public static void main(String[] args) {
		TextInput text = new TextInput();
//		System.out.println(text.getAllArguments().toString());
		text.getAllArguments();
		
//		ArrayList<String> argums = text.getAllArguments();
		
//		for (int i = 0; i < argums.size(); i++) {
//			
//		}
	}
}
