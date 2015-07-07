package com.dummyc0m.amethystcore.config;

import com.dummyc0m.amethystcore.AmethystCore;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * Created by Dummyc0m on 3/3/15.
 */
public class ACConfig {
    private final BufferedReader bReader;
    private final FileWriter fWriter;
    private final Class<?> settingsClass;
    private final Gson gson;
    private Object settings;

    public ACConfig(String file, Class<?> settingsClass) {
        this.settingsClass = settingsClass;
        this.gson = new GsonBuilder()
                .disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
        try {
            File f = new File(AmethystCore.getInstance().getDataFolder() + file);
            this.fWriter = new FileWriter(f);
            this.bReader = new BufferedReader(new FileReader(f));
            if(this.load() == null) this.useDefault();
        } catch (IOException e){
            throw new RuntimeException("An error occurred when trying to instantiate a ACConfig", e);
        }
    }

    public ACConfig(String file, Class<?> settingsClass, Gson gson) {
        this.settingsClass = settingsClass;
        this.gson = gson;
        try {
            File f = new File(AmethystCore.getInstance().getDataFolder() + file);
            this.fWriter = new FileWriter(f);
            this.bReader = new BufferedReader(new FileReader(f));
            if(this.load() == null) this.useDefault();
        } catch (IOException e){
            throw new RuntimeException("An error occurred when trying to instantiate a ACConfig", e);
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

        ACConfig acConfig = (ACConfig) o;

        return new EqualsBuilder()
                .append(bReader, acConfig.bReader)
                .append(fWriter, acConfig.fWriter)
                .append(settingsClass, acConfig.settingsClass)
                .append(settings, acConfig.settings)
                .append(gson, acConfig.gson)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(bReader)
                .append(fWriter)
                .append(settingsClass)
                .append(settings)
                .append(gson)
                .toHashCode();
    }
}
