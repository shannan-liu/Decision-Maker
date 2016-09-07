/**
 * Class that generates a random yes/no response to a user's question.
 *   @author Dave Reed
 *   @version 1/20/13
 */
public class DecisionMaker 
{
    private int expectedYesPercentage;
    private double numY;  
    private double numN;
    private double percentY;
    private double percentN;
    
    /** 
     * Constructs an object that chooses between "YES" and "NO" (with equal probability).
     */
    public DecisionMaker() 
    {
        this(50);    // calls the existing constructor with 50 as parameter
    }
    
    /** 
     * Constructs an object that chooses between "YES" and "NO" (with specified probabilities).
     *   @param yesP the expected probability that the answer is "YES"
     */
    public DecisionMaker(int yesP) 
    {
        this.expectedYesPercentage = yesP;
    }
        
    /**
     * Returns a randomly selected answer.
     *   @param question the user's question (which is actually ignored)
     *   @return the response to that question ("YES" or "NO")
     */
    public String getAnswer(String question) 
    {
        if (Math.random()*100 < this.expectedYesPercentage) 
        {
            numY = numY + 1;
            return "YES";
        }
        else 
        {
            numN = numN + 1;
            return "NO";
        }
    }
    
    public double getYPercent(){
        percentY = (numY/(numY+numN))*100;
        return percentY;
    }
    
    public double getNPercent(){
        percentN = (numN/(numY+numN))*100;
        return percentN;
    }
    
    /**
     * Checks whether the object is within 10% of the expected yes percentage. 
     *   @return a String specifying whether the percentage of yesses reported so far
     *           is within 10% of the expected percentage
     */
    public String checkStats() {
        double yesP = this.getYPercent();
        if (Math.abs(yesP - this.percentY) <= 10) {
            return "Everything appears to be working as expected.";
        }
        else {
            return "Anomalous results - may warrant further checking.";
        }
    }
 }