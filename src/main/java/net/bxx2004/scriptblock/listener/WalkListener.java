package net.bxx2004.scriptblock.listener;

import net.bxx2004.pandalib.bukkit.language.script.ScriptBox;
import net.bxx2004.pandalib.bukkit.language.script.ScriptHandler;
import net.bxx2004.pandalib.bukkit.listener.BukkitListener;
import net.bxx2004.scriptblock.Config;
import net.bxx2004.scriptblock.api.ScriptBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

@BukkitListener
public class WalkListener implements Listener {
    @EventHandler
    public void onWalk(PlayerMoveEvent event){
        if (event.hasChangedBlock()){
            ScriptBlock block = new ScriptBlock(event.getTo().clone().add(0.00,-1.00,0.00));
            if (block.isScriptBlock()){
                event.setCancelled(Config.cancelEvent);
                block.getScriptList().forEach(s -> {
                    ScriptHandler.run(event.getPlayer(),new ScriptBox(s));
                });
            }
        }
    }
}
