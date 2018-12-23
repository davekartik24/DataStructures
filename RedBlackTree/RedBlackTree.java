
import java.io.*;
import java.util.*;

public class RedBlackTree {

	Node root;
	Node nill;

	public RedBlackTree() {

		nill = new Node();
		nill.color = "BLACK";

		root = nill;
	
	}


	public RedBlackTree(String inputFileLocation) {

		this();

		fileInput(inputFileLocation);

	}


	public void leftRotate(Node x) {

		Node y = x.right;
		x.right = y.left;
		if(y.left != nill) {

			y.left.p = x;
		}

		y.p = x.p;

		if(x.p == nill) {

			root = y;
		} else if(x == x.p.left) {

			x.p.left = y;
		} else {

			x.p.right = y;
		}

		y.left = x;
		x.p = y;
	
	}

	public void rightRotate(Node x) {

		Node y = x.left;
		x.left = y.right;
		if(y.right != nill) {

			y.right.p = x;
		}

		y.p = x.p;

		if(x.p == nill) {

			root = y;
		} else if(x == x.p.left) {

			x.p.left = y;
		} else {

			x.p.right = y;
		}

		y.right = x;
		x.p = y;
	}


	public void insert(int key) {

		Node z = new Node();
		z.key = key;

		Node y = nill;
		Node x = root;

		while(x != nill) {

			y = x;
			if(z.key < x.key) {

				x = x.left;
			} else {

				x = x.right;
			}
		}

		z.p = y;

		if(y == nill) {

			root = z;
		} else if(z.key < y.key) {

			y.left = z;
		} else {

			y.right = z;
		}

		z.left = nill;
		z.right = nill;
		z.color = "RED";
		insertFixup(z);
	}


	public void insertFixup(Node z) {

		while(z.p.color.equals("RED")) {

			if(z.p == z.p.p.left) {

				Node y = z.p.p.right;

				if(y.color.equals("RED")) {

					z.p.color = "BLACK";
					y.color = "BLACK";
					z.p.p.color = "RED";
					z = z.p.p;
					

				} else {

					if(z == z.p.right) {

						z = z.p;
						leftRotate(z);
					}

					z.p.color = "BLACK";
					z.p.p.color = "RED";
					rightRotate(z.p.p);
				}
			} else {

				Node y = z.p.p.left;

				if(y.color.equals("RED")) {

					z.p.color = "BLACK";
					y.color = "BLACK";
					z.p.p.color = "RED";
					z = z.p.p;
				} else {

					if(z == z.p.left) {

						z = z.p;
						rightRotate(z);

					}

					z.p.color = "BLACK";
					z.p.p.color = "RED";
					leftRotate(z.p.p);

				}
			}
		}

		this.root.color = "BLACK";
	}

	public void transplant(Node u, Node v) {

		if(u.p == nill) {

			root = v;
		} else if(u.p.left == u) {

			u.p.left = v;
		} else {

			u.p.right = v;
		}

		v.p = u.p;

	}

	public void delete(int key) {

		Node z = root;

		while(z != nill && z.key != key) {

			if(z.key < key) {

				z = z.right;
			} else {

				z = z.left;
			}
 
		}

		if(z == nill) {

			System.out.println("The key is not present in the tree");
			return;
		}

		Node y = z;
		String yOriginalColor = y.color;

		Node x;

		if(z.left == nill) {

			x = z.right;
			transplant(z, z.right);
		} else if(z.right == nill) {

			x = z.left;
			transplant(z, z.left);
		} else {

			y = min(z.right);
			yOriginalColor = y.color;
			x = y.right;

			if(y.p == z) {

				x.p = y;
			} else {

				transplant(y, x);
				y.right = z.right;
				y.right.p = y;

			}

			transplant(z, y);
			y.color = z.color;
			y.left = z.left;
			y.left.p = y;
		}

		if(yOriginalColor == "BLACK") {

			deleteFixUp(x);
		}
	}


	public void deleteFixUp(Node x) {

		while(x != root && x.color == "BLACK") {

			if(x == x.p.left) {

				Node w = x.p.right;

				if(w.color == "RED") {

					w.color = "BLACK";
					x.p.color = "RED";
					leftRotate(x.p);
					w = x.p.right;
				}

				if(w.left.color == "BLACK" && w.right.color == "BLACK") {

					w.color = "RED";
					x = x.p;
				} else {

					if(w.right.color == "BLACK") {

						w.left.color = "BLACK";
						w.color = "RED";
						rightRotate(w);
						w = x.p.right;
					}

					w.color = x.p.color;
					x.p.color = "BLACK";
					w.right.color = "BLACK";
					leftRotate(x.p);
					x = root;
				}
			} else {

				Node w = x.p.left;

				if(w.color == "RED") {

					w.color = "BLACK";
					x.p.color = "RED";
					rightRotate(x.p);
					w = x.p.left;
				}

				if(w.left.color == "BLACK" && w.right.color == "BLACK") {

					w.color = "RED";
					x = x.p;
				} else {

					if(w.left.color == "BLACK") {

						w.right.color = "BLACK";
						w.color = "RED";
						leftRotate(w);
						w = x.p.left;
					}

					w.color = x.p.color;
					x.p.color = "BLACK";
					w.left.color = "BLACK";
					rightRotate(x.p);
					x = root;
				}

			}

		}

		x.color = "BLACK";
	} 

	public void sort(Node focusedNode) {

		if(focusedNode != nill) {

			sort(focusedNode.left);
			System.out.println(focusedNode.toString());
			sort(focusedNode.right);
		}
	}


	public Node search(int key) {

		Node focusedNode = root;

		while(focusedNode != nill && focusedNode.key != key) {

			if(key < focusedNode.key) {

				focusedNode = focusedNode.left;
			} else {

				focusedNode = focusedNode.right;
			}
		}

		return focusedNode;
	} 

	public Node min(Node x) {

		Node focusedNode = x;

		while(focusedNode.left != nill) {

			focusedNode = focusedNode.left;
		}

		return focusedNode;
	
	}


	public Node max(Node x) {

		Node focusedNode = x;

		while(focusedNode.right != nill) {

			focusedNode = focusedNode.right;
		}

		return focusedNode;
	
	}

	public Node successor(Node x) {

		if(x.right != nill) {

			return min(x.right);
		}

		Node y = x.p;

		while(y != nill && x == y.right) {

			x = y;
			y = y.p;
		}

		return y;
	}  
 

	public Node predecessor(Node x) {

		if(x.left != nill) {

			return max(x.left);
		}

		Node y = x.p;

		while(y != nill && x == y.left) {

			x = y;
			y = y.p;
		}

		return y;
	}

	public int height(Node focusedNode) {

		if(focusedNode == nill) return 0;

		return Math.max(height(focusedNode.left), height(focusedNode.right)) + 1;
	}

	public void fileInput(String fileLocation) {

		try{

			File file = new File(fileLocation);   
			Scanner scanner = new Scanner(file);

			while (scanner.hasNext()) {

			    if (scanner.hasNextInt()) {

			        insert(scanner.nextInt());

			    } 
			    else {

			        scanner.next();
			    }
			}

		} catch(FileNotFoundException ex) {

			System.out.println("File not found");
		}

	}  


	public boolean isEmpty() {

		return (root == nill); 
	}

	public class Node {

		int key;
		Node left;
		Node right;
		String color;
		Node p;


		public String toString() {

			return "The value of the node is : " + key + " with color " + color; 
		}


	}

	private List<List<Node>> traverseLevels() {

	    if (root == null) {
	        return Collections.emptyList();
	    }
	    List<List<Node>> levels = new LinkedList<>();

	    Queue<Node> nodes = new LinkedList<>();
	    nodes.add(root);

	    while (!nodes.isEmpty()) {
	        List<Node> level = new ArrayList<>(nodes.size());
	        levels.add(level);

	        for (Node node : new ArrayList<>(nodes)) {
	            level.add(node);
	            if (node.left != null) {
	                nodes.add(node.left);
	            }
	            if (node.right != null) {
	                nodes.add(node.right);
	            }
	            nodes.poll();
	        }
	    }
	    return levels;
	}


	public void printLevelWise() {

	    List<List<Node>> levels = traverseLevels();

	    for (List<Node> level : levels) {
	        for (Node node : level) {
	            System.out.print(node.key + " ");
	        }
	        System.out.println();
	    }
	}

	public static void main(String[] args) {

		RedBlackTree initCheck = new RedBlackTree("C:/Users/Kartik/Dropbox/CS5800_Kartik_Dave/HW8/inputData.txt");

		while(true) {

			System.out.println("Please select the operation you need to be performe:\n" +
							   "1. Insert\n" +
							   "2. Delete\n" +
							   "3. Sort\n" +
							   "4. Search\n" +
							   "5. Min\n" +
							   "6. Max\n" +
							   "7. Structure\n" +
							   "8. Exit");

			Scanner scan = new Scanner(System.in);
			int input = scan.nextInt();

			if(input == 1) {

				System.out.println("Please enter the key to be added");
				initCheck.insert(scan.nextInt());
				System.out.println("The key is inserted now the height of the tree is :" + initCheck.height(initCheck.root));
			} else if(input == 2) {

				System.out.println("Please enter the key to be deleted");
				initCheck.delete(scan.nextInt());
				System.out.println("The key is deleted now the height of the tree is :" + initCheck.height(initCheck.root));
			} else if(input == 3) {

				initCheck.sort(initCheck.root);
				System.out.println("The height of the tree is:" + initCheck.height(initCheck.root));

			} else if(input == 4) {

				System.out.println("Please enter the key to be searched");
				Node output = initCheck.search(scan.nextInt());

				if(output == initCheck.nill){

					System.out.println("The key is not present in the tree");
					System.out.println("The height of the tree is:" + initCheck.height(initCheck.root));
				} else {

					System.out.println("The searched key is present as node : " + output);
					System.out.println("The height of the tree is:" + initCheck.height(initCheck.root));
				}

			} else if(input == 5) {

				System.out.println("The minimum value is:" + initCheck.min(initCheck.root));
				System.out.println("The height of the tree is:" + initCheck.height(initCheck.root));
			} else if(input == 6) {

				System.out.println("The maximum value is:" + initCheck.max(initCheck.root));
				System.out.println("The height of the tree is:" + initCheck.height(initCheck.root));
			} else if(input == 7) {

				System.out.println("The tree structure is : ");
				initCheck.printLevelWise();
			} 
			 else {

				break;
			}
		}

	}
}