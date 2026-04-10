package d0;

import android.annotation.SuppressLint;
import for0.Cfor;
import for0.e;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: TaskReporter.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    @SuppressLint({"StaticFieldLeak"})
    public static c a;

    public static c a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public void a(b bVar, Cfor cfor, String str, String str2) {
        final HashMap map = new HashMap();
        if (cfor != null && cfor.f() != null) {
            map.put("status", cfor.f());
        }
        if (str != null) {
            map.put("taskUUID", str);
        }
        if (str2 != null) {
            map.put("extra", str2);
        }
        final b bVar2 = null;
        new Thread(new Runnable() { // from class: d0.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f20766s.a(map, bVar2);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map map, b bVar) {
        boolean z2 = f.a.a(z.a.f21748f, map) != null;
        if (bVar != null) {
            if (z2) {
                bVar.m176do();
            } else {
                bVar.d();
            }
        }
    }
}
