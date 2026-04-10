package com.anythink.basead.f;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.a.b.b;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.s;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c implements a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f6030h = "extra_request_id";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f6031i = "extra_scenario";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f6032j = "extra_orientation";
    public String b = getClass().getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f6033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected j f6034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected String f6035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f6036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected s f6037g;

    public c(Context context, j jVar, String str, boolean z2) {
        this.f6033c = context.getApplicationContext();
        this.f6034d = jVar;
        this.f6035e = str;
        this.f6036f = z2;
    }

    private com.anythink.basead.c.e b() {
        if (TextUtils.isEmpty(this.f6035e) || TextUtils.isEmpty(this.f6034d.b)) {
            return com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5905i, com.anythink.basead.c.f.f5917u);
        }
        this.f6037g = com.anythink.basead.f.a.a.a(this.f6033c).a(this.f6034d.b, this.f6035e);
        if (this.f6037g == null) {
            return com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5905i, com.anythink.basead.c.f.f5920x);
        }
        if (this.f6034d.f7312m == null) {
            return com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5906j, com.anythink.basead.c.f.f5921y);
        }
        return null;
    }

    @Override // com.anythink.basead.f.a
    public boolean a() {
        try {
            if (d()) {
                return com.anythink.basead.f.a.a.a(this.f6033c).a(this.f6037g, this.f6034d, this.f6036f);
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void c() {
    }

    protected final boolean d() {
        if (this.f6033c == null || TextUtils.isEmpty(this.f6034d.b) || TextUtils.isEmpty(this.f6035e)) {
            return false;
        }
        if (this.f6037g != null) {
            return true;
        }
        this.f6037g = com.anythink.basead.f.a.a.a(this.f6033c).a(this.f6034d.b, this.f6035e);
        return this.f6037g != null;
    }

    public final s e() {
        return this.f6037g;
    }

    @Override // com.anythink.basead.f.a
    public final void a(final com.anythink.basead.e.c cVar) {
        com.anythink.basead.c.e eVarA;
        try {
            if (!TextUtils.isEmpty(this.f6035e) && !TextUtils.isEmpty(this.f6034d.b)) {
                this.f6037g = com.anythink.basead.f.a.a.a(this.f6033c).a(this.f6034d.b, this.f6035e);
                if (this.f6037g == null) {
                    eVarA = com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5905i, com.anythink.basead.c.f.f5920x);
                } else {
                    eVarA = this.f6034d.f7312m == null ? com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5906j, com.anythink.basead.c.f.f5921y) : null;
                }
            } else {
                eVarA = com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5905i, com.anythink.basead.c.f.f5917u);
            }
            if (eVarA != null) {
                cVar.onAdLoadFailed(eVarA);
            } else {
                com.anythink.basead.f.a.a.a(this.f6033c).a(this.f6034d.b, this.f6037g, this.f6034d, new b.InterfaceC0129b() { // from class: com.anythink.basead.f.c.1
                    @Override // com.anythink.basead.a.b.b.InterfaceC0129b
                    public final void a() {
                        com.anythink.basead.e.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onAdCacheLoaded();
                        }
                    }

                    @Override // com.anythink.basead.a.b.b.InterfaceC0129b
                    public final void a(com.anythink.basead.c.e eVar) {
                        com.anythink.basead.e.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.onAdLoadFailed(eVar);
                        }
                    }
                });
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", e2.getMessage()));
        }
    }
}
