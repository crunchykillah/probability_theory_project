import lombok.SneakyThrows;
import math.Combinations;
import math.Permutations;
import math.Placements;
import math.UrnModel;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import service.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;
import java.util.Arrays;

import static service.InlineKeyboardServices.setKeyboardMarkupForReply;
import static service.InlineKeyboardServices.setKeyboardMarkupForStart;
import static service.TextResources.*;
public class MessageSender implements Runnable {
    private Message message;
    private Long who;
    private Update update;
    private CallbackQuery callbackQuery;

    private TelegramLongPollingBot bot;

    public MessageSender(Message message, TelegramLongPollingBot bot, Update update) {
        this.who = message.getChatId();
        this.bot = bot;
        this.message = message;
        this.update = update;
    }
    public MessageSender(Message message, TelegramLongPollingBot bot, Update update,CallbackQuery callbackQuery) {
        this.who = message.getChatId();
        this.bot = bot;
        this.message = message;
        this.update = update;
        this.callbackQuery = callbackQuery;
    }

    @SneakyThrows
    @Override
    public void run() {
        if (message.isCommand()) {
            handleCommandToSend(update);
        } else if ((message.getText().matches(REGEX_FOR_ONE_NUM) || message.getText().matches(REGEX_FOR_TWO_NUM) || message.getText().matches(REGEX_FOR_THREE_NUM) || message.getText().matches(REGEX_FOR_FOUR_NUM)) && !(callbackQuery == null)) {
            handleMessageToSend();
        } else if (!(callbackQuery == null)) {
            sendTextWithButton(who, ERROR_MESSAGE, bot,"reply");
        } else {
            sendText(who, ERROR_MESSAGE, bot);
        }
        System.out.println(Thread.currentThread().getId() + "," +
                message.getText() + ", " +
                message.getFrom().getUserName() + ", " + LocalTime.now());
    }
    private void handleCommandToSend(Update update) throws MalformedURLException {
        switch (message.getText()) {
            case "/start":
                sendTextWithButton(who, START_MESSAGE, bot,"start");
                break;
            case "/formula":
                sendPhotoToUser(update);
                break;
            case "/def":
                sendText(who, DEFINITIONS, bot);
                break;
            default:
                sendText(who, ERROR_COMMAND, bot);
                break;
        }
    }
    public void sendTextWithButton(Long who, String what, TelegramLongPollingBot bot,String type) {
        SendMessage response = new SendMessage().builder()
                .chatId(who.toString())
                .text(what).build();
        switch (type) {
            case "start":
                response.setReplyMarkup(setKeyboardMarkupForStart());
                break;
            case "reply":
                response.setReplyMarkup(setKeyboardMarkupForReply(callbackQuery));
                break;
        }
        try {
            bot.execute(response);
        } catch (TelegramApiException e) {
        }
    }
    private void sendPhotoToUser(Update update) throws MalformedURLException {
        URL resourceUrl = new URL(PHOTO_URL);
        InputFile inputFile = new InputFile(String.valueOf(resourceUrl));
        String chatId = String.valueOf(update.getMessage().getChatId());
        SendPhoto sendPhoto = new SendPhoto(chatId, inputFile);
        sendPhoto.setCaption("Формулы: ");
        try {
            bot.execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    private void handleMessageToSend() {
        String[] numbers = message.getText().split(" ");
        int length = numbers.length;
        if (length == 0) {
            return;
        }
        int[] intNumbers = Service.stringArrayToIntArray(numbers);
        switch (length) {
            case 1:
                handleSingleNumber(intNumbers[0]);
                break;
            case 2:
                handleTwoNumbers(intNumbers[0], intNumbers[1]);
                break;
            case 3:
                handleThreeNumbers(intNumbers[0], intNumbers[1], intNumbers[2]);
                break;
            case 4:
                handleFourNumbers(intNumbers[0], intNumbers[1], intNumbers[2], intNumbers[3]);
                break;
            default:
                int n = intNumbers[0];
                int[] otherNumbers = Arrays.copyOfRange(intNumbers, 1, intNumbers.length);
                handleMoreNumbers(n, otherNumbers);
                break;
        }
    }
    private void handleSingleNumber(int n) {
        if (callbackQuery.getData().equals(callbackText(3))) {
            sendTextWithButton(who, "Полученный ответ: " + Long.toString(Permutations.permutationsWithoutRepetition(n)), bot,"reply");
        } else {
            sendTextWithButton(who, ERROR_MESSAGE, bot, "reply");
        }
    }

    private void handleTwoNumbers(int n, int k) {
        if (callbackQuery.getData().equals(callbackText(1))) {
            sendTextWithButton(who, "Полученный ответ: " + Long.toString(Combinations.combinations(n, k)), bot,"reply");
        } else if (callbackQuery.getData().equals(callbackText(2))) {
            sendTextWithButton(who, "Полученный ответ: " + Long.toString(Combinations.combinationsWithRepetition(n, k)), bot,"reply");
        } else if (callbackQuery.getData().equals(callbackText(5))) {
            sendTextWithButton(who, "Полученный ответ: " + Long.toString(Placements.placementsWithoutRepetition(n, k)), bot,"reply");
        } else if (callbackQuery.getData().equals(callbackText(6))) {
            sendTextWithButton(who, "Полученный ответ: " + Long.toString(Placements.placementsWithRepetition(n, k)), bot,"reply");
        } else {
            sendTextWithButton(who, ERROR_MESSAGE, bot, "reply");
        }
    }

    private void handleThreeNumbers(int n, int m, int k) {
        if (callbackQuery.getData().equals(callbackText(7))) {
            sendTextWithButton(who, "Полученный ответ: " + Float.toString(UrnModel.urnModelFirst(n, m, k)), bot,"reply");
        } else if (callbackQuery.getData().equals(callbackText(4))) {
            handleMoreNumbers(n, Service.createIntArray(m, k));
        } else {
            sendTextWithButton(who, ERROR_MESSAGE, bot, "reply");
        }
    }

    private void handleFourNumbers(int n, int m, int k, int r) {
        if (callbackQuery.getData().equals(callbackText(8))) {
            sendTextWithButton(who, "Полученный ответ: " + Float.toString(UrnModel.urnModelSecond(n, m, k, r)), bot,"reply");
        } else if (callbackQuery.getData().equals(callbackText(4))) {
            handleMoreNumbers(n, Service.createIntArray(m, k, r));
        } else {
            sendTextWithButton(who, ERROR_MESSAGE, bot, "reply");
        }
    }
    private void handleMoreNumbers(int n, int[] numbers) {
        if (callbackQuery.getData().equals(callbackText(4))) {
            sendTextWithButton(who, "Полученный ответ: " + Float.toString(Permutations.permutationsWithRepetition(n,numbers)), bot,"reply");
        }
    }


    public static void sendText(Long who, String what, TelegramLongPollingBot bot) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what).build();
        try {
            bot.execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}