package telegramBot;

import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
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

import static java.lang.Math.toIntExact;

@Component
public class Bot extends TelegramLongPollingBot {


    @Override
    public void onUpdateReceived(Update update) {

            if (update.hasMessage() && update.getMessage().hasText()) {
                SendMessage message = new SendMessage();
                String message_text = update.getMessage().getText();
                long chat_id = update.getMessage().getChatId();

                if (update.getMessage().getText().equals("/start")) {
                    message.setChatId(String.valueOf(chat_id));
                    message.setText("Привет");
                    InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
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
                    inlineKeyboardButton2.setCallbackData("Button  has been pressed");
                    inlineKeyboardButton3.setText("Fi4a");
                    inlineKeyboardButton3.setCallbackData("123");
                    inlineKeyboardButtons3.add(inlineKeyboardButton3);
                    inlineKeyboardButtons1.add(inlineKeyboardButton1);
                    inlineKeyboardButtons2.add(inlineKeyboardButton2);

                    rowsInline.add(inlineKeyboardButtons1);
                    rowsInline.add(inlineKeyboardButtons2);
                    rowsInline.add(inlineKeyboardButtons3);

                    markupInline.setKeyboard(rowsInline);
                    message.setReplyMarkup(markupInline);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

                else if (update.hasCallbackQuery()){
                    long message_id = update.getCallbackQuery().getMessage().getMessageId();
                    String call_data = update.getCallbackQuery().getData();
                    Long chat_id_callback = update.getCallbackQuery().getMessage().getChatId();
                    if(call_data.equals("123")) {
                        String answer = "Updated message text";
                        EditMessageText editMessageText = new EditMessageText().setChatId(String.valueOf(chat_id_callback))
                                                        .setMessageId(toIntExact(message_id)).setText(answer);
                        try {
                            execute(editMessageText);
                        } catch (TelegramApiException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
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
