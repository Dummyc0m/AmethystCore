package com.dummyc0m.amethystutil.framework.item;

import com.dummyc0m.amethystutil.util.AUFormat;

import java.util.HashMap;
import java.util.List;

/**
 * com.dummyc0m.amethystutil.framework.item
 * Created by Dummyc0m on 4/2/15.
 */
public class AUItemHandler {
    private HashMap<String, AUItem> identifierMap = new HashMap<String, AUItem>();
    private static AUItemHandler instance = new AUItemHandler();

    public void registerItems(List<AUItem> auItem){
        for (AUItem item : auItem){
            this.registerItem(item);
        }
    }

    public void registerItem(AUItem auItem){
        this.identifierMap.put(auItem.getIdentifier(), auItem);
    }

    public AUItem unregisterItem(String identifier){
        return this.identifierMap.remove(identifier);
    }

    public AUItem getItem(String identifier){
        if(identifier.startsWith(AUFormat.RESET + AUFormat.DARK_GRAY)){
            return this.identifierMap.get(identifier.replaceFirst(AUFormat.RESET + AUFormat.DARK_GRAY, ""));
        }
        return null;
    }
    public static AUItemHandler getInstance(){
        return instance;
    }
}
