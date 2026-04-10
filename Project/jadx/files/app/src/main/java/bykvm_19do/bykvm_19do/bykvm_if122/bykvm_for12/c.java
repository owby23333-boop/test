package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.content.Context;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile boolean a;
    private static final AtomicLong b = new AtomicLong(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f1678c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f1679d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f1680e = true;

    public static void a(int i2) {
        f1678c = i2;
        if (f1678c == 1 || f1678c == 0) {
            return;
        }
        f1678c = 0;
    }

    public static void a(Context context, d dVar, Map<String, Object> map) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().v()) {
            if (!a() || a) {
                if (context == null) {
                    context = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
                }
                JSONObject jSONObject = new JSONObject();
                if (map != null) {
                    try {
                        for (Map.Entry<String, Object> entry : map.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("eventIndex", b.getAndIncrement());
                jSONObject.put("if_use_new_loglib", a());
                int iJ = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().j();
                if (dVar != null) {
                    dVar.a("event_id", UUID.randomUUID().toString());
                }
                JSONObject jSONObjectA = a.a(context, dVar, jSONObject);
                if (iJ == 0 || iJ == 2) {
                    i iVarB = i.b(context, dVar, jSONObjectA);
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.bykvm_19do.a.a(iVarB, true);
                    if (a()) {
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a aVar = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a(iVarB.a, iVarB);
                        aVar.a((byte) 3);
                        aVar.b((byte) 2);
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.a(aVar);
                    } else {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c().a(iVarB);
                    }
                }
                if (iJ == 0 || iJ == 1) {
                    a aVarB = a.b(context, dVar, jSONObjectA);
                    bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.bykvm_19do.a.a(aVarB, false);
                    if (!a()) {
                        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a().a(aVarB);
                        return;
                    }
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a aVar2 = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a(aVarB.a, aVarB);
                    aVar2.a((byte) 0);
                    aVar2.b((byte) 2);
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.a(aVar2);
                }
            }
        }
    }

    public static boolean a() {
        if (!f1679d) {
            synchronized (c.class) {
                if (!f1679d) {
                    f1680e = f1678c == 1;
                    f1679d = true;
                }
            }
        }
        return f1680e;
    }

    public static void b() {
        a = true;
    }
}
