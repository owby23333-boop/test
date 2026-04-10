package com.yuewen;

import android.content.Context;
import android.util.DisplayMetrics;
import com.duokan.kernel.EpubLibInterface;
import com.duokan.kernel.epublib.DkEpubLib;
import com.duokan.kernel.epublib.DkEpubLibExt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class qx0 implements xl3 {
    public static kv3<qx0> f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DkEpubLib f16797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16798b;
    public String c;
    public List<EpubLibInterface> d;
    public wf2<vh2> e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f16799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f16800b;
        public List<EpubLibInterface> c = new ArrayList();
        public DkEpubLib d;
        public wf2<vh2> e;

        public qx0 a() {
            qx0 qx0Var = new qx0();
            qx0Var.f16797a = this.d;
            qx0Var.f16798b = this.f16799a;
            qx0Var.c = this.f16800b;
            qx0Var.d = this.c;
            qx0Var.e = this.e;
            return qx0Var;
        }

        public a b(Context context, String str) {
            this.f16799a = str;
            DkEpubLibExt dkEpubLibExt = new DkEpubLibExt();
            this.d = dkEpubLibExt;
            dkEpubLibExt.initialize(str);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.d.setDeviceParams(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels), Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels), 65535, displayMetrics.densityDpi);
            this.c.add(this.d);
            return this;
        }

        public a c(EpubLibInterface epubLibInterface) {
            this.c.add(epubLibInterface);
            return this;
        }

        public a d(wf2<vh2> wf2Var) {
            this.e = wf2Var;
            return this;
        }

        public a e(String str) {
            this.f16800b = str;
            return this;
        }
    }

    public static qx0 f() {
        kv3<qx0> kv3Var = f;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void m(kv3<qx0> kv3Var) {
        f = kv3Var;
    }

    public String g() {
        return this.f16797a.getKernelVersion();
    }

    public String h() {
        return this.f16798b;
    }

    public String i() {
        return this.c;
    }

    public void j(vh2 vh2Var) {
        this.e.run(vh2Var);
    }

    public void k(boolean z) {
        Iterator<EpubLibInterface> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().setChsToCht(z);
        }
    }

    public void l(boolean z) {
        this.f16797a.setUseBookStyle(z);
    }
}
