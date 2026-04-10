package com.bytedance.sdk.component.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: loaded from: classes.dex */
public final class dt {
    private static Resources bf;

    @SuppressLint({"StaticFieldLeak"})
    private static Context d;
    private static String e;

    public static int bf(Context context, String str) {
        return e(context, str, TypedValues.Custom.S_STRING);
    }

    public static int bh(Context context, String str) {
        return e(context, str, TypedValues.Custom.S_INT);
    }

    public static Drawable d(Context context, String str) {
        return context.getResources().getDrawable(tg(context, str));
    }

    private static String e(Context context) {
        if (e == null) {
            e = context.getPackageName();
        }
        return e;
    }

    public static int ga(Context context, String str) {
        return e(context, str, "id");
    }

    public static int m(Context context, String str) {
        return context.getResources().getColor(wu(context, str));
    }

    public static int p(Context context, String str) {
        return e(context, str, TtmlNode.TAG_STYLE);
    }

    public static int t(Context context, String str) {
        return context.getResources().getInteger(bh(context, str));
    }

    public static int tg(Context context, String str) {
        return e(context, str, "drawable");
    }

    public static int v(Context context, String str) {
        return e(context, str, "attr");
    }

    public static int vn(Context context, String str) {
        return e(context, str, TtmlNode.TAG_LAYOUT);
    }

    public static int wu(Context context, String str) {
        return e(context, str, "color");
    }

    public static int xu(Context context, String str) {
        return e(context, str, "anim");
    }

    public static int zk(Context context, String str) {
        return e(context, str, "dimen");
    }

    private static int e(Context context, String str, String str2) {
        if (bf == null) {
            bf = context.getResources();
        }
        return bf.getIdentifier(str, str2, e(context));
    }

    public static String e(Context context, String str) {
        Context context2 = d;
        if (context2 == null) {
            return context.getResources().getString(bf(context, str));
        }
        return context2.getResources().getString(bf(d, str));
    }
}
