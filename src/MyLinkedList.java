public class MyLinkedList<T> {
    // аналог классу LinkedList
    private Node<T> head;
    private Node<T> tail;
    private  int size;
    private static class Node<T>{
        private T value;
        private Node<T> next;
        private Node<T> prev;
        public Node (T value){
            this.value=value;
        }
        public T getValue(){
            return value;
        }
        public Node<T> getNext(){
            return next;
        }
        public void setNext(Node<T> next){
            this.next=next;
        }
        public Node <T>getPrev(){
            return prev;
        }
        public void setPrev(Node<T> prev){
            this.prev=prev;
        }
    }
    public void add(T value){
        //додає елемент в кінець
        Node<T> node = new Node<>(value);
        if (head==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;
            node.prev=tail;
            tail=node;
        }
        size++;
    }
    public void remove(int index) {
        System.out.println("видаляє елемент  index="+ index);
        //видаляє елемент із вказаним індексом
        if (index<0||index>size){
            System.out.println("Помилка! index="+index);
            return;
        }
        if (index==size){
            // це останній елемент списку
            Node<T> nodeprev=tail.prev;
            nodeprev.next=null;
            tail=nodeprev;
            size--;
            return;
        }

        if (index==0){
            //це перший елемент списку
            Node<T> nodenext=head.next;
            nodenext.prev=null;
            head=nodenext;
            size--;
            return;
        }
        Node<T> node = head.next;
        for(int i=1;i<=index;i++){
            //cередина списку
            if(i==index) {
                Node<T> nodeprev = node.prev;
                Node<T> nodenext = node.next;
                nodeprev.next = nodenext;
                nodenext.prev = nodeprev;
                System.out.println("nodeprev = " + nodeprev.value + "    nodenext= " + nodenext.value);
                size--;
                return;
            }
            node=node.next;
        }

    }
    public void clear(){
        //очищає колекцію
        head=null;
        tail=null;
        size=0;
    }
    public int size() {
        //повертає розмір колекції
        return size;
    }
    public int getSize(){
        return size;
    }
    public boolean  isEmpty(){
        return head==null&&tail==null;
    }
    public T get(int index){
        //повертає елемент за індексом
        if (index<0||index>size){
            System.out.println("Помилка! index= ");
            return null;
        }
        Node<T> node = head;
        for (int i=0;i<index;i++){
            node=node.next;
        }
        return node.getValue();
    }
}
class MyLinkedListTest{
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        // формуємо список
        for(int i=0;i<10;i++){
            myLinkedList.add(i);
        }
        for (int i = 0; i < myLinkedList.getSize(); i++) {
            System.out.println("index= "+i+" елемент списка - " + myLinkedList.get(i));
        }
        System.out.println("-- розмір  списка - " + myLinkedList.size());

        myLinkedList.remove(10);
        for (int i = 0; i < myLinkedList.getSize(); i++) {
            System.out.println("index= "+i+" елемент списка - " + myLinkedList.get(i));
        }
        System.out.println("-- розмір  списка - " + myLinkedList.size());



        myLinkedList.remove(3);
        for (int i = 0; i < myLinkedList.getSize(); i++) {
            System.out.println("index= "+i+" елемент списка - " + myLinkedList.get(i));
        }
        System.out.println("-- розмір  списка - " + myLinkedList.size());

        myLinkedList.remove(0);
        for (int i = 0; i < myLinkedList.getSize(); i++) {
            System.out.println("index= "+i+" елемент списка - " + myLinkedList.get(i));
        }
        System.out.println("-- розмір  списка - " + myLinkedList.size());

        myLinkedList.clear();

        System.out.println("-- розмір  списка - " + myLinkedList.size());
    }
}

