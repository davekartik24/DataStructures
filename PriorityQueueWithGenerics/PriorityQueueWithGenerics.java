
import java.util.*;


public class PriorityQueueWithGenerics<T extends Comparable> {

	private ArrayList<T> priorityQAList;



	public PriorityQueueWithGenerics() {

		this.priorityQAList = new ArrayList<>();

	}


	public T peek() {

		if(priorityQAList.size() > 0) {

			return priorityQAList.get(0);
		}

		System.out.println("There is no element present in the queue");

		return null;

	}

	public int parentIndex(int index) {

		return ((index - 1)/2);
	}

	public int leftChildIndex(int index) {

		return ((2 * index) + 1);
	}

	public int rightChildIndex(int index) {

		return (leftChildIndex(index) + 1);
	}

	public void swap(int firstIndex, int secondIndex) {

		T temp = priorityQAList.get(firstIndex);

		priorityQAList.set(firstIndex, priorityQAList.get(secondIndex));
		priorityQAList.set(secondIndex, temp);
	}

	public void heapify(int index) {

		int left = leftChildIndex(index);
		int right = rightChildIndex(index);
		int minimum = index;

		if(left < priorityQAList.size() && priorityQAList.get(left).compareTo(priorityQAList.get(index)) < 0)  {

			minimum = left;

		}

		if(right < priorityQAList.size() && priorityQAList.get(right).compareTo(priorityQAList.get(minimum)) < 0) {

			minimum = right;
		}

		if(minimum != index) {

			swap(index, minimum);

			heapify(minimum);
		}
	}

	public void insert(T element) {

		int index = priorityQAList.size();
		int parentIndex = parentIndex(index);

		if(index == 0) {

			priorityQAList.add(element);
		} else {

			priorityQAList.add(element);
			while(priorityQAList.get(parentIndex).compareTo(priorityQAList.get(index)) > 0) {

				swap(parentIndex, index);
				index = parentIndex;
				parentIndex = parentIndex(index);

			}

		}
	
	}
 

	public T poll() {

		if(priorityQAList.size() > 0) {

			T Node = priorityQAList.get(0);

			swap(0, priorityQAList.size() - 1);

			priorityQAList.remove(priorityQAList.size() - 1);

			heapify(0);

			return Node;

		}

		System.out.println("There is no element present in the queue");

		return null;

	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		for(T value : priorityQAList) {

			sb.append(value.toString() + " ");
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		Element<Integer> one = new Element<>(1);

		Element<Integer> two = new Element<>(5);

		Element<Integer> three = new Element<>(7);

		Element<Integer> four = new Element<>(10);

		PriorityQueueWithGenerics<Element<Integer>> pq = new PriorityQueueWithGenerics<>();

		pq.insert(three);
		pq.insert(one);
		pq.insert(two);
		pq.insert(four);

		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());

	}


}