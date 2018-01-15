public class RotationCountSortRotate {


	public static int rotationPoint(int[] array, int start, int end) {

		int mid = (end + start) / 2;

		if(start > end) return -1;

		if(start == end) return start;

		if((mid > start) && (array[mid - 1] > array[mid])) return mid - 1;

		if(mid < end && array[mid] > array[mid + 1]) return mid;

		if(array[mid] >= array[start]) return rotationPoint(array, start, mid);

		return rotationPoint(array, mid+1, end);
	}
 

	public static void main(String[] args) {

		int[] array = {15, 18, 19, 1, 2, 3, 6, 12};

		int value = rotationPoint(array, 0, 5);

		System.out.println(value);
	}
} 