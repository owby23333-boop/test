package com.qq.e.ads.hybrid;

import android.content.Context;
import com.qq.e.ads.AbstractAD;
import com.qq.e.comm.pi.HADI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class HybridAD extends AbstractAD<HADI> implements HADI {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HybridADListener f17725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CountDownLatch f17726g = new CountDownLatch(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HybridADSetting f17727h;

    public HybridAD(Context context, HybridADSetting hybridADSetting, HybridADListener hybridADListener) {
        this.f17727h = hybridADSetting;
        this.f17725f = hybridADListener;
        a(context, "NO_POS_ID");
    }

    protected HADI a(POFactory pOFactory) {
        return pOFactory.getHybridAD(this.f17727h, this.f17725f);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ HADI a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return a(pOFactory);
    }

    @Override // com.qq.e.ads.AbstractAD
    protected /* bridge */ /* synthetic */ void a(HADI hadi) {
        c();
    }

    @Override // com.qq.e.ads.AbstractAD
    protected void b(int i2) {
        HybridADListener hybridADListener = this.f17725f;
        if (hybridADListener != null) {
            hybridADListener.onError(AdErrorConvertor.formatErrorCode(i2));
        }
        this.f17726g.countDown();
    }

    protected void c() {
        this.f17726g.countDown();
    }

    @Override // com.qq.e.comm.pi.HADI
    public void loadUrl(final String str) {
        if (a()) {
            if (!b()) {
                new Thread(new Runnable() { // from class: com.qq.e.ads.hybrid.HybridAD.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            HybridAD.this.f17726g.await(30L, TimeUnit.SECONDS);
                            if (!HybridAD.this.b() || ((AbstractAD) HybridAD.this).a == null) {
                                GDTLogger.e("初始化错误：广告实例未被初始化");
                                HybridAD.this.a(2001);
                            } else {
                                ((HADI) ((AbstractAD) HybridAD.this).a).loadUrl(str);
                            }
                        } catch (InterruptedException unused) {
                            GDTLogger.e("初始化错误：广告实例未被初始化");
                            HybridAD.this.a(2001);
                        }
                    }
                }).start();
                return;
            }
            T t2 = this.a;
            if (t2 != 0) {
                ((HADI) t2).loadUrl(str);
            } else {
                a("loadUrl");
            }
        }
    }
}
