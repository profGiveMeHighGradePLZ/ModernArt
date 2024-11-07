import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ModernArt {

    /**
     * PRE_DEAL contains the number of paintings that should be dealt to each player before each round
     *
     * So for example, PRE_DEAL[3] means for 3 players, the number of painting to be dealt to each player
     * before round 1 is 10, round 2 is 6, and round 3 is 6, and round 4 is 0
     */
    public static final int[][] PRE_DEAL = {null, null, null,  //game can't be played for 0, 1, 2 players
            {10,6,6,0}, {9,4,4,0}, {8,3,3,0}};
    /**
     * The game has 4 rounds in total, they are
     *
     * Round 0, Round 1, Round 2, Round 3
     */
    public static final int ROUND = 4;
    /**
     * The initial money each player has is 100
     */
    public static final int INITIAL_MONEY = 100;
    /**
     * The number of paintings for each artist is fixed
     * "0. Manuel Carvalho" = 12 ,
     * "1. Sigrid Thaler" = 15,
     * "2. Daniel Melim" = 15,
     * "3. Ramon Martins" = 15,
     * "4. Rafael Silveira" = 20
     */
    public static final int[] INITIAL_COUNT = {12,15,15,15,20};
    /**
     * The price of the most sold paintings is 30,
     * the second most sold is 20,
     * and the third most sold is 10
     *
     * Tie-breaker: if two artists have the same number of painting sold
     * the one with the lower id will be the winner, i.e.,
     *
     * If 0. Manuel Carvalho and 1. Sigrid Thaler have the same number of paintings sold
     * then 0. Manuel Carvalho will be considered have more paintings sold than 1. Sigrid Thaler
     *
     */
    private static final int SCORES[] = {30, 20, 10};
    /**
     * Each round a painting can only be played for 5 times.
     * The 5th time the painting is played, it will not be placed in auction
     * and that round ends immediately
     */
    private static final int MAX_PAINTINGS = 5;
    /**
     * The number of players in the game, it should be between 3-5
     */
    private int noOfPlayers;
    /**
     * The array of players in the game
     */
    private Player[] players;
    /**
     * The deck of paintings
     */
    private List<Painting> deck = new ArrayList<>();
    /**
     * The score board of the game
     */
    private int[][] scoreboard = new int[ROUND][Painting.ARTIST_NAMES.length];

    public ModernArt(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
        this.players = new Player[noOfPlayers];
        for (int i = 0; i < noOfPlayers; i++) {
            players[i] = new Player(INITIAL_MONEY);
        }
        prepareDeck();
        dealPainting(1);
    }
    public void prepareDeck() {
        for(int i = 0;i<INITIAL_COUNT.length;i++){
            for(int j = 0;j<INITIAL_COUNT[i];j++){
                deck.add(new Painting(i));
            }
        }
        shuffle(deck);
    }
    public void shuffle(List<Painting> deck) {
        for (int i = 0; i < deck.size(); i++) {
            int index = ThreadLocalRandom.current().nextInt(deck.size());
            Painting temp = deck.get(i);
            deck.set(i, deck.get(index));
            deck.set(index, temp);
        }
    }
    public void dealPainting(int round) {
        for(int i = 0;i<PRE_DEAL[noOfPlayers][round];i++){
            for(int j = 0;j<noOfPlayers;j++){
                players[j].dealPaintings(deck.remove(deck.size()-1));
            }
        }
        deck.clear();
    }
    public static void main(String[] args) {
        ModernArt a = new ModernArt(3);
    }
}
