package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bv {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f16602d = new byte[0];
    private Context a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16603c;

    public bv(Context context, int i2, boolean z2) {
        this.a = context;
        this.b = z2;
        this.f16603c = i2;
    }

    public String a(String str) {
        try {
            synchronized (f16602d) {
                JSONObject jSONObjectA = new cl(str, cj.f16635j).a(this.a);
                if (jSONObjectA == null) {
                    return null;
                }
                JSONObject jSONObjectA2 = a();
                if (jSONObjectA2 == null) {
                    return null;
                }
                jSONObjectA.put("module_section", jSONObjectA2);
                return jSONObjectA.toString();
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x04f6 A[Catch: all -> 0x0569, TRY_ENTER, TryCatch #3 {all -> 0x0569, blocks: (B:92:0x039f, B:94:0x03a7, B:95:0x03ac, B:98:0x03c4, B:100:0x03d1, B:102:0x03da, B:104:0x03e3, B:106:0x03ec, B:108:0x03f5, B:110:0x03fe, B:112:0x0407, B:114:0x0410, B:116:0x0419, B:118:0x0422, B:120:0x042b, B:122:0x0434, B:124:0x043d, B:126:0x0446, B:128:0x044f, B:130:0x0458, B:132:0x0461, B:134:0x046a, B:136:0x0473, B:138:0x047c, B:140:0x04c0, B:143:0x04f6, B:145:0x0503, B:147:0x0509, B:149:0x0512, B:151:0x0518, B:153:0x0525, B:155:0x052d, B:157:0x053a, B:158:0x0540, B:160:0x0544, B:137:0x0478, B:133:0x0466, B:129:0x0454, B:125:0x0442, B:121:0x0430, B:117:0x041e, B:113:0x040c, B:109:0x03fa, B:105:0x03e8, B:101:0x03d6, B:139:0x0480), top: B:180:0x039f }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0544 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject a() {
        /*
            Method dump skipped, instruction units count: 1426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.bv.a():org.json.JSONObject");
    }
}
