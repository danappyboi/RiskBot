import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.awt.*;
import java.io.IOException;


public class Main {

    private static String token = "OTcyNzA0MjA0MTAxNjc3MDU2.GEsyNf.x90sRU6fndS4KoGPmeJ7RMEHmKL41I8brS2qK8";
    static DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();

    public static void main(String[] args) throws IOException {

        //Messages.imgMessage("did it work", 900,560, Color.red);
        api.addMessageCreateListener(new Messages());


        // Print the invite url of your bot
        //System.out.println("You can invite the bot by using the following url: " + api.createBotInvite());
    }



}