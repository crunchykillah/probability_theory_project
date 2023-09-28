import lombok.NoArgsConstructor;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static service.TextResources.*;

@NoArgsConstructor
public class CombinatoricsBot extends TelegramLongPollingBot{
    private Message message;
    private CallbackQuery callback;
    @Override
    public void onUpdateReceived(Update update) {
        message = update.getMessage();
        if (update.hasMessage() && update.getMessage().hasText() && callback == null) {
            handleMessage(update);
        } else if (update.hasCallbackQuery()) {
            callback = update.getCallbackQuery();
            CallbackQueryListener.onCallbackQuery(callback,this);
        } else if (update.hasMessage() && update.getMessage().hasText() && !(callback == null)) {
            handleMessageWithCallback(callback, update);
            callback = null;
        }
    }
    private void handleMessage(Update update) {
        MessageSender messageSender;
        messageSender = new MessageSender(message, this, update);
        new Thread(messageSender).start();
    }
    private void handleMessageWithCallback(CallbackQuery callbackQuery, Update update) {
        MessageSender messageSender;
        messageSender = new MessageSender(message, this, update, callbackQuery);
        new Thread(messageSender).start();
    }
    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }
    @Override
    public String getBotToken() {
        return System.getenv("TELEGRAM_BOT_TOKEN");
    }
}
