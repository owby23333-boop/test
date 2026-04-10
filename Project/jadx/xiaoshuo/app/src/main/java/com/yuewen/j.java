package com.yuewen;

import android.net.Uri;
import com.yuewen.rf4;

/* JADX INFO: loaded from: classes8.dex */
public class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile j f12798b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f12799a;

    public j(String str) {
        this.f12799a = Uri.parse(rf4.c.f17031a + str + ".YWDataContentProvider/reports");
    }

    public Uri a() {
        return this.f12799a;
    }

    public static j a(String str) {
        if (f12798b == null) {
            synchronized (j.class) {
                if (f12798b == null) {
                    f12798b = new j(str);
                }
            }
        }
        return f12798b;
    }
}
