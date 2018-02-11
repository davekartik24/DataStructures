public class BinaryTree {

	Node root; 

	public void addNode(int key, String value) {

		Node newNode = new Node(key, value);

		if(root == null) {

			root = newNode;
		
		} else {

			Node focusedNode = root;
			Node parent;

			while(true) {

				parent = focusedNode;

				if(key < focusedNode.key) {

					focusedNode = focusedNode.leftChild;

					if(focusedNode == null) {

						parent.leftChild = newNode;

						return;
					}


				} else {

					focusedNode = focusedNode.rightChild;

					if(focusedNode == null) {

						parent.rightChild = newNode;

						return;
					}
				}
			}
		}
	}


	public void inOrderTraversal(Node focusedNode) {

		if(focusedNode != null) {

			inOrderTraversal(focusedNode.leftChild);

			System.out.println(focusedNode.toString());

			inOrderTraversal(focusedNode.rightChild);
		}
	}

	public void preOrderTraversal(Node focusedNode) {

		if(focusedNode != null) {

			System.out.println(focusedNode.toString());

			preOrderTraversal(focusedNode.leftChild);

			preOrderTraversal(focusedNode.rightChild);
		}
	}

	public void postOrderTraversal(Node focusedNode) {

		if(focusedNode != null) {

			postOrderTraversal(focusedNode.leftChild);

			postOrderTraversal(focusedNode.rightChild);

			System.out.println(focusedNode.toString());
		}
	}

	public Node nodeSearch(int key) {

		Node focusedNode = root; 

		if(focusedNode == null) {

			return null;
		}

		while(focusedNode.key != key) {

			if(key < focusedNode.key) {

				focusedNode = focusedNode.leftChild;
			} else {

				focusedNode = focusedNode.rightChild;
			}

			if(focusedNode == null) {

			return null;
			}

		}

		return focusedNode;
	}


	public boolean remove(int key) {

		Node parent = root;
		Node focusedNode = root;

		Boolean isLeft = true;

		if(root == null) {

			return false;
		}

		while(focusedNode.key != key) {

			parent = focusedNode;

			if(key < focusedNode.key) {

				isLeft = true;
				focusedNode = focusedNode.leftChild;

			} else {

				isLeft = false;
				focusedNode = focusedNode.rightChild;
			}

			if(focusedNode == null) {

				return false;
			}
		}

		if(focusedNode.leftChild == null && focusedNode.rightChild == null) {

			if(focusedNode == root) {

				root = null;

			} else if(isLeft) {

				parent.leftChild = null;
			} else {

				parent.rightChild = null;
			}
		} else if(focusedNode.rightChild == null) {

			if(focusedNode == root) {

				root = focusedNode.leftChild;
			} else if(isLeft) {

				parent.leftChild = focusedNode.leftChild;
			} else {

				parent.rightChild = focusedNode.leftChild;
			}
		} else if (focusedNode.leftChild == null) {

			if(focusedNode == root) {

				root = focusedNode.rightChild;

			} else if(isLeft) {

				parent.leftChild = focusedNode.rightChild;
			} else {

				parent.rightChild = focusedNode.rightChild;
			}
		} else {

			Node replacement = getReplacement(focusedNode);

			if(focusedNode == root) {

				root = replacement;
			} else if (isLeft) {

				parent.leftChild = replacement;
			} else {

				parent.rightChild = replacement;
			}

			replacement.leftChild = focusedNode.leftChild;
		}

		return true; 

	}

	public Node getReplacement(Node replacedNode) {

		Node replacement = replacedNode;
		Node replacementParent = replacedNode;

		Node focusedNode = replacedNode.rightChild;

		while(focusedNode != null) {

			replacementParent = replacement;
			replacement = focusedNode;
			focusedNode = focusedNode.leftChild;
		}

		replacementParent.leftChild = replacement.leftChild;
		replacement.rightChild = replacedNode.rightChild;

		return replacement;
	}

}