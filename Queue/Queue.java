import java.util.*;

public class Queue {

	String[] queueArray;
	int size;
	int front;
	int rear;
	int numberofItems;

	public Queue(int size) {

		this.size = size;
		queueArray = new String[size];
		Arrays.fill(queueArray,"-1");
	}


	public void insert(String input) {

		if(numberofItems + 1 <= size) {

			queueArray[rear] = input;
		} else {

			System.out.println("The queue is full");
		}

		++numberofItems;
		++rear;
	}


	public void remove() {

		if(numberofItems > 0) {

			queueArray[front] = "-1";
			++front;
			--numberofItems;

		} else {

			System.out.println("Queue is empty");
		}
	}


	public void priorityQueue(String input) {

		int i = numberofItems - 1;

		if(numberofItems == 0) {

			insert(input);
		} else {	

			while(i >= 0) {

				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {

					queueArray[i+1] = queueArray[i];
				} else break;

				i--;
			}

	}

		queueArray[i+1] = input;
		rear++;
		numberofItems++;

	}


	public void display() {

		for(String element : queueArray) {

			System.out.println(element + " ");
		}
	}

	public static void main(String[] args) {
			
		Queue check = new Queue(5);
		check.priorityQueue("1");
		check.priorityQueue("2");

		check.display();

	}
}