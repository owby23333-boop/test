package com.bytedance.sdk.openadsdk.downloadnew;

import android.content.Context;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.openadsdk.api.m;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static int z(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        } catch (Exception e) {
            m.z(e);
            return 0;
        }
    }

    public static int z(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            m.z(e);
            return 0;
        }
    }

    public static int g(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, TtmlNode.TAG_STYLE, context.getPackageName());
        } catch (Exception e) {
            m.z(e);
            return 0;
        }
    }

    public static int dl(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "id", context.getPackageName());
        } catch (Exception e) {
            m.z(e);
            return 0;
        }
    }

    public static int g(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            m.z(e);
            return 0;
        }
    }
}
