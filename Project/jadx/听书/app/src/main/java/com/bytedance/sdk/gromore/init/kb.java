package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.AdSdkInitializerHolder;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class kb implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dl f871a;
    private final com.bytedance.sdk.openadsdk.core.dl dl;
    private com.bytedance.sdk.openadsdk.core.ti.dl g;
    private Bundle gc;
    private com.bytedance.sdk.gromore.z.g.z z;

    public kb(Bundle bundle, com.bytedance.sdk.openadsdk.core.dl dlVar) {
        this.dl = dlVar;
        this.gc = bundle;
        gc.z();
        Bundle bundle2 = this.gc;
        if (bundle2 != null) {
            gc.z = bundle2.getLong("call_init_time");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, com.bytedance.sdk.gromore.z.g.z zVar, com.bytedance.sdk.openadsdk.core.ti.dl dlVar, long j) {
        gc.f870a = SystemClock.elapsedRealtime();
        dl dlVar2 = new dl();
        this.f871a = dlVar2;
        dlVar2.z(context, zVar, dlVar, j, this.dl);
    }

    private void z(final Context context, final PluginValueSet pluginValueSet) {
        com.bytedance.sdk.openadsdk.core.ti.dl dlVar = new com.bytedance.sdk.openadsdk.core.ti.dl(this.z.dl());
        this.g = dlVar;
        dlVar.z(new com.bytedance.sdk.openadsdk.core.ti.g() { // from class: com.bytedance.sdk.gromore.init.kb.1
            @Override // com.bytedance.sdk.openadsdk.core.ti.g
            public void z(boolean z) {
                long j;
                long j2 = 0;
                try {
                    long jLongValue = pluginValueSet.longValue(1, SystemClock.elapsedRealtime());
                    if (jLongValue != 0) {
                        try {
                            gc.m = SystemClock.elapsedRealtime() - jLongValue;
                        } catch (Exception unused) {
                            j2 = jLongValue;
                            j = j2;
                        }
                    }
                    j = jLongValue;
                } catch (Exception unused2) {
                }
                if (z) {
                    gc.dl = SystemClock.elapsedRealtime();
                    kb kbVar = kb.this;
                    kbVar.z(context, kbVar.z, kb.this.g, j);
                }
            }
        });
        if (this.dl != null) {
            gc.g = SystemClock.elapsedRealtime();
            this.dl.z(context, pluginValueSet, this.g);
        } else {
            this.g.z(0, com.bytedance.sdk.openadsdk.ls.gc.z().z(false).z(80000).z("init error Initializer is null").g());
        }
    }

    public boolean z() {
        com.bytedance.sdk.gromore.z.g.z zVar = this.z;
        if (zVar != null && zVar.z()) {
            com.bytedance.sdk.openadsdk.core.dl dlVar = this.dl;
            return dlVar != null && this.f871a != null && dlVar.z() && this.f871a.z();
        }
        com.bytedance.sdk.openadsdk.core.dl dlVar2 = this.dl;
        if (dlVar2 != null) {
            return dlVar2.z();
        }
        return false;
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        switch (pluginValueSetG.intValue(-99999987)) {
            case -999002:
                return Boolean.valueOf(z());
            case -999001:
                com.bytedance.sdk.gromore.z.g.z zVarZ = com.bytedance.sdk.gromore.z.g.z.z(pluginValueSetG);
                this.z = zVarZ;
                if (zVarZ.a()) {
                    com.bytedance.msdk.z.gc.dl.z();
                    com.bytedance.sdk.component.fo.z.z();
                }
                if (this.z.wp() && !AdSdkInitializerHolder.isSdkInitSuccess()) {
                    x.z();
                }
                z(pluginValueSetG);
                Context context = (Context) pluginValueSetG.objectValue(-998000, Context.class);
                zw.z(context);
                boolean zDh = zw.g().dh();
                if (this.z.z() || zDh) {
                    com.bytedance.msdk.core.kb.z.z().g();
                    com.bytedance.msdk.core.kb.z.z().z(zDh);
                    z(context, pluginValueSetG);
                } else {
                    gc.g = SystemClock.elapsedRealtime();
                    this.dl.apply(sparseArray);
                }
                break;
            case -999000:
                if (this.dl != null) {
                    com.bytedance.msdk.z.gc.dl.g("TMe", "getManager mediation");
                    com.bytedance.sdk.openadsdk.core.x xVarG = this.dl.g();
                    if (xVarG != null) {
                        return new uy(xVarG);
                    }
                }
                break;
        }
        return com.bykv.z.z.z.z.z.g.apply(sparseArray);
    }

    private void z(PluginValueSet pluginValueSet) {
        try {
            Boolean bool = (Boolean) pluginValueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                gk.g = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }
}
