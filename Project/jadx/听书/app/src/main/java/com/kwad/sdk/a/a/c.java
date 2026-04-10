package com.kwad.sdk.a.a;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.sdk.a.a.b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private e atc;
    private final Map<String, Integer> atd;
    private final Map<String, Integer> ate;
    private final Stack<AdTemplate> atf;
    private volatile boolean atg;
    public volatile boolean ath;
    public volatile boolean ati;

    static final class a {
        static final c atn = new c(0);
    }

    /* synthetic */ c(byte b) {
        this();
    }

    static /* synthetic */ e a(c cVar, e eVar) {
        cVar.atc = null;
        return null;
    }

    private c() {
        this.atd = new HashMap();
        this.ate = new HashMap();
        this.atf = new Stack<>();
        this.atg = false;
        this.ath = false;
        this.ati = false;
    }

    public static c CU() {
        return a.atn;
    }

    public final void bm(boolean z) {
        this.atg = z;
    }

    public final AdTemplate CV() {
        AdTemplate adTemplate = null;
        while (!this.atf.isEmpty()) {
            AdTemplate adTemplatePop = this.atf.pop();
            if (aY(adTemplatePop)) {
                adTemplate = adTemplatePop;
            }
        }
        if (adTemplate != null) {
            this.atf.add(0, adTemplate);
        }
        return adTemplate;
    }

    private static boolean aY(AdTemplate adTemplate) {
        String strH;
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (as.aq(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(adInfoEl)) || (strH = com.kwad.sdk.core.download.a.H(adInfoEl)) == null || TextUtils.isEmpty(strH)) {
            return false;
        }
        return new File(strH).exists();
    }

    public final void aZ(AdTemplate adTemplate) {
        if (aY(adTemplate)) {
            this.atf.add(adTemplate);
        }
    }

    public final void ba(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.atf.remove(adTemplate);
    }

    public final void bb(final AdTemplate adTemplate) {
        int iIntValue;
        int iFi = com.kwad.sdk.core.config.e.Fi();
        if (adTemplate == null || iFi <= 0) {
            return;
        }
        final AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String strValueOf = String.valueOf(com.kwad.sdk.core.response.b.e.ev(adTemplate));
        if (this.atd.containsKey(strValueOf)) {
            iIntValue = this.atd.get(strValueOf).intValue();
            this.atd.put(strValueOf, Integer.valueOf(iIntValue));
        } else {
            iIntValue = 0;
        }
        if (iIntValue > 0) {
            return;
        }
        h.schedule(new bg() { // from class: com.kwad.sdk.a.a.c.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (adInfoEl.status == 12 || adInfoEl.status == 10 || !w.gQ(com.kwad.sdk.core.download.a.H(com.kwad.sdk.core.response.b.e.el(adTemplate)))) {
                    return;
                }
                c.this.e(adTemplate, true);
            }
        }, iFi, TimeUnit.SECONDS);
    }

    public final void bc(final AdTemplate adTemplate) {
        int iIntValue;
        int iFv = com.kwad.sdk.core.config.e.Fv();
        if (iFv < 0) {
            return;
        }
        final AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        String strValueOf = String.valueOf(adInfoEl.adBaseInfo.creativeId);
        if (this.ate.containsKey(strValueOf)) {
            iIntValue = this.ate.get(strValueOf).intValue();
            this.ate.put(strValueOf, Integer.valueOf(iIntValue));
        } else {
            iIntValue = 0;
        }
        if (iIntValue > 0) {
            return;
        }
        h.schedule(new Runnable() { // from class: com.kwad.sdk.a.a.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (as.ar(ServiceProvider.getContext(), com.kwad.sdk.core.response.b.a.ay(adInfoEl)) == 1) {
                    return;
                }
                c.this.e(adTemplate, false);
            }
        }, iFv, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final AdTemplate adTemplate, final boolean z) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.sdk.a.a.c.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                int iFj = com.kwad.sdk.core.config.e.Fj();
                boolean z2 = z;
                if (!z2 || iFj != 2) {
                    c.this.a(adTemplate, z2, iFj, false);
                } else {
                    c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (i != -1) {
                                if (i == -2) {
                                    c cVar = c.this;
                                    c.g(adTemplate, 1);
                                    return;
                                }
                                return;
                            }
                            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                            bVar.df(29);
                            bVar.dm(23);
                            com.kwad.sdk.core.adlog.c.e(adTemplate, null, bVar);
                            com.kwad.sdk.a.a.a.CP();
                        }
                    });
                }
            }
        });
    }

    public final void CW() {
        b.CR().a(new b.a() { // from class: com.kwad.sdk.a.a.c.4
            @Override // com.kwad.sdk.a.a.b.a
            public final void hy() {
                bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.sdk.a.a.c.4.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        if (!c.this.atg) {
                            c.this.CY();
                        } else {
                            c.this.ati = true;
                        }
                    }
                }, com.kwad.sdk.core.config.e.Fl());
            }

            @Override // com.kwad.sdk.a.a.b.a
            public final void CT() {
                com.kwad.sdk.core.d.c.d("InstallTipsManager", "showInitDelayDialog failed");
            }
        });
    }

    public final void CX() {
        bm(false);
        if (this.ath || !this.ati) {
            return;
        }
        bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.sdk.a.a.c.5
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                c.this.CY();
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CY() {
        if (!this.ath && com.kwad.sdk.a.a.a.b.dO() <= 0) {
            bw.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.a.a.c.6
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        AdTemplate adTemplateCS = b.CR().CS();
                        if (adTemplateCS == null || com.kwad.sdk.core.config.e.Fk() == 0) {
                            return;
                        }
                        c.this.ath = true;
                        com.kwad.sdk.core.c.b.Ho();
                        com.kwad.sdk.a.a.a.b.J(com.kwad.sdk.core.c.b.getCurrentActivity());
                        c.this.bd(adTemplateCS);
                    } catch (Throwable th) {
                        com.kwad.components.core.d.a.reportSdkCaughtException(th);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bd(final AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.a.a.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                try {
                    if (i == -1) {
                        com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                        bVar.df(29);
                        bVar.dm(23);
                        com.kwad.sdk.core.adlog.c.e(adTemplate, null, bVar);
                        com.kwad.sdk.a.a.a.CP();
                    } else {
                        if (i != -2) {
                            return;
                        }
                        c cVar = c.this;
                        c.g(adTemplate, 1);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
        bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.sdk.a.a.c.8
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (com.kwad.sdk.a.a.a.CP()) {
                    c cVar = c.this;
                    c.g(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(AdTemplate adTemplate, int i) {
        com.kwad.sdk.core.adlog.c.e(adTemplate, null, new com.kwad.sdk.core.adlog.c.b().df(69).dm(23).dq(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (com.kwad.sdk.a.a.a.oW()) {
            return;
        }
        com.kwad.sdk.core.c.b.Ho();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null && com.kwad.sdk.a.a.a.a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.kwad.sdk.core.response.model.AdTemplate r2, boolean r3, int r4, boolean r5) {
        /*
            r1 = this;
            com.kwad.sdk.a.a.e r0 = r1.atc
            if (r0 != 0) goto L15
            boolean r0 = com.kwad.components.core.e.c.b.oW()
            if (r0 == 0) goto Lb
            goto L15
        Lb:
            if (r3 == 0) goto L11
            r0 = 1
            if (r4 != r0) goto L11
            goto L12
        L11:
            r0 = 0
        L12:
            r1.b(r2, r3, r0, r5)
        L15:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.a.a.c.a(com.kwad.sdk.core.response.model.AdTemplate, boolean, int, boolean):void");
    }

    private void b(final AdTemplate adTemplate, boolean z, boolean z2, boolean z3) {
        Context context;
        Context contextWrapContextIfNeed;
        com.kwad.sdk.core.c.b.Ho();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity == null || (context = ((f) ServiceProvider.get(f.class)).getContext()) == null || (contextWrapContextIfNeed = m.wrapContextIfNeed(context)) == null) {
            return;
        }
        e eVar = new e(contextWrapContextIfNeed, adTemplate, z, z2, z3);
        View viewFindViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
        if (viewFindViewById instanceof FrameLayout) {
            eVar.b((FrameLayout) viewFindViewById);
            this.atc = eVar;
            a(adTemplate, z, z3);
        }
        if (z3) {
            com.kwad.sdk.core.c.b.Ho();
            com.kwad.sdk.a.a.a.b.J(com.kwad.sdk.core.c.b.getCurrentActivity());
            bw.runOnUiThreadDelay(new bg() { // from class: com.kwad.sdk.a.a.c.9
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    if (c.this.atc != null) {
                        c.this.atc.dismiss();
                        c.a(c.this, (e) null);
                        c cVar = c.this;
                        c.g(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, boolean z, boolean z2) {
        String strValueOf = String.valueOf(com.kwad.sdk.core.response.b.e.ev(adTemplate));
        if (z) {
            b(this.atd, strValueOf);
            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
            if (z2) {
                bVar.dm(23);
                bVar.df(MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED);
            } else {
                bVar.df(92);
            }
            com.kwad.sdk.core.adlog.c.d(adTemplate, (JSONObject) null, bVar);
            return;
        }
        com.kwad.sdk.core.adlog.c.c(adTemplate, 93, (JSONObject) null);
        b(this.ate, strValueOf);
    }

    private static void b(Map<String, Integer> map, String str) {
        if (map.containsKey(str)) {
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
        } else {
            map.put(str, 1);
        }
    }

    public final void CZ() {
        this.atc = null;
    }

    public final void dismiss() {
        com.kwad.sdk.a.a.a.CP();
        e eVar = this.atc;
        if (eVar != null) {
            eVar.dismiss();
            this.atc = null;
        }
    }
}
