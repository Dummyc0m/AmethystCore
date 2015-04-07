package com.dummyc0m.amethystutil.config;

import java.io.*;
import java.lang.reflect.Constructor;

import com.dummyc0m.amethystutil.AmethystUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.FieldNamingPolicy;

/**
 * Created by Dummyc0m on 3/3/15.
 */
public class AUConfig {
    private BufferedReader bReader;
    private FileWriter fWriter;
    private Class<?> settingsClass;
    private Object settings;
    private Gson gson;

    public AUConfig(String file, Class<?> settingsClass){
        this.settingsClass = settingsClass;
        this.gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        try {
            File f = new File(AmethystUtil.getInstance().getDataFolder() + file);
            this.fWriter = new FileWriter(f);
            this.bReader = new BufferedReader(new FileReader(f));
            if(this.load() == null) this.useDefault();
        } catch (IOException e){
            throw new RuntimeException("An error occurred when trying to instantiate a AUConfig", e);
        }
    }

    public AUConfig(String file, Class<?> settingsClass, Gson gson){
        this.settingsClass = settingsClass;
        this.gson = gson;
        try {
            File f = new File(AmethystUtil.getInstance().getDataFolder() + file);
            this.fWriter = new FileWriter(f);
            this.bReader = new BufferedReader(new FileReader(f));
            if(this.load() == null) this.useDefault();
        } catch (IOException e){
            throw new RuntimeException("An error occurred when trying to instantiate a AUConfig", e);
        }
    }

    private void useDefault(){
        try {
            Constructor<?> constructor = this.settingsClass.getConstructor();
            this.settings = constructor.newInstance();
        } catch (Exception e){
            throw new RuntimeException("An error occurred when trying to construct a default configuration", e);
        }
        this.save();

    }

    public Gson getGson(){
        return this.gson;
    }

    public Object getSettings(){
        return this.settings;
    }

    public Object load(){
        this.settings = this.gson.fromJson(bReader, settingsClass);
        return this.settings;
    }

    public Object save() {
        try {
            fWriter.write(this.gson.toJson(settings));
            fWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("An error occurred when trying to save the configuration", e);
        }
        return settings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AUConfig that = (AUConfig) o;

        if (bReader != null ? !bReader.equals(that.bReader) : that.bReader != null) return false;
        if (fWriter != null ? !fWriter.equals(that.fWriter) : that.fWriter != null) return false;
        if (gson != null ? !gson.equals(that.gson) : that.gson != null) return false;
        if (settings != null ? !settings.equals(that.settings) : that.settings != null) return false;
        if (settingsClass != null ? !settingsClass.equals(that.settingsClass) : that.settingsClass != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bReader != null ? bReader.hashCode() : 0;
        result = 31 * result + (fWriter != null ? fWriter.hashCode() : 0);
        result = 31 * result + (settingsClass != null ? settingsClass.hashCode() : 0);
        result = 31 * result + (settings != null ? settings.hashCode() : 0);
        result = 31 * result + (gson != null ? gson.hashCode() : 0);
        return result;
    }
}