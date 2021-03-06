package com.github.tanokun.ec_efc.util.io;

import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Folder {
    private Plugin plugin;
    private File folder;
    private String folderName;

    public Folder(Plugin plugin){
        this.plugin = plugin;
        this.folder = plugin.getDataFolder();
    }
    public Folder(String folderName, Plugin plugin){
        this.plugin = plugin;
        this.folder = new File(plugin.getDataFolder(), folderName);
        this.folderName = folderName;
    }
    public List<Config> getFiles() {
        List<Config> configs = new ArrayList<>();
        for (File file : folder.listFiles()) {
            Config config = new Config(folderName + File.separator + file.getName(), plugin);
            config.setFileName(file.getName());
            configs.add(config);

        }
        return configs;
    }
    public boolean exists(){
        return folder.exists();}
    public File getFolder(){return folder;}

    public void createExists() {
        if (!exists()){
            folder.mkdirs();
        }
    }
}