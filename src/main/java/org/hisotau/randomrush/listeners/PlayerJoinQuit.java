package org.hisotau.randomrush.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.hisotau.randomrush.RandomRush;
import org.hisotau.randomrush.game.GameState;
import org.hisotau.randomrush.player.Players;
import org.hisotau.randomrush.utils.LocationUtil;

import java.util.Objects;

public class PlayerJoinQuit implements Listener {



    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent event) {
        Players.instance.addPlayer(event.getPlayer());
        for (Player player : Players.instance.getPlayers().values()) {
            player.teleport(LocationUtil.getLocation(Objects.requireNonNull(
                    Objects.requireNonNull(RandomRush.getInstance()
                                    .getConfig()
                                    .getConfigurationSection("SpawnLocation"))
                            .getString("HubLocation.location"))));
        }
        if (Players.instance.getCountPlayers() == 2) {
            Bukkit.broadcastMessage("До начала игры осталось 10 секунд.");

            GameState.setGameState(GameState.COUNTDOWN);
        }
        Bukkit.broadcastMessage("Игрок " + event.getPlayer() + " подключился" + " осталось " + "(" + Players.instance.getCountPlayers() + "/" + "2)");

    }

    @EventHandler
    private void onPlayerQuit(PlayerQuitEvent event) {
        Players.instance.removePlayer(event.getPlayer());
        Bukkit.broadcastMessage("Игрок " + event.getPlayer().getName() + " покинул игру.");
    }
}
