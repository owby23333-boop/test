package com.anythink.basead.d.b;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.a.b.b;
import com.anythink.basead.c.e;
import com.anythink.basead.c.f;
import com.anythink.basead.d.c.c;
import com.anythink.basead.g.d;
import com.anythink.core.api.AdError;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.z;
import com.anythink.core.common.g.i;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile a f5990c;
    ConcurrentHashMap<String, Boolean> a = new ConcurrentHashMap<>(3);
    private Context b;

    /* JADX INFO: renamed from: com.anythink.basead.d.b.a$1, reason: invalid class name */
    final class AnonymousClass1 implements i {
        final /* synthetic */ j a;
        final /* synthetic */ InterfaceC0137a b;

        AnonymousClass1(j jVar, InterfaceC0137a interfaceC0137a) {
            this.a = jVar;
            this.b = interfaceC0137a;
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadCanceled(int i2) {
            InterfaceC0137a interfaceC0137a = this.b;
            if (interfaceC0137a != null) {
                interfaceC0137a.a(null, f.a(f.f5905i, "Cancel Request."));
            }
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadError(int i2, String str, AdError adError) {
            InterfaceC0137a interfaceC0137a = this.b;
            if (interfaceC0137a != null) {
                interfaceC0137a.a(null, f.a(f.f5905i, str));
            }
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadFinish(int i2, Object obj) {
            JSONObject jSONObject;
            z zVarA;
            try {
                jSONObject = new JSONObject(obj.toString());
            } catch (Exception unused) {
                jSONObject = null;
            }
            try {
                jSONObject.put(b.a, System.currentTimeMillis());
                zVarA = b.a(this.a, jSONObject);
            } catch (Exception unused2) {
                zVarA = null;
            }
            if (zVarA == null) {
                InterfaceC0137a interfaceC0137a = this.b;
                if (interfaceC0137a != null) {
                    interfaceC0137a.a(null, f.a(f.f5905i, obj != null ? obj.toString() : "No Ad Return."));
                    return;
                }
                return;
            }
            com.anythink.basead.d.c.b.a(zVarA);
            if (zVarA.b() == 1 && com.anythink.basead.a.b.a(a.this.b.getApplicationContext(), zVarA.B())) {
                c cVarA = c.a();
                Context context = a.this.b;
                j jVar = this.a;
                cVarA.a(context, c.a(jVar.b, jVar.f7302c), zVarA, this.a.f7312m);
                InterfaceC0137a interfaceC0137a2 = this.b;
                if (interfaceC0137a2 != null) {
                    interfaceC0137a2.a(null, f.a(f.f5905i, "Application installed."));
                    return;
                }
                return;
            }
            if (zVarA.b() == 2 && !com.anythink.basead.a.b.a(a.this.b.getApplicationContext(), zVarA.B())) {
                c cVarA2 = c.a();
                Context context2 = a.this.b;
                j jVar2 = this.a;
                cVarA2.a(context2, c.a(jVar2.b, jVar2.f7302c), zVarA, this.a.f7312m);
                InterfaceC0137a interfaceC0137a3 = this.b;
                if (interfaceC0137a3 != null) {
                    interfaceC0137a3.a(null, f.a(f.f5905i, "Application not installed yet."));
                    return;
                }
                return;
            }
            com.anythink.basead.d.c.a.a(this.a, zVarA);
            com.anythink.basead.a.b.a(10, zVarA, new com.anythink.basead.c.i(this.a.f7303d, ""));
            com.anythink.core.basead.b.a();
            Context context3 = a.this.b;
            com.anythink.core.basead.b.a();
            com.anythink.core.basead.b.a(context3, com.anythink.core.basead.b.a(this.a), jSONObject.toString());
            InterfaceC0137a interfaceC0137a4 = this.b;
            if (interfaceC0137a4 != null) {
                interfaceC0137a4.a();
            }
            a.this.a(zVarA, this.a, this.b);
        }

        @Override // com.anythink.core.common.g.i
        public final void onLoadStart(int i2) {
        }
    }

    /* JADX INFO: renamed from: com.anythink.basead.d.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0137a {
        void a();

        void a(z zVar);

        void a(z zVar, e eVar);
    }

    private a(Context context) {
        this.b = context.getApplicationContext();
    }

    private void b(j jVar, String str, InterfaceC0137a interfaceC0137a) {
        z zVarA;
        int i2;
        int i3;
        int i4;
        try {
            zVarA = a(jVar);
        } catch (Throwable unused) {
            zVarA = null;
        }
        if (zVarA != null && !zVarA.N()) {
            if (interfaceC0137a != null) {
                interfaceC0137a.a();
            }
            a(zVarA, jVar, interfaceC0137a);
            return;
        }
        if (!TextUtils.isEmpty(jVar.f7312m.r())) {
            try {
                String[] strArrSplit = jVar.f7312m.r().split("x");
                i2 = Integer.parseInt(strArrSplit[0]);
                try {
                    i4 = Integer.parseInt(strArrSplit[1]);
                    i3 = i2;
                } catch (Throwable unused2) {
                    i3 = i2;
                    i4 = 0;
                }
            } catch (Throwable unused3) {
                i2 = 0;
            }
            new d(jVar, i3, i4, c.a().a(this.b, c.a(jVar.b, jVar.f7302c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0137a));
        }
        i3 = 0;
        i4 = 0;
        new d(jVar, i3, i4, c.a().a(this.b, c.a(jVar.b, jVar.f7302c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0137a));
    }

    public static a a(Context context) {
        if (f5990c == null) {
            synchronized (a.class) {
                if (f5990c == null) {
                    f5990c = new a(context);
                }
            }
        }
        return f5990c;
    }

    public final void a(j jVar, String str, InterfaceC0137a interfaceC0137a) {
        int i2;
        int i3;
        int i4;
        com.anythink.core.basead.b.a();
        String strA = com.anythink.core.basead.b.a(jVar);
        z zVarA = null;
        if (this.a.contains(strA) && this.a.get(strA).booleanValue()) {
            interfaceC0137a.a(null, f.a(f.f5903g, f.f5913q));
            return;
        }
        this.a.put(strA, Boolean.TRUE);
        try {
            zVarA = a(jVar);
        } catch (Throwable unused) {
        }
        if (zVarA != null && !zVarA.N()) {
            interfaceC0137a.a();
            a(zVarA, jVar, interfaceC0137a);
            return;
        }
        if (!TextUtils.isEmpty(jVar.f7312m.r())) {
            try {
                String[] strArrSplit = jVar.f7312m.r().split("x");
                i2 = Integer.parseInt(strArrSplit[0]);
                try {
                    i4 = Integer.parseInt(strArrSplit[1]);
                    i3 = i2;
                } catch (Throwable unused2) {
                    i3 = i2;
                    i4 = 0;
                }
            } catch (Throwable unused3) {
                i2 = 0;
            }
            new d(jVar, i3, i4, c.a().a(this.b, c.a(jVar.b, jVar.f7302c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0137a));
        }
        i3 = 0;
        i4 = 0;
        new d(jVar, i3, i4, c.a().a(this.b, c.a(jVar.b, jVar.f7302c)), str).a(0, (i) new AnonymousClass1(jVar, interfaceC0137a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final z zVar, final j jVar, final InterfaceC0137a interfaceC0137a) {
        com.anythink.basead.a.f.a();
        com.anythink.basead.a.f.a(jVar.b, zVar, jVar, new b.InterfaceC0129b() { // from class: com.anythink.basead.d.b.a.2
            @Override // com.anythink.basead.a.b.b.InterfaceC0129b
            public final void a() {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.a;
                com.anythink.core.basead.b.a();
                concurrentHashMap.put(com.anythink.core.basead.b.a(jVar), Boolean.FALSE);
                InterfaceC0137a interfaceC0137a2 = interfaceC0137a;
                if (interfaceC0137a2 != null) {
                    interfaceC0137a2.a(zVar);
                }
            }

            @Override // com.anythink.basead.a.b.b.InterfaceC0129b
            public final void a(e eVar) {
                ConcurrentHashMap<String, Boolean> concurrentHashMap = a.this.a;
                com.anythink.core.basead.b.a();
                concurrentHashMap.put(com.anythink.core.basead.b.a(jVar), Boolean.FALSE);
                InterfaceC0137a interfaceC0137a2 = interfaceC0137a;
                if (interfaceC0137a2 != null) {
                    interfaceC0137a2.a(zVar, eVar);
                }
            }
        });
    }

    public final z a(j jVar) {
        com.anythink.core.basead.b.a();
        String strA = com.anythink.core.basead.b.a(jVar);
        com.anythink.core.basead.b.a();
        String strA2 = com.anythink.core.basead.b.a(this.b, strA);
        z zVarA = null;
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        try {
            zVarA = b.a(jVar, new JSONObject(strA2));
        } catch (Throwable unused) {
        }
        if (zVarA != null) {
            com.anythink.basead.d.c.b.a(zVarA);
            com.anythink.basead.d.c.a.a(jVar, zVarA);
        }
        return zVarA;
    }
}
