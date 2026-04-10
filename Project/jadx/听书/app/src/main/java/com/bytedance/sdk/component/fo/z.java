package com.bytedance.sdk.component.fo;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.component.fo.a.dl;
import com.bytedance.sdk.component.fo.dl.e;
import com.bytedance.sdk.component.fo.dl.m;
import com.bytedance.sdk.component.fo.g.gc;
import com.bytedance.sdk.component.g.z.fo;
import com.bytedance.sdk.component.g.z.wp;
import com.bytedance.sdk.component.utils.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private int dl;
    private m g;
    private wp z;

    private z(C0131z c0131z) {
        wp.z zVarG = new wp.z().z(c0131z.z, TimeUnit.MILLISECONDS).dl(c0131z.dl, TimeUnit.MILLISECONDS).g(c0131z.g, TimeUnit.MILLISECONDS);
        if (c0131z.f711a) {
            m mVar = new m();
            this.g = mVar;
            zVarG.z(mVar);
        }
        if (c0131z.gc != null && c0131z.gc.size() > 0) {
            Iterator<fo> it = c0131z.gc.iterator();
            while (it.hasNext()) {
                zVarG.z(it.next());
            }
        }
        if (c0131z.e != null) {
            zVarG.z(c0131z.e);
        }
        zVarG.z(c0131z.m);
        if (c0131z.gz == null) {
            zVarG.z(new com.bytedance.sdk.component.g.z.z.z.g());
        } else {
            zVarG.z(c0131z.gz);
        }
        this.z = zVarG.z();
    }

    public void z(Context context, boolean z, com.bytedance.sdk.component.fo.dl.g gVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (gVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int iZ = gVar.z();
        this.dl = iZ;
        m mVar = this.g;
        if (mVar != null) {
            mVar.z(iZ);
        }
        e.z().z(this.dl).z(z);
        e.z().z(this.dl).z(gVar);
        e.z().z(this.dl).z(context, p.z(context));
    }

    public void z(Context context, boolean z) {
        com.bytedance.sdk.component.fo.dl.z.g(true);
        if (z(context) || (!p.z(context) && z)) {
            e.z().z(this.dl, context).a();
            e.z().z(this.dl, context).z();
        }
        if (p.z(context)) {
            e.z().z(this.dl, context).a();
            e.z().z(this.dl, context).z();
        }
    }

    public static void z() {
        dl.z(dl.z.DEBUG);
    }

    public gc g() {
        return new gc(this.z);
    }

    public com.bytedance.sdk.component.fo.g.dl dl() {
        return new com.bytedance.sdk.component.fo.g.dl(this.z);
    }

    public com.bytedance.sdk.component.fo.g.g a() {
        return new com.bytedance.sdk.component.fo.g.g(this.z);
    }

    private static boolean z(Context context) {
        String strG = p.g(context);
        if (strG != null) {
            return strG.endsWith(":push") || strG.endsWith(":pushservice");
        }
        return false;
    }

    public com.bytedance.sdk.component.fo.g.z gc() {
        return new com.bytedance.sdk.component.fo.g.z(this.z);
    }

    public wp m() {
        return this.z;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.fo.z$z, reason: collision with other inner class name */
    public static final class C0131z {
        private Bundle e;
        private com.bytedance.sdk.component.g.z.z.z.z gz;
        private Set<String> m;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f711a = true;
        final List<fo> gc = new ArrayList();
        int z = 10000;
        int g = 10000;
        int dl = 10000;

        public C0131z z(long j, TimeUnit timeUnit) {
            this.z = z("timeout", j, timeUnit);
            return this;
        }

        public C0131z g(long j, TimeUnit timeUnit) {
            this.g = z("timeout", j, timeUnit);
            return this;
        }

        public C0131z dl(long j, TimeUnit timeUnit) {
            this.dl = z("timeout", j, timeUnit);
            return this;
        }

        public C0131z z(boolean z) {
            this.f711a = z;
            return this;
        }

        public C0131z z(fo foVar) {
            this.gc.add(foVar);
            return this;
        }

        public C0131z z(Set<String> set) {
            this.m = set;
            return this;
        }

        private static int z(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public z z() {
            return new z(this);
        }
    }
}
