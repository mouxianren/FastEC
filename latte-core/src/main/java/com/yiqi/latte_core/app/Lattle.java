package com.yiqi.latte_core.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by moumou on 17/10/30.
 */

public class Lattle {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLattleConfigs();
    }
    public static Context getContext(){
        return (Context)getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }





}
