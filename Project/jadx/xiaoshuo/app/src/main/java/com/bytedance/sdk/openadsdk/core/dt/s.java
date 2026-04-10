package com.bytedance.sdk.openadsdk.core.dt;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class s {
    private String bf;
    private int d;
    private String e;

    public s() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0000, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0008. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x000b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String s1691727045738dc(java.lang.String r2) {
        /*
        L0:
            r0 = 73
            r1 = 96
        L4:
            switch(r0) {
                case 72: goto L26;
                case 73: goto L8;
                case 74: goto Lb;
                default: goto L7;
            }
        L7:
            goto L2b
        L8:
            switch(r1) {
                case 94: goto L0;
                case 95: goto L26;
                case 96: goto L26;
                default: goto Lb;
            }
        Lb:
            switch(r1) {
                case 55: goto Lf;
                case 56: goto L26;
                case 57: goto L26;
                default: goto Le;
            }
        Le:
            goto L0
        Lf:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L14:
            int r1 = r2.length
            if (r0 >= r1) goto L20
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L14
        L20:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L26:
            r0 = 74
            r1 = 55
            goto L4
        L2b:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.dt.s.s1691727045738dc(java.lang.String):java.lang.String");
    }

    public String bf() {
        return this.bf;
    }

    public int d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public s(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        e(jSONObject.optString("deeplink_url"));
        bf(jSONObject.optString("fallback_url"));
        e(jSONObject.optInt("fallback_type"));
    }

    public void bf(String str) {
        this.bf = str;
    }

    public void e(int i) {
        this.d = i;
    }

    public void e(s sVar) {
        if (sVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(sVar.e())) {
            e(sVar.e());
        }
        if (!TextUtils.isEmpty(sVar.bf())) {
            bf(sVar.bf());
        }
        if (sVar.d() != 0) {
            e(sVar.d());
        }
    }

    public void e(String str) {
        this.e = str;
    }

    public void e(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deeplink_url", e());
            jSONObject2.put("fallback_url", bf());
            jSONObject2.put("fallback_type", d());
            jSONObject.put("deep_link", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
