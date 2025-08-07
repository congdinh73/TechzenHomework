package List;

public class MyArrayList {
    private int capacity;
    private int[] arr;
    private final int[] emptyArray = {};
    private int size;

    public int size() {
        return size;
    }

    public MyArrayList() {
        arr = emptyArray;
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.arr = new int[this.capacity];
    }


    public void addElement(int element) {
        if (arr == emptyArray) {
            this.capacity = 10;
            this.arr = new int[this.capacity];
        }

        if (size == capacity) {
            this.capacity *= 1.5;
            if (size == capacity) {
                capacity++;
            }


            int[] brr = new int[this.capacity];

            for (int i = 0; i < size; i++) {
                brr[i] = arr[i];
            }


            arr = brr;
        }

        arr[size] = element;
        size++;
    }

    public int setElementOfIndex(int index, int element) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return -1;
        }
        int oldValue = arr[index];
        arr[index] = element;
        return oldValue;
    }

    public int getIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return -1;
        }
        return arr[index];
    }

    public int indexOfElement(int element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOfElement(int element) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index out of bounds");
            return -1;
        }
        int removedElement = arr[index];

        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;

        arr[size] = 0;

        return removedElement;
    }

    public int removeElement(int element) {
        int index = indexOfElement(element);
        if (index == -1) {
            System.out.println("Element not found");
            return -1;
        }
        return removeAtIndex(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            stringBuilder.append(arr[i]).append("\t");
        }
        return stringBuilder.toString();
    }
}
