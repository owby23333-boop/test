package com.anythink.basead.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.a.b.b;
import com.anythink.basead.c.e;
import com.anythink.basead.c.f;
import com.anythink.basead.d.a.b;
import com.anythink.basead.d.c.d;
import com.anythink.core.api.AdError;
import com.anythink.core.common.a.c;
import com.anythink.core.common.a.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.g.i;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile a f5964d;
    ConcurrentHashMap<String, Boolean> a = new ConcurrentHashMap<>(3);
    ConcurrentHashMap<String, g> b = new ConcurrentHashMap<>(2);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f5965c;

    /* JADX INFO: renamed from: com.anythink.basead.d.a.a$1, reason: invalid class name */
    final class AnonymousClass1 implements i {
        final /* synthetic */ j a;
        final /* synthetic */ InterfaceC0134a b;

        AnonymousClass1(j jVar, InterfaceC0134a interfaceC0134a) {
            this.a = jVar;
            this.b = interfaceC0134a;
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadCanceled(int i2) {
            InterfaceC0134a interfaceC0134a = this.b;
            if (interfaceC0134a != null) {
                interfaceC0134a.a((com.anythink.core.common.e.g) null, f.a(f.f5905i, "Cancel Request."));
            }
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadError(int i2, String str, AdError adError) {
            InterfaceC0134a interfaceC0134a = this.b;
            if (interfaceC0134a != null) {
                interfaceC0134a.a((com.anythink.core.common.e.g) null, f.a(f.f5905i, str));
            }
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadFinish(int i2, Object obj) {
            com.anythink.core.common.e.g gVarA;
            try {
                gVarA = c.a(this.a.a, new JSONObject(obj.toString()), this.a.f7305f);
            } catch (Exception unused) {
                gVarA = null;
            }
            if (gVarA == null) {
                InterfaceC0134a interfaceC0134a = this.b;
                if (interfaceC0134a != null) {
                    interfaceC0134a.a((com.anythink.core.common.e.g) null, f.a(f.f5905i, obj != null ? obj.toString() : "No Ad Return."));
                    return;
                }
                return;
            }
            com.anythink.basead.d.c.b.a(gVarA);
            com.anythink.basead.d.c.a.a(this.a, gVarA);
            d.a(this.a, gVarA);
            if (this.a.f7305f == 67) {
                com.anythink.core.common.d.c.a(a.this.f5965c).a(gVarA.p(), gVarA.P());
                com.anythink.core.common.d.b.a(a.this.f5965c).a(gVarA.q(), gVarA.P());
            }
            com.anythink.basead.a.b.a(10, gVarA, new com.anythink.basead.c.i(this.a.f7303d, ""));
            com.anythink.core.common.a.a aVarA = com.anythink.core.common.a.a.a();
            Context context = a.this.f5965c;
            j jVar = this.a;
            aVarA.a(context, jVar.f7305f, jVar.f7302c, jVar.a, obj.toString());
            com.anythink.expressad.foundation.d.d dVarA = a.this.a(gVarA, this.a);
            InterfaceC0134a interfaceC0134a2 = this.b;
            if (interfaceC0134a2 != null) {
                interfaceC0134a2.a(gVarA);
            }
            a.this.a(gVarA, this.a, dVarA, this.b);
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadStart(int i2) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.d.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0134a {
        void a(com.anythink.core.common.e.g gVar);

        void a(com.anythink.core.common.e.g gVar, e eVar);

        void a(com.anythink.core.common.e.g gVar, g gVar2);
    }

    private a(Context context) {
        this.f5965c = context.getApplicationContext();
    }

    private void b(j jVar, InterfaceC0134a interfaceC0134a) {
        com.anythink.core.common.e.g gVarA;
        try {
            gVarA = a(jVar);
        } catch (Throwable unused) {
            gVarA = null;
        }
        if (gVarA == null) {
            new com.anythink.basead.g.a(jVar).a(0, (i) new AnonymousClass1(jVar, interfaceC0134a));
            return;
        }
        com.anythink.core.common.a.a.a();
        if (!com.anythink.core.common.a.a.d(this.f5965c, gVarA.b())) {
            com.anythink.basead.a.b.a(10, gVarA, new com.anythink.basead.c.i(jVar.f7303d, ""));
            com.anythink.core.common.a.a.a();
            com.anythink.core.common.a.a.c(this.f5965c, gVarA.b());
        }
        com.anythink.expressad.foundation.d.d dVarA = a(gVarA, jVar);
        if (interfaceC0134a != null) {
            interfaceC0134a.a(gVarA);
        }
        a(gVarA, jVar, dVarA, interfaceC0134a);
    }

    public static a a(Context context) {
        if (f5964d == null) {
            synchronized (a.class) {
                if (f5964d == null) {
                    f5964d = new a(context);
                }
            }
        }
        return f5964d;
    }

    public final void a(j jVar, InterfaceC0134a interfaceC0134a) {
        com.anythink.core.common.e.g gVarA = null;
        if (this.a.contains(jVar.b + jVar.a)) {
            if (this.a.get(jVar.b + jVar.a).booleanValue()) {
                interfaceC0134a.a((com.anythink.core.common.e.g) null, f.a(f.f5903g, f.f5913q));
                return;
            }
        }
        this.a.put(jVar.b + jVar.a, Boolean.TRUE);
        try {
            gVarA = a(jVar);
        } catch (Throwable unused) {
        }
        if (gVarA == null) {
            new com.anythink.basead.g.a(jVar).a(0, (i) new AnonymousClass1(jVar, interfaceC0134a));
            return;
        }
        com.anythink.core.common.a.a.a();
        if (!com.anythink.core.common.a.a.d(this.f5965c, gVarA.b())) {
            com.anythink.basead.a.b.a(10, gVarA, new com.anythink.basead.c.i(jVar.f7303d, ""));
            com.anythink.core.common.a.a.a();
            com.anythink.core.common.a.a.c(this.f5965c, gVarA.b());
        }
        com.anythink.expressad.foundation.d.d dVarA = a(gVarA, jVar);
        interfaceC0134a.a(gVarA);
        a(gVarA, jVar, dVarA, interfaceC0134a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized com.anythink.expressad.foundation.d.d a(com.anythink.core.common.e.g gVar, j jVar) {
        if (TextUtils.isEmpty(gVar.a())) {
            return null;
        }
        com.anythink.expressad.foundation.d.d dVarA = com.anythink.expressad.foundation.d.d.a(gVar.a());
        ArrayList<com.anythink.expressad.foundation.d.c> arrayList = dVarA.J;
        b.a(gVar, arrayList.get(0));
        b.a(gVar, arrayList);
        b.a(jVar, arrayList);
        return dVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.anythink.core.common.e.g gVar, final j jVar, com.anythink.expressad.foundation.d.d dVar, final InterfaceC0134a interfaceC0134a) {
        if (!TextUtils.isEmpty(gVar.a())) {
            b.a().a(gVar, jVar, dVar, new b.a() { // from class: com.anythink.basead.d.a.a.2
                @Override // com.anythink.basead.d.a.b.a
                public final void a(g gVar2) {
                    a.this.a.put(jVar.b + jVar.a, Boolean.FALSE);
                    InterfaceC0134a interfaceC0134a2 = interfaceC0134a;
                    if (interfaceC0134a2 != null) {
                        interfaceC0134a2.a(gVar, gVar2);
                    }
                }

                @Override // com.anythink.basead.d.a.b.a
                public final void a(e eVar) {
                    a.this.a.put(jVar.b + jVar.a, Boolean.FALSE);
                    InterfaceC0134a interfaceC0134a2 = interfaceC0134a;
                    if (interfaceC0134a2 != null) {
                        interfaceC0134a2.a(gVar, eVar);
                    }
                }
            });
        } else {
            com.anythink.basead.a.f.a();
            com.anythink.basead.a.f.a(jVar.b, gVar, jVar, new b.InterfaceC0129b() { // from class: com.anythink.basead.d.a.a.3
                @Override // com.anythink.basead.a.b.b.InterfaceC0129b
                public final void a() {
                    a.this.a.put(jVar.b + jVar.a, Boolean.FALSE);
                    InterfaceC0134a interfaceC0134a2 = interfaceC0134a;
                    if (interfaceC0134a2 != null) {
                        interfaceC0134a2.a(gVar, (g) null);
                    }
                }

                @Override // com.anythink.basead.a.b.b.InterfaceC0129b
                public final void a(e eVar) {
                    a.this.a.put(jVar.b + jVar.a, Boolean.FALSE);
                    InterfaceC0134a interfaceC0134a2 = interfaceC0134a;
                    if (interfaceC0134a2 != null) {
                        interfaceC0134a2.a(gVar, eVar);
                    }
                }
            });
        }
    }

    public final com.anythink.core.common.e.g a(j jVar) {
        String strA = com.anythink.core.common.a.a.a().a(this.f5965c, jVar.a);
        com.anythink.core.common.e.g gVarA = null;
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        try {
            gVarA = c.a(jVar.a, new JSONObject(strA), jVar.f7305f);
        } catch (Throwable unused) {
        }
        if (gVarA != null) {
            com.anythink.basead.d.c.b.a(gVarA);
            com.anythink.basead.d.c.a.a(jVar, gVarA);
            d.a(jVar, gVarA);
        }
        return gVarA;
    }
}
