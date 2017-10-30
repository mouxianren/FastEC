package com.yiqi.fastec;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.yiqi.latte_core.app.Lattle;

/**
 * Created by moumou on 17/10/30.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Lattle.init(this)
                .withIcon(new FontAwesomeModule())
                .withApiHost("http:baidu.com")
                .configure();
    }
}
