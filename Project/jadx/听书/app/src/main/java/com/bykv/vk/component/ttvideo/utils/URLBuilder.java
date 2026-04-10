package com.bykv.vk.component.ttvideo.utils;

import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class URLBuilder {
    private static final String TAG = "URLBuilder";

    public static final URL build(String str) {
        try {
            return new URL(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
