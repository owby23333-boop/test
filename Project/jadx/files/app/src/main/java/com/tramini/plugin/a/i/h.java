package com.tramini.plugin.a.i;

import com.tramini.plugin.a.i.f;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class h implements f.d {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    h(String str, String str2) {
        this.a = str;
        this.b = str2;
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
        if (!map.containsKey(this.a)) {
            return f.b.a();
        }
        Object obj2 = map.get(this.a);
        return obj2 == null ? f.b.a() : obj2.getClass().getName().contains(this.b) ? f.b.a(obj2) : f.b.b(obj2);
    }
}
