package com.bytedance.msdk.dl.z;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.bytedance.msdk.g.dl {
    protected Function<SparseArray<Object>, Object> fo;
    protected com.bytedance.msdk.dl.m.g.z uy;

    public abstract <T> T z(int i, PluginValueSet pluginValueSet, Class<T> cls);

    public a(com.bytedance.msdk.dl.m.g.z zVar) {
        this.uy = zVar;
    }

    public boolean qz() {
        com.bytedance.msdk.dl.m.g.z zVar = this.uy;
        if (zVar != null) {
            return zVar.z();
        }
        return false;
    }

    @Override // com.bytedance.msdk.g.dl
    public void p() {
        super.p();
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8148).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void ls() {
        super.ls();
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8149).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void fv() {
        super.fv();
        if (this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8109).z(Void.class).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public boolean gc() {
        if (this.fo == null) {
            return false;
        }
        this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8120).z(Boolean.class).g());
        return false;
    }

    @Override // com.bytedance.msdk.g.dl
    public void g(Map<String, Object> map) {
        if (k() && this.fo != null) {
            this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8142).z(Void.class).z(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).g());
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(Map<String, Object> map) {
        if (k()) {
            Object obj = map.get("bidding_lose_reason_NUM");
            int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
            if (iIntValue <= 0) {
                iIntValue = 10001;
            }
            map.put(MediationConstant.BIDDING_LOSE_REASON_DEX_ADAPTER, Integer.valueOf(com.bytedance.msdk.core.z.z.gc.z(lw(), iIntValue)));
            if (this.fo != null) {
                this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8144).z(Void.class).z(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, map).g());
            }
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public Map<String, Object> h() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8239).z(Map.class).g());
            dl(objApply instanceof Map ? (Map) objApply : null);
        }
        return super.h();
    }

    @Override // com.bytedance.msdk.g.dl
    public long pd() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8245).z(Long.class).g());
            if (objApply instanceof Long) {
                return ((Long) objApply).longValue();
            }
            return 0L;
        }
        return super.pd();
    }

    @Override // com.bytedance.msdk.g.dl
    public long gm() {
        if (this.fo != null) {
            Object objApply = this.fo.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8246).z(Long.class).g());
            if (objApply instanceof Long) {
                return ((Long) objApply).longValue();
            }
            return 0L;
        }
        return super.gm();
    }

    @Override // com.bytedance.msdk.g.dl, com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8128) {
            this.fo = (Function) pluginValueSet.objectValue(8035, Function.class);
        } else if (i == 8208) {
            String strStringValue = pluginValueSet.stringValue(8058);
            if (!TextUtils.isEmpty(strStringValue)) {
                v(strStringValue);
            }
        } else if (i == 8209) {
            kb(pluginValueSet.intValue(8060));
        } else if (i == 8140) {
            wp(pluginValueSet.intValue(8059));
        }
        return (T) z(i, pluginValueSet, cls);
    }
}
