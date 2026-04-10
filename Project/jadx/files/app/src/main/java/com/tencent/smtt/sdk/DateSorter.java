package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

/* JADX INFO: loaded from: classes3.dex */
public class DateSorter {
    public static int DAY_COUNT;
    private android.webkit.DateSorter a;
    private IX5DateSorter b;

    static {
        a();
        DAY_COUNT = 5;
    }

    public DateSorter(Context context) {
        w wVarA = w.a();
        if (wVarA == null || !wVarA.b()) {
            this.a = new android.webkit.DateSorter(context);
        } else {
            this.b = wVarA.c().h(context);
        }
    }

    private static boolean a() {
        w wVarA = w.a();
        return wVarA != null && wVarA.b();
    }

    public long getBoundary(int i2) {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? this.a.getBoundary(i2) : this.b.getBoundary(i2);
    }

    public int getIndex(long j2) {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? this.a.getIndex(j2) : this.b.getIndex(j2);
    }

    public String getLabel(int i2) {
        w wVarA = w.a();
        return (wVarA == null || !wVarA.b()) ? this.a.getLabel(i2) : this.b.getLabel(i2);
    }
}
