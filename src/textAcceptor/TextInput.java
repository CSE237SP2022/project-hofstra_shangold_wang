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
	
	public ArrayList<String> getAllWordsOfInputtedText() {
		String line = input.nextLine();
		String tempArgument = "";
		
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != ' ') {
				tempArgument += line.charAt(i);
			} 
			
			if (line.charAt(i) == ' ' || (i + 1 == line.length())){
				this.arguments.add(tempArgument);
				tempArgument = "";
			}
		}
		return this.arguments;
	}
	
	public void printOutWordsInListFormat(boolean listFormat) {
		ArrayList<String> words = getAllWordsOfInputtedText();
		System.out.println(words);
	}
	
	public void printOutWordsInOriginalFormat() {
		ArrayList<String> words = getAllWordsOfInputtedText();
		for (String word : words) {
			System.out.print(word + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		TextInput text = new TextInput();
		
	}
}
