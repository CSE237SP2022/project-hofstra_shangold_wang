package textAcceptor;

import java.util.ArrayList;
import java.util.Scanner;

public class TextInput {

	private Scanner input;
	private ArrayList<String> arguments;
	
	public TextInput() {
		this.input = new Scanner(System.in);
		this.arguments = new ArrayList<String>();
	}
	
	public String getNextLineOfText() {
				
		if (input.hasNextLine()) {
			String line = input.nextLine().toString();
			return line;
		}
		return null;
	}
	
	public String getNextArgument() {
		
		if (input.hasNext()) {
			String line = input.next().toString();
			return line;
		}
		return null;
	}
	
	public ArrayList<String> getAllArguments() {
		String line = getNextLineOfText();
		System.out.println("LINE: "+line);
		String tempArgument = "";
		
		for (int i = 0; i < line.length(); i++) {
			if (line != " ") {
				tempArgument += line.charAt(i);
				System.out.println(tempArgument);
			} else if (line == " " || getNextArgument() == null){
				this.arguments.add(tempArgument);
				tempArgument = "";
			}
		}
		
		System.out.println(arguments);
		
		
		return this.arguments;
	}
	
	
	
	public static void main(String[] args) {
		TextInput text = new TextInput();
		System.out.println(text.getAllArguments().toString());
		
//		ArrayList<String> argums = text.getAllArguments();
		
//		for (int i = 0; i < argums.size(); i++) {
//			
//		}
	}
}
