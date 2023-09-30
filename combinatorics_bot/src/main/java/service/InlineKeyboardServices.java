package service;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static service.TextResources.callbackText;

public class InlineKeyboardServices {
    public static InlineKeyboardMarkup setKeyboardMarkupForStart() {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = keyboardMarkup.getKeyboard();

        if (keyboard == null) {
            keyboard = new ArrayList<>();
            keyboardMarkup.setKeyboard(keyboard);
        }
        keyboard.add(createInlineKeyboardRow("Сочетания без повторений", callbackText(1)));
        keyboard.add(createInlineKeyboardRow("Сочетания с повторениями", callbackText(2)));
        keyboard.add(createInlineKeyboardRow("Перестановки без повторений", callbackText(3)));
        keyboard.add(createInlineKeyboardRow("Перестановки с повторениями", callbackText(4)));
        keyboard.add(createInlineKeyboardRow("Размещения без повторений", callbackText(5)));
        keyboard.add(createInlineKeyboardRow("Размещения с повторениями", callbackText(6)));
        keyboard.add(createInlineKeyboardRow("Урновая модель первого типа", callbackText(7)));
        keyboard.add(createInlineKeyboardRow("Урновая модель второго типа", callbackText(8)));
        return keyboardMarkup;
    }
    public static InlineKeyboardMarkup setKeyboardMarkupForReply(CallbackQuery callbackQuery) {
        InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = keyboardMarkup.getKeyboard();

        if (keyboard == null) {
            keyboard = new ArrayList<>();
            keyboardMarkup.setKeyboard(keyboard);
        }
        keyboard.add(createInlineKeyboardRow("Повторить вычисление", callbackQuery.getData()));
        keyboard.add(createInlineKeyboardRow("Выбрать формулу", callbackText(9)));
        return keyboardMarkup;
    }

    private static List<InlineKeyboardButton> createInlineKeyboardRow(String text, String callbackData) {
        List<InlineKeyboardButton> row = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText(text);
        button.setCallbackData(callbackData);
        row.add(button);
        return row;
    }
}
