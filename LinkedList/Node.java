import java.util.*;

public class Node {

	public String name;

	public int rollNo;

	public Node next;

	public Node(String name, int rollNo) {

		this.name = name;
		this.rollNo = rollNo;

	}

	public void display() {

		System.out.println(name + " " + rollNo); 
	}

	public boolean equals(Object ob) {

		if(ob instanceof Node) {

			Node obj = (Node)ob;
			return ((this.name == obj.name) && (this.rollNo == obj.rollNo)); 
		}

		return false;
	}

	public int hashCode() {

		int result = 17;
		result += 31 * name.hashCode();
		result += 31 * rollNo;

		return result;
	}
 
	public static void main(String[] args) {


	}
} 