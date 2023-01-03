package net.bxx2004.scriptblock.listener;

import net.bxx2004.pandalib.bukkit.language.script.ScriptBox;
import net.bxx2004.pandalib.bukkit.language.script.ScriptHandler;
import net.bxx2004.pandalib.bukkit.listener.BukkitListener;
import net.bxx2004.scriptblock.Config;
import net.bxx2004.scriptblock.api.ScriptBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

@BukkitListener
public class BreakListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event){
        ScriptBlock block = new ScriptBlock(event.getBlock().getLocation());
        if (block.isScriptBlock()){
            event.setCancelled(Config.cancelEvent);
            block.getScriptList().forEach(s -> {
                ScriptHandler.run(event.getPlayer(),new ScriptBox(s));
            });
        }
    }
}
