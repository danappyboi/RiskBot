import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.message.MessageBuilder;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.Math;
import java.lang.reflect.Array;

public class Messages implements MessageCreateListener {

    /**Used to find position of player in the Player Array**/
    int num = 0;

    static boolean firstImage = true;

    /**Used to print embed messages to Discord**/
    static void printMessage(String title, String message, Color color) {
        TextChannel channel = Main.api.getTextChannelById(940099280067231757L).get();
        new MessageBuilder()
                .setEmbed(new EmbedBuilder()
                        .setTitle(title)
                        .setDescription(message)
                        .setColor(color))
                .send(channel);
    }

    /**Used to print embed messages to Discord**/
    static void printMessage(String message, Color color) {
        TextChannel channel = Main.api.getTextChannelById(940099280067231757L).get();
        new MessageBuilder()
                .setEmbed(new EmbedBuilder()
                        .setDescription(message)
                        .setColor(color))
                .send(channel);
    }

    static void imgMessage() throws IOException {
        BufferedImage img = ImageIO.read(new File("C:/Users/helio/Desktop/RiskImages/CleanUSMap.jpg"));
//        if (firstImage) {
//            BufferedImage image = ImageIO.read(new File("C:/Users/helio/Desktop/RiskImages/CleanUSMap.jpg"));
//            Imaging.floodFill(image, x, y, color);
//            Imaging.writeImage(image);
//            firstImage = false;
//        } else {
//            BufferedImage img = ImageIO.read(new File("C:/Users/helio/Desktop/RiskImages/coloredUSMap" + (Imaging.i - 1) + ".jpg"));
//            Imaging.floodFill(img, x, y, color);
//            Imaging.writeImage(img);
//        }
        for (Territory terr: Arrays.toBePainted) {
            Imaging.floodFill(img, Arrays.StatePos[terr.num][0], Arrays.StatePos[terr.num][1], terr.owner.color);
            System.out.println("daddy");
        }
        Imaging.writeImage(img);


        TextChannel channel = Main.api.getTextChannelById(940099280067231757L).get();
        new MessageBuilder()
/*                .setEmbed(new EmbedBuilder()
                        .setTitle("Map")
                        .setDescription(message)
                        .setColor(Imaging.defaultColor))*/
                .addAttachment(new File("C:/Users/helio/Desktop/RiskImages/coloredUSMap.jpg"))
                .send(channel);
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        //The first five letters of any given message. Usually used by exclamation points and 4 letter commands. ex. !play !pick
        String command = event.getMessageContent().substring(0, 5); //TODO: This stupid ass error
//        String text = event.getMessageContent();
//        String[] arr = text.split(" ", 3);
//        String command = arr[0];
//        String commandRequest = arr[1];
//        System.out.println(arr.length);

        //Usually comes after command. It's basically the information following the command
        String commandRequest = event.getMessageContent().substring(6);
        //Gives the person who wrote the message
        MessageAuthor playerID = event.getMessageAuthor();
        if (Game.pickingColors) {
            if (command.equalsIgnoreCase("!play")) {
                //Checking if player is already in player list
                boolean flag = false;
                    for (Player players : Arrays.players) {
                        if (players.ID == playerID.getId()) {
                            printMessage("You have already chosen a color.", Imaging.defaultColor);
                            flag = true;
                        }
                    }
                    if (!flag) {
                        Arrays.players.add(new Player(playerID.getDisplayName(), playerID.getId(), Game.pickColor(commandRequest), num));
                        printMessage("Color Picked", Game.player(num).name + " has chosen " + commandRequest + "!", Game.player(num).color);
                        num++;
                    }


            } else if (command.equalsIgnoreCase("!pick")) {
                try {
                    if (Game.player(playerID.getId()).owns.isEmpty()) {
                        Game.firstPick(Game.player(playerID.getId()), Game.convertor(commandRequest));
                        printMessage("First Territory!", Game.player(playerID.getId()).name + " has picked " + Game.convertor(commandRequest).name + " as their first territory!", Game.player(playerID.getId()).color);
                    } else {

                        printMessage("You have already chosen a territory.\n" + Game.player(playerID.getId()).owns, Imaging.defaultColor);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (event.getMessageContent().equalsIgnoreCase("!start")) {
                Game.pickingColors = false;
                Game.starting = true;
            }

        }


        if (Game.starting) {

            //printMessage("It's " + Game.player(0).name + "'s turn.", "Choose a territory.", Imaging.defaultColor);

            for (int turn = 0; turn < Arrays.players.size(); turn++) {

                printMessage("It's " + Game.player(turn).name + "'s turn.", "Choose a territory.", Imaging.defaultColor);

                boolean test = true;
                while (test) {
                    if (command.equalsIgnoreCase("!pick")) {
                        if(playerID.getId() == Game.player(turn).ID) {
                            test = false;
                            try {
                                Game.territory(Game.player(turn), Game.convertor(commandRequest));

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            //printMessage("It's " + Game.player(turn).name + "'s turn.", "Choose a territory.", Imaging.defaultColor);

                        }

                    }
                }



//
//                    if (command.equalsIgnoreCase("!pick")) {
//                        if(playerID.getId() == Game.player(turn).ID) {
//                            try {
//                                Game.territory(Game.player(turn), Game.convertor(commandRequest));
//
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//                            //printMessage("It's " + Game.player(turn).name + "'s turn.", "Choose a territory.", Imaging.defaultColor);
//
//                        }
//
//                    }


                //printMessage("It's " + Game.player(turn).name + "'s turn.", "Choose a territory.", Imaging.defaultColor);

            }
        }
    }
}
