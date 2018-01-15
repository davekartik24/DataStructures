public class MaximuProductSubArray {

	public static void main(String[] args) {

		int[] array = {-2, -3, 0, -2, -40};

		int productSoFor = 1;

		int innerProduct = 1;

		for(int i = 0; i < array.length; i++) {

			innerProduct = innerProduct * array[i];

			if(innerProduct == 0) {

				innerProduct = 1;
			}

			if(productSoFor < innerProduct) {

				productSoFor = innerProduct;
			}
		}

		System.out.println(productSoFor);
	}
}