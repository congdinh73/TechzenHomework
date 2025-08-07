package TaskMange;

import TaskMange.model.Task;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TaskManager <T>{
    private final Stack<T>  stack = new Stack<>();
    private final Queue<T> queue = new LinkedList<>();
    private final Stack<T> redoStack = new Stack<>();


    public void pushToStack(T task) {
        stack.push(task);
        redoStack.clear();
    }

    public T peekStack() {
       return stack.peek();
    }

    public T popFromStack() {
        if (stack.isEmpty()){
            return null;
        }
        T task = stack.pop();
        redoStack.push(task);
        return task;
    }

    public boolean isStackEmpty() {
        return stack.isEmpty();
    }

    public T redoStack() {
        if (redoStack.isEmpty()) {
            return null;
        }
        T task = redoStack.pop();
        stack.push(task);
        return task;
    }

    public void addToQueue(T task) {
        queue.offer(task);
    }

    public T peekQueue() {
        return queue.peek();
    }

    public T pollFromQueue() {
        return queue.poll();
    }

    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    public T findHighestPriorityTask() {
        if (queue.isEmpty()) {
            return null;
        }
        T highest = null;
        int highestPriority = 0;

        for (T task : queue) {
            int currentPriority = ((Task) task).getPriority();
            if (currentPriority < highestPriority) {
                highestPriority = currentPriority;
                highest = task;
            }
        }
        return highest;
    }
}
