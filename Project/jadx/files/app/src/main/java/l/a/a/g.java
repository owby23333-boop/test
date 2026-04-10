package l.a.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SpringConfigRegistry.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static final g b = new g(true);
    private final Map<f, String> a = new HashMap();

    g(boolean z2) {
        if (z2) {
            a(f.f21029c, "default config");
        }
    }

    public static g b() {
        return b;
    }

    public boolean a(f fVar, String str) {
        if (fVar == null) {
            throw new IllegalArgumentException("springConfig is required");
        }
        if (str == null) {
            throw new IllegalArgumentException("configName is required");
        }
        if (this.a.containsKey(fVar)) {
            return false;
        }
        this.a.put(fVar, str);
        return true;
    }

    public Map<f, String> a() {
        return Collections.unmodifiableMap(this.a);
    }
}
