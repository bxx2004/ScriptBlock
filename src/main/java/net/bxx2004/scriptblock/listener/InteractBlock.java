package net.bxx2004.scriptblock.listener;

import net.bxx2004.pandalib.bukkit.language.script.ScriptBox;
import net.bxx2004.pandalib.bukkit.language.script.ScriptHandler;
import net.bxx2004.pandalib.bukkit.listener.BukkitListener;
import net.bxx2004.scriptblock.Config;
import net.bxx2004.scriptblock.api.ScriptBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

@BukkitListener
public class InteractBlock implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if (event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            ScriptBlock block = new ScriptBlock(event.getClickedBlock().getLocation());
            if (block.isScriptBlock()){
                event.setCancelled(Config.cancelEvent);
                switch (block.getType()){
                    case LEFT_CLICK -> {
                        if (event.getAction() == Action.LEFT_CLICK_BLOCK){
                            block.getScriptList().forEach(s -> {
                                ScriptHandler.run(event.getPlayer(),new ScriptBox(s));
                            });
                        }
                        break;
                    }
                    case RIGHT_CLICK -> {
                        if (event.getAction() == Action.RIGHT_CLICK_BLOCK){
                            block.getScriptList().forEach(s -> {
                                ScriptHandler.run(event.getPlayer(),new ScriptBox(s));
                            });
                        }
                        break;
                    }
                }
            }
        }
    }
}
