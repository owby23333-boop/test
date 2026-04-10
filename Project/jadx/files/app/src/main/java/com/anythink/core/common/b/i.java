package com.anythink.core.common.b;

import android.text.TextUtils;
import com.reyun.mobdna.MobClientInfo;
import com.reyun.mobdna.MobDNA;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static volatile i b;
    private final String a = i.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f6932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f6933e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f6934f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f6935g;

    public static i a() {
        if (b == null) {
            synchronized (i.class) {
                if (b == null) {
                    b = new i();
                }
            }
        }
        return b;
    }

    private boolean e() {
        return (TextUtils.isEmpty(this.f6931c) || TextUtils.isEmpty(this.f6932d) || TextUtils.isEmpty(this.f6933e)) ? false : true;
    }

    public final String b() {
        return this.f6931c;
    }

    public final String c() {
        return this.f6932d;
    }

    public final String d() {
        return this.f6933e;
    }

    public final void a(int i2, com.anythink.core.common.e.e eVar) {
        if (eVar != null) {
            if (i2 == 4 || i2 == 6) {
                com.anythink.core.c.a aVarB = com.anythink.core.c.b.a(n.a().g()).b(n.a().p());
                if (n.a().H()) {
                    a(aVarB);
                    if (e()) {
                        String string = "";
                        try {
                            Map<String, Object> mapM = n.a().m();
                            if (mapM != null) {
                                string = mapM.get("user_id").toString();
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            if (aVarB.h() == 1 && i2 == 4) {
                                MobDNA.dna_event_ad(string, eVar.H(), eVar.k(), String.valueOf(eVar.w()), 2);
                            } else if (aVarB.f() == 1 && i2 == 6) {
                                MobDNA.dna_event_ad(string, eVar.H(), eVar.k(), String.valueOf(eVar.w()), 3);
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            }
        }
    }

    public final synchronized boolean a(com.anythink.core.c.a aVar) {
        if (this.f6935g) {
            return true;
        }
        if (aVar == null || aVar.d() != 1) {
            return false;
        }
        try {
            if (TextUtils.isEmpty(this.f6931c) || TextUtils.isEmpty(this.f6932d) || TextUtils.isEmpty(this.f6933e)) {
                MobClientInfo clientInfo = MobDNA.getClientInfo(n.a().g());
                if (clientInfo == null) {
                    return false;
                }
                this.f6931c = clientInfo.oid;
                this.f6932d = clientInfo.appkey;
                this.f6933e = clientInfo.rdid;
                StringBuilder sb = new StringBuilder("oid: ");
                sb.append(this.f6931c);
                sb.append(", appkey: ");
                sb.append(this.f6932d);
                sb.append(", rdid: ");
                sb.append(this.f6933e);
            }
        } catch (Throwable unused) {
        }
        this.f6935g = e();
        if (!this.f6934f && this.f6935g) {
            this.f6934f = true;
            com.anythink.core.common.j.c.b(this.f6931c, this.f6932d, this.f6933e);
        }
        return this.f6935g;
    }
}
