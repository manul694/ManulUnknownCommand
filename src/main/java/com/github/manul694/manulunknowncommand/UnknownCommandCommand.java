package com.github.manul694.manulunknowncommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class UnknownCommandCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender.hasPermission("manulunknowncommand.reload")) {
            ManulUnknownCommand.getInstance().reloadConfig();
            ManulUnknownCommand.getInstance().sendMessage(sender, "reloaded");
        } else {
            ManulUnknownCommand.getInstance().getMessage("nopermission");
        }
        return true;
    }
}
