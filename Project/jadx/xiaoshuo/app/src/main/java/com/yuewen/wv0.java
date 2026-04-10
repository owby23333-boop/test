package com.yuewen;

import android.content.Context;
import android.text.TextUtils;
import android.util.LongSparseArray;
import com.duokan.reader.ui.general.DkToast;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes3.dex */
public class wv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f19724a = -100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f19725b = -101;
    public static final int c = 10001;
    public static final LongSparseArray<Integer> d;

    static {
        LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
        d = longSparseArray;
        longSparseArray.put(-100L, Integer.valueOf(rt2.r.C6));
        longSparseArray.put(-101L, Integer.valueOf(rt2.r.u2));
        longSparseArray.put(10001L, Integer.valueOf(rt2.r.v2));
    }

    public static String a(Context context, int i) {
        return context.getString(d.get(i).intValue());
    }

    public static boolean b(int i) {
        return i == -101;
    }

    public static void c(Context context, int i, String str) {
        if (TextUtils.isEmpty(str)) {
            d(context, i);
        } else {
            DkToast.makeText(context, str, 0).show();
        }
    }

    public static boolean d(Context context, int i) {
        Integer num = d.get(i);
        if (num == null) {
            return false;
        }
        DkToast.makeText(context, num.intValue(), 0).show();
        return true;
    }
}
