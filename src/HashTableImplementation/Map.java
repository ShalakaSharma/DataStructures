package HashTableImplementation;

import java.util.ArrayList;

public class Map<K, V> {

	private ArrayList<HashNode<K, V>> bucketArray;

	private int numberOfBuckets;

	private int size;

	public Map() {
		bucketArray = new ArrayList<HashNode<K, V>>();
		numberOfBuckets = 10;
		size = 0;

		for (int i = 0; i < numberOfBuckets; i++) {
			bucketArray.add(null);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getBucketyIndex(K key) {
		
		int hashcode = key.hashCode();
		int index = hashcode % numberOfBuckets;
		return index;
	}
	
	public V remove(K key) {
		int bucketIndex = getBucketyIndex(key);
		HashNode<K, V> head = bucketArray.get(bucketIndex);
		
	}

}
