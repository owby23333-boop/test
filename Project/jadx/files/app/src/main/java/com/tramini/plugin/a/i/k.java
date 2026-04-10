package com.tramini.plugin.a.i;

import com.tramini.plugin.a.i.f;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class k implements f.d {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StringBuffer f19363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f19364d;

    final class a implements f.d {
        a() {
        }

        @Override // com.tramini.plugin.a.i.f.d
        public final boolean a(Object obj) {
            return obj.getClass().getName().startsWith(k.this.b);
        }

        @Override // com.tramini.plugin.a.i.f.d
        public final f.b b(Object obj) {
            String str = k.this.f19364d;
            return (str == null || !str.contains(obj.getClass().getName())) ? f.b.b(obj) : f.b.a(obj);
        }
    }

    k(String str, String str2, StringBuffer stringBuffer, String str3) {
        this.a = str;
        this.b = str2;
        this.f19363c = stringBuffer;
        this.f19364d = str3;
    }

    @Override // com.tramini.plugin.a.i.f.d
    public final boolean a(Object obj) {
        return obj instanceof Map;
    }

    @Override // com.tramini.plugin.a.i.f.d
    public final f.b b(Object obj) {
        Map map;
        try {
            map = (Map) obj;
        } catch (Throwable unused) {
        }
        if (map != null && map.size() > 0) {
            if (!map.containsKey(this.a)) {
                return f.b.a();
            }
            Object obj2 = map.get(this.a);
            if (obj2 == null) {
                return f.b.a();
            }
            Object objA = f.a(obj2, this.b, this.f19363c, new a());
            if (objA != null) {
                return f.b.a(objA);
            }
            return f.b.a();
        }
        return f.b.a();
    }
}
