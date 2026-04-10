package com.tramini.plugin.a.j;

import com.tramini.plugin.a.a.c;
import com.tramini.plugin.a.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final /* synthetic */ String f19365s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final /* synthetic */ JSONObject f19366t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ JSONObject f19367u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ int f19368v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final /* synthetic */ b f19369w;

    /* JADX INFO: renamed from: com.tramini.plugin.a.j.a$a, reason: collision with other inner class name */
    final class C0541a implements h.d {
        C0541a() {
        }

        @Override // com.tramini.plugin.a.h.d
        public final void a() {
        }

        @Override // com.tramini.plugin.a.h.d
        public final void a(int i2, Object obj) {
            Runnable runnable;
            if (2 == i2 && a.this.f19369w.a != null && (runnable = (Runnable) a.this.f19369w.a.remove(Integer.valueOf(i2))) != null) {
                runnable.run();
            }
            c.c().b(c.c().a());
        }

        @Override // com.tramini.plugin.a.h.d
        public final void b() {
            c.c().b(c.c().a());
        }
    }

    a(b bVar, String str, JSONObject jSONObject, JSONObject jSONObject2, int i2) {
        this.f19369w = bVar;
        this.f19365s = str;
        this.f19366t = jSONObject;
        this.f19367u = jSONObject2;
        this.f19368v = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new h.g(c.c().a(), this.f19365s, this.f19366t, this.f19367u).a(this.f19368v, (h.d) new C0541a());
    }
}
