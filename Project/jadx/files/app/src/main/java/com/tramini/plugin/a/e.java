package com.tramini.plugin.a;

import android.text.TextUtils;
import com.tramini.plugin.a.k.a;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class e implements a.b {
    final /* synthetic */ int a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ l.c.a.a.a f19329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f19330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f19331e;

    final class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ com.tramini.plugin.a.g.a f19332s;

        a(com.tramini.plugin.a.g.a aVar) {
            this.f19332s = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                JSONObject jSONObject = new JSONObject(e.this.b);
                if (this.f19332s != null && this.f19332s.a != null) {
                    JSONObject jSONObject2 = this.f19332s.a;
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, jSONObject2.optString(next));
                    }
                    jSONObject.put("setting_id", e.this.f19329c.b());
                } else if (this.f19332s != null && this.f19332s.b != null) {
                    jSONObject.put("type", 10001);
                    jSONObject.put("i_t", this.f19332s.b.a);
                    if (!TextUtils.isEmpty(this.f19332s.b.b)) {
                        jSONObject.put("i_al", com.tramini.plugin.a.k.c.a(this.f19332s.b.b.getBytes()));
                    }
                } else if (e.this.a != 18 && e.this.a != 19 && e.this.a != 20) {
                    return;
                }
                com.tramini.plugin.a.j.b.a().a(e.this.f19330d, new JSONObject(e.this.f19331e), jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    e(b bVar, int i2, String str, l.c.a.a.a aVar, String str2, String str3) {
        this.a = i2;
        this.b = str;
        this.f19329c = aVar;
        this.f19330d = str2;
        this.f19331e = str3;
    }

    @Override // com.tramini.plugin.a.k.a.b
    public final void a(com.tramini.plugin.a.g.a aVar) {
        int i2;
        if (aVar != null || (i2 = this.a) == 18 || i2 == 19 || i2 == 20) {
            com.tramini.plugin.a.a.c.c();
            com.tramini.plugin.a.a.c.a(new a(aVar));
        }
    }
}
