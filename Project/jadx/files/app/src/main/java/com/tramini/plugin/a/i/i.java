package com.tramini.plugin.a.i;

import com.tramini.plugin.a.i.f;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class i implements f.d {
    final /* synthetic */ String a;

    i(String str) {
        this.a = str;
    }

    @Override // com.tramini.plugin.a.i.f.d
    public final boolean a(Object obj) {
        return obj instanceof Map;
    }

    @Override // com.tramini.plugin.a.i.f.d
    public final f.b b(Object obj) {
        Map map = (Map) obj;
        if (map == null || map.size() == 0) {
            return f.b.a();
        }
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return f.b.a();
        }
        Object value = ((Map.Entry) it.next()).getValue();
        return value == null ? f.b.a() : value.getClass().getSimpleName().contains(this.a) ? f.b.a(value) : f.b.b(value);
    }
}
