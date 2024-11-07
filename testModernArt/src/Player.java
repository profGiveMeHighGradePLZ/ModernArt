import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Player {
//    private final String name;
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

    public Player(int money) {
        name = "Player "+Integer.toString(totalPlayers);
        this.money = money;
    }
    public void dealPaintings(Painting painting) {
        handPaintings.add(painting);
    }
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

    public void sellPainting(int[] scores) {
        int profit = 0;
        for(Painting p:boughtPaintings){
            profit += scores[p.getArtistId()];
        }
        money+=profit;
        boughtPaintings.clear();
    }

    public int getMoney() {
        return money;
    }

    private boolean validBid(int bid) throws Exception{
        if(bid>=0 && bid <= getMoney())
            return true;
        else if(bid < 0)
            throw new Exception("Error, You cannot bid a negative price!");
        else
            throw new Exception("Error, You don't have so much money!");
    }


    public int bid(int currentBid) {
        Scanner in = new Scanner(System.in);
        while(true){
            try {
                System.out.printf("Current bid is %d. You have $%d. Please input your bid: ",currentBid,getMoney());
                int bid = in.nextInt();
                if (validBid(bid)){
                    return bid;
                }
            }catch (InputMismatchException e){
                System.out.println("Error. Please input a number!");
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    public void pay(int amount) {
        money-=amount;
    }
    /**
     * To let the player to earn
     */
    public void earn(int amount) {
        money+=amount;
    }
    public void buyPainting(Painting Painting) {
        boughtPaintings.add(Painting);
    }
    /**
     * To sell all the paintings the player has bought to the bank
     * after each round
     */
//    public void sellPainting(int[] scores) {
//        for(Painting p:boughtPaintings){
//            earn(scores[p.getArtistId()]);
//        }
//        boughtPaintings.clear();
//    }

    public String getName() {
        return name;
    }
    public String toString() {
        return getName();
    }

    public static void main(String[] args) {
        Player a = new Player(100);
        Player b = new Player(100);
        Player c = new Player(100);
        Player d = new Player(100);
        Player[] players = {a,b,c,d};
//        int[] score = {20,0,0,20,0};
//        a.boughtPaintings.add(new Painting(0));
//        a.boughtPaintings.add(new Painting(1));
//        a.boughtPaintings.add(new Painting(2));
//        a.boughtPaintings.add(new Painting(3));
//        a.boughtPaintings.add(new Painting(3));
//        a.boughtPaintings.add(new Painting(4));
//        a.boughtPaintings.add(new Painting(0));
//        a.sellPainting(score);
        Painting p = new Painting(0);
        p.setOwner(a);
        p.auction(players);

    }

}
