package hackerrank;

import java.util.Stack;

public class ATaleOfTwoStacks {
	
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
                       
            stackNewestOnTop.push(value);
        }

        public T peek() {
        	if (stackOldestOnTop.empty()) {
	        	while (!stackNewestOnTop.empty())
	                stackOldestOnTop.push(stackNewestOnTop.pop());
        	}
        	
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
        	if (stackOldestOnTop.empty()) {
	            while (!stackNewestOnTop.empty())
	                stackOldestOnTop.push(stackNewestOnTop.pop());
        	}        
            return stackOldestOnTop.pop();
        }
    }

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.enqueue(42);
        System.out.println(queue.dequeue());
        queue.enqueue(14);
        System.out.println(queue.peek());
    }
}
