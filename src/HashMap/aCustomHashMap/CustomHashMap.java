package HashMap.aCustomHashMap;



class CustomHashMap<K, V>{

    // create the underlying HashMapNode array with the initial size of 10
    private Entry<K, V>[] currentArray = new Entry[10];

    private int hashCode(K key){
        // get the hashCode for the key and mod that hashCode by the length of the array
        int index = Math.abs(key.hashCode() % currentArray.length);

        // the result will be the index where we can find and/or place entries
        return index;
    }
    //put aka insert, responsible for adding elements into the HashMap
    public void put(K key, V value) {
        // call the hash() method to get the index to place the element
        int index = hashCode(key);

        //create the HashMapNode object containing the key and
        //value that we will store in the underlying array called arrayMap
        Entry<K,V> entry = new Entry(key, value);

        if(currentArray[index] == null){

            currentArray[index] = entry;
        }
        else{
            // get the first Entry (in the linked list) at the given index
            Entry<K,V> head = currentArray[index]; //       "head"

            //traverse/loop the linked list
            while(head.getNext() != null){ //if it's not empty
                head = head.getNext();// continue looping
            }
            head.setNext(entry);
        }

//        if (keys().size() > .length * .75) {
//            // the resize method will create a bigger underlying array and
//            // add all values in the existing array to the new, larger array
//            resize();
//        }

    }
    public V get(K key){
        // call the hash() method to get the index for the key
        int index = hashCode(key);

        // nothing at key - return null
        if (currentArray[index] == null) {
            return null;
        }
        //get entry at index
        Entry<K,V> entry = currentArray[index];

        while(entry.getKey() != key){

            if(entry.getNext() == null){
                return null;
            }

            //otherwise keep looing
            entry = entry.getNext();
        }
        return entry.getValue();
    }

    public void remove(K key){

        // ensure key exists by calling the get() method
        if (get(key) == null) {
            // if the get() method returns null, there's nothing to delete
            return;
        }
        // otherwise, get the index for the key by calling the hash() method
        int index = hashCode(key);

        // get the Entry at the index
        Entry<K, V> entry = currentArray[index];

        // if this entry has the matching key, remove the element at this index
        if (entry.getKey().equals(key) && entry.getNext() == null){
            currentArray[index] = null;
            return;
        }
        // otherwise, if the next element in the linked list is not null
        while (entry.getNext() != null && !entry.getNext().getKey().equals(key)) {
            // if the key of the next element in the linked list is not the key we're looking for
            entry = entry.next;
        }
        //if we are at the end of the list
        //null check
        if(entry.getNext() == null){
            return;
        }else if (entry.getNext().getKey().equals(key)){
            //middle of list
            if(null != entry.getNext().getNext()){
                entry.setNext(entry.getNext().getNext());
            }
            // otherwise, entry.next is the end of the list so we can just chop it off
            else {
                entry.setNext(null);
            }
        }
    }

    public boolean contains(K key){

        int index = hashCode(key);

        // nothing at key
        if (currentArray[index] == null) {
            System.out.println("empty, no key");
            return false;
        }
        //get entry at index
        Entry<K,V> entry = currentArray[index];

        while(null != entry){
            if(entry.getKey().equals(key)){
                return true;
            }
            //otherwise keep looping
            entry = entry.getNext();
        }
        return false;
    }

    public void print() {

        for(int i = 0; i < currentArray.length; i++){
            if(currentArray[i] == null) {
                continue;
            }
            System.out.println(currentArray[i]);

            Entry<K, V> iterator = currentArray[i];

            while(iterator.getNext() != null){
                System.out.println(iterator.getNext());
                iterator = iterator.getNext();
            }
        }
    }

}