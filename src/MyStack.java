public class MyStack<T> {
    private Node<T> head;
    private int size=0;
    private static class Node <T>{
        private final T value;
        private final Node<T> prev;

        public Node(T value, Node<T> prev){
            this.value=value;
            this.prev=prev;
        }
        public T getValue(){
            return value;
        }
        public Node<T> getPrev(){
            return prev;
        }
    }

    public boolean isEmpty(){
        //проверяем что список пустой
        return head==null;
    }
    public void push(T value){
        //добавляет элемент в конец
        head=new Node<>(value,head);
        size++;
    }
    public T pop(){
        //возвращает первый элемент в стеке и удаляет его из коллекции
        if(isEmpty()){
            System.out.println("Помилка1! Stak is empty ");
            return null;
        }
        T value = head.getValue();//достаем значение из головы
        head=head.getPrev();//головой становится пред элт в стеке
        size--;
        return value;
    }
    public T peek() {
        //возвращает первый элемент в стеке (LIFO)
        if(isEmpty()){
            System.out.println("Помилка2! Stak is empty ");
            return null;
        }
        T value = head.getValue();//достаем значение из головы
        return value;
    }
    public void clear() {
        //очищает коллекцию
        while (!isEmpty()){
            pop();
        }
    }
    public void remove(int index){
        //удаляет элемент под индексом
        for (int i=0;i<=index;i++) {
            if (!isEmpty()) {
                pop();
            }
        }
    }

    public int size() {
        //возвращает размер коллекции
        return size;
    }
}


class MyStakTest {
    public static void main(String[] args) {
        MyStack<Integer> myStack=new MyStack<>();
        //добавляем в стек значения
        for(int i=0;i<12;i++){
            myStack.push(i);
            System.out.println(i);
        }

        //  // извлекаем и печатаем пока стек не станет пустым
        //  while(!myStack.isEmpty()){
        //      System.out.println(myStack.pop());
        //  }
        System.out.println("розмір  стека "+myStack.size());
        System.out.println("перший елемент стека "+myStack.peek());
        for(int i=0;i<3;i++){
            myStack.pop();
        }
        System.out.println("розмір  стека "+myStack.size());
        System.out.println("перший елемент стека "+myStack.peek());

        myStack.remove(2);
        System.out.println("розмір  стека "+myStack.size());
        System.out.println("перший елемент стека "+myStack.peek());

        myStack.clear();
//        System.out.println("розмір  стека "+myStack.size());
//        System.out.println("перший елемент стека "+myStack.peek());

        MyStack<String > myStack1 = new MyStack<>();
        for(int i=0;i<7;i++){
            myStack1.push("word"+i);
            System.out.println("word"+i);
        }

    }

}

