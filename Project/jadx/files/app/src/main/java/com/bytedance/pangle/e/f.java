package com.bytedance.pangle.e;

import android.os.SystemClock;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.i;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    interface a {
        boolean a(String str, int i2);
    }

    public static void a() {
        if ((i.d() || i.f() || i.b()) && com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.e.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    f.b();
                }
            });
        }
    }

    public static synchronized void b() {
        Map<String, ?> all = b.a(Zeus.getAppApplication()).getAll();
        if (all.size() > 0) {
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if ((i.f() ? new e() : i.d() ? new d() : i.b() ? new c() : new a() { // from class: com.bytedance.pangle.e.f.2
                    @Override // com.bytedance.pangle.e.f.a
                    public final boolean a(String str, int i2) {
                        return true;
                    }
                }).a(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                    b.a(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat:" + entry.getKey());
                }
            }
        }
    }
}
