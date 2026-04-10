package com.anythink.basead.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.a.c;
import com.anythink.basead.d.a.a;
import com.anythink.basead.d.b.a;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.z;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    private a a;
    protected Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected j f5980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected c f5981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected aa f5982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.anythink.core.common.a.g f5983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected com.anythink.basead.a.c f5984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected com.anythink.basead.e.a f5985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected ConcurrentHashMap<String, com.anythink.basead.a.c> f5986i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f5987j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5988k = false;

    /* JADX INFO: renamed from: com.anythink.basead.d.b$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] a = new int[a.values().length];

        static {
            try {
                a[a.ADX_OFFER_REQUEST_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.ONLINE_API_OFFER_REQUEST_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum a {
        ADX_OFFER_REQUEST_TYPE,
        ONLINE_API_OFFER_REQUEST_TYPE
    }

    public b(Context context, a aVar, j jVar) {
        this.b = context.getApplicationContext();
        this.a = aVar;
        this.f5980c = jVar;
    }

    static /* synthetic */ boolean a(b bVar) {
        bVar.f5988k = true;
        return true;
    }

    private void b(com.anythink.basead.e.c cVar) {
        try {
            if (this.f5980c != null && !TextUtils.isEmpty(this.f5980c.b) && !TextUtils.isEmpty(this.f5980c.a)) {
                com.anythink.basead.d.a.a.a(this.b).a(this.f5980c, new AnonymousClass1(cVar));
                return;
            }
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5905i, com.anythink.basead.c.f.f5918v));
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th.getMessage()));
            }
        }
    }

    public final boolean c() {
        int i2 = AnonymousClass4.a[this.a.ordinal()];
        if (i2 == 1) {
            if (this.f5982e == null) {
                this.f5982e = com.anythink.basead.d.a.a.a(this.b).a(this.f5980c);
            }
            com.anythink.core.common.a.g gVar = this.f5983f;
            if (gVar != null) {
                return gVar.isReady();
            }
            if (this.f5988k) {
                return true;
            }
            aa aaVar = this.f5982e;
            if (aaVar == null || !com.anythink.basead.a.b.c.a(aaVar, this.f5980c)) {
                return false;
            }
            this.f5988k = true;
            return true;
        }
        if (i2 != 2) {
            return false;
        }
        if (this.f5982e == null) {
            this.f5982e = com.anythink.basead.d.b.a.a(this.b).a(this.f5980c);
        }
        if (this.f5988k) {
            return true;
        }
        aa aaVar2 = this.f5982e;
        if (aaVar2 == null || !(aaVar2 instanceof z) || ((z) aaVar2).N() || !com.anythink.basead.a.b.c.a(this.f5982e, this.f5980c)) {
            return false;
        }
        this.f5988k = true;
        return true;
    }

    public final com.anythink.core.common.e.i d() {
        return this.f5982e;
    }

    /* JADX INFO: renamed from: com.anythink.basead.d.b$2, reason: invalid class name */
    final class AnonymousClass2 implements a.InterfaceC0137a {
        final /* synthetic */ com.anythink.basead.e.c a;

        AnonymousClass2(com.anythink.basead.e.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.basead.d.b.a.InterfaceC0137a
        public final void a() {
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.d.b.a.InterfaceC0137a
        public final void a(z zVar) {
            b bVar = b.this;
            bVar.f5982e = zVar;
            com.anythink.basead.a.b.a(33, b.this.f5982e, new com.anythink.basead.c.i(bVar.f5980c.f7303d, ""));
            b.a(b.this);
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdCacheLoaded();
            }
        }

        @Override // com.anythink.basead.d.b.a.InterfaceC0137a
        public final void a(z zVar, com.anythink.basead.c.e eVar) {
            b.a(b.this, zVar, eVar, this.a, false);
        }
    }

    public final void a(String str) {
        this.f5987j = str;
    }

    /* JADX INFO: renamed from: com.anythink.basead.d.b$1, reason: invalid class name */
    final class AnonymousClass1 implements a.InterfaceC0134a {
        final /* synthetic */ com.anythink.basead.e.c a;

        AnonymousClass1(com.anythink.basead.e.c cVar) {
            this.a = cVar;
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0134a
        public final void a(com.anythink.core.common.e.g gVar) {
            b.this.a(gVar);
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdDataLoaded();
            }
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0134a
        public final void a(com.anythink.core.common.e.g gVar, com.anythink.core.common.a.g gVar2) {
            b bVar = b.this;
            bVar.f5982e = gVar;
            bVar.f5983f = gVar2;
            bVar.f5984g = new com.anythink.basead.a.c(bVar.b, bVar.f5980c, bVar.f5982e);
            b.this.f5984g.a(new c.b() { // from class: com.anythink.basead.d.b.1.1
                @Override // com.anythink.basead.a.c.b
                public final void a() {
                    com.anythink.basead.e.a aVar = b.this.f5985h;
                    if (aVar != null) {
                        aVar.onAdClick(1);
                    }
                }

                @Override // com.anythink.basead.a.c.b
                public final void b() {
                }

                @Override // com.anythink.basead.a.c.b
                public final void a(boolean z2) {
                    com.anythink.basead.e.a aVar = b.this.f5985h;
                    if (aVar != null) {
                        aVar.onDeeplinkCallback(z2);
                    }
                }
            });
            com.anythink.basead.a.b.a(33, gVar, new com.anythink.basead.c.i(b.this.f5980c.f7303d, ""));
            b.a(b.this);
            com.anythink.basead.e.c cVar = this.a;
            if (cVar != null) {
                cVar.onAdCacheLoaded();
            }
        }

        @Override // com.anythink.basead.d.a.a.InterfaceC0134a
        public final void a(com.anythink.core.common.e.g gVar, com.anythink.basead.c.e eVar) {
            b.a(b.this, gVar, eVar, this.a, true);
        }
    }

    public final void a(c cVar) {
        this.f5981d = cVar;
        k kVar = this.f5980c.f7312m;
        if (kVar instanceof ab) {
            ab abVar = (ab) kVar;
            c cVar2 = this.f5981d;
            if (abVar == null || cVar2 == null) {
                return;
            }
            abVar.v(cVar2.a());
            abVar.w(cVar2.b());
            abVar.a(cVar2.d());
            abVar.p(cVar2.c());
            abVar.o(cVar2.e());
            abVar.b(cVar2.f());
            abVar.n(cVar2.g());
            abVar.a(cVar2.h());
            abVar.b(cVar2.i());
            abVar.b(cVar2.j());
        }
    }

    public void b() {
        this.f5982e = null;
    }

    public final void a(com.anythink.basead.e.a aVar) {
        this.f5985h = aVar;
    }

    private void c(com.anythink.basead.e.c cVar) {
        try {
            com.anythink.basead.d.b.a.a(this.b).a(this.f5980c, this.f5987j, new AnonymousClass2(cVar));
        } catch (Throwable th) {
            th.printStackTrace();
            if (cVar != null) {
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th.getMessage()));
            }
        }
    }

    public final void a(com.anythink.basead.e.c cVar) {
        int i2 = AnonymousClass4.a[this.a.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            try {
                com.anythink.basead.d.b.a.a(this.b).a(this.f5980c, this.f5987j, new AnonymousClass2(cVar));
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th.getMessage()));
                return;
            }
        }
        try {
            if (this.f5980c != null && !TextUtils.isEmpty(this.f5980c.b) && !TextUtils.isEmpty(this.f5980c.a)) {
                com.anythink.basead.d.a.a.a(this.b).a(this.f5980c, new AnonymousClass1(cVar));
                return;
            }
            cVar.onAdLoadFailed(com.anythink.basead.c.f.a(com.anythink.basead.c.f.f5905i, com.anythink.basead.c.f.f5918v));
        } catch (Throwable th2) {
            th2.printStackTrace();
            cVar.onAdLoadFailed(com.anythink.basead.c.f.a("-9999", th2.getMessage()));
        }
    }

    protected final String a(aa aaVar) {
        return this.f5980c.b + this.f5980c.f7302c + this.f5980c.f7305f + aaVar.p() + System.currentTimeMillis();
    }

    private void a(com.anythink.core.common.e.i iVar, com.anythink.basead.c.e eVar, com.anythink.basead.e.c cVar, boolean z2) {
        if (iVar != null) {
            com.anythink.basead.a.b.a(34, iVar, new com.anythink.basead.c.i(this.f5980c.f7303d, ""));
        }
        if (iVar instanceof z) {
            com.anythink.core.basead.b.a();
            Context contextG = n.a().g();
            com.anythink.core.basead.b.a();
            com.anythink.core.basead.b.b(contextG, com.anythink.core.basead.b.a(this.f5980c));
        }
        if (z2) {
            try {
                com.anythink.core.b.f.a().a(this.f5980c.f7302c);
                com.anythink.core.b.f.a();
                com.anythink.core.b.f.b(this.f5980c.f7302c);
                com.anythink.core.common.a.a.a().b(n.a().g(), this.f5980c.a);
            } catch (Throwable unused) {
            }
        }
        if (cVar != null) {
            cVar.onAdLoadFailed(eVar);
        }
    }

    protected final synchronized void a(com.anythink.expressad.foundation.d.c cVar, String str) {
        try {
            if (this.f5984g == null) {
                return;
            }
            if (this.f5986i == null) {
                this.f5986i = new ConcurrentHashMap<>(2);
            }
            com.anythink.basead.a.c cVarA = this.f5986i.get(cVar.aZ());
            if (cVarA == null) {
                cVarA = com.anythink.basead.d.a.b.a(this.f5984g, cVar);
                this.f5986i.put(cVar.aZ(), cVarA);
            }
            if (cVarA != null) {
                com.anythink.basead.c.i iVar = new com.anythink.basead.c.i(this.f5980c.f7303d, str);
                iVar.f5935g = new com.anythink.basead.c.a();
                cVarA.a(new c.b() { // from class: com.anythink.basead.d.b.3
                    @Override // com.anythink.basead.a.c.b
                    public final void a() {
                        com.anythink.basead.e.a aVar = b.this.f5985h;
                        if (aVar != null) {
                            aVar.onAdClick(1);
                        }
                    }

                    @Override // com.anythink.basead.a.c.b
                    public final void b() {
                    }

                    @Override // com.anythink.basead.a.c.b
                    public final void a(boolean z2) {
                        com.anythink.basead.e.a aVar = b.this.f5985h;
                        if (aVar != null) {
                            aVar.onDeeplinkCallback(z2);
                        }
                    }
                });
                cVarA.a(iVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected final void a(com.anythink.core.common.e.g gVar) {
        if (gVar.c() == 1) {
            com.anythink.core.common.a.b.a().b();
            if (com.anythink.core.common.k.h.a(this.b, gVar.B())) {
                StringBuilder sb = new StringBuilder("check offer installed(onAdDataLoaded):ture,dsp offerid:");
                sb.append(gVar.U());
                sb.append(",packagename:");
                sb.append(gVar.B());
                com.anythink.core.common.a.b.a().c(gVar);
                return;
            }
            StringBuilder sb2 = new StringBuilder("check offer installed(onAdDataLoaded):false,need record show,dsp offerid:");
            sb2.append(gVar.U());
            sb2.append(",packagename:");
            sb2.append(gVar.B());
            com.anythink.core.common.a.b.a().a(gVar);
        }
    }

    static /* synthetic */ void a(b bVar, com.anythink.core.common.e.i iVar, com.anythink.basead.c.e eVar, com.anythink.basead.e.c cVar, boolean z2) {
        if (iVar != null) {
            com.anythink.basead.a.b.a(34, iVar, new com.anythink.basead.c.i(bVar.f5980c.f7303d, ""));
        }
        if (iVar instanceof z) {
            com.anythink.core.basead.b.a();
            Context contextG = n.a().g();
            com.anythink.core.basead.b.a();
            com.anythink.core.basead.b.b(contextG, com.anythink.core.basead.b.a(bVar.f5980c));
        }
        if (z2) {
            try {
                com.anythink.core.b.f.a().a(bVar.f5980c.f7302c);
                com.anythink.core.b.f.a();
                com.anythink.core.b.f.b(bVar.f5980c.f7302c);
                com.anythink.core.common.a.a.a().b(n.a().g(), bVar.f5980c.a);
            } catch (Throwable unused) {
            }
        }
        if (cVar != null) {
            cVar.onAdLoadFailed(eVar);
        }
    }
}
