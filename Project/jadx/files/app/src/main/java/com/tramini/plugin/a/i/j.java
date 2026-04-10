package com.tramini.plugin.a.i;

import com.tramini.plugin.a.i.f;

/* JADX INFO: loaded from: classes3.dex */
final class j implements f.d {
    final /* synthetic */ String a;
    final /* synthetic */ String b;

    j(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.tramini.plugin.a.i.f.d
    public final boolean a(Object obj) {
        return obj.getClass().getName().startsWith(this.a);
    }

    @Override // com.tramini.plugin.a.i.f.d
    public final f.b b(Object obj) {
        try {
            return (this.b == null || !this.b.contains(obj.getClass().getName())) ? f.b.b(obj) : f.b.a(obj);
        } catch (Throwable unused) {
            return f.b.a();
        }
    }
}
