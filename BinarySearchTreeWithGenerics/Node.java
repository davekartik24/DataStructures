

public class Node<T> {

	public T value;

	Node<T> left;

	Node<T> right;

	Node<T> parent;


	public Node(T value) {

		this.value = value;
	}


	public Node() {


	}

	public boolean equals(Object input) {

		if(input instanceof Node<?>) {

			Node<T> inputNode = (Node<T>)input;

			return this.value.equals(inputNode.value);
		}

		return false;
	}


	public int hashCode() {

		return value.hashCode();
	}

	public String toString() {

		return value.toString();
	}
} 