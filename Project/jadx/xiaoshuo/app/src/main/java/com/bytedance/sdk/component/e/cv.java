package com.bytedance.sdk.component.e;

import android.text.TextUtils;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class cv {
    private final Map<String, y> bf;
    private final wu d;
    private final Collection<String> e;
    private final Set<e> tg;

    public interface e {
    }

    public void bf(e eVar) {
        this.tg.remove(eVar);
    }

    public y e(String str) {
        if (this.e.contains(str) || TextUtils.equals(str, "host")) {
            return e(str, null);
        }
        throw new IllegalArgumentException("Namespace: " + str + " not registered.");
    }

    public void e(e eVar) {
        this.tg.add(eVar);
    }

    private y e(String str, JSONObject jSONObject) {
        y yVar = this.bf.get(str);
        if (yVar == null) {
            y yVar2 = new y(str, this.d.d(), this.d.e(), this.d.bf(), jSONObject);
            this.bf.put(str, yVar2);
            return yVar2;
        }
        if (jSONObject == null) {
            return yVar;
        }
        yVar.update(jSONObject);
        return yVar;
    }
}
