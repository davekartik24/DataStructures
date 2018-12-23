// Trie is also called as Radix or Prefix tree
// It is a search Tree and that is why the major operations are Insert and search
// The run time to find the presence of the string is O(L)
// where L is the length of the input string or word

// Better then HashMap when prefix check is important 
// as no need to deal with the collision and chaining

public class Trie {

	Node root; 


	public Trie() {

		root = new Node();

	}


	public void insert(String inputWord) {

		Node focusedNode = root;

		int inputLength = inputWord.length();

		for(int i = 0; i < inputLength; i++) {

			int index = inputWord.charAt(i) - 'a';

			if(focusedNode.children[index] == null) {

				focusedNode.children[index] = new Node();
			}

			focusedNode = focusedNode.children[index];
		}

		focusedNode.isCompleteWord = true;
	}


	public boolean search(String inputWord) {

		Node focusedNode = root;

		int inputLength = inputWord.length();

		for(int i = 0; i < inputLength; i++) {

			int index = inputWord.charAt(i) - 'a';

			if(focusedNode.children[index] == null) {

				return false;
			}

			focusedNode = focusedNode.children[index];
		}

		return focusedNode.isCompleteWord;
	}

	public static void main(String[] args) {

		Trie testinstance = new Trie();

		testinstance.insert("kartik");
		testinstance.insert("kar");
		testinstance.insert("hitman");
		testinstance.insert("dave");

		System.out.println(testinstance.search("hitman"));
	}
}