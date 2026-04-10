package com.bytedance.sdk.openadsdk.core.dt;

import com.xiaomi.verificationsdk.internal.Constants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class tg {
    private String bf;
    private String d;
    private String e;
    private int ga;
    private String p;
    private int tg;
    private int vn;

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
    public static java.lang.String tg1691727045736dc(java.lang.String r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.dt.tg.tg1691727045736dc(java.lang.String):java.lang.String");
    }

    public String bf() {
        return this.e;
    }

    public String d() {
        return this.bf;
    }

    public String e() {
        return this.p;
    }

    public int ga() {
        return this.tg;
    }

    public int p() {
        return this.vn;
    }

    public String tg() {
        return this.d;
    }

    public JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.APP_NAME, d());
            jSONObject.put("app_size", p());
            jSONObject.put("comment_num", vn());
            jSONObject.put("download_url", bf());
            jSONObject.put("package_name", tg());
            jSONObject.put("score", ga());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wu.d(e.toString());
        }
        return jSONObject;
    }

    public int vn() {
        return this.ga;
    }

    public void bf(int i) {
        this.ga = i;
    }

    public void d(int i) {
        this.vn = i;
    }

    public void e(int i) {
        this.tg = i;
    }

    public void tg(String str) {
        this.d = str;
    }

    public void bf(String str) {
        this.e = str;
    }

    public void d(String str) {
        this.bf = str;
    }

    public void e(String str) {
        this.p = str;
    }
}
