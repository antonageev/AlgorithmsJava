package lesson8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChainingHashMap<Key, Value> {
    int capacity;
    int size = 0;
    List<Node>[] hm;

    public ChainingHashMap(int capacity){
        if (capacity <= 0) throw new IllegalArgumentException();
        this.capacity =capacity;
        hm = new LinkedList[capacity];

        for (int i = 0; i < hm.length; i++){
            hm[i] = new LinkedList<>();
        }

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int hash (Key key){
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    public void put(Key key, Value value){
        isKeyNotNull(key);
        for (Node n: hm[hash(key)]){
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        hm[hash(key)].add(new Node(key, value));
        size++;
    }

    public Value get(Key key){
        isKeyNotNull(key);
        for (Node n : hm[hash(key)]){
            if (n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }

    public Value delete(Key key){
        isKeyNotNull(key);
        if (isEmpty()) return null;
        Iterator<Node> iterator = hm[hash(key)].iterator();
        Node resultNode = null;
        while (iterator.hasNext()){
            Node bufferNode = iterator.next();
            if (bufferNode.key.equals(key)){
                resultNode = bufferNode;
                iterator.remove();
                break;
            }
        }
        size--;
        return resultNode.value;
    }

    public boolean isKeyNotNull(Key key){
        if (key == null) throw new IllegalArgumentException("key must be not null");
        return true;
    }

    @Override
    public String toString(){
        if (isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hm.length; i++){
            for (Node n: hm[i]){
                sb.append(n.key).append(" = ").append(n.value).append(";");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    private class Node{
        Key key;
        Value value;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }

    }

}
