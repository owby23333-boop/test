package com.xiaomi.push;

import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class fq implements fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fo f7973a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static fq f7974a = new fq();
    }

    public static fq a() {
        return a.f7974a;
    }

    private fq() {
    }

    @Override // com.xiaomi.push.fo
    public void a(fn fnVar) {
        fo foVar = this.f7973a;
        if (foVar != null) {
            foVar.a(fnVar);
        }
    }

    @Override // com.xiaomi.push.fo
    public void a(String str, Map<String, Object> map) {
        fo foVar = this.f7973a;
        if (foVar != null) {
            foVar.a(str, map);
        }
    }
}
