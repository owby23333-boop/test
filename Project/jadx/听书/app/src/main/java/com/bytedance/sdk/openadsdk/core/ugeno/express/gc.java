package com.bytedance.sdk.openadsdk.core.ugeno.express;

import android.content.Context;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.adsdk.ugeno.dl.q;
import com.bytedance.sdk.component.adexpress.g.gz;
import com.bytedance.sdk.component.adexpress.g.i;
import com.bytedance.sdk.component.adexpress.g.pf;
import com.bytedance.sdk.component.adexpress.g.uy;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledFuture<?> f1356a;
    private i dl;
    private a g;
    private AtomicBoolean gc = new AtomicBoolean(false);
    private Context z;

    public gc(Context context, a aVar, gz gzVar, i iVar) {
        this.z = context;
        this.g = aVar;
        this.dl = iVar;
        this.g.z(gzVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy
    public boolean z(final uy.z zVar) {
        int iGz = this.dl.gz();
        if (iGz < 0) {
            z(zVar, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
        } else {
            this.f1356a = e.a().schedule(new z(1, zVar), iGz, TimeUnit.MILLISECONDS);
            this.g.z(new com.bytedance.sdk.component.adexpress.g.e() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.express.gc.1
                @Override // com.bytedance.sdk.component.adexpress.g.e
                public void z(View view, v vVar) {
                    if (zVar.dl()) {
                        return;
                    }
                    q qVar = new q();
                    qVar.z(0);
                    ((g) gc.this.dl).mc().z(qVar);
                    gc.this.dl.e().i();
                    pf pfVarG = zVar.g();
                    if (pfVarG == null) {
                        return;
                    }
                    pfVarG.z(gc.this.g, vVar);
                    zVar.z(true);
                }

                @Override // com.bytedance.sdk.component.adexpress.g.e
                public void z(int i, String str) {
                    pf pfVarG;
                    q qVar = new q();
                    qVar.z(i);
                    qVar.z(str);
                    ((g) gc.this.dl).mc().z(qVar);
                    if (zVar.g(gc.this)) {
                        zVar.z(gc.this);
                    } else {
                        if (zVar.dl() || (pfVarG = zVar.g()) == null) {
                            return;
                        }
                        pfVarG.a_(i);
                    }
                }
            });
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy
    public void z() {
        a aVar = this.g;
        if (aVar != null) {
            aVar.kb();
        }
    }

    private void g() {
        try {
            ScheduledFuture<?> scheduledFuture = this.f1356a;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.f1356a.cancel(false);
            this.f1356a = null;
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private class z implements Runnable {
        private int dl;
        uy.z z;

        z(int i, uy.z zVar) {
            this.dl = i;
            this.z = zVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.dl == 1) {
                gc.this.g.z(true);
                gc.this.z(this.z, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(uy.z zVar, int i) {
        pf pfVarG;
        if (zVar.dl() || this.gc.get()) {
            return;
        }
        g();
        q qVar = new q();
        qVar.z(i);
        ((g) this.dl).mc().z(qVar);
        if (zVar.g(this)) {
            zVar.z(this);
        } else {
            if (zVar.dl() || (pfVarG = zVar.g()) == null) {
                return;
            }
            zVar.z(true);
            pfVarG.a_(i);
        }
        this.gc.getAndSet(true);
    }
}
