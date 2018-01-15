public class LargestSumSubArray {

	public static void main(String[] args) {

		int[] array = {-2, -3, 4, -1, -2, 1, 5, -3, 3};

		int first = -1;
		int last = -1;
		int outerSum = -10000;

		for(int i = 0; i < array.length; i++) {

			int innerSum = 0; 

			for(int j = i; j < array.length; j++) {

				innerSum += array[j];

				if(innerSum > outerSum) {

					outerSum = innerSum;
					first = i;
					last = j;
				}
			} 
		}

		System.out.println(first + " " + last);
	}
}