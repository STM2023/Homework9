public class MyQueue <T>{
    //аналог класу Queue, який буде працювати за принципом FIFO (first-in-first-out).
    private Node<T> head=null;
    private Node<T> tail=null;
    private int size=0;
    private static class Node<T>{
        private  T value;
        private  Node <T> next;
        public Node(T value){
            this.value=value;
        }
        public T getValue(){
            return value;
        }
        public void setValue(T value){
            this.value=value;
        }
        public  void setNext(Node<T> next){
            this.next=next;
        }
        public  Node<T> getNext(){
            //   System.out.println("next "+next );
            return next;
        }
    }
    public boolean isEmpty(){
        //проверяем что очередь пуста
        return head==null&&tail==null;
    }
    public void add( T value) {
        //додає елемент в кінець
        Node<T> ob = new Node<>( value );
        if(head==null){
            head=ob;
            //  System.out.println("добавляем в конец очереди1 "+value+tail+head);
        }else{
            tail.setNext(ob);
            // System.out.println("добавляем в конец очереди2 "+value+tail+head);
        }
        tail=ob;
        size++;
    }
    public T poll(){
        //повертає перший елемент з черги і видаляє його з колекції
        if(isEmpty()){
            System.out.println("Помилка1! MyQueue is empty ");
            return null;
        }
        T value = head.getValue();//достаем значение из головы
        head = head.getNext();//головой становится след элт в

        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }
    public T peek(){
        //повертає перший елемент з черги
        if(isEmpty()){
            System.out.println("Помилка2! MyQueue is empty ");
            return null;
        }
        T value = head.getValue();//достаем значение из головы
        return value;
    }
    public void clear() {
        //очищає колекцію
        head = null;
        tail=null;
        size=0;
    }
    public int size() {
        //возвращает размер коллекции
        return size;
    }
}

class MyQueueTest {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue=new MyQueue<>();

        //добавляем в очередь значения
        for(int i=0;i<12;i++){

            myQueue.add(i);
            //       System.out.println(i);
        }
        System.out.println("Розмір очереди "+myQueue.size());
        // извлекаем и печатаем пока очередь не станет пуста
        while(!myQueue.isEmpty()){
            System.out.println(myQueue.poll());
        }

        System.out.println("Розмір очереди "+myQueue.size());

        MyQueue<String> myQueue1=new MyQueue<>();

        //добавляем в очередь значения
        for(int i=0;i<7;i++){

            myQueue1.add("ww"+i);

        }
        System.out.println("Розмір очереди "+myQueue1.size());

        myQueue1.poll();
        System.out.println("Розмір очереди "+myQueue1.size());
        System.out.println("перший елемент  очереди "+myQueue1.peek());
        myQueue1.clear();
 //       System.out.println("Розмір очереди "+myQueue1.size());
 //       System.out.println("перший елемент  очереди "+myQueue1.peek());
    }
}

