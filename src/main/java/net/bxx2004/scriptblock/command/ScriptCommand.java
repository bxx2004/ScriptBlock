package net.bxx2004.scriptblock.command;

import net.bxx2004.pandalib.bukkit.commands.BukkitCommand;
import net.bxx2004.pandalib.bukkit.commands.PCommand;
import net.bxx2004.pandalib.bukkit.util.PMath;
import net.bxx2004.scriptblock.ScriptBlockMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;
@BukkitCommand(name = "scriptblock",permission = "scriptblock.admin",aliases = {"script","sb","sbp","sblock"})
public class ScriptCommand extends PCommand {
    @Override
    public boolean run(CommandSender commandSender, Command command, String s, String[] strings) {
        commandHelp(ScriptBlockMain.node);
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return PMath.toStringList("create","delete","info","edit","list");
    }
}
