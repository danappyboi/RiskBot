package Setups;

/** This class is used to create the connection arrays for each state. */
public class ConnectionArray {
    static String[] states = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
    static int stateNum = 0;

    public static void main(String[] args) {

        String[] listOfList = {"Mississippi, Tennessee, Florida, Georgia"," ","Nevada, New Mexico, Utah, California, Colorado","Oklahoma, Tennessee, Texas, Louisiana, Mississippi, Missouri","Oregon, Arizona, Nevada","New Mexico, Oklahoma, Utah, Wyoming, Arizona, Kansas, Nebraska","New York, Rhode Island, Massachusetts","New Jersey, Pennsylvania, Maryland","Georgia, Alabama","North Carolina, South Carolina, Tennessee, Alabama, Florida", "","Utah, Washington, Wyoming, Montana, Nevada, Oregon","Kentucky, Missouri, Wisconsin, Indiana, Iowa, Michigan","Michigan, Ohio, Illinois, Kentucky","Nebraska, South Dakota, Wisconsin, Illinois, Minnesota, Missouri","Nebraska, Oklahoma, Colorado, Missouri","Tennessee, Virginia, West Virginia, Illinois, Indiana, Missouri, Ohio","Texas, Arkansas, Mississippi","New Hampshire","Virginia, West Virginia, Delaware, Pennsylvania","New York, Rhode Island, Vermont, Connecticut, New Hampshire","Ohio, Illinois, Indiana, Wisconsin, Minnesota","North Dakota, South Dakota, Iowa, Wisconsin, Michigan","Louisiana, Tennessee, Alabama, Arkansas","Nebraska, Oklahoma, Tennessee, Arkansas, Illinois, Iowa, Kansas, Kentucky","South Dakota, Wyoming, Idaho, North Dakota","Missouri, South Dakota, Wyoming, Colorado, Iowa, Kansas","Idaho, Oregon, Utah, Arizona, California","Vermont, Maine, Massachusetts","Pennsylvania, Delaware, New York","Oklahoma, Texas, Utah, Arizona, Colorado","Pennsylvania, Rhode Island, Vermont, Connecticut, Massachusetts, New Jersey","Tennessee, Virginia, Georgia, South Carolina","South Dakota, Minnesota, Montana","Michigan, Pennsylvania, West Virginia, Indiana, Kentucky","Missouri, New Mexico, Texas, Arkansas, Colorado, Kansas","Nevada, Washington, California, Idaho","New York, Ohio, West Virginia, Delaware, Maryland, New Jersey","Massachusetts, New York, Connecticut","North Carolina, Georgia","Nebraska, North Dakota, Wyoming, Iowa, Minnesota, Montana","Mississippi, Missouri, North Carolina, Virginia, Alabama, Arkansas, Georgia, Kentucky","New Mexico, Oklahoma, Arkansas, Louisiana","Nevada, New Mexico, Wyoming, Arizona, Colorado, Idaho","New Hampshire, New York, Massachusetts","North Carolina, Tennessee, West Virginia, Kentucky, Maryland","Oregon, Idaho","Pennsylvania, Virginia, Kentucky, Maryland, Ohio","Michigan, Minnesota, Illinois, Iowa","Nebraska, South Dakota, Utah, Colorado, Idaho, Montana"};

        for (String connectedStates : listOfList) {
            String[] arrOfList = connectedStates.split(", ", 8);
            printer(arrOfList);
            stateNum++;
        }
    }

    /** Prints out all the connections in the form of an array. It also adds a comment at the end to label the State the array is for using stateNum.*/
    static void printer(String[] arrOfList) {
        int[] newList = new int[8];
        int num = 0;
        for (int i = 0; i < states.length; i++) {
            for (int j = 0; j < arrOfList.length; j++) {
                if (arrOfList[j].equals(states[i])) {
                    newList[num] = i + 1;
                    num++;
                }
            }
        }

        System.out.println();
        System.out.print("{");
        for (int k = 0; k < newList.length; k++) {
            System.out.print((newList[k]));
            if (k < 7) {
                System.out.print(", ");
            }
        }
        System.out.print("}," + " //" + states[stateNum] + " " + (stateNum + 1));
    }
}
