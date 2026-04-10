package com.bytedance.sdk.component.z;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class iq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<z> f857a;
    private final kb dl;
    private final Map<String, q> g;
    private final Collection<String> z;

    interface z {
    }

    q z(String str) {
        if (!this.z.contains(str) && !TextUtils.equals(str, "host")) {
            throw new IllegalArgumentException("Namespace: " + str + " not registered.");
        }
        return z(str, null);
    }

    void z(z zVar) {
        this.f857a.add(zVar);
    }

    void g(z zVar) {
        this.f857a.remove(zVar);
    }

    private q z(String str, JSONObject jSONObject) {
        q qVar = this.g.get(str);
        if (qVar == null) {
            q qVar2 = new q(str, this.dl.dl(), this.dl.z(), this.dl.g(), jSONObject);
            this.g.put(str, qVar2);
            return qVar2;
        }
        if (jSONObject == null) {
            return qVar;
        }
        qVar.update(jSONObject);
        return qVar;
    }
}
