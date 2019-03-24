package com.design.create.Color;

import java.util.HashMap;

/**
 * 描述: 依照原型模式和单例设计的ColorManager
 *
 */
public class ColorManager {
    private static HashMap<String, Color> map = new HashMap<>();   // k,v分别对应name,Color

    private static ColorManager colorManager = null;

    static{
        for (String key :ColorInfo.colorMap.keySet()){
            map.put(key, ColorInfo.getColor(key));
        }
    }

    private ColorManager(){}

    public static ColorManager getInstance() {
        if (colorManager == null){
            colorManager = new ColorManager();
        }
        return colorManager;
    }

    public Color getColor(String name){
        return (Color)map.get(name).clone();
    }
}


class ColorInfo {
    static HashMap<String, String> colorMap = new HashMap<>();  // k,v分别对应name,RGB

    static {
        colorMap.put("red", "#FF0000");
        colorMap.put("blue", "#0000FF");
        colorMap.put("green", "#008000");
        colorMap.put("magenta", "#FF00FF");
        colorMap.put("purple", "#800080");
        colorMap.put("yellowgreen", "#9ACD32");
        colorMap.put("pink", "#FF1493");
    }

    static Color getColor(String name){
        Color color = new Color();
        color.setName(name);
        color.setRGB(colorMap.get(name));
        return color;
    }
}