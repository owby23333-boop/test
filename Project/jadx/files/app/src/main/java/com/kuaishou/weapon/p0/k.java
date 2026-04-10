package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k<T> implements Runnable {
    private String a;
    private JSONObject b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private j f16735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f16736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f16737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f16738f;

    public k(Context context, String str, String str2, String str3, JSONObject jSONObject, j jVar) {
        this.f16736d = context;
        this.a = str3;
        this.b = jSONObject;
        this.f16735c = jVar;
        this.f16737e = str;
        this.f16738f = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            l lVarA = l.a(this.f16736d);
            m mVar = new m(this.a, this.b);
            mVar.a(this.f16737e);
            mVar.b(this.f16738f);
            lVarA.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.k.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str) {
                    e.c("WeaponHttpTask sendLog response: --- " + str);
                    if (k.this.f16735c != null) {
                        k.this.f16735c.a(str);
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str) {
                    e.c("WeaponHttpTask sendLog errorMsg: --- " + str);
                    if (k.this.f16735c != null) {
                        k.this.f16735c.b(str);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
