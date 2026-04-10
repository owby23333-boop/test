package com.yuewen;

import android.content.res.Configuration;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes12.dex */
public class b61 {
    public static Resources a(Resources resources) {
        if (resources != null && resources.getConfiguration().fontScale != 1.0f) {
            Configuration configuration = resources.getConfiguration();
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }
}
