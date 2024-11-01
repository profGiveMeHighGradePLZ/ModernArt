import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents a player in the ModernArt game
 * 
 * You are not allowed to add any new field to this class
 * You are not allowed to add any new public method to this class
 */
public class Player {
    /**
     * The name of the player
     * 
     * The first player should have the name "Player 0"
     * The second player should have the name "Player 1"
     * The third player should have the name "Player 2"
     * ...
     */
    private final String name;
    /**
     * The money the player has
     */
    private int money;
    /**
     * The total number of players in the game
     */
    private static int totalPlayers = 0;
    /**
     * The paintings the player has in hand
     */
    private List<Painting> handPaintings = new ArrayList<>();
    /**
     * The paintings the player has bought
     */
    private List<Painting> boughtPaintings = new ArrayList<>();
    /**
     * Constructor of the Player class
     */
    public Player(int money) {
        name = Integer.toString(totalPlayers);
        this.money = money;
    }
    /**
     * To deal a painting to the player
     */
    public void dealPaintings(Painting painting) {
        boughtPaintings.add(painting);
    }
    /**
     * Get the name of the player
     */
    public String getName() {
        return name;
    }
    /**
     * To let the player to put up a painting for auction
     * After this method, the painting should be removed from handPaintings
     * 
     * Validation of user's input should be done in this method,
     * such as checking if the index is valid. If it is invalid,
     * the player will need to enter the index again.
     */
    private boolean validPaintingInput(int index) throws Exception{
        if(index < 0 || 4 < index )
            throw new Exception("Error input! No Such Painting");
        for(Painting painting:handPaintings){
            if(painting.getArtistId()==index)
                return true;
        }
        System.out.println("Error input! You don't have this painting!");
        return false;
    }
    public Painting playPainting() {
        Scanner in = new Scanner(System.in);
        int index;
        while(true) {
            System.out.print("Please put up a painting:");
            try {
                index = in.nextInt();
                if (validPaintingInput(index)) {
//                    handPaintings.remove(index);
                    break;
                }
            } catch (Exception e) {
                in.nextLine();
                System.out.println(e.getMessage());
            }
        }
        System.out.println("The player put up a painting by "+handPaintings.get(index).getArtistName());
        return handPaintings.remove(index);
    }
    /**
     * Get the money the player has
     */
    public int getMoney() {
        return money;
    }
    /**
     * To let the player to bid. 
     * 
     * In some auctions, e.g. open auction, the player knows the current bid.
     * In this case the currentBid will be passed to the method.
     * 
     * In some auctions, e.g. blind auction, the player does not know the current bid.
     * In this case, the currentBid passed to the method will be 0.
     * 
     * A human player should be asked to input the bid amount.
     * The bid amount should be less than or equal to the money the player has.
     * If the bid amount is too high, the player should be asked to input again.
     * 
     * If the bid amount is too small (less than the current bid or less than 1),
     * the bid amount will also be returned, which may means to pass the bid.
     * 
     * You should not assume there is only open auction when writing this method
     */
    public int bid(int currentBid) {
        //TODO
    }
    /**
     * To let the player to pay
     */
    public void pay(int amount) {
        money-=amount;
    }
    /**
     * To let the player to earn
     */
    public void earn(int amount) {
        money+=amount;
    }
    /**
     * toString method that you need to override
     */
    public String toString() {
        //TODO
    }
    /**
     * To finalize a bid and purchase a painting
     * 
     * This method has been finished for you
     */
    public void buyPainting(Painting Painting) {
        boughtPaintings.add(Painting);
    }
    /**
     * To sell all the paintings the player has bought to the bank 
     * after each round
     */    
    public void sellPainting(int[] scores) {
        int profit = 0;
        for(Painting p:boughtPaintings){
            profit += scores[p.getArtistId()];
        }
        money+=profit;
        boughtPaintings.clear();
    }
}
