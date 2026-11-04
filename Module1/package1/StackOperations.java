package package1;
/*
 * STACK IN JAVA — INITIALIZATION AND ALL COMMON OPERATIONS
 *
 * A stack follows LIFO: Last In, First Out.
 * Common operations:
 *   push()    -> add an element to the top
 *   pop()     -> remove and return the top element
 *   peek()    -> view the top element without removing it
 *   isEmpty() -> check whether the stack is empty
 *   size()    -> number of elements
 *   search()  -> find an element (1-based position from the top in java.util.Stack)
 *   clear()   -> remove all elements
 *
 * Save as: StackOperations.java
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackOperations {
    public static void main(String[] args) {

        // =========================================================
        // 1. INITIALIZATION USING java.util.Stack
        // =========================================================
        Stack<Integer> stack = new Stack<>();

        // Initialize with values one by one
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack after push: " + stack); // [10, 20, 30]

        // =========================================================
        // 2. COMMON STACK OPERATIONS
        // =========================================================

        // push(): insert an element at the top
        stack.push(40);
        System.out.println("After push(40): " + stack);

        // peek(): read the top element; does not remove it
        System.out.println("Top element: " + stack.peek());

        // pop(): remove and return the top element
        int removed = stack.pop();
        System.out.println("Popped element: " + removed);
        System.out.println("After pop: " + stack);

        // isEmpty(): check if there are no elements
        System.out.println("Is stack empty? " + stack.isEmpty());

        // size(): number of elements
        System.out.println("Stack size: " + stack.size());

        // search(): position from the top, starting at 1; -1 if absent
        System.out.println("Position of 20 from top: " + stack.search(20));
        System.out.println("Position of 99 from top: " + stack.search(99));

        // contains(): check whether an element exists
        System.out.println("Contains 10? " + stack.contains(10));

        // Iterate from bottom to top (Stack's iterator order)
        System.out.print("Elements bottom to top: ");
        for (int value : stack) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Iterate from top to bottom using a ListIterator
        System.out.print("Elements top to bottom: ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();

        // =========================================================
        // 3. CLEARING A STACK
        // =========================================================
        stack.clear();
        System.out.println("After clear(): " + stack);
        System.out.println("Is stack empty now? " + stack.isEmpty());

        // =========================================================
        // 4. INITIALIZE A STACK FROM EXISTING VALUES
        // =========================================================
        Stack<String> names = new Stack<>();
        names.addAll(java.util.Arrays.asList("Aman", "Riya", "Karan"));
        System.out.println("Stack initialized from a collection: " + names);

        // =========================================================
        // 5. RECOMMENDED MODERN ALTERNATIVE: ArrayDeque
        //    Deque can be used as a stack. It generally avoids the
        //    legacy Stack class and is preferred for single-threaded use.
        // =========================================================
        Deque<Integer> dequeStack = new ArrayDeque<>();

        dequeStack.push(100); // add to top
        dequeStack.push(200);
        dequeStack.push(300);
        System.out.println("ArrayDeque stack: " + dequeStack);

        System.out.println("Top using peek(): " + dequeStack.peek());
        System.out.println("Removed using pop(): " + dequeStack.pop());
        System.out.println("After pop(): " + dequeStack);
        System.out.println("Is empty? " + dequeStack.isEmpty());
        System.out.println("Size: " + dequeStack.size());

        // Remove all remaining items safely
        dequeStack.clear();
        System.out.println("After clear(): " + dequeStack);

        // =========================================================
        // 6. SAFE CHECKS BEFORE pop() OR peek()
        //    Stack.pop()/peek() throw EmptyStackException when empty.
        //    ArrayDeque.pop() throws NoSuchElementException when empty.
        // =========================================================
        if (!dequeStack.isEmpty()) {
            System.out.println(dequeStack.peek());
            System.out.println(dequeStack.pop());
        } else {
            System.out.println("Cannot pop/peek: stack is empty.");
        }
    }
}
