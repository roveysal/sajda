package uz.pdp;


import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.Arrays;

import static uz.pdp.GetMethods.*;

public class MyBot extends TelegramLongPollingBot {

    public MyBot(String token) {
        super(token);
    }

    private static final ButtonService buttonService = new ButtonService();

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(Arrays.toString(getWeekly()));
        System.out.println(Arrays.toString(getMonthly()));
        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getFrom().getId();
            String text = update.getMessage().getText();
            if (text.equals("/start")) {
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("\uD83E\uDD17Assalomu alaykum, " + update.getMessage().getFrom().getFirstName() + '\n' + '\n' +
                                    "Bu bot sizga namoz vaqtlarini oson va tezda bilib olish imkonini beradi.");
                sendMessage.setReplyMarkup(buttonService.getReplyKeyboardMarkup());
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else if (text.equals("⏰ Namoz Vaqtlari")) {
                SendMessage message = new SendMessage();
                try {
                    message.setText(get().toString());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                message.setChatId(chatId);
                message.setReplyMarkup(buttonService.getInlineKeyboardMarkup());
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            } else if (text.equals("\uD83D\uDCDA Bot haqida")) {
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("❓ Salom! Men sizga Toshkentdagi vaqt mintaqasiga mos ravishda namoz vaqtlarini aniq va tezkor tarzda taqdim etaman. Sizning hududingiz uchun to'g'ri vaqtlarda namoz o'qish imkoniyatini ta'minlashga harakat qilaman. Siz faqat shahar yoki tuman nomini yuboring va kerakli namoz vaqtlarini osonlik bilan bilib oling!\n" +
                                "\n" +
                                "«⏰ Namoz Vaqtlari» - bo'limi orqali namoz vaqtlarini korsangiz boladi.");

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        } else if (update.hasCallbackQuery()) {
            String data = update.getCallbackQuery().getData();
            System.out.println(data);

            if (data.equals("back")) {
                Long chatId = update.getCallbackQuery().getFrom().getId();
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setText("✅ Asosiy menyudasiz!");
                message.setReplyMarkup(buttonService.getReplyKeyboardMarkup());
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }

            }
            if (data.equals("weekly")) {
                Long chatId = update.getCallbackQuery().getFrom().getId();

                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("✨Bu haftadagi namoz vaqtlari :\n" + Arrays.toString(getWeekly()));
                sendMessage.setChatId(chatId);
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
            if (data.equals("monthly")) {
                Long chatId = update.getCallbackQuery().getFrom().getId();

                SendMessage sendMessage = new SendMessage();
                sendMessage.setText("✨Bu oydagi namoz vaqtlari :\n" + Arrays.toString(getMonthly()));
                sendMessage.setChatId(chatId);
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }


    @Override
    public String getBotUsername() {
        return "@sajdaTimes_bot";


    }
}