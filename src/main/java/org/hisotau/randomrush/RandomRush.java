package org.hisotau.randomrush;

import org.bukkit.plugin.java.JavaPlugin;
import org.hisotau.randomrush.listeners.PlayerDamage;
import org.hisotau.randomrush.listeners.PlayerHungry;
import org.hisotau.randomrush.listeners.PlayerJoinQuit;
import org.hisotau.randomrush.utils.LocationManager;

public final class RandomRush extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();

        LocationManager.getInstance().loadLocation();
        getServer().getPluginManager().registerEvents(new PlayerJoinQuit(), this);
        getServer().getPluginManager().registerEvents(new PlayerDamage(),this);
        getServer().getPluginManager().registerEvents(new PlayerHungry(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static RandomRush getInstance() {
        return getPlugin(RandomRush.class);
    }
}
