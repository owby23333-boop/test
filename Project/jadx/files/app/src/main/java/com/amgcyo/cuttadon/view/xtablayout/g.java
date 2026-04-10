package com.amgcyo.cuttadon.view.xtablayout;

import android.os.Build;
import com.amgcyo.cuttadon.view.xtablayout.d;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class g {
    static final d.f a = new a();

    /* JADX INFO: compiled from: ViewUtils.java */
    class a implements d.f {
        a() {
        }

        @Override // com.amgcyo.cuttadon.view.xtablayout.d.f
        public com.amgcyo.cuttadon.view.xtablayout.d c() {
            return new com.amgcyo.cuttadon.view.xtablayout.d(Build.VERSION.SDK_INT >= 12 ? new f() : new e());
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    private interface b {
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    private static class c implements b {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    private static class d implements b {
        private d() {
        }

        /* synthetic */ d(a aVar) {
            this();
        }
    }

    static {
        a aVar = null;
        if (Build.VERSION.SDK_INT >= 21) {
            new d(aVar);
        } else {
            new c(aVar);
        }
    }

    static com.amgcyo.cuttadon.view.xtablayout.d a() {
        return a.c();
    }
}
