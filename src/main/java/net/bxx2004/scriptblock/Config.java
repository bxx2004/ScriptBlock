package net.bxx2004.scriptblock;

import net.bxx2004.pandalib.bukkit.file.Node;

@net.bxx2004.pandalib.bukkit.file.Config(path = "plugins/ScriptBlock/config.yml")
public class Config {
    @Node(key = "cancelEvent")
    public static boolean cancelEvent = true;
}
