package telegramBot;

import liquibase.pro.packaged.S;
import org.hibernate.mapping.Map;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class Bot extends TelegramLongPollingBot {


    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        String i = "1";
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/buy":
                    SendMessage_Buy(message, "Это команда покупки");
                    System.out.println(message.getText());
                    break;
                case "Инструмент 1":
                    SendMessage_Tool1(message, "Это инструмент 1");
                    System.out.println(message.getText());
                    break;
                case "Инструмент 2":
                    SendMessage_Tool2(message, "Это инструмент 2");
                    System.out.println(message.getText());
                    break;
                case "Инструмент 3":
                    SendMessage_Tool3(message, "Это инструмент 3");
                    System.out.println(message.getText());
                    break;
                case "Инструмент 4":
                    SendMessage_Tool4(message, "Это инструмент 4");
                    System.out.println(message.getText());
                    break;
                case "Ввести цену":
                    SendMessage_Cost(message, "это цена");
                    System.out.println(message.getText());
                    break;
                case "Ввести кол-во лотов":
                    SendMessage_Lot(message, "это лоты");
                    System.out.println(message.getText());
                    break;
                case "Ввести объём":
                    SendMessage_Volume(message, "Это объём");
                    System.out.println(message.getText());
                    break;

            }
        }
    }

    public void SendMessage_Buy(Message message, String text) {
        long chat_id = message.getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chat_id));
        sendMessage.setText("Привет");
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardRow keyboardRow3 = new KeyboardRow();
        KeyboardRow keyboardRow4 = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        KeyboardButton keyboardButton4 = new KeyboardButton();
        keyboardButton1.setText("Инструмент 1");
        keyboardButton2.setText("Инструмент 2");
        keyboardButton3.setText("Инструмент 3");
        keyboardButton4.setText("Инструмент 4");
        keyboardRow1.add(keyboardButton1);
        keyboardRow2.add(keyboardButton2);
        keyboardRow3.add(keyboardButton3);
        keyboardRow4.add(keyboardButton4);
        keyboardRowList.add(keyboardRow1);
        keyboardRowList.add(keyboardRow2);
        keyboardRowList.add(keyboardRow3);
        keyboardRowList.add(keyboardRow4);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage_Tool1(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ответик1");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardRow keyboardRow3 = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        keyboardButton1.setText("Ввести цену");
        keyboardButton2.setText("Ввести кол-во лотов");
        keyboardButton3.setText("Ввести объём");
        keyboardRow1.add(keyboardButton1);
        keyboardRow2.add(keyboardButton2);
        keyboardRow3.add(keyboardButton3);
        keyboardRowList.add(keyboardRow1);
        keyboardRowList.add(keyboardRow2);
        keyboardRowList.add(keyboardRow3);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage_Tool2(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ответик2");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardRow keyboardRow3 = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        keyboardButton1.setText("Ввести цену");
        keyboardButton2.setText("Ввести кол-во лотов");
        keyboardButton3.setText("Ввести объём");
        keyboardRow1.add(keyboardButton1);
        keyboardRow2.add(keyboardButton2);
        keyboardRow3.add(keyboardButton3);
        keyboardRowList.add(keyboardRow1);
        keyboardRowList.add(keyboardRow2);
        keyboardRowList.add(keyboardRow3);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage_Tool3(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ответик3");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardRow keyboardRow3 = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        keyboardButton1.setText("Ввести цену");
        keyboardButton2.setText("Ввести кол-во лотов");
        keyboardButton3.setText("Ввести объём");
        keyboardRow1.add(keyboardButton1);
        keyboardRow2.add(keyboardButton2);
        keyboardRow3.add(keyboardButton3);
        keyboardRowList.add(keyboardRow1);
        keyboardRowList.add(keyboardRow2);
        keyboardRowList.add(keyboardRow3);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage_Tool4(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("ответик4");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow keyboardRow1 = new KeyboardRow();
        KeyboardRow keyboardRow2 = new KeyboardRow();
        KeyboardRow keyboardRow3 = new KeyboardRow();
        KeyboardButton keyboardButton1 = new KeyboardButton();
        KeyboardButton keyboardButton2 = new KeyboardButton();
        KeyboardButton keyboardButton3 = new KeyboardButton();
        keyboardButton1.setText("Ввести цену");
        keyboardButton2.setText("Ввести кол-во лотов");
        keyboardButton3.setText("Ввести объём");
        keyboardRow1.add(keyboardButton1);
        keyboardRow2.add(keyboardButton2);
        keyboardRow3.add(keyboardButton3);
        keyboardRowList.add(keyboardRow1);
        keyboardRowList.add(keyboardRow2);
        keyboardRowList.add(keyboardRow3);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage_Cost(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Введите цену");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    public void SendMessage_Lot(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Введите сколько лотов хотите купить ");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage_Volume(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Введите объем покупки инструмента ");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void SendMessage_9(Message message, String text) {
        if (message.hasText() && !message.getText().equals("Ввести цену")){
            String text_upd = message.getText();
        SendMessage sendMessage_2 = new SendMessage();
        long chat_id_12 = message.getChatId();
        sendMessage_2.setChatId(String.valueOf(chat_id_12));
        sendMessage_2.setText("Цена введена успешно");
        try {
            execute(sendMessage_2); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}


        public String getBotUsername () {
            return "@Adaptermtsb_bot";
        }


        public String getBotToken () {
            return "2022925522:AAE4BGFWkRWUPiBJJXX5eIc7TDM0D53CHX8";
        }
        @SneakyThrows
        public static void main (String[]args){
            Bot bot = new Bot();
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);
        }
    }
