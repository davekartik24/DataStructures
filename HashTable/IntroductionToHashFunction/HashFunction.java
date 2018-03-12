import java.util.*;

public class HashFunctionRevised {

	String[] theArray;
	int maxSize;

	int arrayCount;


	public HashFunctionRevised(int maxSize) {

		this.maxSize = maxSize;
		theArray = new String[maxSize];

		Arrays.fill(theArray, "-1");
	}


	public void HashFunctionOne(String[] inputArray) {

		for(String i : inputArray) {

			theArray[Integer.parseInt(i)] = i;
		
		}
	}


	public void HashFunctionTwo(String[] inputArray) {

		for(String i : inputArray) {

			int index = Integer.parseInt(i) % maxSize;

			while(!theArray[index].equals("-1")) {

				++index;

				index %= maxSize;
			}

			theArray[index] = i;
		}
	}

	public String findHashFunction(String key) {

		int indexToSearch = Integer.parseInt(key) % maxSize;

		while(!theArray[indexToSearch].equals("-1")) {

			if(theArray[indexToSearch].equals(key)) {

				return "The key is found at index " + indexToSearch + " of the array";

			}

			indexToSearch++;
			indexToSearch %= maxSize;
		}

		return "The key is not present in the HashTable";
	} 

	public static void main(String[] args) {

		HashFunctionRevised hashFunctionCheck = new HashFunctionRevised(12);

		String[] inputArray = {"10","1", "2", "3", "0", "9"};

		hashFunctionCheck.HashFunctionTwo(inputArray);

		System.out.println(hashFunctionCheck.theArray[4]);

		System.out.println(hashFunctionCheck.findHashFunction("4"));

	}
}