import java.util.ArrayList;

public class Arrays {
    /**An array made with the Setups.ConnectionArray class that shows what state is connected to what state based on the index. */
    static int[][] connectionArray = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0}, //Just to align Territory.num
            {9, 10, 24, 42, 0, 0, 0, 0}, //Alabama 1
            {0, 0, 0, 0, 0, 0, 0, 0}, //Alaska 2
            {5, 6, 28, 31, 44, 0, 0, 0}, //Arizona 3
            {18, 24, 25, 36, 42, 43, 0, 0}, //Arkansas 4
            {3, 28, 37, 0, 0, 0, 0, 0}, //California 5
            {3, 16, 27, 31, 36, 44, 50, 0}, //Colorado 6
            {21, 32, 39, 0, 0, 0, 0, 0}, //Connecticut 7
            {20, 30, 38, 0, 0, 0, 0, 0}, //Delaware 8
            {1, 10, 0, 0, 0, 0, 0, 0}, //Florida 9
            {1, 9, 33, 40, 42, 0, 0, 0}, //Georgia 10
            {0, 0, 0, 0, 0, 0, 0, 0}, //Hawaii 11
            {26, 28, 37, 44, 47, 50, 0, 0}, //Idaho 12
            {14, 15, 17, 22, 25, 49, 0, 0}, //Illinois 13
            {13, 17, 22, 35, 0, 0, 0, 0}, //Indiana 14
            {13, 23, 25, 27, 41, 49, 0, 0}, //Iowa 15
            {6, 25, 27, 36, 0, 0, 0, 0}, //Kansas 16
            {13, 14, 25, 35, 42, 46, 48, 0}, //Kentucky 17
            {4, 24, 43, 0, 0, 0, 0, 0}, //Louisiana 18
            {29, 0, 0, 0, 0, 0, 0, 0}, //Maine 19
            {8, 38, 46, 48, 0, 0, 0, 0}, //Maryland 20
            {7, 29, 32, 39, 45, 0, 0, 0}, //Massachusetts 21
            {13, 14, 23, 35, 49, 0, 0, 0}, //Michigan 22
            {15, 22, 34, 41, 49, 0, 0, 0}, //Minnesota 23
            {1, 4, 18, 42, 0, 0, 0, 0}, //Mississippi 24
            {4, 13, 15, 16, 17, 27, 36, 42}, //Missouri 25
            {12, 34, 41, 50, 0, 0, 0, 0}, //Montana 26
            {6, 15, 16, 25, 41, 50, 0, 0}, //Nebraska 27
            {3, 5, 12, 37, 44, 0, 0, 0}, //Nevada 28
            {19, 21, 45, 0, 0, 0, 0, 0}, //New Hampshire 29
            {8, 32, 38, 0, 0, 0, 0, 0}, //New Jersey 30
            {3, 6, 36, 43, 44, 0, 0, 0}, //New Mexico 31
            {7, 21, 30, 38, 39, 45, 0, 0}, //New York 32
            {10, 40, 42, 46, 0, 0, 0, 0}, //North Carolina 33
            {23, 26, 41, 0, 0, 0, 0, 0}, //North Dakota 34
            {14, 17, 22, 38, 48, 0, 0, 0}, //Ohio 35
            {4, 6, 16, 25, 31, 43, 0, 0}, //Oklahoma 36
            {5, 12, 28, 47, 0, 0, 0, 0}, //Oregon 37
            {8, 20, 30, 32, 35, 48, 0, 0}, //Pennsylvania 38
            {7, 21, 32, 0, 0, 0, 0, 0}, //Rhode Island 39
            {10, 33, 0, 0, 0, 0, 0, 0}, //South Carolina 40
            {15, 23, 26, 27, 34, 50, 0, 0}, //South Dakota 41
            {1, 4, 10, 17, 24, 25, 33, 46}, //Tennessee 42
            {4, 18, 31, 36, 0, 0, 0, 0}, //Texas 43
            {3, 6, 12, 28, 31, 50, 0, 0}, //Utah 44
            {21, 29, 32, 0, 0, 0, 0, 0}, //Vermont 45
            {17, 20, 33, 42, 48, 0, 0, 0}, //Virginia 46
            {12, 37, 0, 0, 0, 0, 0, 0}, //Washington 47
            {17, 20, 35, 38, 46, 0, 0, 0}, //West Virginia 48
            {13, 15, 22, 23, 0, 0, 0, 0}, //Wisconsin 49
            {6, 12, 26, 27, 41, 44, 0, 0} //Wyoming 50

    };

    /**Array of all the states.*/
    static String[] States = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};

    /**Array of all the state initials**/
    static String[] stateInitals = {"AL","AK","AZ","AR","CA","CO","CT","DE","FL","GA","HI","ID","IL","IN","IA","KS","KY","LA","ME","MD","MA","MI","MN","MS","MO","MT","NE","NV","NH","NJ","NM","NY","NC","ND","OH","OK","OR","PA","RI","SC","SD","TN","TX","UT","VT","VA","WA","WV","WI","WY"};

    /**Number of connections for each state*/
    static int[] Score = {4,5,6,3,7,3,3,2,5,6,6,4,6,4,7,3,1,4,5,5,5,4,8,4,6,5,3,3,5,6,4,3,5,6,4,6,3,2,6,8,4,6,3,5,2,5,4,6};

    static ArrayList<Player> players = new ArrayList<>();

    static int[][] StatePos = {
        {0,0},    //Just to align Territory.num
        {900,560},
        {150,700},
        {300,450},
        {775,480},
        {100,400},
        {400,400},
        {1160,230},
        {1125,338},
        {1000,630},
        {1000,575},
        {445,750},
        {250,220},
        {800,300},
        {880,300},
        {700,300},
        {600,370},
        {900,400},
        {750,650},
        {1200,70},
        {1085,318},
        {1170,210},
        {900,200},
        {700,150},
        {800,600},
        {750,420},
        {450,100},
        {500,280},
        {200,300},
        {1180,180},
        {1130,305},
        {450,450},
        {1050,230},
        {1000,450},
        {500,100},
        {950,300},
        {600,500},
        {100,200},
        {1050,260},
        {1190,220},
        {1000,500},
        {600,200},
        {900,450},
        {600,630},
        {300,300},
        {1150,160},
        {1000,410},
        {150,50},
        {1000,350},
        {750,200},
        {400,200},
    };

    static ArrayList<Territory> toBePainted = new ArrayList<>();




}
