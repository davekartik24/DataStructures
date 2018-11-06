

public class Node{

	private final int maxMapSize = 26;

	public Node[] children;

	public boolean isCompleteWord;


	public Node() {

		children = new Node[maxMapSize];
	}


}