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
////		TextInput mockScanner = new TextInput();
//		
//	}
	
	@Test
	void getOneArgumentTest() {
		TextInput text = new TextInput();
		ArrayList<String> arguments = text.getAllArguments();
		
		ArrayList<String> testArguments = new ArrayList<String>();
		testArguments.add("test");
		
		assertEquals(testArguments, arguments);
		
	}
	
	@Test
	void getTwoArgumentsTest() {
		TextInput text = new TextInput();
		ArrayList<String> arguments = text.getAllArguments();
		
		ArrayList<String> testArguments = new ArrayList<String>();
		testArguments.add("test");
		testArguments.add("hello");
		
		assertEquals(testArguments, arguments);
		
	}
	
	@Test
	void getThreeArgumentsTest() {
		TextInput text = new TextInput();
		ArrayList<String> arguments = text.getAllArguments();
		
		ArrayList<String> testArguments = new ArrayList<String>();
		testArguments.add("test");
		testArguments.add("hello");
		testArguments.add("world");
		
		assertEquals(testArguments, arguments);
		
	}
	
	
	

}