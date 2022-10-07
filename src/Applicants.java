import java.util.Random;

/**
 * Trello (Task Checklist): https://trello.com/invite/b/5W8XE8vO/f84fe6b40d347ec0be7ffd9a0664dedb/individual-concurrency-assignment-4
 * <p>
 * Applicants.java
 * Producer Class, implements Runnable
 * <p>
 * Author: Jacob Jonas
 * Date Completed: 3/23/22
 */

public class Applicants implements Runnable {
    private ApplicationQueue mySharedQueue; // Store a reference to the shared queue as a field


    /**
     * Applicants(ApplicationQueue mySharedQueue) method
     * <p>
     * Sets ApplicationQueue with applicants
     *
     * @param mySharedQueue
     */
    public Applicants(ApplicationQueue mySharedQueue) {
        this.mySharedQueue = mySharedQueue;
    }

    /**
     * Run() method
     * <p>
     * Executes the addition of applications during a set ammount of time,
     * sleeping between each interval between 100-1200 milsec
     * Adds Application to sharedQueue
     */
    public void run() {

        long start = System.currentTimeMillis();
        // Run for a second adding orders to the shared queue
// One min would be 60000 milsec(6sec)
        while (System.currentTimeMillis() - start <= 60000) {

            //creates new application with random credit and requested amount
            Application App = new Application(new Random().nextInt(300, 850), new Random().nextInt(5000, 50000));
            mySharedQueue.addApplication(App); // Adds Application into sharedQueue

            //Used for debugging to identify if threads were original or duplicates
            //System.out.print("DEBUGING|credit:" + App.getCreditScore() + "  *  ");

            //Prints the new application
            System.out.println(Thread.currentThread().getName() + " created application #" + Application.getNextId());

            //Waits 100-1200 Random milsec between prints
            int rantime = new Random().nextInt(100, 1200);
            try {
                Thread.sleep(rantime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " finished!" + " (Thread ran for " + (System.currentTimeMillis() - start) / 1000 + " seconds)");

    }

}
