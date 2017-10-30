package com.yiqi.latte_core.app;

import java.util.WeakHashMap;

/**
 * Created by moumou on 17/10/30.
 */

public class Configurator {
    private static final WeakHashMap<String, Object> LATTLE_CONFIGS = new WeakHashMap<String, Object>();

    /**
     *
     */
    private Configurator() {
        LATTLE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }
    /**
     *内部类 初始化数据 线程安全
     */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    //初始化完成
    public final void configure() {
        LATTLE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final WeakHashMap<String, Object> getLattleConfigs() {
        return LATTLE_CONFIGS;
    }

    public final Configurator withApiHost(String host) {
        LATTLE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTLE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("configuration is not ready,call configurate");
        }
    }

    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) LATTLE_CONFIGS.get(key.name());

    }


}