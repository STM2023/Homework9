public class MyArrayList <T>{
    //аналог класу ArrayList
    private T[] array;
    private int size=0;
    private static final int DEFAULT_LENGTH = 10;
    public MyArrayList(){
        this.array=(T[])new Object[DEFAULT_LENGTH];
    }

    public void add(T value){
        //додає елемент в кінець
        if(size>= array.length){
            bigArray();
        }
        array[size]=value;
        size++;
    }
    public void bigArray() {
        T[] newArray = (T[])new Object [array.length * 2];
        for (int i = 0; i <= array.length - 1; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
    public void remove(int index ){
        // видаляє елемент із вказаним індексом
        if(index<0|| index>array.length-1){
            System.out.println("Помилка3 index" +index+" не відповідає розмірності " + +array.length);
            return;
        }
        for(int i=index;i<size-1;i++){
            array[i]=array[i+1];
        }
        array[size-1]=null;
        size--;
    }
    public void clear(){
        //очищає колекцію

        array=(T[]) new Object[DEFAULT_LENGTH];
        size=0;
    }
    public int size(){
        //повертає розмір колекції
        return size;
    }
    public T get(int index){
        //повертає елемент за індексом
        if(index<0||index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }
}
class MyArrayListTest{
    public static void main(String[] args) {

        MyArrayList<Integer> myArrayList= new MyArrayList();
        //добавляем в массив значения
        for(int i=0;i<10;i++){
            myArrayList.add(i);
        }
        //  печатаем  массив
        for(int i=0;i<10;i++){
            System.out.println( " index - "+ i +" значення - "+ myArrayList.get(i));
        }
        System.out.println( " розмір колекції - "+ + myArrayList.size());

        myArrayList.remove(9);
        System.out.println( " розмір колекції - "+ + myArrayList.size() );
        myArrayList.remove(0);
        System.out.println( " розмір колекції - "+ + myArrayList.size() );
        myArrayList.remove(3);
        System.out.println( " розмір колекції - "+ + myArrayList.size() );

        for(int i=0;i<7;i++){
            System.out.println( " index - "+ i +" значення - "+ myArrayList.get(i));
        }
        System.out.println( " розмір колекції - "+ + myArrayList.size());

        for(int i=0;i<15;i++){
            myArrayList.add(i);

        }
        //  печатаем  массив
        for(int i=0;i<22;i++){
            System.out.println( " index - "+ i +" значення - "+ myArrayList.get(i));
        }
        System.out.println( " розмір колекції - "+ + myArrayList.size() );
        myArrayList.clear();
        System.out.println( " розмір колекції - "+ + myArrayList.size() );

//-----------
        MyArrayList<String > myArrayList1 = new MyArrayList();
        //добавляем в массив значения
        for(int i=0;i<10;i++){
            myArrayList1.add("words"+i);

        }
        //  печатаем  массив
        for(int i=0;i<10;i++){
            System.out.println( " index - "+ i +" значення - "+ myArrayList1.get(i));
        }
        System.out.println( " розмір колекції - "+ + myArrayList1.size());

        myArrayList1.remove(9);
        System.out.println( " розмір колекції - "+ + myArrayList1.size() );
        myArrayList1.remove(0);
        System.out.println( " розмір колекції - "+ + myArrayList1.size() );
        myArrayList1.remove(3);
        System.out.println( " розмір колекції - "+ + myArrayList1.size() );

        for(int i=0;i<7;i++){
            System.out.println( " index - "+ i +" значення - "+ myArrayList1.get(i));
        }
        System.out.println( " розмір колекції - "+ + myArrayList1.size());

        for(int i=0;i<15;i++){
            myArrayList1.add("words"+i);

        }
        //  печатаем  массив
        for(int i=0;i<22;i++){
            System.out.println( " index - "+ i +" значення - "+ myArrayList1.get(i));
        }
        System.out.println( " розмір колекції - "+ + myArrayList1.size() );
        myArrayList1.clear();
        System.out.println( " розмір колекції - "+ + myArrayList1.size() );

    }
}

