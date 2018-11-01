

// Implementation of LinkedList with Generics
// Assumtion that the node will never be passes as null

public class DoublyLinkedListWithGenerics<T> {

	private Node<T> head;


	public void sethead(Node<T> head) {

		this.head = head;
	}

	public Node<T> gethead() {

		return head;
	}


	public void add(T value) {

		Node<T> newInstance = new Node<>(value);

		newInstance.setNext(head);

		if(head != null) head.setPrevious(newInstance);
		
		head = newInstance;

	}


	public void add(Node<T> inputNode) {

		inputNode.setNext(head);
		head.setPrevious(inputNode);
		head = inputNode;

	}


	public Node<T> contains(T value) {

		Node<T> nodePointer = head;

		while(nodePointer != null && !(nodePointer.getValue().equals(value))) {

			nodePointer = nodePointer.getNext();
		}

		return nodePointer;
	}

	public boolean contains(Node<T> inputNode) {

		Node<T> nodePointer = head;

		while(nodePointer != null && nodePointer != inputNode) {

			nodePointer = nodePointer.getNext();
		}

		if(nodePointer == null) return false;

		return true;
	}

	public Node<T> remove(T value) {

		Node<T> presentNode = this.contains(value);

		if(presentNode != null) {

			if(presentNode.getPrevious() != null) {

				presentNode.getPrevious().setNext(presentNode.getNext());
			} else {

				if(presentNode == head) {

					head = presentNode.getNext();
				}
			}

			if(presentNode.getNext() != null) {

				presentNode.getNext().setPrevious(presentNode.getPrevious());
			}
		}

		return presentNode; 
	}

	public boolean remove(Node<T> inputNode) {

		if(this.contains(inputNode)) {

			if(inputNode.getNext() != null) {
				inputNode.getNext().setPrevious(inputNode.getPrevious());
			}

			if(inputNode.getPrevious() != null) {

				inputNode.getPrevious().setNext(inputNode.getNext());
			} else {

				if(inputNode == head) {
					head = inputNode.getNext();
				}

			}

			return true;
		}

		return false;   
	}

	public String toString() {

		Node<T> nodePointer = head;

		StringBuilder sb = new StringBuilder();

		while(nodePointer != null) {

			sb.append(nodePointer.getValue());
			sb.append(" ");

			nodePointer = nodePointer.getNext();
		}

		return sb.toString();
	}
 
	public class Node<T> {

		private T value;
		private Node<T> next;
		private Node<T> previous;


		public Node(T value) {

			this.value = value;
		}


		public Node() {


		}

		public void setValue(T value) {

			this.value = value;
		}

		public T getValue() {

			return this.value;
		}

		public void setNext(Node<T> nextNode) {

			this.next = nextNode;
		}

		public Node<T> getNext() {

			return this.next;
		}

		public void setPrevious(Node<T> previousNode) {

			this.previous = previousNode;
		}

		public Node<T> getPrevious() {

			return this.previous;
		}

		public String toString() {

			return value.toString();
		}

	}

	public static void main(String[] args) {

		DoublyLinkedListWithGenerics<String> testInstance = new DoublyLinkedListWithGenerics<>();

		DoublyLinkedListWithGenerics<String>.Node<String> inputNode = testInstance.new Node<>("My");

		testInstance.add("Kartik");
		testInstance.add("is");
		testInstance.add("name");
		testInstance.add(inputNode);

		System.out.println(testInstance.toString());

		testInstance.remove("is");
		testInstance.remove(inputNode);

		System.out.println(testInstance.toString());

	}
}