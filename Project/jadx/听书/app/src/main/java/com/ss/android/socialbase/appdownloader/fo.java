package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes4.dex */
public class fo {
    public static int z(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.dl.xl().getResources().getIdentifier(str, TtmlNode.TAG_LAYOUT, com.ss.android.socialbase.downloader.downloader.dl.xl().getPackageName());
        } catch (Exception e) {
            wp.z(e);
            return 0;
        }
    }

    public static int z(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, context.getPackageName());
        } catch (Exception e) {
            wp.z(e);
            return 0;
        }
    }

    public static int g(String str) {
        return z(com.ss.android.socialbase.downloader.downloader.dl.xl(), str);
    }

    public static int dl(String str) {
        try {
            return z(str, com.ss.android.socialbase.downloader.downloader.dl.xl().getPackageName());
        } catch (Exception e) {
            wp.z(e);
            return 0;
        }
    }

    public static int z(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.dl.xl().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            wp.z(e);
            return 0;
        }
    }

    public static int a(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.dl.xl().getResources().getIdentifier(str, TtmlNode.TAG_STYLE, com.ss.android.socialbase.downloader.downloader.dl.xl().getPackageName());
        } catch (Exception e) {
            wp.z(e);
            return 0;
        }
    }

    public static int gc(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.dl.xl().getResources().getIdentifier(str, "id", com.ss.android.socialbase.downloader.downloader.dl.xl().getPackageName());
        } catch (Exception e) {
            wp.z(e);
            return 0;
        }
    }

    public static int m(String str) {
        try {
            return com.ss.android.socialbase.downloader.downloader.dl.xl().getResources().getIdentifier(str, "color", com.ss.android.socialbase.downloader.downloader.dl.xl().getPackageName());
        } catch (Exception e) {
            wp.z(e);
            return 0;
        }
    }

    public static int g(String str, String str2) {
        try {
            return com.ss.android.socialbase.downloader.downloader.dl.xl().getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            wp.z(e);
            return 0;
        }
    }
}
