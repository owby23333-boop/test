package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.bykvm_19do;

import android.content.Context;
import android.os.Process;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.n;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.am;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {
    protected bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c a;
    protected Context b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.e f1994c = i.e().a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected b f1995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected d f1996e;

    c(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.c cVar, Context context, b bVar, d dVar) {
        this.a = cVar;
        this.b = context;
        this.f1995d = bVar;
        this.f1996e = dVar;
    }

    private void e(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        List<bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.a> listA = i.d().a(this.a);
        if (listA != null) {
            JSONObject jSONObject = new JSONObject();
            Iterator<bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.a> it = listA.iterator();
            while (it.hasNext()) {
                Map<? extends String, ? extends String> mapA = it.next().a(this.a);
                if (mapA != null) {
                    try {
                        for (String str : mapA.keySet()) {
                            jSONObject.put(str, mapA.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            aVar.a("custom", jSONObject);
        }
    }

    void a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        Map<String, Object> mapD = i.e().d();
        if (mapD == null) {
            return;
        }
        if (mapD.containsKey("app_version")) {
            aVar.a("crash_version", mapD.get("app_version"));
        }
        if (mapD.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
            aVar.a("app_version", mapD.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
        }
        if (mapD.containsKey("version_code")) {
            try {
                aVar.a("crash_version_code", Integer.valueOf(Integer.parseInt(mapD.get("version_code").toString())));
            } catch (Exception unused) {
                aVar.a("crash_version_code", mapD.get("version_code"));
            }
        }
        if (mapD.containsKey("update_version_code")) {
            try {
                aVar.a("crash_update_version_code", Integer.valueOf(Integer.parseInt(mapD.get("update_version_code").toString())));
            } catch (Exception unused2) {
                aVar.a("crash_update_version_code", mapD.get("update_version_code"));
            }
        }
    }

    protected boolean a() {
        return true;
    }

    public bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a b(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        if (aVar == null) {
            aVar = new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a();
        }
        c(aVar);
        e(aVar);
        return aVar;
    }

    protected boolean b() {
        return true;
    }

    void c(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        b bVar;
        if (a() && (bVar = this.f1995d) != null) {
            aVar.a(bVar);
        }
        aVar.a(i.a());
        aVar.a("is_background", Boolean.valueOf(!bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.a.e(this.b)));
        aVar.a(com.anythink.expressad.d.a.b.aB, Integer.valueOf(Process.myPid()));
        aVar.a(am.Z, Integer.valueOf(this.f1996e.a()));
        aVar.b(this.f1994c.g());
        aVar.c(i.i());
        aVar.a(i.g(), i.h());
        aVar.b(this.f1994c.b());
        aVar.a(n.c(this.b));
        if (b()) {
            d(aVar);
        }
        aVar.a(this.f1994c.d());
        String strC = i.c();
        if (strC != null) {
            aVar.a("business", strC);
        }
        if (i.k()) {
            aVar.a("is_mp", (Object) 1);
        }
        aVar.a(i.d().d());
        aVar.a("crash_uuid", UUID.randomUUID().toString());
    }

    protected void d(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_for12.a aVar) {
        aVar.a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.e.a(i.f().b(), i.f().c()));
    }
}
