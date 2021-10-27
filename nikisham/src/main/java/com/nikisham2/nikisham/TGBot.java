package com.nikisham2.nikisham;

import com.nikisham2.nikisham.entities.Instruments;
import com.nikisham2.nikisham.repositories.InstrumentsModeService;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import javax.sound.midi.Instrument;
import java.util.*;

public class TGBot extends TelegramLongPollingBot {
    private final InstrumentsModeService instrumentsModeService = InstrumentsModeService.getInstance();


    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasCallbackQuery()){
        handleCallback(update.getCallbackQuery());
        }
        if (update.hasMessage()){
            handleMessage(update.getMessage());
        }
    }
    @SneakyThrows
    private void handleCallback(CallbackQuery callbackQuery) {
     Message message = callbackQuery.getMessage();
     String[] param = callbackQuery.getData().split(":");
     String action = param[0];
     Instruments newInstruments = Instruments.valueOf(param[1]);
     switch (action){
         case "Instrument":
             instrumentsModeService.setInstrumentsInstrument(message.getChatId(),newInstruments);
             break;
     }
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        Instruments instrumentsMap = instrumentsModeService.getInstrumentsInstrument(message.getChatId());
        for (Instruments instruments : Instruments.values()) {
            buttons.add(Arrays.asList(
                    InlineKeyboardButton.builder().text(getInstrumentsInstrument(instrumentsMap, instruments)).callbackData("Instrument:" + instruments).build()

            ));

        };
     execute(EditMessageReplyMarkup.builder().chatId(message.getChatId().toString()).messageId(message.getMessageId()).replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());
    }


    @SneakyThrows
    private void handleMessage(Message message){
        if (message.hasText() && message.hasEntities()){
            Optional<MessageEntity> commandEntity =
            message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();
        if(commandEntity.isPresent()){
            String command = message.getText().substring(commandEntity.get().getOffset(),commandEntity.get().getLength());
            switch (command) {
                case "/buy":
                    List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
                    Instruments instrumentsMap = instrumentsModeService.getInstrumentsInstrument(message.getChatId());
                    for (Instruments instruments : Instruments.values()){
                    buttons.add(Arrays.asList(
                            InlineKeyboardButton.builder().text(getInstrumentsInstrument(instrumentsMap, instruments)).callbackData("Instrument:" + instruments).build()
                    ));

                   };
                    execute(SendMessage.builder().text("Выберите Нужный инструмент").chatId(message.getChatId().toString()).replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build()).build());
            return;
                default:
                    throw new IllegalStateException("Unexpected values: " + command);
            }
        }
        }

    }

private String getInstrumentsInstrument(Instruments saved, Instruments instruments){
    return  saved == instruments ? instruments + "✅" : instruments.name();
}
    @Override
    public String getBotUsername() {
        return "@Adaptermtsb_bot";
    }

    @Override
    public String getBotToken() {
        return "2022925522:AAE4BGFWkRWUPiBJJXX5eIc7TDM0D53CHX8";
    }
    @SneakyThrows
    public static void main(String[] args){
        TGBot bot = new TGBot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(bot);
    }


}
