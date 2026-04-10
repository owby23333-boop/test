package com.kwad.components.core.proxy.launchdialog;

import android.app.Application;
import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private static e WB = new e();
    private List<b> WC = new CopyOnWriteArrayList();
    private a WD = new a();
    private com.kwad.components.core.proxy.b WE = new com.kwad.components.core.proxy.b(this.WD);

    public static e sc() {
        return WB;
    }

    public final void a(b bVar) {
        if (bVar != null) {
            this.WC.add(bVar);
        }
    }

    public final void b(b bVar) {
        if (bVar != null) {
            this.WC.remove(bVar);
        }
    }

    public final void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(this.WE);
        }
    }

    public final void aF(final AdTemplate adTemplate) {
        n(this.WD.rW());
        sc().a(DetectEventType.USER_CANCEL, new f() { // from class: com.kwad.components.core.proxy.launchdialog.e.1
            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void j(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onContinue");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void k(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onComplete");
                e.this.aH(adTemplate);
                e.this.n(aVar);
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void l(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onTimeout");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void m(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CANCEL PageLaunchDialogManager onNotMatch");
            }
        });
        sc().a(DetectEventType.USER_CONFIRM, new f() { // from class: com.kwad.components.core.proxy.launchdialog.e.2
            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void j(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onContinue");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void k(com.kwad.components.core.proxy.a aVar) {
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onComplete");
                e.this.aG(adTemplate);
                e.this.n(aVar);
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void l(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onTimeout");
            }

            @Override // com.kwad.components.core.proxy.launchdialog.f
            public final void m(com.kwad.components.core.proxy.a aVar) {
                e.this.n(aVar);
                com.kwad.sdk.core.d.c.d("PageLaunchDialogManager", "USER_CONFIRM PageLaunchDialogManager onNotMatch");
            }
        });
        long jEv = com.kwad.sdk.core.response.b.e.ev(adTemplate);
        Iterator<b> it = this.WC.iterator();
        while (it.hasNext()) {
            it.next().b(jEv, 1);
        }
    }

    private void a(DetectEventType detectEventType, f fVar) {
        c cVarA = this.WD.a(detectEventType);
        if (cVarA != null) {
            cVarA.a(fVar);
            cVarA.start();
        }
    }

    public final void n(com.kwad.components.core.proxy.a aVar) {
        this.WD.i(aVar);
        this.WD.h(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT).dm(25));
        long jEv = com.kwad.sdk.core.response.b.e.ev(adTemplate);
        Iterator<b> it = this.WC.iterator();
        while (it.hasNext()) {
            it.next().b(jEv, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(AdTemplate adTemplate) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR).dm(25));
        long jEv = com.kwad.sdk.core.response.b.e.ev(adTemplate);
        Iterator<b> it = this.WC.iterator();
        while (it.hasNext()) {
            it.next().b(jEv, 3);
        }
    }
}
