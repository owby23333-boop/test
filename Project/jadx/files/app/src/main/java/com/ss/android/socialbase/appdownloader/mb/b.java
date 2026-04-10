package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.taobao.accs.common.Constants;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b extends mb {
    private final JSONObject hj;

    public b(Context context, DownloadSetting downloadSetting, String str, JSONObject jSONObject) {
        super(context, downloadSetting, str);
        this.hj = jSONObject;
    }

    private static void mb(@NonNull Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (itKeys = jSONObject.keys()) == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject2.optString(next);
            if (strOptString != null) {
                mb(jSONObject, next, strOptString, intent);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        String strOptString = this.hj.optString(NativeAdvancedJsUtils.f8246p);
        String strOptString2 = this.hj.optString("category");
        int iOptInt = this.hj.optInt(Constants.KEY_FLAGS, 1342210048);
        String strOptString3 = this.hj.optString("path_extra_key");
        String strOptString4 = this.hj.optString("path_data_key");
        JSONObject jSONObjectOptJSONObject = this.hj.optJSONObject("extra");
        JSONObject jSONObjectOptJSONObject2 = this.hj.optJSONObject("extra_type");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        Intent intent = new Intent(strOptString);
        if (!TextUtils.isEmpty(strOptString2)) {
            intent.addCategory(strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                intent.setData(Uri.parse(String.format(strOptString4, this.b)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(iOptInt);
        if (!TextUtils.isEmpty(strOptString3)) {
            intent.putExtra(strOptString3, this.b);
        }
        mb(intent, jSONObjectOptJSONObject, jSONObjectOptJSONObject2);
        return intent;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void mb(org.json.JSONObject r5, java.lang.String r6, java.lang.String r7, android.content.Intent r8) {
        /*
            int r0 = r7.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1325958191: goto L34;
                case -891985903: goto L2a;
                case 104431: goto L20;
                case 3327612: goto L16;
                case 64711720: goto Lc;
                default: goto Lb;
            }
        Lb:
            goto L3e
        Lc:
            java.lang.String r0 = "boolean"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3e
            r7 = 1
            goto L3f
        L16:
            java.lang.String r0 = "long"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3e
            r7 = 2
            goto L3f
        L20:
            java.lang.String r0 = "int"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3e
            r7 = 0
            goto L3f
        L2a:
            java.lang.String r0 = "string"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3e
            r7 = 4
            goto L3f
        L34:
            java.lang.String r0 = "double"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3e
            r7 = 3
            goto L3f
        L3e:
            r7 = -1
        L3f:
            if (r7 == 0) goto L6a
            if (r7 == r4) goto L62
            if (r7 == r3) goto L5a
            if (r7 == r2) goto L52
            if (r7 == r1) goto L4a
            goto L71
        L4a:
            java.lang.String r5 = r5.optString(r6)
            r8.putExtra(r6, r5)
            goto L71
        L52:
            double r0 = r5.optDouble(r6)
            r8.putExtra(r6, r0)
            goto L71
        L5a:
            long r0 = r5.optLong(r6)
            r8.putExtra(r6, r0)
            goto L71
        L62:
            boolean r5 = r5.optBoolean(r6)
            r8.putExtra(r6, r5)
            goto L71
        L6a:
            int r5 = r5.optInt(r6)
            r8.putExtra(r6, r5)
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.mb.b.mb(org.json.JSONObject, java.lang.String, java.lang.String, android.content.Intent):void");
    }
}
