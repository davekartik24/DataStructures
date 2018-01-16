public class IndexOfATermSortDuplicate {

	public static int binarySearch(int[] array, int start, int end, int value) {

		if(start == end) {

			return start;
		}

		if(start < end) {

			int mid = (end + start) / 2;

			if(array[mid] == value) {

				if(array[mid - 1] < array[mid]) {

					return mid;
				} else {

					return binarySearch(array, start, mid - 1, value);
				}
			}

			if(array[mid] > value) {

				return binarySearch(array, start, mid - 1, value);
			}

			return binarySearch(array, mid + 1, end, value);

		}

		return -1;
	}

	public static void main(String[] arg) {

		int[] array = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,3,3,4};

		int value = 3;

		int start = 0;
		int end = array.length - 1;

		int index = binarySearch(array, start, end, value);

		System.out.println(index);
	}
}