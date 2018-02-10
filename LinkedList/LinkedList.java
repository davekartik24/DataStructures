public class LinkedList {


	public Node head;

	public LinkedList() {

		this.head = null;
	}


	public boolean isEmpty() {

		return (head == null);
	}

	public Node insertFirstNode(String name, int rollNo) {

		Node firstNode = new Node(name, rollNo);

		firstNode.next = head;

		head = firstNode;

		return firstNode;
	}

	public Node deleteFirstNode() {

		Node linkRef = head;

		if(!isEmpty()) {

			head = head.next;

		} else {

			System.out.println("Empty Linked List");
		}
		
		return linkRef;		
	}

	public void display() {

		Node traverse = head;

		while(traverse != null) {

			traverse.display();

			traverse = traverse.next;
		}
	}

	public Node search(String name) {

		Node start = head;

		if(!isEmpty()) {

			while(start.name != name) {

				if(start.next == null) {

					return null;
				} else {

					start = start.next;
				}
			}

		} else {

				System.out.println("The List is Empty"); 
		}

		return start;
	}

	public Node remove(String name) {

		Node removeNode = head;
		Node previousNode = head;

		if(!isEmpty()) {

			while(removeNode.name != name) {

				if(removeNode.next == null) {

					return null;
				
				} else {

					previousNode = removeNode;
					removeNode = removeNode.next;
				}
			}

			if(removeNode == head) {

				head = head.next;
			} else {

				previousNode.next = removeNode.next;
			}
		} else {

			System.out.println("List is Empty");
		}

		return removeNode;
	}

}