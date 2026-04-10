package com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import androidx.media3.session.SessionCommand;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADZoomOutListener;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public class s extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SplashADZoomOutListener f2522a = new SplashADZoomOutListener() { // from class: com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g.s.1
        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public boolean isSupportZoomOut() {
            return true;
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADClicked() {
            t.a("onADClicked");
            if (s.this.d != null) {
                s.this.d.b();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADDismissed() {
            t.a("onADDismissed");
            if (s.this.d != null) {
                s.this.d.c();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADExposure() {
            t.a("onADExposure");
            if (s.this.d != null) {
                s.this.d.a();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADLoaded(long j) {
            t.a("onADLoaded expireTimestamp = " + j);
            s.this.a(j);
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADPresent() {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onADTick(long j) {
        }

        @Override // com.qq.e.ads.splash.SplashADListener
        public void onNoAD(AdError adError) {
            t.a("onNoAD adError = " + adError);
            s.this.a(adError);
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOut() {
            t.a("onZoomOut");
            if (s.this.d != null) {
                s.this.d.e();
            }
        }

        @Override // com.qq.e.ads.splash.SplashADZoomOutListener
        public void onZoomOutPlayFinish() {
            t.a("onZoomOutPlayFinish");
            if (s.this.d != null) {
                s.this.d.d();
            }
        }
    };
    private SplashAD b;
    private Function<SparseArray<Object>, Object> c;
    private r d;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        if (this.c != null) {
            b();
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60000);
            sparseArray.put(-99999985, null);
            sparseArray.put(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, this.d);
            sparseArray.put(50012, Long.valueOf(j));
            this.c.apply(sparseArray);
        }
    }

    private void a(Context context, String str, int i) {
        t.a("createUnifiedInterstitialAD context = " + context + " adnId = " + str + " loadTimeOut = " + i);
        if (context instanceof Activity) {
            this.b = new SplashAD(context, str, this.f2522a, i);
            if (Thread.currentThread().getName().equals("gm_t_main")) {
                return;
            }
            com.jbB1g.jbB1g.jbB1g.jbB1g.n.a(getClass().getName(), context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdError adError) {
        if (this.c != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60001);
            sparseArray.put(-99999985, null);
            sparseArray.put(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, new h(adError));
            this.c.apply(sparseArray);
        }
    }

    private void a(Object obj) {
        t.a("load ad fetchAdOnly = " + obj);
        if (this.b != null) {
            this.c = AdnAdapterBridgeWrapper.covertToFunction(obj);
            this.b.fetchAdOnly();
        }
    }

    private void a(Map<String, String> map) {
        t.a("setExtraUserData map = " + map);
        if (map != null) {
            GlobalSetting.setExtraUserData(map);
        }
    }

    private void b() {
        if (this.d == null) {
            this.d = new r(this.b, this);
        }
    }

    private void b(Object obj) {
        t.a("load ad fetchFullScreenAdOnly = " + obj);
        if (this.b != null) {
            this.c = AdnAdapterBridgeWrapper.covertToFunction(obj);
            this.b.fetchFullScreenAdOnly();
        }
    }

    private void c() {
        t.a("preload");
        SplashAD splashAD = this.b;
        if (splashAD != null) {
            splashAD.preLoad();
        }
    }

    public void a() {
        this.f2522a = null;
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40024) {
            a((Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50000), String.class, null), ((Integer) MediationValueUtil.objectValue(sparseArray.get(50011), Integer.class, 0)).intValue());
        } else if (i == 40025) {
            a((Map<String, String>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40026) {
            c();
        } else if (i == 40027) {
            a(MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1), Object.class, null));
        } else if (i == 40028) {
            b(MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1), Object.class, null));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            return valueSetValues.sparseArray();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
