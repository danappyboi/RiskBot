package Setups;

public class StateSwitchCase {
    static String[] States = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
    static String[] stateInitals = {"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};

    public static void main(String[] args) {
        territoryInitalizer();

    }

    static void switchCase() {
        for (int i = 0; i < stateInitals.length; i++) {
            System.out.println("case " + '"' + stateInitals[i] + '"' + ":");
            //System.out.println("    Territory " + States[i] + " = new Territory(Arrays.States[" + i + "], " + '"' + stateInitals[i] + '"' + ", " + i + ");");
            System.out.println("    return " + States[i] + ";");
        }
    }

    static void territoryInitalizer() {
        for (int i = 0; i < States.length; i++) {
            System.out.println("    static Territory " + States[i] + " = new Territory(" + '"' + States[i] + '"' + ","  + '"' + stateInitals[i] + '"' + ", " + (i + 1) + ");");
        }

    }
}
