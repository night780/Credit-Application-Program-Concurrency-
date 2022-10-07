import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Check out my trello for more info, trello page has bugs/issues, logic, function info, and more
 * Trello (Task Checklist): https://trello.com/invite/b/5W8XE8vO/f84fe6b40d347ec0be7ffd9a0664dedb/individual-concurrency-assignment-4
 * <p>
 * ApplicationQueue.java
 * Queue class
 * <p>
 * Author: Jacob Jonas
 * Date Completed: 3/23/22
 */


public class ApplicationQueue {

    private static BlockingQueue<Application> queue = new LinkedBlockingQueue<>();

    /**
     * addApplication(Application App) method
     * <p>
     * Adds an application to the queue using the put method passing Application as prama
     *
     * @param App
     */
    public void addApplication(Application App) {
        try {
            queue.put(App);// Put into blocking queue
        } catch (InterruptedException e) {

        }
    }

    /**
     * removeApplication() method
     * <p>
     * Removes the last App from the queue using the take method
     *
     * @return removed = queue.take();
     */
    public Application removeApplication() {
        Application removed = null;
        try {
            removed = queue.take();//taking out of blocking queue
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return removed;
    }

    /**
     * getQueueSize() method
     * <p>
     * checks the size of the queue
     *
     * @return queue.size();
     */
    public int getQueueSize() {
        return queue.size();
    }

    /**
     * getQueue() method
     * <p>
     * Fetches the queue (BlockingQueue<Application>)
     *
     * @return queue
     */
    public static BlockingQueue<Application> getQueue() {
        return queue;
    }


}
