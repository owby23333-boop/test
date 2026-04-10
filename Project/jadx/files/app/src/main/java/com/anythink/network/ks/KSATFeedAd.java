package com.anythink.network.ks;

import android.content.Context;
import android.view.View;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.kwad.sdk.api.KsFeedAd;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class KSATFeedAd extends CustomNativeAd {
    Context a;
    KsFeedAd b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    View f12488c;

    /* JADX INFO: renamed from: com.anythink.network.ks.KSATFeedAd$1, reason: invalid class name */
    final class AnonymousClass1 implements KsFeedAd.AdInteractionListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onAdClicked() {
            KSATFeedAd.this.notifyAdClicked();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onAdShow() {
            KSATInitManager.getInstance().a(KSATFeedAd.this.getShowId(), new WeakReference(KSATFeedAd.this.b));
            KSATFeedAd.this.notifyAdImpression();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onDislikeClicked() {
            KSATFeedAd.this.notifyAdDislikeClick();
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onDownloadTipsDialogDismiss() {
        }

        @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
        public final void onDownloadTipsDialogShow() {
        }
    }

    public KSATFeedAd(Context context, KsFeedAd ksFeedAd, boolean z2) {
        this.a = context.getApplicationContext();
        this.b = ksFeedAd;
        try {
            this.b.setVideoSoundEnable(z2);
            setNativeInteractionType(this.b.getInteractionType() == 2 ? 3 : this.b.getInteractionType() == 1 ? 1 : 0);
            if (this.b.getMaterialType() == 1) {
                this.mAdSourceType = "1";
            } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2) {
                this.mAdSourceType = "2";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.b.setAdInteractionListener(new AnonymousClass1());
    }

    private void a(boolean z2) {
        try {
            this.b.setVideoSoundEnable(z2);
            int i2 = this.b.getInteractionType() == 1 ? 1 : 0;
            if (this.b.getInteractionType() == 2) {
                i2 = 3;
            }
            setNativeInteractionType(i2);
            if (this.b.getMaterialType() == 1) {
                this.mAdSourceType = "1";
            } else if (this.b.getMaterialType() == 3 || this.b.getMaterialType() == 2) {
                this.mAdSourceType = "2";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.b.setAdInteractionListener(new AnonymousClass1());
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void clear(View view) {
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.core.api.BaseAd
    public void destroy() {
        KsFeedAd ksFeedAd = this.b;
        if (ksFeedAd != null) {
            ksFeedAd.setAdInteractionListener(null);
            this.b = null;
        }
        this.a = null;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a, com.anythink.core.api.IATThirdPartyMaterial
    public View getAdMediaView(Object... objArr) {
        try {
            if (this.f12488c == null) {
                this.f12488c = this.b.getFeedView(this.a);
            }
            return this.f12488c;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public boolean isNativeExpress() {
        return true;
    }

    @Override // com.anythink.nativead.unitgroup.api.CustomNativeAd, com.anythink.nativead.unitgroup.a
    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
    }
}
