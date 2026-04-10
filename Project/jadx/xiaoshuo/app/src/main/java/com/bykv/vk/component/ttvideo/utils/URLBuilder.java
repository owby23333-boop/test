package com.bykv.vk.component.ttvideo.utils;

import android.util.Log;
import com.bykv.vk.component.ttvideo.player.Keep;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class URLBuilder {
    private static final String TAG = "URLBuilder";

    public static final URL build(String str) {
        try {
            return new URL(str);
        } catch (Exception e) {
            Log.d(TAG, e.toString());
            return null;
        }
    }
}
