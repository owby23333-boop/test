package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.fe;
import com.xiaomi.push.ix;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public abstract class as {
    public abstract fe a(Context context, int i, String str, Map<String, String> map);

    public abstract void a(ix ixVar, Map<String, String> map, int i, Notification notification);

    public abstract void a(String str);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public abstract boolean m743a(Context context, int i, String str, Map<String, String> map);

    public abstract boolean a(Map<String, String> map, int i, Notification notification);
}
