package array;

public class StaticArray<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数
     * @param capacity 数组容量
     */
    public StaticArray(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    // 无参数的构造函数，默认数组容量为10
    public StaticArray() {
        this(10);
    }

    // 获取数组中元素个数
    public int getSize() {
        return size;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 判断组数是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 指定索引位置添加一个新元素
     * @param index 索引
     * @param e int新元素
     */
    public void add(int index, E e) {
        if (size == data.length)
            throw new IllegalArgumentException("Add failed. Array is full.");
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Requrie index >= 0 and index <= size.");
        for (int i = size - 1; i >= index; i --)
            data[i + 1] = data[i];
        data[index] = e;
        size ++;
    }

    // 在数组最后添加一个新元素
    public void addLast(E e) {
        add(size, e);
    }

    // 在数组最前添加一个新元素
    public void addFirest(E e) {
        add(0, e);
    }

    // 取出index索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        return data[index];
    }

    // 获取第一个索引元素
    public E getLast() {
        return get(size - 1);
    }

    // 获取最后一个索引元素
    public E getFirst() {
        return get(0);
    }


    // 修改index索引位置的元素为e
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e) {
        for (int i = 0; i < size; i ++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 从数组中删除index位置的元素，返回删除的元素
    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Requrie index >= 0 and index <= size.");
        E ret = data[index];
        for(int i = index + 1; i < size; i ++)
            data[i - 1] = data[i];
        size --;
        return ret;
    }

    // 从数组中删除第一个元素，返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从数组中删除最后一个元素，返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    // 打印，类似于python的 def __str__（self）方法
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0; i < size; i ++) {
            res.append(data[i]);
            if (i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
