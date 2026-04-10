package com.yuewen;

import androidx.annotation.Nullable;
import com.xiaomi.ad.mediation.MMAdError;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class im2 implements hm2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12515b = "PreloadMonitor";
    public static final int c = 500;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, br2> f12516a = new LinkedHashMap();

    @Override // com.yuewen.hm2
    @Nullable
    public br2 b(String str) {
        return this.f12516a.get(str);
    }

    public void g() {
        pw3.d(f12515b, "clear preload quality monitor");
        this.f12516a.clear();
    }

    public synchronized void h(String str) {
        if (str == null) {
            pw3.a(f12515b, "null url");
        }
        br2 br2Var = this.f12516a.get(str);
        if (br2Var != null) {
            pw3.a(f12515b, "duplicate put in preload queue");
            br2Var.f(1);
        } else {
            if (this.f12516a.size() > 500) {
                i();
            }
            this.f12516a.put(str, new br2(str, 1));
        }
    }

    public final void i() {
        int size = this.f12516a.size() + MMAdError.LOAD_NO_AD_CONFIG;
        if (size < 0) {
            pw3.a(f12515b, "illegal trim size");
            return;
        }
        pw3.a(f12515b, "trim size:$trimSize");
        Iterator<Map.Entry<String, br2>> it = this.f12516a.entrySet().iterator();
        for (int i = 0; i < size; i++) {
            it.next();
            it.remove();
        }
    }

    public synchronized void j(String str, int i) {
        pw3.a(f12515b, "$url, state:$newState");
        br2 br2Var = this.f12516a.get(str);
        if (br2Var == null) {
            pw3.a(f12515b, "error to find exist record");
        } else {
            br2Var.f(i);
        }
    }
}
