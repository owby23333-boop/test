package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class RewardActionBarControl {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private j qS;
    private b uF;

    @Nullable
    private e uI;

    @Nullable
    private c uJ;

    @Nullable
    private d uK;
    private final long uM;

    @NonNull
    private a uL = new a(0);
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean uN = false;
    private boolean uO = false;

    public enum ShowActionBarResult {
        SHOW_NATIVE_DEFAULT,
        SHOW_H5_SUCCESS,
        SHOW_H5_FAILURE,
        SHOW_ORDER,
        TK,
        SHOW_NATIVE_ORDER,
        SHOW_NATIVE_JINNIU,
        SHOW_NATIVE_PLAYABLE_PORTRAIT,
        SHOW_NATIVE_LIVE_SUBSCRIBE,
        SHOW_NATIVE_ORIGIN_LIVE
    }

    static class a implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
        private List<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> uT;
        private ShowActionBarResult uU;

        private a() {
            this.uT = new CopyOnWriteArrayList();
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
        public final void a(ShowActionBarResult showActionBarResult, View view) {
            com.kwad.sdk.core.d.b.d("ActionBarControl", "onActionBarShown result: " + showActionBarResult);
            this.uU = showActionBarResult;
            Iterator<com.kwad.components.ad.reward.presenter.platdetail.actionbar.a> it = this.uT.iterator();
            while (it.hasNext()) {
                it.next().a(showActionBarResult, view);
            }
        }

        public final void c(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.uT.add(aVar);
        }

        public final void d(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
            this.uT.remove(aVar);
        }
    }

    public interface b {
        void a(boolean z2, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface c {
        void e(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface d {
        void f(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public interface e {
        boolean g(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar);
    }

    public RewardActionBarControl(j jVar, Context context, AdTemplate adTemplate) {
        this.qS = jVar;
        this.mContext = context;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        long jAR = !com.kwad.sdk.core.response.a.a.ci(this.mAdInfo) ? com.kwad.sdk.core.response.a.b.aR(adTemplate) : 1000L;
        this.uM = jAR <= 0 ? 1000L : jAR;
    }

    private ShowActionBarResult T(boolean z2) {
        c cVar;
        d dVar;
        if (j.d(this.qS) && (dVar = this.uK) != null) {
            dVar.f(this.uL);
            return ShowActionBarResult.TK;
        }
        if (com.kwad.components.ad.reward.kwai.b.j(this.mAdInfo) && (cVar = this.uJ) != null) {
            cVar.e(this.uL);
            return ShowActionBarResult.SHOW_ORDER;
        }
        if (!com.kwad.sdk.core.response.a.b.aS(this.mAdTemplate) || this.uI == null) {
            U(z2);
            return ShowActionBarResult.SHOW_NATIVE_DEFAULT;
        }
        com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar success in " + this.uM);
        return this.uI.g(this.uL) ? ShowActionBarResult.SHOW_H5_SUCCESS : ShowActionBarResult.SHOW_H5_FAILURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(boolean z2) {
        if (this.uF != null) {
            com.kwad.sdk.core.d.b.d("ActionBarControl", "showNativeActionBar");
            this.uO = true;
            this.uF.a(z2, this.uL);
        }
    }

    public static void a(final com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar, final View view, final ShowActionBarResult showActionBarResult) {
        if (aVar != null) {
            view.post(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.2
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(showActionBarResult, view);
                }
            });
        }
    }

    static /* synthetic */ boolean a(RewardActionBarControl rewardActionBarControl, boolean z2) {
        rewardActionBarControl.uN = true;
        return true;
    }

    public final void S(boolean z2) {
        ShowActionBarResult showActionBarResultT = T(z2);
        com.kwad.sdk.core.d.b.d("ActionBarControl", "showActionBarOnVideoStart result: " + showActionBarResultT);
        if (showActionBarResultT != ShowActionBarResult.SHOW_H5_FAILURE) {
            return;
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.1
            @Override // java.lang.Runnable
            public final void run() {
                RewardActionBarControl.a(RewardActionBarControl.this, true);
                com.kwad.sdk.core.d.b.d("ActionBarControl", "mHasOutTime");
                if (RewardActionBarControl.this.uI != null && !RewardActionBarControl.this.uO && RewardActionBarControl.this.uI.g(RewardActionBarControl.this.uL)) {
                    com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar success on " + RewardActionBarControl.this.uM);
                } else {
                    com.kwad.sdk.core.d.b.d("ActionBarControl", "showWebActionBar out " + RewardActionBarControl.this.uM);
                    com.kwad.components.core.m.a.pr().f(RewardActionBarControl.this.mAdTemplate, RewardActionBarControl.this.uM);
                    com.kwad.components.ad.reward.monitor.a.a(RewardActionBarControl.this.qS.pN, "play_card", com.kwad.sdk.core.response.a.b.aQ(RewardActionBarControl.this.qS.mAdTemplate), RewardActionBarControl.this.uM, 1);
                    RewardActionBarControl.this.U(true);
                }
            }
        }, this.uM);
    }

    @MainThread
    public final void a(b bVar) {
        this.uF = bVar;
    }

    @MainThread
    public final void a(@Nullable c cVar) {
        this.uJ = cVar;
    }

    public final void a(@Nullable d dVar) {
        this.uK = dVar;
    }

    @MainThread
    public final void a(e eVar) {
        this.uI = eVar;
    }

    public final void a(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.uL.c(aVar);
    }

    public final void b(com.kwad.components.ad.reward.presenter.platdetail.actionbar.a aVar) {
        this.uL.d(aVar);
    }

    public final void iv() {
        if (this.uN) {
            com.kwad.sdk.core.d.b.i("ActionBarControl", "showWebActionBar time out on pageStatus");
        } else {
            this.mHandler.removeCallbacksAndMessages(null);
            T(true);
        }
    }

    @Nullable
    public final ShowActionBarResult iw() {
        return this.uL.uU;
    }
}
