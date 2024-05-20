package org.hisotau.randomrush.manager;

import org.bukkit.entity.Player;

public interface PlayerManager {
    void addPlayer(Player player);
    int getCountPlayers();
    void removePlayer(Player player);
}
