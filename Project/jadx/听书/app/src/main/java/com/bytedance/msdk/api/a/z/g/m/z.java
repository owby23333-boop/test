package com.bytedance.msdk.api.a.z.g.m;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.a.z.g.dl.g;
import com.bytedance.msdk.m.g.dl;
import com.bytedance.msdk.m.g.gc;
import com.bytedance.sdk.openadsdk.core.ti.a;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends a {
    private static final String dl = "TTMediationSDK_z";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f363a;
    private Function<SparseArray<Object>, Object> e;
    private final AtomicBoolean gc = new AtomicBoolean(false);
    protected long z = 0;
    protected int g = 0;
    private final Function<SparseArray<Object>, Object> m = dl.z(com.bytedance.msdk.core.z.kb().ti()).z();

    public String a() {
        return "0.0";
    }

    public final void z() {
        this.gc.set(true);
    }

    public final boolean g() {
        return this.gc.get();
    }

    public final void z(Context context, g gVar, Map<String, Object> map) {
        this.gc.set(false);
        this.f363a = gVar;
        g(context, gVar, map);
    }

    public void g(Context context, g gVar, Map<String, Object> map) {
        if (gVar != null) {
            com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsLiveLoaderEnable).z(Void.class).z(8089, com.bytedance.msdk.core.z.kb().ti().sparseArray()).z(8545, com.bytedance.sdk.openadsdk.ls.dl.a.z(gVar.z())).z(8400, map).z(8401, this).z(8098, Boolean.TRUE);
            gc.z(aVarZ);
            this.m.apply(aVarZ.g());
        }
    }

    public String dl() {
        if (this.e == null) {
            return null;
        }
        Object objApply = this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsLoaderFactoryP2PStragetyLevel).z(String.class).g());
        return objApply instanceof String ? (String) objApply : "";
    }

    public String z(Context context, Map<String, Object> map) {
        if (this.e == null) {
            return null;
        }
        Object objApply = this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(8139).z(String.class).z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).z(8075, map).g());
        return objApply instanceof String ? (String) objApply : "";
    }

    public String g(Context context, Map<String, Object> map) {
        if (this.e == null) {
            return null;
        }
        Object objApply = this.e.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(AVMDLDataLoader.KeyIsLoaderFactoryXYLibValue).z(String.class).z(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, context).z(8075, map).g());
        return objApply instanceof String ? (String) objApply : "";
    }

    public long gc() {
        return this.z;
    }

    public int m() {
        return this.g;
    }

    public void e() {
        this.g = 0;
        this.z = 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8216) {
            this.e = (Function) pluginValueSet.objectValue(8402, Function.class);
        } else if (i == 8219) {
            z();
        } else {
            if (i == 8220) {
                return (T) Boolean.valueOf(g());
            }
            if (i == 8270) {
                long jLongValue = pluginValueSet.longValue(8073);
                this.g = pluginValueSet.intValue(8557);
                this.z = jLongValue;
            }
        }
        return (T) com.bytedance.msdk.core.ls.z.z(cls);
    }
}
