package com.bytedance.sdk.component.adexpress.g;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.adexpress.g.uy;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class ls implements uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f580a;
    private gz dl;
    private com.bytedance.sdk.component.adexpress.gc.z g;
    private ScheduledFuture<?> gc;
    private AtomicBoolean m = new AtomicBoolean(false);
    private Context z;

    public ls(Context context, i iVar, com.bytedance.sdk.component.adexpress.gc.z zVar, gz gzVar) {
        this.z = context;
        this.f580a = iVar;
        this.dl = gzVar;
        this.g = zVar;
        zVar.z(this.dl);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy
    public boolean z(final uy.z zVar) {
        int iGz = this.f580a.gz();
        if (iGz < 0) {
            z(zVar, 107, "time is ".concat(String.valueOf(iGz)));
        } else {
            this.gc = com.bytedance.sdk.component.adexpress.a.gc.z(new z(1, zVar), iGz, TimeUnit.MILLISECONDS);
            this.g.z(new e() { // from class: com.bytedance.sdk.component.adexpress.g.ls.1
                @Override // com.bytedance.sdk.component.adexpress.g.e
                public void z(View view, v vVar) {
                    pf pfVarG;
                    ls.this.dl();
                    if (zVar.dl() || (pfVarG = zVar.g()) == null) {
                        return;
                    }
                    pfVarG.z(ls.this.g, vVar);
                    zVar.z(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.g.e
                public void z(int i, String str) {
                    ls.this.z(zVar, i, str);
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy
    public void z() {
        this.g.a();
        dl();
    }

    public com.bytedance.sdk.component.adexpress.gc.z g() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        try {
            ScheduledFuture<?> scheduledFuture = this.gc;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.gc.cancel(false);
            this.gc = null;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
    }

    private class z implements Runnable {
        private int dl;
        uy.z z;

        public z(int i, uy.z zVar) {
            this.dl = i;
            this.z = zVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dl == 1) {
                ls.this.g.z(true);
                ls.this.z(this.z, 107, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(uy.z zVar, int i, String str) {
        pf pfVarG;
        if (zVar.dl() || this.m.get()) {
            return;
        }
        dl();
        this.f580a.e().z(i, str);
        if (zVar.g(this)) {
            zVar.z(this);
        } else {
            if (zVar.dl() || (pfVarG = zVar.g()) == null) {
                return;
            }
            zVar.z(true);
            pfVarG.a_(i);
        }
        this.m.getAndSet(true);
    }
}
