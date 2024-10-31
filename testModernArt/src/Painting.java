public class Painting {
    private final int artist_id;
    /**
     * The type of auction of the painting
     */
    private final String TYPE = "Open Auction";
    /**
     * The owner of the painting.
     *
     * When the painting is dealt to a player, the owner is set to that player.
     * When the painting is sold in the auction, the owner is set to the player
     * that won the auction.
     * After the painting is sold to the bank after each round, the owner
     * information is irrelevant and can be set as any value.
     *
     */
    private Player owner;
    /**
     * The current bidder of the painting.
     */
    private Player currentBidder;
    /**
     * The current bid of the painting.
     */
    private int currentBid;
    /**
     * The names of the artists
     */
    public static final String[] ARTIST_NAMES = {"0. Manuel Carvalho", "1. Sigrid Thaler", "2. Daniel Melim", "3. Ramon Martins", "4. Rafael Silveira"};

    /**
     * Constructor of the Painting class
     */
    public Painting(int artist_id) {
        this.artist_id = artist_id;
    }
    /**
     * Get the artist ID of the painting
     */
    public int getArtistId() {
        return artist_id;
    }
    /**
     * Setter of owner
     */
    public void setOwner(Player p) {
        owner = p;
    }
    /**
     * Getter of owner
     */
    public Player getOwner() {
        return owner;
    }
    /**
     * Get the name of the artist
     */
    public String getArtistName() {
        return ARTIST_NAMES[artist_id];
    }
    /**
     * Sold the painting to the current bidder
     * This method has been completed for you.
     * You should not modify this method.
     */
//    public void sold() {
//        System.out.println(this.toString() + " is sold to " + currentBidder + " for " + currentBid);
//        if (currentBidder == null || owner == currentBidder) {
//            //owner get the painting automatically
//            owner.buyPainting(this);
//            owner.pay(currentBid); //owner pay to the bank
//        } else {
//            //currentBidder get the painting
//            currentBidder.buyPainting(this);
//            currentBidder.pay(currentBid);
//            //owner get the money
//            owner.earn(currentBid);
//            owner = currentBidder;
//        }
//
//    }
}
