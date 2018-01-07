// Time Complexity => O(n)
// Space Complexity => O(1)

import java.util.Arrays;

public class ArrayRotationReducedSpaceComplexity {

	public void rotate(int[] array, int k) {
        k %= array.length;
        reverse(array, 0, k-1);
        reverse(array, k, array.length-1);
        reverse(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }


	public void reverse(int[] array, int start, int end) {
        while (start < end) {
            int tempArray = array[start];
            array[start] = array[end];
            array[end] = tempArray;
            start++;
            end--;
        }
    }

	public static void main(String[] args) {

		ArrayRotationSpaceCompex testRotation = new ArrayRotationSpaceCompex();

        int rotationValue = 2;

		testRotation.rotate(new int[] {1,2,3,4,5,6,7}, rotationValue);

	}

}