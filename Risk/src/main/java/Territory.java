import java.awt.*;
import java.io.IOException;

public class Territory {
    String name;
    String initials;
    int num;
    boolean owned;
    Player owner;

    public Territory(String name, String initials, int num) {
        this.name = name;
        this.initials = initials;
        this.num = num;
    }

    /**Used to switch owners**/
    void newOwner(Player newOwner) throws IOException {
        if(owner != null) {
            int pos = owner.owns.indexOf((num));
            owner.owns.remove(pos);
        }
        owned = true;
        owner = newOwner;
        owner.owns.add(num);

        if (!Arrays.toBePainted.contains(this)) {
            Arrays.toBePainted.add(this);
        }

        Messages.imgMessage(); //Arrays.StatePos[num][0], Arrays.StatePos[num][1]


    }
}
