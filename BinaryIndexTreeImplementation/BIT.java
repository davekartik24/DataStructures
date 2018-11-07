
import java.util.*;

public class BIT{

	private int[] bitArray;
	public int size;

	public BIT(int size) {
		this.size = size;
		bitArray = new int[size + 1];
 	}


 	public void update(int value, int i) {

 		++i;

 		while(i <= size) {
 			bitArray[i] += value; 
 			i += Integer.lowestOneBit(i);
 		}
 	}

 	public int prefixSum(int i) {

 		++i;

 		int sum = 0;

 		while(i > 0) {

 			sum += bitArray[i];
 			i -= Integer.lowestOneBit(i);
 		}

 		return sum;
 	}

 	public void constructBIT(int[] inputArray) {

 		int length = inputArray.length;

 		for(int i = 0; i < length; i++) {

 			update(inputArray[i], i);
 		}

 	}

 	public int rangeSum(int i, int j) {

 		return prefixSum(j) - prefixSum(i - 1);
 	}


	public static void main(String[] args) {


		int freq[] = {2, 1, 1, 3, 2, 3, 
					4, 5, 6, 7, 8, 9}; 
		
		BIT tree = new BIT(freq.length); 

		// Build fenwick tree from given array 
		tree.constructBIT(freq); 

		System.out.println("Sum of elements in arr[0..5]"+ 
						" is "+ tree.prefixSum(5)); 
		
		// Let use test the update operation 
		freq[3] += 6; 
		
		// Update BIT for above change in arr[] 
		tree.update(6, 3); 

		// Find sum after the value is updated 
		System.out.println("Sum of elements in arr[0..5]"+ 
					" after update is " + tree.prefixSum(5)); 

		System.out.println("The sum of the range from 4 to 8 is : " + tree.rangeSum(4, 8));

	}
}