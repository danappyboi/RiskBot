import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;

class Game {

    static boolean starting = false;
    static boolean pickingColors = true;

    static Territory Alabama = new Territory("Alabama","AL", 1);
    static Territory Alaska = new Territory("Alaska","AK", 2);
    static Territory Arizona = new Territory("Arizona","AZ", 3);
    static Territory Arkansas = new Territory("Arkansas","AR", 4);
    static Territory California = new Territory("California","CA", 5);
    static Territory Colorado = new Territory("Colorado","CO", 6);
    static Territory Connecticut = new Territory("Connecticut","CT", 7);
    static Territory Delaware = new Territory("Delaware","DE", 8);
    static Territory Florida = new Territory("Florida","FL", 9);
    static Territory Georgia = new Territory("Georgia","GA", 10);
    static Territory Hawaii = new Territory("Hawaii","HI", 11);
    static Territory Idaho = new Territory("Idaho","ID", 12);
    static Territory Illinois = new Territory("Illinois","IL", 13);
    static Territory Indiana = new Territory("Indiana","IN", 14);
    static Territory Iowa = new Territory("Iowa","IA", 15);
    static Territory Kansas = new Territory("Kansas","KS", 16);
    static Territory Kentucky = new Territory("Kentucky","KY", 17);
    static Territory Louisiana = new Territory("Louisiana","LA", 18);
    static Territory Maine = new Territory("Maine","ME", 19);
    static Territory Maryland = new Territory("Maryland","MD", 20);
    static Territory Massachusetts = new Territory("Massachusetts","MA", 21);
    static Territory Michigan = new Territory("Michigan","MI", 22);
    static Territory Minnesota = new Territory("Minnesota","MN", 23);
    static Territory Mississippi = new Territory("Mississippi","MS", 24);
    static Territory Missouri = new Territory("Missouri","MO", 25);
    static Territory Montana = new Territory("Montana","MT", 26);
    static Territory Nebraska = new Territory("Nebraska","NE", 27);
    static Territory Nevada = new Territory("Nevada","NV", 28);
    static Territory NewHampshire = new Territory("New Hampshire","NH", 29);
    static Territory NewJersey = new Territory("New Jersey","NJ", 30);
    static Territory NewMexico = new Territory("New Mexico","NM", 31);
    static Territory NewYork = new Territory("New York","NY", 32);
    static Territory NorthCarolina = new Territory("North Carolina","NC", 33);
    static Territory NorthDakota = new Territory("North Dakota","ND", 34);
    static Territory Ohio = new Territory("Ohio","OH", 35);
    static Territory Oklahoma = new Territory("Oklahoma","OK", 36);
    static Territory Oregon = new Territory("Oregon","OR", 37);
    static Territory Pennsylvania = new Territory("Pennsylvania","PA", 38);
    static Territory RhodeIsland = new Territory("Rhode Island","RI", 39);
    static Territory SouthCarolina = new Territory("South Carolina","SC", 40);
    static Territory SouthDakota = new Territory("South Dakota","SD", 41);
    static Territory Tennessee = new Territory("Tennessee","TN", 42);
    static Territory Texas = new Territory("Texas","TX", 43);
    static Territory Utah = new Territory("Utah","UT", 44);
    static Territory Vermont = new Territory("Vermont","VT", 45);
    static Territory Virginia = new Territory("Virginia","VA", 46);
    static Territory Washington = new Territory("Washington","WA", 47);
    static Territory WestVirginia = new Territory("West Virginia","WV", 48);
    static Territory Wisconsin = new Territory("Wisconsin","WI", 49);
    static Territory Wyoming = new Territory("Wyoming","WY", 50);

    //TODO: You should be able to pick more than one
    /**Used to give a territory to a player. If a territory is already owned by another player, it will start Game.attack**/
    static void territory(Player player, Territory territory) throws IOException {
        if (!player.touches().contains(territory.num)) {
            Messages.printMessage("You can't pick that territory.", "You don't have any territory that touches it. Try another spot.", Imaging.defaultColor);
            //territory(player, territory);
        } else if (territory.owned) {
          attack(player, territory.owner, territory);
        } else {

            territory.newOwner(player);
        }
    }

    /**Used for the first territory pick sequence**/
    static void firstPick(Player player, Territory territory) throws IOException {
        territory.newOwner(player);
    }

    /**Used when two players are battling over territory**/
    static void attack(Player offense, Player defense, Territory territory) throws IOException {
        Messages.printMessage("Battle!", offense.name + " is fighting " + defense.name + " over " + territory.name + "!", Imaging.defaultColor);
        ArrayList<Integer> offenseConnections = new ArrayList<>();
        ArrayList<Integer> defenseConnections = new ArrayList<>();

        int offenseNum = 0;
        int defenseNum = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                //TODO: i doubt that territory num works. maybe no -1
                if (Arrays.connectionArray[territory.num - 1][i] == offense.owns.get(j)) {
                    offenseConnections.add(Arrays.connectionArray[territory.num - 1][i]);
                }
                if (Arrays.connectionArray[territory.num - 1][i] == defense.owns.get(j)) {
                    defenseConnections.add(Arrays.connectionArray[territory.num - 1][i]);
                }
            }
        }

        for(int k: offenseConnections) {
            offenseNum += Arrays.Score[k - 1];
        }

        for(int k: defenseConnections) {
            defenseNum += Arrays.Score[k - 1];
        }

        double ran = Math.floor(Math.random() * 6) + 1;
        double ran2 = Math.floor(Math.random() * 6) + 1;
        //TODO: message about dice roll
        //TODO: message about scores

        //This gives a buff to defense and also means defense wins ties
        if (ran + offenseNum/20 < ran2 + defenseNum/18) {
            //TODO: message about defense winning
        } else {
            //TODO: message about offense winning
            territory.newOwner(offense);
        }

    }

    /**The color picker. Includes names and colors available for players to choose from.**/
    static Color pickColor(String pickedColor) {
        pickedColor = pickedColor.toLowerCase();
        switch(pickedColor) {
            case "gamer red":
                return new Color(150,0,0);
            case "imposter red":
                return new Color(242, 30,30);
            case "luigi":
                return new Color(76, 187, 23);
            case "awesome orange":
                return new Color(255, 163, 26);
            case "color blind blue":
                return new Color(66,50,191);
            case "orange":
                return new Color(153, 51,255);
            case "roe v wade":
                return new Color(255, 102, 204);
            case "baby poop":
                return new Color(138, 155, 0);
            case "wii sports":
                return new Color(0, 200,200);
            case "nice gray":
                return new Color(69,69,69);
            case "eric pale":
                return new Color(198,179,152);
            case "police blue-tality":
                return new Color(19,93,216);
            case "pee yellow":
                return new Color(220, 230, 34);
            case "shishir brown":
                return new Color(192,138,92);
            case "blm black":
                return new Color(255,255,255);
            case "all lives matter":
                return new Color(0,0,0);
            default:
                return Color.white;
        }
    }

    /**Returns a player based on their position in the array.**/
    static Player player(int playerNum) {
        return Arrays.players.get(playerNum);
    }

    /**Returns a player based on their Discord ID**/
    static Player player(long playerID) {
        for (int i = 0; i < Arrays.players.size(); i++) {
            if (playerID == Arrays.players.get(i).ID) {
                return Arrays.players.get(i);
            }
        }
        return null;
    }

    /**Converts State abbreviations into actual territories**/
    static Territory convertor(String pick) {
        switch (pick.toUpperCase()) {
            case "AL":
                return Alabama;
            case "AK":
                return Alaska;
            case "AZ":
                return Arizona;
            case "AR":
                return Arkansas;
            case "CA":
                return California;
            case "CO":
                return Colorado;
            case "CT":
                return Connecticut;
            case "DE":
                return Delaware;
            case "FL":
                return Florida;
            case "GA":
                return Georgia;
            case "HI":
                return Hawaii;
            case "ID":
                return Idaho;
            case "IL":
                return Illinois;
            case "IN":
                return Indiana;
            case "IA":
                return Iowa;
            case "KS":
                return Kansas;
            case "KY":
                return Kentucky;
            case "LA":
                return Louisiana;
            case "ME":
                return Maine;
            case "MD":
                return Maryland;
            case "MA":
                return Massachusetts;
            case "MI":
                return Michigan;
            case "MN":
                return Minnesota;
            case "MS":
                return Mississippi;
            case "MO":
                return Missouri;
            case "MT":
                return Montana;
            case "NE":
                return Nebraska;
            case "NV":
                return Nevada;
            case "NH":
                return NewHampshire;
            case "NJ":
                return NewJersey;
            case "NM":
                return NewMexico;
            case "NY":
                return NewYork;
            case "NC":
                return NorthCarolina;
            case "ND":
                return NorthDakota;
            case "OH":
                return Ohio;
            case "OK":
                return Oklahoma;
            case "OR":
                return Oregon;
            case "PA":
                return Pennsylvania;
            case "RI":
                return RhodeIsland;
            case "SC":
                return SouthCarolina;
            case "SD":
                return SouthDakota;
            case "TN":
                return Tennessee;
            case "TX":
                return Texas;
            case "UT":
                return Utah;
            case "VT":
                return Vermont;
            case "VA":
                return Virginia;
            case "WA":
                return Washington;
            case "WV":
                return WestVirginia;
            case "WI":
                return Wisconsin;
            case "WY":
                return Wyoming;
            default:
                return new Territory("something broke", "wtf", 69);
        }
    }


}
