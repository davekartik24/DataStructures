public class LargestSumSubArrayAlgorithm {


	public static void main(String[] args) {

		int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};

		int sumSoFar  = 0;

		int innerSum = 0;

		for(int i = 0; i < array.length; i++) {

			innerSum += array[i];

			if(innerSum < 0) {

				innerSum = 0;
			}

			if(sumSoFar < innerSum) {

				sumSoFar = innerSum;
			}
		}

		System.out.println(sumSoFar); 
	}
} 