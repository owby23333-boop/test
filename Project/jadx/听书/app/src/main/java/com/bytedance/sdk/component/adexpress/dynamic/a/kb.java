package com.bytedance.sdk.component.adexpress.dynamic.a;

import android.text.TextUtils;
import android.widget.TextView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.android.live.base.api.push.ILivePush;
import com.bytedance.sdk.component.adexpress.dynamic.a.g;
import com.bytedance.sdk.component.utils.wp;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kb {
    private static String g;
    private static final Set<String> z = Collections.unmodifiableSet(new HashSet(Arrays.asList("dislike", ILivePush.ClickType.CLOSE, "close-fill", "webview-close")));

    /* JADX WARN: Removed duplicated region for block: B:218:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x048d A[Catch: Exception -> 0x049e, JSONException -> 0x04a3, TryCatch #0 {Exception -> 0x049e, blocks: (B:219:0x0482, B:221:0x048d, B:226:0x0497), top: B:272:0x0482 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.adexpress.dynamic.a.g.dl z(java.lang.String r19, java.lang.String r20, java.lang.String r21, boolean r22, boolean r23, int r24, com.bytedance.sdk.component.adexpress.dynamic.dl.gz r25, double r26, int r28, double r29, java.lang.String r31, com.bytedance.sdk.component.adexpress.g.i r32) {
        /*
            Method dump skipped, instruction units count: 1352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.a.kb.z(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, com.bytedance.sdk.component.adexpress.dynamic.dl.gz, double, int, double, java.lang.String, com.bytedance.sdk.component.adexpress.g.i):com.bytedance.sdk.component.adexpress.dynamic.a.g$dl");
    }

    public static String z(String str) {
        String[] strArrSplit;
        return (TextUtils.isEmpty(str) || (strArrSplit = str.split("adx:")) == null || strArrSplit.length < 2) ? "" : strArrSplit[1];
    }

    private static g.dl z(g.dl dlVar, String str, String str2, String str3) {
        if (str.contains("union")) {
            dlVar.z = 0.0f;
            dlVar.g = 0.0f;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = z(str);
            }
            if (TextUtils.isEmpty(str3)) {
                dlVar.z = 0.0f;
                dlVar.g = 0.0f;
            } else {
                return z(str3, str2);
            }
        }
        return dlVar;
    }

    public static g.dl z(String str, String str2) {
        return z(str, str2, false);
    }

    public static g.dl z(String str, String str2, boolean z2) {
        g.dl dlVar = new g.dl();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            int[] iArrZ = z(str, (float) g(str2), z2);
            dlVar.z = iArrZ[0];
            dlVar.g = iArrZ[1];
            if (jSONObject.optDouble("lineHeight", 1.0d) == 0.0d) {
                dlVar.g = 0.0f;
            }
        } catch (Exception e) {
            wp.z(e);
        }
        return dlVar;
    }

    public static double g(String str) {
        try {
            return Double.parseDouble(new JSONObject(str).optString(TtmlNode.ATTR_TTS_FONT_SIZE));
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int[] z(String str, float f, boolean z2) {
        int[] iArrG = g(str, f, z2);
        return new int[]{com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), iArrG[0]), com.bytedance.sdk.component.adexpress.a.gz.g(com.bytedance.sdk.component.adexpress.a.getContext(), iArrG[1])};
    }

    public static int[] g(String str, float f, boolean z2) {
        try {
            TextView textView = new TextView(com.bytedance.sdk.component.adexpress.a.getContext());
            textView.setTextSize(f);
            textView.setText(str);
            textView.setIncludeFontPadding(false);
            if (z2) {
                textView.setSingleLine();
            }
            textView.measure(-2, -2);
            return new int[]{textView.getMeasuredWidth() + 2, textView.getMeasuredHeight() + 2};
        } catch (Exception unused) {
            return new int[]{0, 0};
        }
    }

    public static String z() {
        return g;
    }

    public static boolean g() {
        return !TextUtils.isEmpty(g);
    }
}
