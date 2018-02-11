import java.util.*;

public class Stack { 

	int stackSize;

	String[] stackArray;

	int topOfStackPointer = -1;

	public Stack(int stackSize) {

		this.stackSize = stackSize;

		stackArray = new String[stackSize];

		Arrays.fill(stackArray, "-1");
	}

	public void push(String input) {

		if(++topOfStackPointer < stackSize) {

			stackArray[topOfStackPointer] = input;
			
		} else {

			System.out.println("StackOverflow");
		}
	}

	public String pop() {

		String popResult = null;

		if(topOfStackPointer != -1) {

			popResult = stackArray[topOfStackPointer];
			stackArray[topOfStackPointer] = "-1";
			--topOfStackPointer;


		} else {

			System.out.println("Stack Empty");

		}

		return popResult;
	}

	public String peek() {

		if(topOfStackPointer != -1) {

			return stackArray[topOfStackPointer];
		} else {

			System.out.println("The stack is empty");
		}

		return null;
	}

	public void pushAll(String input) {

		String[] addArray = input.split(" ");

		if((stackSize - topOfStackPointer) > addArray.length) {

			for(String elements : addArray) {

				push(elements);
			}

		} else {

			System.out.println("StackOverflow");
		}
	}

	public void popAll() {

		while(topOfStackPointer != -1) {

			stackArray[topOfStackPointer] = "-1";
			--topOfStackPointer;
		}
	}

	public void stackDisplay() {

		for (String elements : stackArray) {

			System.out.print(elements + " ");
		
		}

	}


	public static void main(String[] args) {

		Stack testStack = new Stack(5);

		testStack.pushAll("1 2 3 4 5");

		testStack.popAll();
		
		System.out.println(testStack.peek());
	}

}