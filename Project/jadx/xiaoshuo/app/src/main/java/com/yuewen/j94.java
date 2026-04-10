package com.yuewen;

import com.duokan.reader.ReaderEnv;

/* JADX INFO: loaded from: classes12.dex */
public class j94 extends ul2 {
    public static final String e = "up_scale_";

    @Deprecated
    public static final String f = "highexp";
    public static final String g = m(ReaderEnv.d.t0);
    public volatile Boolean d = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j94 f12864a = new j94();
    }

    public static j94 l() {
        return a.f12864a;
    }

    public static String m(String str) {
        return e + str;
    }

    public boolean n() {
        if (this.d == null) {
            this.d = Boolean.valueOf(b(g, false));
        }
        return this.d.booleanValue();
    }

    public void o() {
        this.d = Boolean.TRUE;
        h(g, true);
    }
}
