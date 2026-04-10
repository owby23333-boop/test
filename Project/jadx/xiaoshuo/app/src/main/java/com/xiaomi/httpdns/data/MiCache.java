package com.xiaomi.httpdns.data;

import android.os.SystemClock;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class MiCache implements Serializable {
    public static boolean d = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7356a = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f7357b = new ArrayList();
    public final String[] c;

    public MiCache(String str, String[] strArr) {
        this.c = strArr;
    }
}
