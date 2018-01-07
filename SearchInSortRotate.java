public class SearchInSortRotate {


	public static int searchNo(int[] array, int find) {

		int arrayLengthIndex = array.length - 1;
		int rotationPoint = searchRotationPoint(array, 0, arrayLengthIndex);

		if(rotationPoint == -1) {

			return binarySearch(array, 0, arrayLengthIndex, find);
		}

		if(array[rotationPoint] == find) {

			return rotationPoint;
		}

		if(array[0] > find) {

			return binarySearch(array, rotationPoint + 1, arrayLengthIndex, find);
		}

		return binarySearch(array, 0, rotationPoint - 1, find);

	}


	public static int binarySearch(int[] array, int start, int end, int find) {

		if (start > end) {

			return -1;
		}

		int mid = (start + end) / 2;

		if (array[mid] == find) {

			return mid;
		}

		if (find > array[mid]) {

			return binarySearch(array, mid + 1, end, find);
		}

		return binarySearch(array, start, mid -1, find);
	}


	public static int searchRotationPoint(int[] array, int start, int end) {

		if(start > end) {

			return -1;
		}

		if(start == end) {

			return start;
		}

		int mid = (start + end) / 2;

		if ((mid < end) && (array[mid] > array[mid + 1])) {

			return mid;
		}

		if ((start < mid) && (array[mid - 1] > array[mid])) {

			return mid -1;
		}

		if (array[mid] <= array[start]) {

			return searchRotationPoint(array, start, mid-1);
		}

		return searchRotationPoint(array, mid + 1, end);
	}

	public static void main(String[] args) {

		int[] array = {13,15,19,30,70,1,6,7,9,11};

		int find = 9;

		int result = searchNo(array, find);

		System.out.println(result);

	}
}