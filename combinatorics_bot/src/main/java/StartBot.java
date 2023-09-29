/** made by CRUNCHYKILLAH specifically for the subject Theory of Probability**/

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class StartBot {
    public static void main(String[] args) {
        CombinatoricsBot bot = new CombinatoricsBot();
        System.out.println("bot started");
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(bot);
            System.out.println("bot registered");
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
