package com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.splash.SplashAD;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public class r extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SplashAD f2521a;
    private Function<SparseArray<Object>, Object> b;
    private s c;

    public r(SplashAD splashAD, s sVar) {
        this.f2521a = splashAD;
        this.c = sVar;
    }

    private void a(int i) {
        SplashAD splashAD = this.f2521a;
        if (splashAD != null) {
            splashAD.sendWinNotification(i);
        }
    }

    private void a(Map<String, Object> map) {
        int iA;
        if (map == null || this.f2521a == null || (iA = com.jbB1g.jbB1g.jbB1g.jbB1g.a.a(map.get(MediationConstant.BIDDING_LOSE_REASON))) <= 0) {
            return;
        }
        this.f2521a.sendLossNotification(0, iA, null);
    }

    private void f() {
        this.f2521a = null;
        s sVar = this.c;
        if (sVar != null) {
            sVar.a();
            this.c = null;
        }
    }

    private Map<String, Object> g() {
        SplashAD splashAD = this.f2521a;
        if (splashAD != null) {
            return splashAD.getExtraInfo();
        }
        return null;
    }

    public void a() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60009);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40003) {
            SplashAD splashAD = this.f2521a;
            int ecpm = splashAD != null ? splashAD.getECPM() : -1;
            t.a("getECPM ecpm = " + ecpm);
            return (T) Integer.valueOf(ecpm);
        }
        if (i == 40004) {
            SplashAD splashAD2 = this.f2521a;
            Object obj = splashAD2 != null ? (T) splashAD2.getECPMLevel() : (T) "";
            t.a("getECPMLevel level = " + ((String) obj));
            return (T) obj;
        }
        if (i == 40008) {
            ViewGroup viewGroup = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(50013), ViewGroup.class, null);
            if (this.f2521a != null && viewGroup != null) {
                t.a("showAD  viewGroup  = " + viewGroup);
                this.f2521a.showAd(viewGroup);
            }
        } else if (i == 40029) {
            ViewGroup viewGroup2 = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(50013), ViewGroup.class, null);
            if (this.f2521a != null && viewGroup2 != null) {
                t.a("showAD  viewGroup  = " + viewGroup2);
                this.f2521a.showFullScreenAd(viewGroup2);
            }
        } else if (i == 40009) {
            this.b = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(50009), Object.class, null));
        } else {
            if (i == 40010) {
                SplashAD splashAD3 = this.f2521a;
                T t = (T) Boolean.valueOf(splashAD3 != null ? splashAD3.isValid() : false);
                t.a("isValid  flag  = " + t);
                return t;
            }
            if (i == 40011) {
                t.a("onDestroy");
                f();
            } else {
                if (i == 40012) {
                    T t2 = (T) Boolean.valueOf(this.f2521a == null);
                    t.a("hasDestroy  flag  = " + t2);
                    return t2;
                }
                if (i == 40013) {
                    int iIntValue = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50007), Integer.class, 0)).intValue();
                    t.a("sendWinNotification  ecpm  = " + iIntValue);
                    a(iIntValue);
                } else if (i == 40014) {
                    Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null);
                    t.a("sendLossNotification  map  = " + map);
                    a(map);
                } else if (i == 40015) {
                    T t3 = (T) g();
                    t.a("getExtraInfo  map  = " + t3);
                    return t3;
                }
            }
        }
        return null;
    }

    public void b() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60004);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    public void c() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60013);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    public void d() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60014);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    public void e() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60015);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
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
