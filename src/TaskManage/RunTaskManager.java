package TaskMange;

import TaskMange.model.Task;

public class RunTaskManager {
    public static void main(String[] args) {
        TaskManager<Task> tm = new TaskManager<>();

        tm.pushToStack(new Task("Fix bug", 2));
        tm.pushToStack(new Task("Write report", 3));
        System.out.println("Stack top: " + tm.peekStack());
        Task undone = tm.popFromStack();
        System.out.println("Popped from stack (undo): " + undone);
        System.out.println("Redo from stack: " + tm.redoStack());

        tm.addToQueue(new Task("Email reply", 2));
        tm.addToQueue(new Task("Team meeting", 1));
        tm.addToQueue(new Task("Code review", 3));
        System.out.println("Peek queue: " + tm.peekQueue());


        Task highest = tm.findHighestPriorityTask();
        System.out.println("Highest priority task: " + highest);

    }
}
