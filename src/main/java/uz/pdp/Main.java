package uz.pdp;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(new MyBot("7560789894:AAHWyVouM4DdreUypaMVIqnr8ZooLKBtw_4"));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
