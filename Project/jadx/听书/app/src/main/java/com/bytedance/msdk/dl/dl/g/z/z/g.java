package com.bytedance.msdk.dl.dl.g.z.z;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.z.g.g.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends com.bytedance.msdk.dl.dl.g.z.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bytedance.msdk.dl.m.g.g f444a;
    protected Function<SparseArray<Object>, Object> dl;
    protected int e;
    private String fo;
    protected com.bytedance.msdk.api.a.z.g.dl.dl g;
    protected Map<String, Object> gc;
    protected int gz;
    private com.bytedance.msdk.api.z.g kb;
    protected boolean m;
    private String uy;

    public abstract <T> T z(int i, PluginValueSet pluginValueSet, Class<T> cls);

    public g(String str, com.bytedance.msdk.dl.z.g gVar) {
        super(gVar);
        this.gc = new ConcurrentHashMap();
        this.m = false;
        this.e = 0;
        this.gz = 0;
        this.uy = str;
    }

    public void z(int i, String str) {
        z(new com.bytedance.msdk.api.z(i, str));
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g
    public final void g(Context context, com.bytedance.msdk.dl.m.g.g gVar, com.bytedance.msdk.api.z.g gVar2, Map<String, Object> map) {
        this.f444a = gVar;
        this.kb = gVar2;
        this.g = new com.bytedance.msdk.api.a.z.g.dl.dl(gVar.iq(), gVar.wp(), gVar.v(), gVar.pf(), gVar.un());
        com.bytedance.msdk.api.a.z.g.m.z zVarZ = com.bytedance.msdk.m.g.z.z(gVar.i());
        this.fo = zVarZ != null ? zVarZ.dl() : "";
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        aVarZ.z(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow, this);
        if (com.bytedance.sdk.gromore.init.z.z() >= 5900) {
            aVarZ.z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, com.bytedance.msdk.z.gc.z.z(context));
        } else {
            aVarZ.z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context);
        }
        aVarZ.z(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, this.uy);
        aVarZ.z(8546, com.bytedance.sdk.openadsdk.ls.dl.a.z(this.g.z()));
        if (gVar2.wj() != null) {
            aVarZ.z(8548, com.bytedance.sdk.openadsdk.ls.dl.a.z(gVar2.wj()));
        }
        Function<SparseArray<Object>, Object> functionE = com.bytedance.msdk.core.kb.z.z().e();
        if (functionE != null) {
            aVarZ.z(Void.class);
            aVarZ.z(8106);
            functionE.apply(aVarZ.g());
            return;
        }
        z(new com.bytedance.msdk.api.z("Adn custom class loader is null"));
    }

    @Override // com.bytedance.msdk.dl.z.z
    public String z(String str) {
        return this.fo;
    }

    public void m() {
        this.m = true;
    }

    public String e() {
        com.bytedance.msdk.dl.m.g.g gVar = this.f444a;
        return gVar != null ? gVar.uf() : "";
    }

    public Object gz() {
        com.bytedance.msdk.dl.m.g.g gVar = this.f444a;
        return gVar != null ? gVar.ti() : "";
    }

    public int fo() {
        com.bytedance.msdk.dl.m.g.g gVar = this.f444a;
        if (gVar != null) {
            return gVar.js();
        }
        return 0;
    }

    public void z(Map<String, Object> map) {
        if (map != null) {
            this.gc.clear();
            this.gc.putAll(map);
        }
    }

    public Integer uy() {
        if (this.dl != null) {
            Integer numZ = com.bytedance.sdk.openadsdk.core.ti.z.z.z(this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8121).z(Object.class).z(20068, 1).g()));
            if (numZ == null) {
                return 1;
            }
            return numZ;
        }
        return 1;
    }

    public void z(boolean z, double d, int i, Map<String, Object> map) {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8225).z(Void.class).z(8406, Boolean.valueOf(z)).z(8407, Double.valueOf(d)).z(8408, Integer.valueOf(i)).z(8075, map).g());
        }
    }

    public void kb() {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8149).z(Void.class).g());
        }
    }

    public void wp() {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8148).z(Void.class).g());
        }
    }

    public void i() {
        if (this.dl != null) {
            this.dl.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8109).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8221) {
            this.dl = (Function) pluginValueSet.objectValue(8405, Function.class);
        } else {
            if (i == 8137) {
                T t = (T) e();
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom loader : getAdm = ".concat(String.valueOf(t)));
                return t;
            }
            if (i == 8224) {
                T t2 = (T) gz();
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom loader : getExtraDataNoParse = ".concat(String.valueOf(t2)));
                return t2;
            }
            if (i == 8226) {
                T t3 = (T) Integer.valueOf(fo());
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom loader : getBiddingType = ".concat(String.valueOf(t3)));
                return t3;
            }
            if (i == 8227 && pluginValueSet != null) {
                Map<String, Object> map = (Map) pluginValueSet.objectValue(8075, Map.class);
                com.bytedance.msdk.z.gc.dl.g("TTMediationSDK", "Adn custom loader : setExtraInfo map =".concat(String.valueOf(map)));
                z(map);
            }
        }
        return (T) z(i, pluginValueSet, cls);
    }

    public final void z(z.InterfaceC0068z interfaceC0068z) {
        if (!g()) {
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter 调用错误需要在load成功之后才可以调用");
        } else if (interfaceC0068z != null) {
            interfaceC0068z.z();
        }
    }

    public final void g(z.InterfaceC0068z interfaceC0068z) {
        if (this.m) {
            int i = this.e;
            if (i < 2) {
                this.e = i + 1;
                if (interfaceC0068z != null) {
                    interfaceC0068z.z();
                    return;
                }
                return;
            }
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
    }

    public final void dl(z.InterfaceC0068z interfaceC0068z) {
        int i = this.gz;
        if (i < 60) {
            this.gz = i + 1;
            if (interfaceC0068z != null) {
                interfaceC0068z.z();
                return;
            }
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter click方法回调次数需要小于60次");
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g
    public void z(com.bytedance.msdk.g.dl dlVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(dlVar);
        z(arrayList);
    }

    protected void z(com.bytedance.msdk.g.dl dlVar, double d, Map<String, Object> map) {
        if (d > 0.0d && fo() == 1) {
            dlVar.z(d);
        }
        if (map != null) {
            this.gc.putAll(map);
        }
        dlVar.a(this.gc);
        z(dlVar);
    }

    @Override // com.bytedance.msdk.dl.dl.g.z.g, com.bytedance.msdk.dl.z.g
    public void z(List<com.bytedance.msdk.g.dl> list) {
        for (com.bytedance.msdk.g.dl dlVar : list) {
            dlVar.dl(this.gc);
            dlVar.v(this.f444a.sy());
        }
        super.z(list);
    }
}
