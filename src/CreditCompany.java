/**
 * Check out my trello for more info, trello page has bugs/issues, logic, function info, and more
 * Trello (Task Checklist): https://trello.com/invite/b/5W8XE8vO/f84fe6b40d347ec0be7ffd9a0664dedb/individual-concurrency-assignment-4
 * <p>
 * The Consumer threads will remove orders from the blocking Queue
 * <p>
 * CreditCompany.java
 * Consumer class, implements Runnable
 * <p>
 * Author: Jacob Jonas
 * Date Completed: 3/23/22
 */

public class CreditCompany implements Runnable {
    private final ApplicationQueue mySharedQueue;    // Store a reference to the shared queue as a field


    /**
     * CreditCompany(ApplicationQueue mySharedQueue) method
     * <p>
     * Sets ApplicationQueue with credit card company's
     *
     * @param mySharedQueue
     */
    public CreditCompany(ApplicationQueue mySharedQueue) {
        this.mySharedQueue = mySharedQueue;
    }

    /**
     * Run() method
     * <p>
     * Performs logic on applications for a set duration of time using the applicants credit score
     * to return and remove credit card company's response to loan
     * approval or denial and for what amount
     */
    public void run() {
        long start = System.currentTimeMillis();
        // Run for a second removing orders from the shared queue
        // One min would be 60000 milsec
        while (System.currentTimeMillis() - start <= 60000) {

            mySharedQueue.removeApplication();//removes application from queue, must be first

            //System.out.print("DEBUGING|Applications:"+ApplicationQueue. getQueue()); // Shows what queues are being removed

            String print = Thread.currentThread().getName() + "Application #" + Application.getApplicationId() + " with credit score " + Application.getCreditScore();

            if (Application.getCreditScore() > 580 && Application.getCreditScore() < 669) {
                int num = Application.getRequestedLimit() + 5000;
                System.out.println(print + " is approved for $" + num + " (requested: $" + Application.getRequestedLimit() + ")");
                Application.isApproved();
                Application.setRequestedLimit(num);
            }

            if (Application.getCreditScore() > 670 && Application.getCreditScore() < 739) {
                int num = Application.getRequestedLimit() + 10000;
                System.out.println(print + " is approved for $" + num + " (requested: $" + Application.getRequestedLimit() + ")");
                Application.isApproved();
                Application.setRequestedLimit(num);
            }

            if (Application.getCreditScore() > 740 && Application.getCreditScore() < 799) {
                int num = Application.getRequestedLimit() + 25000;
                System.out.println(print + " is approved for $" + num + " (requested: $" + Application.getRequestedLimit() + ")");
                Application.isApproved();
                Application.setRequestedLimit(num);
            }

            if (Application.getCreditScore() >= 800) {
                int num = Application.getRequestedLimit() + 50000;
                System.out.println(print + " is approved for $" + num + " (requested: $" + Application.getRequestedLimit() + ")");
                Application.isApproved();
                Application.setRequestedLimit(num);
            }

            if (Application.getCreditScore() < 579) {
                System.out.println(print + " is not approved");
            }

        }


    }

}
