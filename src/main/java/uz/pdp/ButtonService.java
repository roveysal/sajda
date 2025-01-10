package uz.pdp;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ButtonService {
    public ReplyKeyboardMarkup getReplyKeyboardMarkup() {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> rowList = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();

        KeyboardButton button = new KeyboardButton();
        button.setText("⏰ Namoz Vaqtlari");

        KeyboardButton button2 = new KeyboardButton();
        button2.setText("\uD83D\uDCDA Bot haqida");


        row.add(button);
        row.add(button2);

        rowList.add(row);
        markup.setKeyboard(rowList);
        markup.setResizeKeyboard(true);
        markup.setIsPersistent(true);
        markup.setSelective(true);
        markup.setOneTimeKeyboard(true);

        return markup;
    }

    public InlineKeyboardMarkup getInlineKeyboardMarkup() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        List<InlineKeyboardButton> row = new ArrayList<>();
        List<InlineKeyboardButton> row1 = new ArrayList<>();
        List<InlineKeyboardButton> row2 = new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button.setText("⬅\uFE0FOrqaga");
        button.setCallbackData("back");

        button1.setText("Haftalik namoz vaqti");
        button1.setCallbackData("weekly");


        row.add(button1);
        row1.add(button);

        rowList.add(row);
        rowList.add(row1);

        markup.setKeyboard(rowList);

        return markup;
    }
}
