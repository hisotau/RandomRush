package org.hisotau.randomrush.player;

import org.bukkit.entity.Player;
import org.hisotau.randomrush.manager.PlayerManager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Players implements PlayerManager {

    public static final Players instance = new Players();

    private final Map<Integer, Player> players = new ConcurrentHashMap<>();

    @Override
    public void addPlayer(Player player) {
        players.put(player.getEntityId(), player);
    }

    public Map<Integer, Player> getPlayers() {
        return players;
    }

    public Player getPlayer(Integer id) {
        return players.get(id);
    }

    @Override
    public int getCountPlayers() {
        return players.size();
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player.getEntityId());
    }
}
