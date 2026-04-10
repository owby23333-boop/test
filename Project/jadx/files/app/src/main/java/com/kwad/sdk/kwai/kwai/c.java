package com.kwad.sdk.kwai.kwai;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.core.report.i;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.kwai.kwai.b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.g;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private e YA;
    private final Map<String, Integer> YB;
    private final Map<String, Integer> YC;
    private final Stack<AdTemplate> YD;
    private volatile boolean YE;
    public volatile boolean YF;
    public volatile boolean YG;

    static final class a {
        static final c YL = new c(0);
    }

    private c() {
        this.YB = new HashMap();
        this.YC = new HashMap();
        this.YD = new Stack<>();
        this.YE = false;
        this.YF = false;
        this.YG = false;
    }

    /* synthetic */ c(byte b) {
        this();
    }

    static /* synthetic */ e a(c cVar, e eVar) {
        cVar.YA = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(AdTemplate adTemplate, DialogInterface.OnDismissListener onDismissListener, DialogInterface.OnClickListener onClickListener) {
        if (com.kwad.sdk.kwai.kwai.a.na()) {
            return;
        }
        com.kwad.sdk.core.b.b.we();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        if (currentActivity != null && com.kwad.sdk.kwai.kwai.a.a(currentActivity, adTemplate, onDismissListener, onClickListener)) {
            a(adTemplate, true, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void a(AdTemplate adTemplate, boolean z2, int i2, boolean z3) {
        if (this.YA != null || com.kwad.components.core.d.a.b.na()) {
            return;
        }
        a(adTemplate, z2, z2 && i2 == 1, z3);
    }

    private void a(AdTemplate adTemplate, boolean z2, boolean z3) {
        int i2;
        String strValueOf = String.valueOf(com.kwad.sdk.core.response.a.d.ck(adTemplate));
        if (!z2) {
            com.kwad.sdk.core.report.a.c(adTemplate, 93, (JSONObject) null);
            a(this.YC, strValueOf);
            return;
        }
        a(this.YB, strValueOf);
        i iVar = new i();
        if (z3) {
            iVar.bm(23);
            i2 = 191;
        } else {
            i2 = 92;
        }
        iVar.bh(i2);
        com.kwad.sdk.core.report.a.d(adTemplate, (JSONObject) null, iVar);
    }

    @UiThread
    private void a(final AdTemplate adTemplate, boolean z2, boolean z3, boolean z4) {
        Context context;
        Context contextWrapContextIfNeed;
        com.kwad.sdk.core.b.b.we();
        Activity currentActivity = com.kwad.sdk.core.b.b.getCurrentActivity();
        if (currentActivity == null || (context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext()) == null || (contextWrapContextIfNeed = Wrapper.wrapContextIfNeed(context)) == null) {
            return;
        }
        e eVar = new e(contextWrapContextIfNeed, adTemplate, z2, z3, z4);
        View viewFindViewById = currentActivity.getWindow().getDecorView().findViewById(R.id.content);
        if (viewFindViewById instanceof FrameLayout) {
            eVar.a((FrameLayout) viewFindViewById);
            this.YA = eVar;
            a(adTemplate, z2, z4);
        }
        if (z4) {
            com.kwad.sdk.core.b.b.we();
            com.kwad.sdk.kwai.kwai.kwai.b.J(com.kwad.sdk.core.b.b.getCurrentActivity());
            bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.9
                @Override // java.lang.Runnable
                public final void run() {
                    if (c.this.YA != null) {
                        c.this.YA.dismiss();
                        c.a(c.this, (e) null);
                        c cVar = c.this;
                        c.g(adTemplate, 2);
                    }
                }
            }, 5000L);
        }
    }

    private static void a(Map<String, Integer> map, String str) {
        map.put(str, map.containsKey(str) ? Integer.valueOf(map.get(str).intValue() + 1) : 1);
    }

    private static boolean ag(AdTemplate adTemplate) {
        String strA;
        if (adTemplate == null) {
            return false;
        }
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null || aj.ah(context, com.kwad.sdk.core.response.a.a.ar(adInfoCb)) || (strA = com.kwad.sdk.core.download.a.A(adInfoCb)) == null || TextUtils.isEmpty(strA)) {
            return false;
        }
        return new File(strA).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(final AdTemplate adTemplate) {
        a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.c.7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                if (i2 != -1) {
                    if (i2 == -2) {
                        c cVar = c.this;
                        c.g(adTemplate, 1);
                        return;
                    }
                    return;
                }
                i iVar = new i();
                iVar.bh(29);
                iVar.bm(23);
                com.kwad.sdk.core.report.a.a(adTemplate, iVar);
                com.kwad.sdk.kwai.kwai.a.th();
            }
        });
        bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.8
            @Override // java.lang.Runnable
            public final void run() {
                if (com.kwad.sdk.kwai.kwai.a.th()) {
                    c cVar = c.this;
                    c.g(adTemplate, 2);
                }
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(final AdTemplate adTemplate, final boolean z2) {
        bh.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.3
            @Override // java.lang.Runnable
            public final void run() {
                int iUu = com.kwad.sdk.core.config.d.uu();
                if (z2 && iUu == 2) {
                    c.this.a(adTemplate, (DialogInterface.OnDismissListener) null, new DialogInterface.OnClickListener() { // from class: com.kwad.sdk.kwai.kwai.c.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            if (i2 == -1) {
                                i iVar = new i();
                                iVar.bh(29);
                                iVar.bm(23);
                                com.kwad.sdk.core.report.a.a(adTemplate, iVar);
                                com.kwad.sdk.kwai.kwai.a.th();
                                return;
                            }
                            if (i2 == -2) {
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                c cVar = c.this;
                                c.g(adTemplate, 1);
                            }
                        }
                    });
                } else {
                    c.this.a(adTemplate, z2, iUu, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(AdTemplate adTemplate, int i2) {
        com.kwad.sdk.core.report.a.a(adTemplate, new i().bh(69).bm(23).bq(i2));
    }

    public static c tm() {
        return a.YL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tq() {
        if (!this.YF && com.kwad.sdk.kwai.kwai.kwai.b.cO() <= 0) {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.6
                @Override // java.lang.Runnable
                @SuppressLint({"WrongConstant"})
                public final void run() {
                    try {
                        AdTemplate adTemplateTk = b.tj().tk();
                        if (adTemplateTk == null || com.kwad.sdk.core.config.d.uv() == 0) {
                            return;
                        }
                        c.this.YF = true;
                        com.kwad.sdk.core.b.b.we();
                        com.kwad.sdk.kwai.kwai.kwai.b.J(com.kwad.sdk.core.b.b.getCurrentActivity());
                        c.this.al(adTemplateTk);
                    } catch (Throwable th) {
                        com.kwad.components.core.c.a.b(th);
                    }
                }
            });
        }
    }

    public final void aR(boolean z2) {
        this.YE = z2;
    }

    public final void ah(AdTemplate adTemplate) {
        if (ag(adTemplate)) {
            this.YD.add(adTemplate);
        }
    }

    public final void ai(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        this.YD.remove(adTemplate);
    }

    public final void aj(final AdTemplate adTemplate) {
        int iUt = com.kwad.sdk.core.config.d.ut();
        if (adTemplate == null || iUt <= 0) {
            return;
        }
        final AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        if (adTemplate.mAdScene.getAdStyle() == 0) {
            return;
        }
        String strValueOf = String.valueOf(com.kwad.sdk.core.response.a.d.ck(adTemplate));
        int iIntValue = 0;
        if (this.YB.containsKey(strValueOf)) {
            iIntValue = this.YB.get(strValueOf).intValue();
            this.YB.put(strValueOf, Integer.valueOf(iIntValue));
        }
        if (iIntValue > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.1
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = adInfoCb.status;
                if (i2 == 12 || i2 == 10) {
                    return;
                }
                c.this.f(adTemplate, true);
            }
        }, iUt, TimeUnit.SECONDS);
    }

    public final void ak(final AdTemplate adTemplate) {
        int iUF = com.kwad.sdk.core.config.d.uF();
        if (iUF < 0) {
            return;
        }
        final AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        String strValueOf = String.valueOf(adInfoCb.adBaseInfo.creativeId);
        int iIntValue = 0;
        if (this.YC.containsKey(strValueOf)) {
            iIntValue = this.YC.get(strValueOf).intValue();
            this.YC.put(strValueOf, Integer.valueOf(iIntValue));
        }
        if (iIntValue > 0) {
            return;
        }
        g.schedule(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.2
            @Override // java.lang.Runnable
            public final void run() {
                if (aj.ai(KsAdSDK.getContext(), com.kwad.sdk.core.response.a.a.ar(adInfoCb)) == 1) {
                    return;
                }
                c.this.f(adTemplate, false);
            }
        }, iUF, TimeUnit.SECONDS);
    }

    public final void dismiss() {
        com.kwad.sdk.kwai.kwai.a.th();
        e eVar = this.YA;
        if (eVar != null) {
            eVar.dismiss();
            this.YA = null;
        }
    }

    @Nullable
    public final AdTemplate tn() {
        AdTemplate adTemplate = null;
        while (!this.YD.isEmpty()) {
            AdTemplate adTemplatePop = this.YD.pop();
            if (ag(adTemplatePop)) {
                adTemplate = adTemplatePop;
            }
        }
        if (adTemplate != null) {
            this.YD.add(0, adTemplate);
        }
        return adTemplate;
    }

    @SuppressLint({"WrongConstant"})
    public final void to() {
        b.tj().a(new b.a() { // from class: com.kwad.sdk.kwai.kwai.c.4
            @Override // com.kwad.sdk.kwai.kwai.b.a
            public final void gM() {
                bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (c.this.YE) {
                            c.this.YG = true;
                        } else {
                            c.this.tq();
                        }
                    }
                }, com.kwad.sdk.core.config.d.uw());
            }

            @Override // com.kwad.sdk.kwai.kwai.b.a
            public final void tl() {
                com.kwad.sdk.core.d.b.d("InstallTipsManager", "showInitDelayDialog failed");
            }
        });
    }

    public final void tp() {
        aR(false);
        if (this.YF || !this.YG) {
            return;
        }
        bh.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.c.5
            @Override // java.lang.Runnable
            public final void run() {
                c.this.tq();
            }
        }, 5000L);
    }

    public final void tr() {
        this.YA = null;
    }
}
