public class BinomialHeap {

	Node head;

	public static BinomialHeap makeHeap() {

		return new BinomialHeap();
	}


	public Node binomialHeapMinimum() {

		Node y = null;
		Node x = head;
		int min = Integer.MAX_VALUE;

		while(x != null) {

			if(x.key < min) {

				min = x.key;
				y = x;
			}

			x = x.sibling;
		}

		return y;
 
	}


	public void binomialLink(Node y, Node z) {

		y.p = z;
		y.sibling = z.child;
		z.child = y;
		++z.degree;
	}

	public Node minDegree(Node a, Node b) {

		if(a == null && b == null) {

			return null;
		} else if(a == null) {

			return b;
		} else if(b == null) {

			return a;
		} else if(a.degree < b.degree) {

			return a;
		}

		return b;
	} 


	public void binomialHeapMerge(BinomialHeap h2) {

		Node a = this.head;
		Node b = h2.head;

		this.head = minDegree(a, b);

		if(this.head == null) {

			return;
		}


		if(this.head == b) {

			b = a;
		}

		a = this.head;

		while(b != null) {

			if(a.sibling == null) {

				a.sibling = b;
				return;
			} else {

				if(a.sibling.degree < b.degree) {

					a = a.sibling;
				} else {

					Node c = b.sibling;
					b.sibling = a.sibling;
					a.sibling = b;
					a = a.sibling;
					b = c;
				}
			}
		}

	}

	public void binomialHeapUnion(BinomialHeap h2) {

		binomialHeapMerge(h2);

		if(head == null) {

			return;
		}

		Node prev = null;
		Node x = head;
		Node next = x.sibling;


		while(next != null) {

			if((x.degree != next.degree) || (next.sibling != null && next.sibling.degree == x.degree)) {

				prev = x;
				x = next;
			} else {

				if(x.key <= next.key) {

					x.sibling = next.sibling;
					binomialLink(next, x);
				} else {

					if(prev == null) {

						head = next;
					} else {

						prev.sibling = next;
					}

					binomialLink(x, next);
					x = next;
				}
			}

			next = x.sibling;
		}

	}


	public void binomialHeapInsert(int key) {

		Node x = new Node(key);
		BinomialHeap hh = makeHeap();
		hh.head = x;
		binomialHeapUnion(hh);
	}


	public Node listExtractMin() {

		Node focusedNode = head;
		Node prev = null;
		Node minimum = null;
		Node minimumPrev = null;
		int  minKey = Integer.MAX_VALUE;


		while(focusedNode != null) {

			if(focusedNode.key < minKey) {

				minimum = focusedNode;
				minimumPrev = prev;
				minKey = focusedNode.key;
			}

			prev = focusedNode;
			focusedNode = focusedNode.sibling;
		}


		if(minimum == null) return null;


		if(prev == null) {
			head = minimum.sibling;
		} else {
			minimumPrev.sibling = minimum.sibling;
		}

		return minimum;
	} 

	public Node reverseList(Node head) {

		Node prev = null;
		Node current = head;
		Node next = null;

		while(current != null) {

			next = current.sibling;
			current.sibling = prev;
			prev = current;
			current = next;
		}


		head = prev;

		return head;
	
	}


	public Node binomialHeapExtractMin() {

		Node minimum = listExtractMin();

		BinomialHeap h1 = makeHeap();

		Node reverseNodeHead = reverseList(minimum.child);

		h1.head = reverseNodeHead;

		binomialHeapUnion(h1);

		return minimum;

	}


	public Node findKeyNode(int key) {

		Node focusedNode = head;

		Node foundKey = null;

		while(focusedNode != null && focusedNode.key != key) {

			if(focusedNode.child == null) {

				focusedNode = focusedNode.sibling;
				continue;
			}


			Node subHeap = focusedNode.child;

			while(subHeap.child != null && subHeap.key != key) {


				if(subHeap.sibling == null) {

					subHeap = subHeap.child;
					continue;
				}

				Node subHeapSib = subHeap.sibling;

				while(subHeapSib != null && subHeapSib.key != key) {

					subHeapSib = subHeapSib.sibling;
				}

				if(subHeapSib != null && subHeapSib.key == key) {

					return subHeapSib;
				}

				subHeap = subHeap.child;
				
			}

			if(subHeap != null && subHeap.key == key) {

				return subHeap;
			}

			focusedNode = focusedNode.sibling;

		}

		if(focusedNode != null && focusedNode.key == key) {

			return focusedNode;
		}

		return null;
	}


	public void binomialHeapDecreaseKey(int key, int newKey) {


		Node x = findKeyNode(key);

		if(x == null) {

			System.out.println("The key is not present");
			return;
		} 

		if(key < newKey) {
 
			System.out.println("The new key is greater that the old key");
			return;
		}

		x.key = newKey;
		Node y = x;
		Node z = y.p;

		while(z != null && y.key < z.key) {

			int tempKey = y.key;
			y.key = z.key;
			z.key = tempKey;

			y = z;
			z = y.p;

		}

	}

	public void binomialHeapDelete(int key) {

		binomialHeapDecreaseKey(key, Integer.MIN_VALUE);
		binomialHeapExtractMin();
	}


	public void display() {

		Node focusedNode = head;

		while(focusedNode != null) {

			System.out.println(focusedNode);

			if(focusedNode.child == null) {

				focusedNode = focusedNode.sibling;
				continue;
			}


			Node subHeap = focusedNode.child;

			while(subHeap != null) {

				System.out.print("----" + subHeap + "--------");

				if(subHeap.sibling == null) {

					subHeap = subHeap.child;
					continue;
				}

				Node subHeapSib = subHeap.sibling;

				while(subHeapSib != null) {

					System.out.println("-----------" + subHeapSib + "----------------");
					subHeapSib = subHeapSib.sibling;
				}

				subHeap = subHeap.child;
				
			}

			focusedNode = focusedNode.sibling;

		}

	}


	public class Node {

		int key;
		Node p;
		int degree;
		Node child;
		Node sibling;


		public Node(int key) {

			this.key = key;
		}


		public String toString() {

			return "The value of the node is : " + key + " with degree : " + degree;
		} 
	}


	public static void main(String[] args) {

		BinomialHeap firstHeap = BinomialHeap.makeHeap();

		firstHeap.binomialHeapInsert(2);
		firstHeap.binomialHeapInsert(5);
		firstHeap.binomialHeapInsert(4);
		firstHeap.binomialHeapInsert(6);
		firstHeap.binomialHeapInsert(9);
		firstHeap.binomialHeapInsert(7);



		firstHeap.display();





	}
}