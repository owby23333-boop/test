package com.anythink.rewardvideo.a;

import android.app.Activity;
import android.content.Context;
import com.anythink.core.api.ATAdStatusInfo;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.n;
import com.anythink.core.common.h;
import com.anythink.core.common.j;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.s;
import com.anythink.core.common.v;
import com.anythink.rewardvideo.api.ATRewardVideoAutoLoadListener;
import com.anythink.rewardvideo.api.ATRewardVideoListener;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.anythink.core.common.f<f> {
    public static final String a = "a";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    Runnable f12716n;

    private a(Context context, String str) {
        super(context, str);
        this.f12716n = new Runnable() { // from class: com.anythink.rewardvideo.a.a.2
            @Override // java.lang.Runnable
            public final void run() {
                if (a.this.j()) {
                    a.this.a(n.a().E(), 4, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
                }
            }
        };
    }

    private void m() {
        n.a().a(this.f12716n, ((long) Math.pow(2.0d, this.f7397h)) * 1000);
    }

    @Override // com.anythink.core.common.f
    public final /* synthetic */ h a(j jVar) {
        f fVar = (f) jVar;
        b bVar = new b(fVar.a());
        bVar.a(fVar.f7583d);
        return bVar;
    }

    @Override // com.anythink.core.common.f
    protected final String a() {
        return "1";
    }

    @Override // com.anythink.core.common.f
    protected final boolean j() {
        return v.a().f(this.f7392c);
    }

    @Override // com.anythink.core.common.f
    protected final void k() {
        n.a().c(this.f12716n);
    }

    @Override // com.anythink.core.common.f
    protected final void l() {
        ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener;
        super.l();
        if (!j() || (aTRewardVideoAutoLoadListener = d.a().b) == null) {
            return;
        }
        aTRewardVideoAutoLoadListener.onRewardVideoAutoLoaded(this.f7392c);
    }

    @Override // com.anythink.core.common.f
    protected final void b(AdError adError) {
        super.b(adError);
        if (j()) {
            n.a().a(this.f12716n, ((long) Math.pow(2.0d, this.f7397h)) * 1000);
            ATRewardVideoAutoLoadListener aTRewardVideoAutoLoadListener = d.a().b;
            if (aTRewardVideoAutoLoadListener != null) {
                aTRewardVideoAutoLoadListener.onRewardVideoAutoLoadFail(this.f7392c, adError);
            }
        }
    }

    public static a a(Context context, String str) {
        com.anythink.core.common.f fVarB = v.a().b(str);
        if (fVarB == null || !(fVarB instanceof a)) {
            fVarB = new a(context, str);
            v.a().a(str, fVarB);
        }
        return (a) fVarB;
    }

    public final synchronized void a(final Activity activity, final String str, final ATRewardVideoListener aTRewardVideoListener, final ATEventInterface aTEventInterface, final Map<String, Object> map) {
        final com.anythink.core.common.e.b bVarA = a((Context) activity, false, true, map);
        if (bVarA != null && (bVarA.e() instanceof CustomRewardVideoAdapter)) {
            a(bVarA);
            f();
            bVarA.a(bVarA.d() + 1);
            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.anythink.core.common.e.e trackingInfo = bVarA.e().getTrackingInfo();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (trackingInfo != null) {
                        trackingInfo.f7248v = ((com.anythink.core.common.f) a.this).f7396g;
                        trackingInfo.C = str;
                        trackingInfo.h(g.a(trackingInfo.X(), trackingInfo.x(), jCurrentTimeMillis));
                        s.a(((com.anythink.core.common.f) a.this).b, trackingInfo);
                        s.a((Map<String, Object>) map, trackingInfo);
                    }
                    com.anythink.core.common.a.a().a(((com.anythink.core.common.f) a.this).b, bVarA);
                    com.anythink.core.common.j.a.a(((com.anythink.core.common.f) a.this).b).a(13, trackingInfo, bVarA.e().getUnitGroupInfo(), jCurrentTimeMillis);
                    final CustomRewardVideoAdapter customRewardVideoAdapter = (CustomRewardVideoAdapter) bVarA.e();
                    Activity activity2 = activity;
                    if (activity2 != null) {
                        customRewardVideoAdapter.refreshActivityContext(activity2);
                    }
                    n.a().a(new Runnable() { // from class: com.anythink.rewardvideo.a.a.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            customRewardVideoAdapter.setScenario(str);
                            IExHandler iExHandlerB = n.a().b();
                            if (iExHandlerB != null) {
                                CustomRewardVideoAdapter customRewardVideoAdapter2 = customRewardVideoAdapter;
                                customRewardVideoAdapter2.setAdDownloadListener(iExHandlerB.createDownloadListener(customRewardVideoAdapter2, null, aTEventInterface));
                            }
                            CustomRewardVideoAdapter customRewardVideoAdapter3 = customRewardVideoAdapter;
                            customRewardVideoAdapter3.internalShow(activity, new e(customRewardVideoAdapter3, n.a().B(), aTRewardVideoListener));
                        }
                    });
                }
            });
            return;
        }
        if (a((ATAdStatusInfo) null)) {
            a(n.a().E(), 7, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, map);
        }
        AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noADError, "", "No Cache.");
        if (aTRewardVideoListener != null) {
            aTRewardVideoListener.onRewardedVideoAdPlayFailed(errorCode, com.anythink.core.common.b.j.a((com.anythink.core.common.b.d) null));
        }
    }

    public final void a(Context context, int i2, com.anythink.core.common.b.a aVar, com.anythink.core.common.b.b bVar, Map<String, Object> map) {
        f fVar = new f();
        fVar.a(context);
        fVar.f7583d = i2;
        fVar.f7584e = bVar;
        if (map != null) {
            try {
                fVar.f7586g = new HashMap(map);
            } catch (Throwable unused) {
            }
        }
        super.a(this.b, "1", this.f7392c, fVar, aVar);
    }

    private static h a(f fVar) {
        b bVar = new b(fVar.a());
        bVar.a(fVar.f7583d);
        return bVar;
    }

    @Override // com.anythink.core.common.f
    public final ATAdStatusInfo a(Context context, Map<String, Object> map) {
        ATAdStatusInfo aTAdStatusInfoA = super.a(context, map);
        if (!c() && a(aTAdStatusInfoA)) {
            a(context, 5, (com.anythink.core.common.b.a) null, (com.anythink.core.common.b.b) null, (Map<String, Object>) null);
        }
        return aTAdStatusInfoA;
    }
}
