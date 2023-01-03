package net.bxx2004.scriptblock;

import net.bxx2004.pandalib.bukkit.language.application.PLangNode;
import net.bxx2004.pandalib.bukkit.manager.Lang;
import net.bxx2004.pandalib.java.sql.sqlite.SQLite;
import net.bxx2004.pandalib.java.sql.sqlite.SQLiteBase;
import net.bxx2004.pandalib.java.sql.sqlite.SQLiteConnection;
import net.bxx2004.pandalib.java.sql.sqlite.SQLiteData;
import net.bxx2004.pandalibloader.BukkitPlugin;
import net.bxx2004.pandalibloader.Path;

@Path(pack = "net.bxx2004.scriptblock")
public class ScriptBlockMain extends BukkitPlugin {
    public static PLangNode node;
    public static SQLiteBase sqLite;
    @Override
    public void start() {
        startMessage(true);
        registerPredefineScript();
        registerScript("net.bxx2004.scriptblock.scripts");
        SQLite s = new SQLite();
        s.set(new SQLiteConnection("plugins/ScriptBlock/data.db"));
        if (s.exist("scriptblock")) {
            Lang.print("&f数据库已连接");
        } else {
            //world,x,y,z
            s.createTable("scriptblock", true,
                    SQLiteData.getTable(SQLiteData.SQLiteDataType.VARCHAR, "location", 200));
        }
        node = new PLangNode(this,"简体中文");
    }

    @Override
    public void load() {
        sqLite = new SQLiteBase(new SQLiteConnection("plugins/ScriptBlock/data.db"),"scriptblock");
    }

    @Override
    public void end() {

    }
}
