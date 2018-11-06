

public class Element<T extends Comparable> implements Comparable<Element<T>> {

	public T value;

	public Element(T value) {

		this.value = value;
	}


	public int compareTo(Element<T> inputObj) {

		return this.value.compareTo(inputObj.value);
	} 


	public boolean equals(Object input) {

		if(input instanceof Element<?>) {

			Element<T> inputNode = (Element<T>)input;

			return (inputNode.value.equals(this.value)); 
		}

		return false;
	}

	public int hashCode() {

		return value.hashCode();
	}

	public String toString() {

		return value.toString();
	}
}