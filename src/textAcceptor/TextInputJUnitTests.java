package textAcceptor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TextInputJUnitTests {
	
//	@BeforeEach
//	void setup() {
//		
//	}
	
	@Test
	void getOneWordTest() {
		TextInput text = new TextInput();
		System.out.println("TYPE: 'test'");
		
		ArrayList<String> arguments = text.getAllWordsOfInputtedText();
		ArrayList<String> testArguments = new ArrayList<String>();
		testArguments.add("test");
		
		
		
		assertEquals(testArguments, arguments);
		
	}
	
	@Test
	void getWordsTest() {
		TextInput text = new TextInput();
		System.out.println("TYPE: 'test hello'");
		
		ArrayList<String> arguments = text.getAllWordsOfInputtedText();
		ArrayList<String> testArguments = new ArrayList<String>();
		testArguments.add("test");
		testArguments.add("hello");
		
		
		
		assertEquals(testArguments, arguments);
		
	}
	
	@Test
	void getThreeWordsTest() {
		TextInput text = new TextInput();
		System.out.println("TYPE: 'test hello world'");
		
		ArrayList<String> arguments = text.getAllWordsOfInputtedText();
		ArrayList<String> testArguments = new ArrayList<String>();
		testArguments.add("test");
		testArguments.add("hello");
		testArguments.add("world");
		
		
		
		assertEquals(testArguments, arguments);
		
	}
	
	@Test
	void getSentenceWithPunctuationTest() {
		TextInput text = new TextInput();
		System.out.println("TYPE: 'hello world, this is a program!!'");
		
		ArrayList<String> arguments = text.getAllWordsOfInputtedText();
		ArrayList<String> testArguments = new ArrayList<String>();
		testArguments.add("hello");
		testArguments.add("world,");
		testArguments.add("this");
		testArguments.add("is");
		testArguments.add("a");
		testArguments.add("program!!");
		
		
		
		assertEquals(testArguments, arguments);
		
	}
	
	

}