
// The loadfactor is considered as 0.75
// The initial size of the array is 10 and increases when load gets higher that loadfactor
// by making the size double


// The Amortized analysis will result in O(1) for put operation
// The java hashCode is considered in hashfunction 


import java.util.*;

public class HashTableWithGenericsAndRehashing<K, V> {

	final float LOAD_FACTOR = 0.75f;

	float currentLoadFactor;

	int bucketSize;

	int inputElements;

	ArrayList<LinkedList<BucketElement<K, V>>> bucket;


	public HashTableWithGenericsAndRehashing() {

		bucketSize = 10;

		bucket = new ArrayList<>(bucketSize);

		for(int i = 0; i < bucketSize; i++) {

			bucket.add(null);
		}

		currentLoadFactor = inputElements/bucketSize;
		
	}

	public BucketElement<K, V> containsKey(K key) {

		LinkedList<BucketElement<K, V>> bucketList = bucket.get(keyHashCode(key));

		if(bucketList != null) {

			for(BucketElement<K, V> bucketElement : bucketList) {

				if(bucketElement.key.equals(key)) return bucketElement;
			}
		}
		
		return null;
	}

	public V getValue(K key) {

		BucketElement<K, V> elementReq = containsKey(key);

		if(elementReq != null) return elementReq.value;

		return null;
		
	}

	public void put(K key, V value) {

		BucketElement<K, V> bucketElement = containsKey(key);

		if(bucketElement != null) {

			bucketElement.value = value;
		} else {

			LinkedList<BucketElement<K, V>>  bucketList = bucket.get(keyHashCode(key));

			if(bucketList != null) {
				bucketList.add(new BucketElement<K, V>(key, value));

			} else {

				LinkedList<BucketElement<K,V>> newBucketList = new LinkedList<BucketElement<K, V>>();
				newBucketList.add(new BucketElement<K, V>(key, value));
				this.bucket.add(keyHashCode(key), newBucketList);
			}

			inputElements++;
		}

		rehashing(inputElements);

	}

	public void rehashing(int inputElements) {

		if((inputElements / bucketSize) > 0.75) {

			bucketSize = bucketSize * 2;

			ArrayList<LinkedList<BucketElement<K, V>>> increaseBucket = new ArrayList<>(bucketSize);

			for(int i = 0; i < bucketSize; i++) {

				increaseBucket.add(null);
			}

			for(LinkedList<BucketElement<K, V>> bucketList : bucket) {

				if(bucketList != null) {

					for(BucketElement<K, V> element : bucketList) {

						int keyIndexPostion = keyHashCode(element.key);

						LinkedList<BucketElement<K, V>> newBucketList = increaseBucket.get(keyIndexPostion);

						if(newBucketList != null) {

							newBucketList.add(element);
						} else {

							LinkedList<BucketElement<K, V>> newIncreasedBucketList = new LinkedList<>();
							newIncreasedBucketList.add(element);
							increaseBucket.add(keyIndexPostion, newIncreasedBucketList);

						}
					}
				}
			}

			bucket = increaseBucket;
		}
	}

	public void remove(K key) {

		BucketElement<K, V> elementReq = containsKey(key);

		if(elementReq != null) {

			bucket.get(keyHashCode(key)).remove(elementReq);
		}
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append("[");

		for(LinkedList<BucketElement<K, V>> bucketList : bucket) {

			if(bucketList != null) {

				for(BucketElement<K, V> element : bucketList) {

					sb.append("(key:" + element.key + " value:" + element.value + ") ");
				}
			}
		}

		sb.append("]");

		return sb.toString();

	}


	public int keyHashCode(K key) {

		return key.hashCode() % bucketSize;
	}


	public static void main(String[] args) {

		HashTableWithGenericsAndRehashing<Integer, String> testHashTable = new HashTableWithGenericsAndRehashing<>();

		testHashTable.put(1, "My");
		testHashTable.put(2, "Name");


		System.out.println(testHashTable);

		System.out.println(testHashTable.getValue(1));

		testHashTable.remove(1);


		System.out.println(testHashTable);

	}



}