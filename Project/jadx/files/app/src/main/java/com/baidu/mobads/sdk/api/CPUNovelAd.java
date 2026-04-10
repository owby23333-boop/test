package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.internal.cv;

/* JADX INFO: loaded from: classes2.dex */
public class CPUNovelAd {
    private cv mCpuNovelProd;

    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j2);
    }

    public CPUNovelAd(Context context, String str, CPUWebAdRequestParam cPUWebAdRequestParam, CpuNovelListener cpuNovelListener) {
        this.mCpuNovelProd = new cv(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }

    public void destory() {
        cv cvVar = this.mCpuNovelProd;
        if (cvVar != null) {
            cvVar.x();
        }
    }

    public View getNovelView() {
        return this.mCpuNovelProd.v();
    }
}
