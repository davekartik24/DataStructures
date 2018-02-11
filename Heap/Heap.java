public class Heap{


	public Data[] theHeap;

	int maxSize;

	int itemsInArray;

	public Heap(int maxSize) {

		this.maxSize = maxSize;
		theHeap = new Data[maxSize];

		Data one = new Data(90);
		Data two = new Data(85);
		Data three = new Data(80);
		Data four = new Data(40);
		Data five = new Data(65);
		Data six = new Data(55);

		theHeap[0] = one;
		theHeap[1] = two;
		theHeap[2] = three;
		theHeap[3] = four;
		theHeap[4] = five;
		theHeap[5] = six;

		itemsInArray = theHeap.length;
	}

	public void insert(int index, Data value) {

		theHeap[index] = value;
	}

	public void incrementTheArray() {

		itemsInArray++;
	}



	public class Data {

		public int key;

		public Data(int ke) {

			key = ke;
		}
	}

	public Data pop() {

		Data root = theHeap[0];

		theHeap[0] = theHeap[--itemsInArray];

		heapify(0);

		return root;
	}

	public void heapify(int index) {

		int largest;
		int leftChild;
		int rightChild;

		Data root = theHeap[index];

		while(index < (itemsInArray/2)) {

			leftChild = (index * 2) + 1;
			rightChild = leftChild + 1;


			if((rightChild < itemsInArray) && (theHeap[leftChild].key > theHeap[rightChild].key)) {

				largest = leftChild;
			
			} else {

				largest = rightChild;
			}

			if(root.key >= theHeap[largest].key) break;

			theHeap[index] = theHeap[largest];

			index = largest;

		}

		theHeap[index] = root;
	}

	public static void main(String[] args) {

		Heap checkHeap = new Heap(6);

		System.out.println(checkHeap.pop().key);

		for(int i = 0; i < checkHeap.itemsInArray; i++) {

			System.out.println(checkHeap.theHeap[i].key);
		
		}
	
	}
}