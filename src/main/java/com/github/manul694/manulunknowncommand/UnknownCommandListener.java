package com.github.manul694.manulunknowncommand;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.command.UnknownCommandEvent;

public class UnknownCommandListener implements Listener {

    @EventHandler
    public void onUnknownCommand(UnknownCommandEvent e) {
        String message = ManulUnknownCommand.getInstance().getConfig().getString("messages.unknowncommand");
        if(message == null) return;
        e.setMessage(ManulUnknownCommand.getInstance().getMessage("unknowncommand"));
    }
}
