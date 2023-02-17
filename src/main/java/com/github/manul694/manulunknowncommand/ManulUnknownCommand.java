package com.github.manul694.manulunknowncommand;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class ManulUnknownCommand extends JavaPlugin {

    private static ManulUnknownCommand instance;
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Bukkit.getPluginManager().registerEvents(new UnknownCommandListener(), this);
        PluginCommand cmd = getCommand("unknowncommand");
        if(cmd == null) {
            getLogger().severe("Не удалось зарегистрировать команду /unknowncommand");
            getLogger().severe("Скорее всего, вы вырезали её из plugin.yml или её убрал какой-то плагин");
            getLogger().severe(" ");
            getLogger().severe("Could not register command /unknowncommand");
            getLogger().severe("It seems like you removed it from plugin.yml or another plugin unregistered command");
        } else cmd.setExecutor(new UnknownCommandCommand());
    }

    @Override
    public void onDisable() {

    }

    public static ManulUnknownCommand getInstance() {
        return instance;
    }

    public String getMessage(String key) {
        String message = ManulUnknownCommand.getInstance().getConfig().getString("messages." + key);
        if(message == null) return null;
        return message.replace("&", "§");
    }

    public void sendMessage(CommandSender p, String key) {
        String message = getMessage(key);
        if(message != null) p.sendMessage(message);
    }
}
