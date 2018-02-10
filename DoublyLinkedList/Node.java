public class Node {

	public String name;
	public int rollNo;

	public Node next;
	public Node previous;

	public Node(String name, int rollNo) {

		this.name = name;
		this.rollNo = rollNo;

	}

	public void display() {

		System.out.println("The name of the student is : " + name + " with rollNo : " + rollNo);
	}

}