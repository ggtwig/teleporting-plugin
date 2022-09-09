package com.jack.teleporting;

import com.jack.teleporting.commands.Teleport;
import com.jack.teleporting.commands.TeleportAll;
import com.jack.teleporting.commands.TeleportOther;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("tp").setExecutor(new Teleport());
        getCommand("tpother").setExecutor(new TeleportOther());
        getCommand("tpall").setExecutor(new TeleportAll());
    }

}
