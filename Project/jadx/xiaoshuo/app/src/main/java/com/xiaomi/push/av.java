package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: loaded from: classes8.dex */
class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f7805a;

    public static aq a(Context context) {
        if (j.m611a()) {
            f7805a = 1;
            return new au(context);
        }
        if (an.a(context)) {
            f7805a = 2;
            return new an(context);
        }
        if (ax.a(context)) {
            f7805a = 4;
            return new ax(context);
        }
        if (bb.a(context)) {
            f7805a = 5;
            return new bb(context);
        }
        if (at.a(context)) {
            f7805a = 3;
            return new ar(context);
        }
        f7805a = 0;
        return new ba();
    }
}
