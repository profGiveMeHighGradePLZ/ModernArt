import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
//    private final String name;
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
        this.money = money;
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

    public static void main(String[] args) {
        Player a = new Player(100);
        a.handPaintings.add(new Painting(0));
        a.handPaintings.add(new Painting(1));
        a.handPaintings.add(new Painting(2));
        Painting p = a.playPainting();
    }
    public void test(){
//        Player a = new Player(100);
//        a.handPaintings.add(new Painting(0));
//        a.handPaintings.add(new Painting(1));
//        a.handPaintings.add(new Painting(2));
//        a.playPainting();
    }
}
