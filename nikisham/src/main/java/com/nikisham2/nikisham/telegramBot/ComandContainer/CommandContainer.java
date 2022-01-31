package telegramBot.ComandContainer;

import com.google.common.collect.ImmutableMap;
import com.nikisham2.nikisham.service.TelegramUserService;
import org.eclipse.persistence.sessions.coordination.Command;
import telegramBot.Bot;

public class CommandContainer {
    private final ImmutableMap<String, Bot> BotMap;

    public CommandContainer(TelegramUserService telegramUserService) {
        BotMap = ImmutableMap.<String, Bot>builder()
                .put("/start", new Bot(telegramUserService))
                .put("/stat", new Bot(telegramUserService))
                .build()
        ;
    }
}
