package telegramBot;

import liquibase.pro.packaged.S;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
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
        update.getUpdateId();
        SendMessage sendMessage_1 = new SendMessage();
        sendMessage_1.setChatId(String.valueOf(update.getMessage()));
        sendMessage_1.getChatId();


        if (update.hasMessage() && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            Message message = update.getMessage();
            /*Double text_upd = Double.valueOf(message.getText());*/
            String text_upd = update.getMessage().getText();



                String text = message.getText();

                if (text.equals("1")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(String.valueOf(chat_id));
                    sendMessage.setText("Привет");
                    /*InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                    List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                    List<InlineKeyboardButton> inlineKeyboardButtons1 = new ArrayList<>();
                    List<InlineKeyboardButton> inlineKeyboardButtons2 = new ArrayList<>();
                    List<InlineKeyboardButton> inlineKeyboardButtons3 = new ArrayList<>();
                    InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                    InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
                    inlineKeyboardButton1.setText("Тык");
                    inlineKeyboardButton1.setCallbackData("Button 1 has been pressed");
                    inlineKeyboardButton2.setText("Тык2");
                    inlineKeyboardButton2.setCallbackData("Button has been pressed");
                    inlineKeyboardButton3.setText("Fi4a");
                    inlineKeyboardButton3.setCallbackData("123");
                    inlineKeyboardButtons3.add(inlineKeyboardButton3);
                    inlineKeyboardButtons1.add(inlineKeyboardButton1);
                    inlineKeyboardButtons2.add(inlineKeyboardButton2);

                    rowsInline.add(inlineKeyboardButtons1);
                    rowsInline.add(inlineKeyboardButtons2);
                    rowsInline.add(inlineKeyboardButtons3);

                    markupInline.setKeyboard(rowsInline);
                    sendMessage.setReplyMarkup(markupInline);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }*/
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

                } else if (text.equals("Инструмент 1")) {
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
                } else if (text.equals("Инструмент 2")) {
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
                } else if (text.equals("Инструмент 3")) {
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
                } else if (text.equals("Инструмент 4")) {
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
                } else if (text.equals("Ввести цену")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Введите цену ");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(String.valueOf(message.getChatId()));
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }else if (Double.valueOf(text_upd)>1000 && Double.valueOf(text_upd)<2000 && message.hasText() && !update.getMessage().equals("1")) {
                    SendMessage sendMessage = new SendMessage();
                    long chat_id_12 = update.getMessage().getChatId();
                    sendMessage.setChatId(String.valueOf(chat_id_12));
                    sendMessage.setText("Цена введена успешно");
                    try {
                        execute(sendMessage); // Sending our message object to user
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
            }else if (text.equals("Ввести кол-во лотов")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Введите сколько лотов хотите купить ");
                    sendMessage.setParseMode(ParseMode.MARKDOWN);
                    sendMessage.setChatId(String.valueOf(message.getChatId()));

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else if (text.equals("Ввести объём")) {
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
            } else if (update.hasMessage() && update.hasCallbackQuery()) {
                long chat_id = update.getMessage().getChatId();
                long message_id = update.getCallbackQuery().getMessage().getMessageId();
                String call_data = update.getCallbackQuery().getData();
                Long chat_id_callback = update.getCallbackQuery().getMessage().getChatId();
                if (call_data.equals("123")) {
                    String answer = "Введите цену покупки3";
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(String.valueOf(chat_id_callback));
                    editMessageText.setMessageId((int) message_id);
                    editMessageText.setText(answer);
                    try {
                        execute(editMessageText);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                if (call_data.equals("Button has been pressed")) {
                    String answer = "Введите цену покупки2";
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(String.valueOf(chat_id_callback));
                    editMessageText.setMessageId((int) message_id);
                    editMessageText.setText(answer);
                    try {
                        execute(editMessageText);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                if (call_data.equals("Button 1 has been pressed")) {
                    String answer = "Введите цену покупки1";
                    EditMessageText editMessageText = new EditMessageText();
                    editMessageText.setChatId(String.valueOf(chat_id_callback));
                    editMessageText.setMessageId((int) message_id);
                    editMessageText.setText(answer);
                    try {
                        execute(editMessageText);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        /*if(update.getMessage().getText().equals("2") ){
            SendMessage sendMessage = new SendMessage();
            long chat_id = update.getMessage().getChatId();
            sendMessage.setChatId(String.valueOf(chat_id));
            if(update.getMessage().getText().equals("1000")){
                sendMessage.setText("Привет");
            }
            else {
                sendMessage.setText("dd");
            }

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }*/

        }


    public String getBotUsername() {
        return "@Adaptermtsb_bot";
    }


    public String getBotToken() {
        return "2022925522:AAE4BGFWkRWUPiBJJXX5eIc7TDM0D53CHX8";
    }
    @SneakyThrows
    public static void main(String[] args) {
        Bot bot = new Bot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }
}
