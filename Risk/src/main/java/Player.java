import java.awt.*;
import java.util.ArrayList;

public class Player {
    String name;
    Color color;
    long ID;
    int num;
    ArrayList<Integer> owns = new ArrayList<>();

    public Player(String name, long ID, Color color, int num) {
        this.name = name;
        this.color = color;
        this.ID = ID;
        this.num = num;
        touches();
    }

    /**Arraylist of all the territories the Player owns**/
    ArrayList<Integer> touches() {
        ArrayList<Integer> list = new ArrayList<>(owns);
        int size = list.size();

        for (int j = 0; j < size; j++) {
            for (int index = 0; index < 8; index++) {
                list.add(Arrays.connectionArray[list.get(j)][index]);
            }
        }
        list.removeIf(n -> (n == 0));

        ArrayList<Integer> newList = new ArrayList<>();
        for (int i : list) {
            if (!newList.contains(i)) {
                newList.add(i);
            }
        }

        return newList;
    }

}
