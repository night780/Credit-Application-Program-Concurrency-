/**
 * Check out my trello for more info, trello page has bugs/issues, logic, function info, and more
 * Trello (Task Checklist): https://trello.com/invite/b/5W8XE8vO/f84fe6b40d347ec0be7ffd9a0664dedb/individual-concurrency-assignment-4
 * <p>
 * Bug/Q: First three consumer thread prints execute on the same application, why?
 * join was causing a previous bug similar, is it have to do with that?
 * <p>
 * TestCreditApplication.java
 * Driver class
 * <p>
 * Author: Jacob Jonas
 * Date Completed: 3/23/22
 */

public class TestCreditApplication {
    /**
     * Main() method
     * <p>
     * Creates 3 producer threads and 2 consumer threads which it will pass to producer (Applicants) and consumer
     * (CreditCompany) threads as a parameter to the constructor methods.
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        // construct Shared Queue
        ApplicationQueue orderQueue = new ApplicationQueue();


        Thread[] producers = new Thread[3];
        Thread[] consumers = new Thread[2];

        // construct Consumer and Producer Threads (pass Shared Queue)
        for (int i = 0; i < producers.length; i++) {
            producers[i] = new Thread(new Applicants(orderQueue), "P" + (i + 1) + ": ");
            System.out.println(producers[i].getName() + " started!");
        }
        for (int i = 0; i < producers.length; i++) {
            producers[i].start();
        }

        /*
        Extra Info --

        Broke into 4 loops as was having trouble interleaving when in two.

        Also when using .join() like in the examples from class, I also encounter multiple problems.
        Code seems to work without it but thought I had to join after starting them?
         */

        for (int i = 0; i < consumers.length; i++) {
            consumers[i] = new Thread(new CreditCompany(orderQueue), "C" + (i + 1) + ": ");
        }
        for (int i = 0; i < consumers.length; i++) {
            consumers[i].start();
        }


    }
}
