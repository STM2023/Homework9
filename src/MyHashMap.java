import java.util.Map;
import java.util.Objects;

public class MyHashMap<K,V> {
    //аналог класу HashMap
    private static final int DEFAULT_LENGTH = 8;
    private Entry<K,V> [] entries=new Entry[DEFAULT_LENGTH];
    private int size=0;
    private static  class Entry<K,V>{
        private K key;
        private V value;
        private Entry<K,V>  next;
        private int myhesh;
        public Entry(K key, V value, Entry<K,V> next ){
            this.key=key;
            this.value=value;
            this.next=next;
        }

        public K getKey(){
            return key;
        }
        public void setKey(K key){
            this.key=key;
        }
        public void setValue(V value){
            this.value=value;
        }
        public void setNext(Entry<K,V> next){
            this.next=next;
        }
        public V getValue(){
            return value;
        }
        public Entry< K,V> getNext(){
            return next;
        }

        @Override
        public int hashCode(){
            myhesh=31;
            myhesh=myhesh*17+ key.hashCode();
            return myhesh;
        }

        @Override
        public boolean equals ( Object obj){

            if(this==obj) {
                return true;
            }
            if(obj==null || getClass()!=obj.getClass()) {
                return false;
            }
            Entry<K,V> entry = (Entry) obj;

            return Objects.equals(key,entry.key)&& Objects.equals(value,entry.value)&&Objects.equals(hashCode(),entry.hashCode()) ;

        }

    }



    public void put(K key, V value){
        //додає пару ключ + значення
        int index= getBucketIndex(key);
        System.out.println("додає - index = " + index);

        Entry<K,V>entry =new Entry<>(key, value, null);
        if(entries[index]==null){
            entries[index]=entry;
            size++;
        }else{
            //это не пустая ячейка массива, ищем хвост
            entry =entries[index];
            while (entry.next!=null){
                entry=entry.next;
            }
            if (entry.next==null){
                entry.key=key;
                entry.value=value;
                size++;
            }
        }
    }
    private  int getBucketIndex(K key){
        //вычисляем место в массиве
        return Math.abs(key.hashCode())% entries.length;
    }
    //---------------------------------------------------------
    public void remove(K key) {
        //видаляє пару за ключем
        int index = getBucketIndex(key);
        System.out.println("видаляє-- index = " + index);
        if (entries[index].getKey().equals(key)) {
            //         return entries[index].value;
            entries[index].value = null;
            entries[index].key = null;
            size--;
            return;
        } else {
            Entry<K, V> entry = new Entry<>(entries[index].key, entries[index].value, entries[index].next);
            Entry<K, V> entryprev = entry;

            while (entry.next != null) {
                entryprev = entry;
                entry = entry.next;
                if (entry.getKey().equals(key)) {
//                   return entry.value;
                    entryprev.next = entry.next;
                    size--;
                    return;
                }
            }
            if (entry.next == null) {
                System.out.println("Помилка! не знайдено елемент key= "+entry.key);
            }

        }
    }
    //---------------------------------------------------------
    public void clear(){
        //очищає колекцію
        Entry<K,V> [] entries=new Entry[DEFAULT_LENGTH];
        size=0;
    }

    public int size() {
        //повертає розмір колекції
        return size;
    }
    //---------------------------------------------------------
    public V get(K key) {
        //повертає значення (Object value) за ключем
        int index=getBucketIndex(key);
        System.out.println("-- index = " + index);
        if(entries[index].getKey().equals(key)){
            return entries[index].value;
        }else {
            Entry<K,V>entry =new Entry<>(entries[index].key,entries[index].value , entries[index].next);

            while(entry.next!=null ){
                entry =entry.next;

                if (entry.getKey().equals(key) ){
                    return entry.value;
                }

            }
            if (entry.next==null){
                System.out.println("Помилка! не знайдено елемент key= "+entry.key);
                return null;
            }
        }
        return null;
    }
//---------------------------------------------------------
}

class  MyHashMapTest{
    public static void main(String[] args) {
        MyHashMap<String,String> myHashMap = new MyHashMap<>();
        System.out.println("-- розмір   myHashMap - " + myHashMap.size());
        myHashMap.put("first","first value");
        myHashMap.put("second","second value");
        myHashMap.put("fhird","fhird value");
        myHashMap.put("fourth","fourth value");
        myHashMap.put("fifth","fifth value");
        System.out.println("-- розмір   myHashMap = " + myHashMap.size());
        System.out.println(" ключ fhird елемент "+myHashMap.get("fhird"));
        myHashMap.remove("first");
        myHashMap.remove("fifth");
        myHashMap.remove("fhird");
        System.out.println("-- розмір   myHashMap - " + myHashMap.size());

        System.out.println(" ключ second елемент "+myHashMap.get("second"));
        System.out.println(" ключ fourth елемент "+myHashMap.get("fourth"));
        myHashMap.clear();

        System.out.println("-- розмір   myHashMap - " + myHashMap.size());



    }
}

