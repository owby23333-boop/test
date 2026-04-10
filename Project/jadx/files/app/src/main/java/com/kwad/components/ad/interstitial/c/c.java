package com.kwad.components.ad.interstitial.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.kwad.components.core.d.b.a;
import com.kwad.components.core.video.a;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.widget.KSFrameLayout;
import com.tencent.smtt.sdk.TbsListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends com.kwad.sdk.mvp.a {

    @NonNull
    public KsAdVideoPlayConfig dY;
    public com.kwad.sdk.core.video.videoview.a eM;
    public com.kwad.components.ad.interstitial.d.b hI;
    public KsInterstitialAd.AdInteractionListener hK;
    public com.kwad.components.ad.interstitial.d hR;

    @NonNull
    public KSFrameLayout jA;
    public d jB;
    public boolean jF;
    public com.kwad.components.ad.interstitial.e.f jr;
    public boolean jt;
    public boolean ju;
    public boolean jv;
    public a jw;
    public com.kwad.components.core.webview.a.d.b jz;
    public com.kwad.components.core.d.b.c mApkDownloadHelper;
    public List<a> jx = new CopyOnWriteArrayList();
    public List<i> jy = new CopyOnWriteArrayList();
    private Handler mHandler = new Handler(Looper.getMainLooper());
    public volatile boolean jE = false;
    public int jG = -1;
    public List<a.c> jD = new CopyOnWriteArrayList();
    private List<e> js = new CopyOnWriteArrayList();
    public List<InterfaceC0358c> jC = new ArrayList();

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.c.c$4, reason: invalid class name */
    final class AnonymousClass4 implements ImageLoadingListener {
        final /* synthetic */ View fm;
        final /* synthetic */ Context jL;

        AnonymousClass4(Context context, View view) {
            this.jL = context;
            this.fm = view;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            com.kwad.sdk.utils.g.execute(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.c.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmap = decodedResult.mBitmap;
                    com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "onLoadingComplete before blur");
                    Bitmap bitmapStackBlur = BlurUtils.stackBlur(bitmap, 50, false);
                    com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "onLoadingComplete after blur");
                    float dimension = AnonymousClass4.this.jL.getResources().getDimension(R.dimen.ksad_interstitial_icon_radius);
                    final RoundedBitmapDrawable roundedBitmapDrawableCreate = RoundedBitmapDrawableFactory.create(AnonymousClass4.this.jL.getResources(), bitmapStackBlur);
                    roundedBitmapDrawableCreate.setCornerRadius(dimension);
                    AnonymousClass4.this.fm.post(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.c.4.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            AnonymousClass4.this.fm.setBackground(roundedBitmapDrawableCreate);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    public interface a {
        void cr();
    }

    public static class b {
        private final Context context;
        private int jQ;
        private boolean jR;
        private int jS;
        private boolean jT;
        private ab.a jU;
        public double jV;
        public boolean jW;

        public b(Context context) {
            this.context = context;
        }

        public final b C(int i2) {
            this.jQ = i2;
            return this;
        }

        public final b D(int i2) {
            this.jS = i2;
            return this;
        }

        public final b a(ab.a aVar) {
            this.jU = aVar;
            return this;
        }

        public final b c(double d2) {
            this.jV = d2;
            return this;
        }

        public final int db() {
            return this.jQ;
        }

        public final boolean dc() {
            return this.jR;
        }

        public final boolean dd() {
            return this.jT;
        }

        public final int de() {
            return this.jS;
        }

        public final double df() {
            return this.jV;
        }

        public final Context getContext() {
            return this.context;
        }

        public final ab.a getTouchCoords() {
            return this.jU;
        }

        public final b k(boolean z2) {
            this.jR = z2;
            return this;
        }

        public final b l(boolean z2) {
            this.jT = true;
            return this;
        }

        public final b m(boolean z2) {
            this.jW = true;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.c.c$c, reason: collision with other inner class name */
    public interface InterfaceC0358c {
        void dg();
    }

    public interface d {
        void dh();
    }

    interface e {
        void onError();
    }

    private static int a(long j2, @NonNull AdTemplate adTemplate) {
        if (j2 == -1) {
            return -1;
        }
        float fG = com.kwad.sdk.core.response.a.a.G(com.kwad.sdk.core.response.a.d.cb(adTemplate)) / 1000.0f;
        if (fG != 0.0f) {
            return Math.round((j2 / fG) * 100.0f);
        }
        return -1;
    }

    private static long a(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1L;
        }
        return aVar.getCurrentPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3, Context context) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.i().bj(i2).bf(i3).br(ah.cu(context) ? 2 : 1).xk(), (JSONObject) null);
        if (!this.jv && (adInteractionListener = this.hK) != null) {
            adInteractionListener.onAdClicked();
        }
        this.jt = true;
        if (this.jv) {
            return;
        }
        cr();
    }

    public static boolean a(Context context, AdInfo adInfo) {
        return com.kwad.sdk.core.response.a.a.aP(adInfo) && !ah.cu(context);
    }

    private static int b(@Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        if (aVar == null) {
            return -1;
        }
        long duration = aVar.getDuration();
        long currentPosition = aVar.getCurrentPosition();
        if (duration != 0) {
            return Math.round((currentPosition / duration) * 100.0f);
        }
        return -1;
    }

    public final boolean M(Context context) {
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null && context != null) {
            return com.kwad.sdk.core.response.a.a.bu(com.kwad.sdk.core.response.a.d.cb(adTemplate));
        }
        com.kwad.sdk.core.d.b.w("InterstitialCallerContext", "isPlayable illegal params: " + this.mAdTemplate + ", context: " + context);
        return false;
    }

    public final void a(final Context context, final int i2, int i3, int i4) {
        final int i5 = 9;
        com.kwad.components.core.d.b.a.a(new a.C0395a(context).J(this.mAdTemplate).b(this.mApkDownloadHelper).al(false).ap(2).an(6).ao(i2).a(new a.b() { // from class: com.kwad.components.ad.interstitial.c.c.3
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                c.this.a(i5, i2, context);
            }
        }));
    }

    public final void a(Context context, AdInfo adInfo, AdTemplate adTemplate, @Nullable View view) {
        if (view == null) {
            return;
        }
        String url = com.kwad.sdk.core.response.a.a.bh(adInfo).getUrl();
        if (ba.isNullString(url)) {
            return;
        }
        KSImageLoader.loadImage(url, adTemplate, KSImageLoader.IMGOPTION_NORMAL, new AnonymousClass4(context, view));
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jx.add(aVar);
    }

    public final void a(final b bVar) {
        boolean z2 = bVar.db() == 1;
        if ((com.kwad.components.ad.interstitial.kwai.b.cK() || z2 || bVar.dd() || bVar.jW) && com.kwad.components.core.d.b.a.a(new a.C0395a(bVar.getContext()).J(this.mAdTemplate).b(this.mApkDownloadHelper).al(z2).an(1).ao(bVar.jS).ap(bVar.db()).a(new a.b() { // from class: com.kwad.components.ad.interstitial.c.c.1
            @Override // com.kwad.components.core.d.b.a.b
            public final void onAdClicked() {
                c.this.b(bVar);
            }
        })) == 0 && this.hR != null && com.kwad.components.ad.interstitial.kwai.b.cN()) {
            a(false, -1, this.eM);
            this.mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.interstitial.c.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.hR.dismiss();
                }
            }, 500L);
        }
    }

    public final void a(e eVar) {
        this.js.add(eVar);
    }

    public final void a(i iVar) {
        if (iVar == null) {
            return;
        }
        this.jy.add(iVar);
    }

    public final void a(a.c cVar) {
        if (this.jD.contains(cVar)) {
            return;
        }
        this.jD.add(cVar);
    }

    public final void a(boolean z2, int i2, @Nullable com.kwad.sdk.core.video.videoview.a aVar) {
        long jA;
        int iA;
        if (aVar != null) {
            jA = a(aVar);
            iA = b(aVar);
        } else {
            jA = i2;
            iA = a(jA, this.mAdTemplate);
        }
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, z2 ? 14 : 1, jA, iA, this.hR.getTimerHelper().getTime(), null);
    }

    public final void b(Context context, AdTemplate adTemplate) {
        if (this.jE) {
            return;
        }
        com.kwad.components.core.page.a.launch(context, adTemplate);
        this.jE = true;
    }

    public final void b(a aVar) {
        if (aVar == null) {
            return;
        }
        this.jx.remove(aVar);
    }

    public final void b(b bVar) {
        KsInterstitialAd.AdInteractionListener adInteractionListener;
        com.kwad.sdk.core.report.i iVar = new com.kwad.sdk.core.report.i();
        iVar.c(bVar.getTouchCoords());
        if (!bVar.dc() && !bVar.jT) {
            bVar.D(TbsListener.ErrorCode.STARTDOWNLOAD_LOCKED_IO_FAILED);
        }
        com.kwad.sdk.core.report.a.a(this.mAdTemplate, new com.kwad.sdk.core.report.i().bf(bVar.de()).c(bVar.getTouchCoords()).br(ah.cu(bVar.context) ? 2 : 1).i(bVar.df()), (JSONObject) null);
        com.kwad.sdk.core.video.videoview.a aVar = this.eM;
        if (aVar != null) {
            long jA = a(aVar);
            int iB = b(this.eM);
            iVar.R(jA);
            iVar.bk(iB);
        }
        if (!this.jv && (adInteractionListener = this.hK) != null) {
            adInteractionListener.onAdClicked();
        }
        this.jt = true;
        if (this.jv) {
            return;
        }
        cr();
    }

    public final void b(i iVar) {
        if (iVar == null) {
            return;
        }
        this.jy.remove(iVar);
    }

    public final void b(a.c cVar) {
        this.jD.remove(cVar);
    }

    public final void cV() {
        List<e> list = this.js;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (e eVar : this.js) {
            if (eVar != null) {
                eVar.onError();
            }
        }
    }

    public final void cW() {
        d dVar = this.jB;
        if (dVar != null) {
            dVar.dh();
        }
    }

    public final void cX() {
        Iterator<InterfaceC0358c> it = this.jC.iterator();
        while (it.hasNext()) {
            it.next().dg();
        }
    }

    public final void cY() {
        Iterator<i> it = this.jy.iterator();
        while (it.hasNext()) {
            it.next().dA();
        }
    }

    public final void cZ() {
        Iterator<i> it = this.jy.iterator();
        while (it.hasNext()) {
            it.next().dB();
        }
    }

    public final void cr() {
        Iterator<a> it = this.jx.iterator();
        while (it.hasNext()) {
            it.next().cr();
        }
        a aVar = this.jw;
        if (aVar != null) {
            aVar.cr();
        }
    }

    public final boolean da() {
        com.kwad.components.ad.interstitial.e.f fVar = this.jr;
        boolean z2 = fVar == null || fVar.getParent() == null;
        com.kwad.sdk.core.d.b.d("InterstitialCallerContext", "isH5Interstitial :" + z2);
        return z2;
    }

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.jD.clear();
        this.js.clear();
        this.jC.clear();
        this.jy.clear();
        com.kwad.components.ad.interstitial.d.b bVar = this.hI;
        if (bVar != null) {
            bVar.rV();
        }
    }
}
