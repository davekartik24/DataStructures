 Qimport java.util.*;
import java.nio.file.*;
import java.io.*;

public class AlgoHashTable {

	WorldList[] bucket;
	int maxSize;


	public AlgoHashTable() {

		// 1993 are the unique words, so if we consider max of 3 Collision
		// 1993/3 = 665 and the prime number near to it can be considered as 701
		maxSize = 701;
		bucket = new WorldList[maxSize];
 
	}

	public AlgoHashTable(String fileName) {

		this();

		try {

			String[] inputArray = readFileAsTokens(fileName);

			for(int i = 1; i <= inputArray.length; i++) {

				insert(inputArray[i-1], 1, i);

			}
		} catch(Exception e) {

			System.out.println("Error with the input location provided");
		}

		try {

			PrintWriter writer = new PrintWriter("HashTableOutput.txt", "UTF-8");


			for(WorldList list : bucket) {

				if(list == null) {

					continue;
				} else {

					Word current = list.head;

					while(current != null) {
						writer.println(current);
						current = current.next;
					}
				}


			}

			writer.close();

		} catch(Exception ex) {

			System.out.println("The output file is having Error");
		}
	
	}


	public void insert(String key, int value) {

		int index = stringHashing(key);

		if(bucket[index] == null) {

			bucket[index] = new WorldList();
			bucket[index].add(key, value);
		} else {

			Word toUpdate = bucket[index].search(key);
				
			if(toUpdate != null) {

				toUpdate.value = toUpdate.value + value;

			} else {

				bucket[index].add(key,value);
			}
		}
	}


	public void insert(String key, int value, int position) {

		int index = stringHashing(key);

		if(bucket[index] == null) {

			bucket[index] = new WorldList();
			bucket[index].add(key, value, position);
		} else {

			Word toUpdate = bucket[index].search(key);
				
			if(toUpdate != null) {

				toUpdate.value = toUpdate.value + value;
				toUpdate.position.add(position);

			} else {

				bucket[index].add(key,value,position);
			}
		}
	}


	public void delete(String key) {

		int index = stringHashing(key);

		if(bucket[index] == null) {

			System.out.println("Key not present check");
			return;
		} else {

			Word toSearch = bucket[index].search(key);
			if(toSearch == null) {

				System.out.println("Key not present");
				return;
			} else {

				bucket[index].remove(toSearch);
			} 
		}
	}


	public void increase(String key) {

		int index = stringHashing(key);

		if(bucket[index] == null) {

			System.out.println("key is not present");
			return;
		} else {

			Word toSearch = bucket[index].search(key);
			if(toSearch == null) {

				System.out.println("Key not present");
				return;
			} else {

				toSearch.value += 1;
			}

		}
		
	}


	public boolean find(String key) {

		int index = stringHashing(key);

		if(bucket[index] == null) {

			return false;
		} else {

			Word toSearch = bucket[index].search(key);

			if(toSearch == null) {

				return false;
			}

		}


		return true; 
	}


	public void listAllKeys() {

		for(WorldList element : bucket) {

			if(element == null) {

				continue;
			} else {

				element.displayWordList();
			} 
		}
	}

	public int stringHashing(String inputWord) {

		int initCode = 7;

		for(int i = 0; i < inputWord.length(); i++) {

			initCode = ((initCode * 31) + inputWord.charAt(i)) % maxSize; 
		}

		return initCode; 

	}


	public String[] readFileAsTokens(String fileName) throws Exception {
		    	
		String data = "";
		data = new String(Files.readAllBytes(Paths.get(fileName)));
		String[] words = data.toLowerCase().split("\\P{L}+");
		return words;

	}



	public class Word {

		public String key;
		public int value;
		public Word next;
		public LinkedList<Integer> position;


		public Word(String key, int value) {

			this.key = key;
			this.value = value;
		}

		public Word(String key, int value, int position) {

			this.key = key;
			this.value = value;
			this.position = new LinkedList<Integer>();
			this.position.add(position);
		}

		public String toString() {

			if(position == null) {

				return key + " : " + value;

			} else {

				return key + " : " + value + " position in text : " + position.toString().replace(","," -> "); 
			}

		}

	}


	public class WorldList{

		public Word head;


		public boolean isEmpty() {

		return (head == null);
		
		}

		public void add(String key, int value) {

			Word toAdd = new Word(key, value);

			if(isEmpty()) {

				head = toAdd;
			} else {

				toAdd.next = head;
				head = toAdd;		
			}

		}

		public void add(String key, int value, int position) {

			Word toAdd = new Word(key, value, position);

			if(isEmpty()) {

				head = toAdd;
			} else {

				toAdd.next = head;
				head = toAdd;		
			}

		}


		public Word search(String key) {

			Word current = head;

			if(!isEmpty()) {

				while(!current.key.equals(key)) {

					if(current.next == null) {
						return null;
					} else {

						current = current.next;
					}
				}
			}

			return current;
		}


		public boolean remove(Word toRemove) {

			Word current = head;

			if(current == toRemove) {

				head = head.next;
				return true;
			}

			while(current != null && current.next != toRemove) {

				current = current.next;
			}



			if(current != null) {

				current.next = current.next.next;
				return true;
			}

			return false;
		}


		public void displayWordList() {

			Word current = head;

			while(current != null) {

				System.out.println(current);

				current = current.next;
			}
		}




	}

	public static void main(String[] args) {

		AlgoHashTable testHash = new AlgoHashTable("C:/Users/Kartik/Documents/LearningJava/DataStructures/HashTable/Algorithms/alice_in_wonderland.txt");

		testHash.insert("kartik", 5);
		testHash.delete("kartik");

		System.out.println(testHash.find("kartik"));


		// testHash.listAllKeys();		

	}
}