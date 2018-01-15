public class BFCircularArrayMaxSubSeqSum {

	public static int maxCircular(int[] array) {

		int aLength = array.length;
		
		int scoreBeforeUnwrapping = algoImp(array);

		int scoreAfterUnwrapping = 0;

		for(int i = 0; i < aLength; i++) {

			scoreAfterUnwrapping += array[i];
			array[i] = -array[i];

		}


		scoreAfterUnwrapping += algoImp(array);

		return (scoreAfterUnwrapping > scoreBeforeUnwrapping)? scoreAfterUnwrapping : scoreBeforeUnwrapping; 
	
	}

	public static int algoImp(int[] array) {

		int soFar = 0;

		int innerSum = 0;

		for(int i = 0; i < array.length; i++) {

			innerSum += array[i];

			if(innerSum < 0) innerSum = 0;

			if(soFar < innerSum) soFar = innerSum;
		}

		return soFar;
	}

	public static void main(String[] args) {

		int[] array = {-1, 40, -14, 7, 6, 5, -4, -1};

		int result = maxCircular(array);

		System.out.println(result);

	}
}