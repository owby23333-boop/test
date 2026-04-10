package com.volcengine.mobsecBiz.metasec.ml;

import ms.bz.bd.c.Pgl.a;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends a {
    private final a w;

    /* JADX INFO: renamed from: com.volcengine.mobsecBiz.metasec.ml.e$e, reason: collision with other inner class name */
    public static class C0530e extends a.pgla<C0530e> {
        public C0530e(String str, String str2, String str3, int i) {
            super(str, str2, str3, i);
        }

        public C0530e e(int i) {
            bf(i);
            return this;
        }

        public C0530e e(String str) {
            bf(str);
            return this;
        }

        public e e() {
            return new e(bf());
        }
    }

    private e(a aVar) {
        this.w = aVar;
    }

    public a e() {
        return this.w;
    }
}
