package com.xiaomi.ad;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.xiaomi.ad.mediation.internal.DspWeight;
import com.xiaomi.ad.mediation.internal.loader.AdInternalConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class p {
    public static final String TAG = "BaseAd";
    public String mAdId;
    public long mAdShowTime;
    public AdInternalConfig mConfig;
    public Context mContext;
    public long mExpireTime;
    public int mWeight;
    public boolean mDownloadFinished = false;
    public boolean mDownloading = false;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    public List<DspWeight> mDspWeightList = new ArrayList();
    public boolean mDestroyed = false;
    public Runnable mRunnable = new a(this);
    public long mAdCreateTime = z.c().a();

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<p> f7283a;

        public a(p pVar) {
            this.f7283a = new WeakReference<>(pVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<p> weakReference = this.f7283a;
            p pVar = weakReference != null ? weakReference.get() : null;
            if (pVar != null) {
                pVar.mDownloadFinished = false;
            }
        }
    }

    public p(Context context, AdInternalConfig adInternalConfig) {
        this.mContext = context.getApplicationContext();
        this.mConfig = adInternalConfig;
        this.mExpireTime = adInternalConfig.timeout;
    }

    public String getAdId() {
        return this.mAdId;
    }

    public abstract String getAdType();

    public abstract String getDspName();

    public List<DspWeight> getDspWeightList() {
        return this.mDspWeightList;
    }

    public long getExpireTime() {
        long jA = (this.mAdCreateTime + this.mExpireTime) - z.c().a();
        if (jA > 0) {
            return jA;
        }
        return 0L;
    }

    public String getPlaceMentId() {
        AdInternalConfig adInternalConfig = this.mConfig;
        return adInternalConfig != null ? adInternalConfig.adPositionId : "";
    }

    public int getWeight() {
        return this.mWeight;
    }

    public boolean isDestroyed() {
        return this.mDestroyed;
    }

    public boolean isExpired() {
        return z.c().a() - (this.mAdCreateTime + this.mExpireTime) >= 0;
    }

    public void removeDownloadMonitorHandler() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mRunnable);
        }
    }

    public void resetDownState() {
        this.mDownloadFinished = false;
        this.mHandler.removeCallbacks(this.mRunnable);
    }

    public void setAdId(String str) {
        this.mAdId = str;
    }

    public void setDestroyed(boolean z) {
        this.mDestroyed = z;
    }

    public void setDownLoadState() {
        this.mDownloadFinished = true;
        this.mHandler.postDelayed(this.mRunnable, 60000L);
    }

    public void setWeight(int i) {
        this.mWeight = i;
    }
}
