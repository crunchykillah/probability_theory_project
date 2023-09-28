import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;

import static service.TextResources.*;

public class CallbackQueryListener {
    public static Map<String, String> callbackMapCreator() {
        Map<String, String> buttonMessages = new HashMap<>();
        buttonMessages.put(callbackText(1), COMBINATIONS_WITHOUT_REP);
        buttonMessages.put(callbackText(2), COMBINATIONS_WITH_REP);
        buttonMessages.put(callbackText(3), PERMUTATIONS_WITHOUT_REP);
        buttonMessages.put(callbackText(4), PERMUTATIONS_WITH_REP);
        buttonMessages.put(callbackText(5), PLACEMENTS_WITHOUT_REP);
        buttonMessages.put(callbackText(6), PLACEMENTS_WITH_REP);
        buttonMessages.put(callbackText(7), URN_MODEL_FIRST);
        buttonMessages.put(callbackText(8), URN_MODEL_SECOND);
        return buttonMessages;
    }
    public static void onCallbackQuery(CallbackQuery callbackQuery, TelegramLongPollingBot bot) {
        String data = callbackQuery.getData();
        Long chatId = callbackQuery.getMessage().getChatId();
        Map<String, String> buttonMessages = callbackMapCreator();
        if (buttonMessages.containsKey(data)) {
            String messageText = buttonMessages.get(data);
            SendMessage message = SendMessage.builder()
                    .chatId(chatId)
                    .text("Вы нажали на кнопку " + messageText)
                    .build();
            try {
                bot.execute(message);
            } catch (TelegramApiException e) {
                // Обработка исключений
            }
        }
    }
}
