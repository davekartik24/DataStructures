// Time Complexity = O(n)
// Space Complexity = O(d) - Which can be resuced

import java.util.Arrays;

public class ArrayRotation {

	public int[] rotation(int[] array, int position) {

		int length = array.length;
		int temp = 0;
		int[] tempArray = Arrays.copyOf(array,position);

		for (int i = 0; i < length; i++) {

			if (position < length) {
				array[i] = array[position];
				position++;
			} else {

				array[i] = tempArray[temp];
				temp++;
			}
		}

		return array;

	}

	public static void main(String[] args) {

		int[] array = {1,2,3,4,5,6};
		int rotationValue = 3;

		ArrayRotation testRotate = new ArrayRotation();
		int[] result = testRotate.rotation(array,rotationValue);
		System.out.println(Arrays.toString(result));
	}
}