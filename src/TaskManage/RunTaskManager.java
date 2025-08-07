package TaskManage;

import TaskManage.model.Task;

public class RunTaskManager {
    public static void main(String[] args) {
        TaskManager<Task> manager = new TaskManager<>();


        System.out.println("=== STACK Demo ===");
        manager.pushToStack(new Task("Fix bug", 3));
        manager.pushToStack(new Task("Review code", 2));
        manager.pushToStack(new Task("Write report", 1));

        System.out.println("Stack top: " + manager.peekStack());

        Task undone = manager.popFromStack();
        System.out.println("Undo (pop): " + undone);

        Task redone = manager.redoStack();
        System.out.println("Redo (push lại): " + redone);


        System.out.println("\n=== QUEUE Demo ===");
        manager.addToQueue(new Task("Email reply", 4));
        manager.addToQueue(new Task("Daily meeting", 1));
        manager.addToQueue(new Task("Deploy release", 2));

        System.out.println("Queue front: " + manager.peekQueue());

        System.out.println("Poll from queue: " + manager.pollFromQueue());
        System.out.println("Queue front after poll: " + manager.peekQueue());


        System.out.println("\n=== Find Highest Priority Task in Queue ===");
        Task highest = manager.findHighestPriorityTask();
        System.out.println("Highest priority task in queue: " + highest);

    }
}
