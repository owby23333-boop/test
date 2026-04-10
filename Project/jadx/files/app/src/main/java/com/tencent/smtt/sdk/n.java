package com.tencent.smtt.sdk;

import android.os.HandlerThread;

/* JADX INFO: loaded from: classes3.dex */
class n extends HandlerThread {
    private static n a;

    public n(String str) {
        super(str);
    }

    public static synchronized n a() {
        if (a == null) {
            a = new n("TbsHandlerThread");
            a.start();
        }
        return a;
    }
}
