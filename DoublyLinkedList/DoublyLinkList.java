public class DoublyLinkList {

	Node head;
	Node tail;


	public DoublyLinkList() {

		this.head = null;
		this.tail = null;

	}

	public boolean isEmpty() {

		return (head == null);

	}

	public void insertFirst(String name, int rollNo) {

		Node insFirst = new Node(name, rollNo);

		if(isEmpty()) {

			tail = insFirst;
			
		} else {

			head.previous = insFirst;
			insFirst.next = head;
		}

		head = insFirst;


	}

	public void insertLast(String name, int rollNo) {

		Node insLast = new Node(name, rollNo);

		if(isEmpty()) {

			head = insLast;
		} else {

			tail.next = insLast;
			insLast.previous = tail;
		}

		tail = insLast;
	
	}

	public void display() {

		Node disNode = head;

		while(disNode != null) {

			disNode.display();
			disNode = disNode.next;
		}
	}


	public boolean insertAfterKey(String name, int rollNo, int key) {

		Node startRun = head;
		Node insAfterKeyNode = new Node(name, rollNo);

		if(isEmpty()) {

			System.out.println("The list is Empty");
			return false;
			
		} else {

			while(startRun.rollNo != key) {

				startRun = startRun.next;

				if(startRun == null) {

					return false;
				}

			}

			if(startRun.next == null) {

				tail = insAfterKeyNode;
			} else {
 
				insAfterKeyNode.next = startRun.next;
				startRun.next.previous = insAfterKeyNode;

			}

			startRun.next = insAfterKeyNode;
			insAfterKeyNode.previous = startRun;

		}

		return true;
	}

	public void inOrder(String name, int rollNo) {

		Node newStudent = new Node(name, rollNo);

		Node start = head;

		Node previous = null;

		while(start != null && rollNo > start.rollNo) {

			previous = start;
			start = start.next;
		}

		if(previous == null) {

			head = newStudent;
		} else {

			previous.next = newStudent;
		}

		newStudent.next = start;

		
	}

	public static class StudentIterator {

	DoublyLinkList collectionList;
	Node current;
	Node previous;


	public StudentIterator(DoublyLinkList collectionList) {

		this.collectionList = collectionList;
		this.current = collectionList.head;
		this.previous = collectionList.tail;
	}

	public boolean hasNext() {

		if(current == null || current.next == null) {

			return false;
		} 

		return true;

	}


	public Node next() {

		if(hasNext()) {

			previous = current;
			current = current.next;

			return current;
		}

		return null;
	}

	public void remove() {

		if(previous != null) {

			previous.next = current.next;

				if(current.next == null) {

					current = collectionList.head;
					previous = null;
				} else {

					current = current.next;
				}

			}

		}

	}

}