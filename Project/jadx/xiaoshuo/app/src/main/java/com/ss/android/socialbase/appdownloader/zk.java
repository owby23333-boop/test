package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: loaded from: classes4.dex */
public class zk {
    public static int bf(String str) {
        return e(com.ss.android.socialbase.downloader.downloader.d.i(), str);
    }

    public static int d(String str) {
        try {
            return e(str, com.ss.android.socialbase.downloader.downloader.d.i().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int e(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.d.i().getResources().getIdentifier(str, TtmlNode.TAG_LAYOUT, com.ss.android.socialbase.downloader.downloader.d.i().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int ga(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.d.i().getResources().getIdentifier(str, "id", com.ss.android.socialbase.downloader.downloader.d.i().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int tg(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.d.i().getResources().getIdentifier(str, TtmlNode.TAG_STYLE, com.ss.android.socialbase.downloader.downloader.d.i().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int vn(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.d.i().getResources().getIdentifier(str, "color", com.ss.android.socialbase.downloader.downloader.d.i().getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int bf(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.d.i().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int e(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, context.getPackageName());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int e(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.d.i().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
