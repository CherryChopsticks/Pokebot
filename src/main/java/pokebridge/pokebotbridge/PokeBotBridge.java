package pokebridge.pokebotbridge;

import com.google.inject.Inject;
import com.google.inject.internal.cglib.proxy.$LazyLoader;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.game.GameReloadEvent;
import org.spongepowered.api.event.game.state.GamePreInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.message.MessageEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.command.CommandManager;
import org.spongepowered.api.event.message.MessageChannelEvent;
import org.spongepowered.api.text.channel.MessageReceiver;

@Plugin(
        id = "pokebotbridge",
        name = "PokeBotBridge",
        version = "1.0-SNAPSHOT",
        description = "A bridge for the Bonbot discord bot and the pixelmon server to relay messages to each other",
        authors = {
                "Bonnie"
        }
)
public class PokeBotBridge {

    @Inject
    private Logger logger;

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("Succesfully running pokebotbridge!!!");

        PluginContainer pbot = () -> "PokeBot";

        CommandSpec myCommandSpec = CommandSpec.builder()
                .description(Text.of("Hello World Command"))
                .permission("myplugin.command.helloworld")
                .executor(new HelloWorldCommand())
                .build();
        Sponge.getCommandManager().register(pbot, myCommandSpec, "helloworld", "hello", "test");
    }

    @Listener
    public void reload(GameReloadEvent event) {
        logger.info("Pokebot has been reloaded");
    }

    @Listener
    public void chatsent(MessageEvent event)
    {
//        event to listen to chat and return given chat message
    }
    }


}


