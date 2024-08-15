package mont;

public class Stack<E> {
    private E[] array;
    private int index = 0;

    public Stack(int size)
    {
        this.array = (E[]) new Object[size];
    }

    public void push(E i)
    {
        this.array[this.index++] = i;
    }
    public E pop()
    {
        return this.array[--index];
    }

}

class Test
{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>(20);

        stack.push(2);
        stack.push(1);

        int a = (Integer)stack.pop();
        int i = (int)stack.pop();
    }
}
