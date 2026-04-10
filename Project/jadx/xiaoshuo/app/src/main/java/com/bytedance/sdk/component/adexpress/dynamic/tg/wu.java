package com.bytedance.sdk.component.adexpress.dynamic.tg;

import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.tg.bf;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.yuewen.qe0;
import com.yuewen.w51;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class wu {
    private static String bf;
    private static final Set<String> e = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", qe0.c.O, "close-fill", "webview-close")));

    public static double bf(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString(TtmlNode.ATTR_TTS_FONT_SIZE));
        } catch (Throwable unused) {
            return w51.l;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x03e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.adexpress.dynamic.tg.bf.d e(java.lang.String r18, java.lang.String r19, java.lang.String r20, boolean r21, boolean r22, int r23, com.bytedance.sdk.component.adexpress.dynamic.d.v r24, double r25, int r27, double r28, java.lang.String r30) {
        /*
            Method dump skipped, instruction units count: 1094
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.tg.wu.e(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.bytedance.sdk.component.adexpress.dynamic.d.v, double, int, double, java.lang.String):com.bytedance.sdk.component.adexpress.dynamic.tg.bf$d");
    }

    public static int[] bf(String str, float f, boolean z) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.tg.getContext());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static boolean bf() {
        return !TextUtils.isEmpty(bf);
    }

    public static String e(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static bf.d e(bf.d dVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            dVar.e = 0.0f;
            dVar.bf = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = e(str);
            }
            if (TextUtils.isEmpty(str3)) {
                dVar.e = 0.0f;
                dVar.bf = 0.0f;
            } else {
                return e(str3, str2);
            }
        }
        return dVar;
    }

    public static bf.d e(String str, String str2) {
        return e(str, str2, false);
    }

    public static bf.d e(String str, String str2, boolean z) {
        bf.d dVar = new bf.d();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrE = e(str, (float) bf(str2), z);
            dVar.e = iArrE[0];
            dVar.bf = iArrE[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == w51.l) {
                dVar.bf = 0.0f;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return dVar;
    }

    public static int[] e(String str, float f, boolean z) {
        int[] iArrBf = bf(str, f, z);
        return new int[]{com.bytedance.sdk.component.adexpress.d.bf.bf(com.bytedance.sdk.component.adexpress.tg.getContext(), iArrBf[0]), com.bytedance.sdk.component.adexpress.d.bf.bf(com.bytedance.sdk.component.adexpress.tg.getContext(), iArrBf[1])};
    }

    public static String e() {
        return bf;
    }
}
