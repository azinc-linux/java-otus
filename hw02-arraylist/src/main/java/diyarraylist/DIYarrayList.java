package diyarraylist;
import java.util.*;

public class DIYarrayList<T> implements List<T> {
    private Object[] myarray;
    private final static int initial_cap = 20; // исходная емкость массива
    private int cap=initial_cap; // текущая емкость массива
    private int size = 0; // кол-во вставленных элементов

    public DIYarrayList(){
        myarray = new Object[initial_cap];
    }

    public DIYarrayList(int cap) {
        if(cap < 0)
            throw new IllegalArgumentException("Wrong parameter: "+cap);
        this.myarray = new Object[cap];
    }

    public DIYarrayList(Collection<T> c){
        this();
        for(T item : c)
            this.add(item);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public boolean contains(Object o) {
        if(o == null)
            return false;

        for(int i =0; i<=this.size; i++)
        {
            if(myarray[i].equals(o))
                return true;
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new DIYiterate<T>(this);
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        System.arraycopy(myarray, 0, res, 0, size);
        return res;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(T t) {
        if(this.size == this.cap) {
            this.cap = 2*this.size;
            Object[] temparray = new Object[this.cap];
            System.arraycopy(myarray,0,temparray,0,myarray.length);
            myarray = temparray;
        }
        myarray[this.size] = t;
        this.size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null)
            return false;
        int index =this.indexOf(o);
        if (index >= 0) {
            this.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c == null)
            return false;
        for(T item : c)
            this.add(item);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        for(int i =0; i<=this.size; i++)
            myarray[i]=null;
        this.size=0;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= this.size)
            throw new ArrayIndexOutOfBoundsException("index must be greater 0 and lesser "+index+" "+this.size);
        return (T)myarray[index];
    }

    @Override
    public T set(int index, T element) {
        if (index >= this.size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        T oldval = (T)myarray[index];
        myarray[index] = element;
        return oldval;
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        if (index <0 || index > this.size)
            throw new IllegalArgumentException();
        T item = (T)myarray[index];
        myarray[index]=null;
        for(int i=index; i<this.size-1; i++)
            myarray[i]=myarray[i+1];
        myarray[this.size-1] = null;
        this.size--;
        return item;
    }

    @Override
    public int indexOf(Object o) {
        if(o == null)
            throw new IllegalArgumentException();
        for(int i=0; i<=this.size; i++) {
            if (myarray[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new DIYiterate<T>(this);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new DIYiterate<T>(this,index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private class DIYiterate<T> implements ListIterator<T>{
        private int index=-1;
        private DIYarrayList arraylist;

        public DIYiterate(DIYarrayList arraylist)
        {
            this.arraylist = arraylist;
        }

        public DIYiterate(DIYarrayList arraylist,int index)
        {
            this.arraylist=arraylist;
            this.index=index;
        }

        @Override
        public boolean hasNext() {
            return !this.arraylist.isEmpty() && ((this.arraylist.size() -1) > this.index);
        }

        @Override
        public T next() {
            if(!this.hasNext())
                throw new NoSuchElementException();
            return (T)arraylist.get(++this.index);
        }

        @Override
        public boolean hasPrevious() {
            return !this.arraylist.isEmpty() && this.index > 0;
        }

        @Override
        public T previous() {
            if(!this.hasPrevious())
                throw new NoSuchElementException();

            return (T)this.arraylist.get(--this.index);
        }

        @Override
        public int nextIndex() {
            return ++this.index;
        }

        @Override
        public int previousIndex() {
            return --this.index;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) {
            if (this.index > 0 && this.index < arraylist.size())
                this.arraylist.set(this.index,t);
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }
    }


    public static void main(String[] args){

        DIYarrayList<Integer> listint = new DIYarrayList<>();
        DIYarrayList<Integer> listint2 = new DIYarrayList<>();
        Integer[] elements1 = new Integer[100];
        Integer[] elements2 = new Integer[100];

        for (int i=0; i<100; i++) {
            elements1[i] = i;
            elements2[i]= i+100;
        }

        System.out.println("test addAll");
        System.out.println("listint's size before add: "+listint.size());
        Collections.addAll(listint, elements1);
        System.out.println("listint's size after add: "+listint.size()) ;
        Collections.addAll(listint2, elements2);
        System.out.println("test copy");
        Collections.copy(listint, listint2);
        for(Integer j : listint)
            System.out.println(j);


        System.out.println("test sorting id descent");
        Collections.sort(listint,new Comparator<Integer>(){
            public int compare(Integer e, Integer e1)
            {
                return e > e1 ? -1 : (e == e1 ? 0 : 1);
            }
        });

        for ( Integer j : listint)
            System.out.println(j);

    }
}

