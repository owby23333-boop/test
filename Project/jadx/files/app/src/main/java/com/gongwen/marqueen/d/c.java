package com.gongwen.marqueen.d;

import android.content.Context;
import java.util.List;

/* JADX INFO: compiled from: Util.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static int a(Context context, float f2) {
        return (int) ((f2 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static boolean a(List list) {
        return list == null || list.size() == 0;
    }
}
