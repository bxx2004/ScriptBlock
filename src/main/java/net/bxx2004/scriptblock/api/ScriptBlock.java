package net.bxx2004.scriptblock.api;

import de.tr7zw.changeme.nbtapi.NBTBlock;
import de.tr7zw.changeme.nbtapi.NBTStringList;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ScriptBlock {
    private Location location;
    private NBTBlock block;
    public ScriptBlock(Location location){
        this.location = location;
        this.block = new NBTBlock(location.getBlock());
    }
    public ScriptBlock(String[] args){
        this(new Location(Bukkit.getWorld(args[0]),Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3])));
    }
    public boolean isScriptBlock(){
        return block.getData().hasTag("scriptblock");
    }
    public void _init(){
        block.getData().addCompound("scriptblock");
        block.getData().getCompound("scriptblock").setString("type","RIGHT_CLICK");
        block.getData().getCompound("scriptblock").setByteArray("script0", "tell &e欢迎!".getBytes());
    }
    public ScriptBlockType getType(){
        return ScriptBlockType.valueOf(block.getData().getCompound("scriptblock").getString("type").toUpperCase());
    }
    public List<String> getScriptList(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100;i++){
            try {
                list.add(new String(block.getData().getCompound("scriptblock").getByteArray("script" + i)));
            }catch (Exception e){
                break;
            }
        }
        return list;
    }
}