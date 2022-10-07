import java.util.concurrent.atomic.AtomicInteger;

/**
 * Check out my trello for more info, trello page has bugs/issues, logic, function info, and more
 * Trello (Task Checklist): https://trello.com/invite/b/5W8XE8vO/f84fe6b40d347ec0be7ffd9a0664dedb/individual-concurrency-assignment-4
 * <p>
 * Application.java
 * <p>
 * Author: Jacob Jonas
 * Date Completed: 3/23/22
 */


public class Application {

    private static int nextId = 9999;
    private static int lastId;
    private static int applicationId;
    private static int creditScore;
    private static int requestedLimit;
    private static boolean approved;
    private int approvedLimit;

    /**
     * Application constructor
     * <p>
     * Creates an application with creditScore and requested loan amount as prama
     *
     * @param creditScore
     * @param requestedLimit
     */
    public Application(int creditScore, int requestedLimit) {
        this.creditScore = creditScore;
        this.requestedLimit = requestedLimit;
    }

    /**
     * getNextId() method
     * <p>
     * Increments getNextId by one and returns prev value using atomicInt
     *
     * @return nextId = atomicInteger.incrementAndGet();
     */
    public static int getNextId() {
        AtomicInteger atomicInteger = new AtomicInteger(nextId);
        return nextId = atomicInteger.incrementAndGet();//returns previous value and Increments nextID
    }

    /**
     * getApplicationId() method
     *
     * @return applicationId;
     */
    public static int getApplicationId() {
        /**
         * Assigns appID as nextID but de-increments to what # should be.
         * Not correct though, should be retuning just the ID and not de incrementing as a format
         * but should be using ID as a reference, but how?
         * eg;applicationId = nextId--;
         */
//        applicationId = nextId--;
        applicationId = nextId;
        return applicationId;
    }

    /**
     * getCreditScore() method
     * <p>
     * Fetches creditScore
     *
     * @return creditScore
     */
    public static int getCreditScore() {
        return creditScore;
    }

    /**
     * setCreditScore() method
     * <p>
     * Sets creditScore
     *
     * @param creditScore
     */
    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    /**
     * getRequestedLimit() method
     * <p>
     * Fetches how much the applicant is requesting (random int in Applicant)
     *
     * @return requestedLimit
     */
    public static int getRequestedLimit() {
        return requestedLimit;
    }

    /**
     * setRequestedLimit() method
     * <p>
     * Sets requested limit
     *
     * @param requestedLimit
     * @return
     */
    public static int setRequestedLimit(int requestedLimit) {
        return requestedLimit = requestedLimit;
    }

    /**
     * isApproved() method
     * <p>
     * Returns true if is approved and false if not
     *
     * @return approved
     */
    public static boolean isApproved() {
        return approved = true;
    }

    /**
     * setApproved() method
     * <p>
     * Can change approved status (true if is approved and false if not)
     *
     * @param approved
     */
    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    /**
     * getApprovedLimit() method
     * <p>
     * returns approvedLimit (0 if not approved) (Follows table logic if approved)
     *
     * @return approvedLimit
     */
    public int getApprovedLimit() {
        return approvedLimit;
    }

    /**
     * setApprovedLimit() method
     * <p>
     * Can set approvedLimit (used in consumer thread with conditional logic)
     *
     * @param approvedLimit
     */
    public void setApprovedLimit(int approvedLimit) {
        this.approvedLimit = approvedLimit;
    }

}
