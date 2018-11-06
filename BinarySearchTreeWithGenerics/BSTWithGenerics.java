

public class BSTWithGenerics<T extends Comparable> {

	Node<T> root;


	public Node<T> search(T value) {

		Node<T> parseIndex = root;

		while(parseIndex != null) {

			if(parseIndex.value.compareTo(value) == 0) {

				return parseIndex;
			}

			if(parseIndex.value.compareTo(value) > 0) {

				parseIndex = parseIndex.left;
			} else {

				parseIndex = parseIndex.right;
			}
		}

		return null;

	}

	public void insert(Node<T> inputNode) {

		Node<T> parseIndex = root;

		Node<T> previousNode = null;

		if(search(inputNode.value) != null) {
			
			System.out.println("The value is already present");
			return;
		}

		if(parseIndex == null) {

			root = inputNode;
			return;
		}

		while(parseIndex != null) {

			previousNode = parseIndex;

			if(parseIndex.value.compareTo(inputNode.value) > 0) {

				parseIndex = parseIndex.left;
			} else {

				parseIndex = parseIndex.right;
			}

		}

		inputNode.parent = previousNode;

		if(previousNode.value.compareTo(inputNode.value) > 0) {

			previousNode.left = inputNode;
		} else {

			previousNode.right = inputNode;
		}

	}


	public void insert(T value) {

		Node<T> inputNode = new Node<T>(value);

		insert(inputNode);
 
	}

	public void inOrderTraversal(Node<T> node) {

		if(node != null) {

			inOrderTraversal(node.left);
			System.out.println(node);
			inOrderTraversal(node.right);
		}
		
	}

	public Node<T> minimum(Node<T> nodeIndex) {

		if(nodeIndex != null) {

			while(nodeIndex.left != null) {

				nodeIndex = nodeIndex.left;
			}
		}

		return nodeIndex;
	}

	public Node<T> maximum(Node<T> nodeIndex) {

		if(nodeIndex != null) {

			while(nodeIndex.right != null) {

				nodeIndex = nodeIndex.right;
			}
		}

		return nodeIndex;
	}  

	public Node<T> successor(Node<T> inputNode) {

		if(inputNode.right != null) {

			return minimum(inputNode.right);
		}

		Node<T> parentIndex = inputNode.parent;

		while(parentIndex != null && parentIndex.left != inputNode) {

			inputNode = parentIndex;
			parentIndex = parentIndex.parent;
		}

		return parentIndex;
 
	}


	public Node<T> predecessor(Node<T> inputNode) {

		if(inputNode.left != null) {

			return maximum(inputNode.left);
		}

		Node<T> parentIndex = inputNode.parent;

		while(parentIndex != null && parentIndex.right != inputNode) {

			inputNode = parentIndex;
			parentIndex = parentIndex.parent;
		}

		return parentIndex;
	}

	public void transplant(Node<T> toBeRemoved, Node<T> toBeAdded) {

		if(toBeRemoved == root) {

			root = toBeAdded;
		} else if(toBeRemoved.parent.left == toBeRemoved) {

			toBeRemoved.parent.left = toBeAdded;
		} else {

			toBeRemoved.parent.right = toBeAdded;
		}

		if(toBeAdded != null) {

			toBeAdded.parent = toBeRemoved.parent;
		}
	}

	public void delete(Node<T> inputNode) {

		if(inputNode.left == null) {

			transplant(inputNode, inputNode.right);
		} else if(inputNode.right == null) {

			transplant(inputNode, inputNode.left);
		} else {

			Node<T> minimumNode = minimum(inputNode.right);

			if(minimumNode.parent != inputNode) {

				transplant(minimumNode, minimumNode.right);
				minimumNode.right = inputNode.right;
				minimumNode.right.parent = minimumNode;
			}

			transplant(inputNode, minimumNode);
			minimumNode.left = inputNode.left;
			minimumNode.left.parent = minimumNode;
			
		}
		
	}

	public void delete(T value) {

		Node<T> focusedNode = search(value);

		if(focusedNode != null) {

			delete(focusedNode);
		}

	}

	public static void main(String[] args) {

		BSTWithGenerics<Integer> testInstance = new BSTWithGenerics<>();

		Node<Integer> inputNodeOne = new Node<>(10);
		Node<Integer> inputNodeTwo = new Node<>(5);

		testInstance.insert(inputNodeOne);
		testInstance.insert(8);
		testInstance.insert(13);
		testInstance.insert(inputNodeTwo);

		testInstance.delete(8);


		testInstance.inOrderTraversal(testInstance.root);

	}
}