package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.anythink.expressad.foundation.d.c;

/* JADX INFO: loaded from: classes2.dex */
public enum i {
    NEWS("news", 0),
    IMAGE(c.C0205c.f10205e, 1),
    VIDEO("video", 2),
    TOPIC("topic", 3),
    AD("ad", 4),
    HOTDOC("hotkey", 5),
    SMALLVIDEO("smallvideo", 6),
    RECALLNEWS("recallNews", 8),
    POLICETASK("policetask", 9);


    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f13150j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f13151k;

    i(String str, int i2) {
        this.f13150j = str;
        this.f13151k = i2;
    }

    public String b() {
        return this.f13150j;
    }

    public int c() {
        return this.f13151k;
    }

    public static i b(String str) {
        for (i iVar : values()) {
            if (iVar != null && TextUtils.isEmpty(iVar.f13150j) && iVar.f13150j.equals(str)) {
                return iVar;
            }
        }
        return null;
    }
}
