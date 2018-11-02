

public class BucketElement<K, V> {

		public K key;
		public V value;
		public BucketElement<K, V> next;

		public BucketElement(K key, V value) {

			this.key = key;
			this.value = value;
		}

		public boolean equals(Object input) {

			if(input instanceof BucketElement<?,?>) {

				BucketElement<K, V> inputCast = (BucketElement<K, V>)input;

				return this.key.equals(inputCast.key);
				
			}

			return false;

		}

		public int hashCode() {

			return key.hashCode();
		}

		public String toString() {

			return key + " : " + value;
		
		}

	}