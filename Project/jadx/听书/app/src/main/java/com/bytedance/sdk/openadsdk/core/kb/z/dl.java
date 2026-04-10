package com.bytedance.sdk.openadsdk.core.kb.z;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.gk;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl extends com.bytedance.sdk.openadsdk.core.ti.a implements com.ss.android.z.z.dl.a, LongSupplier {
    private int mCurrentPercent;

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void onDownloadActive(long j, long j2, String str);

    public abstract void onDownloadFailed(long j, long j2, String str);

    public abstract void onDownloadFinished(long j, long j2, String str);

    public abstract void onDownloadPaused(long j, long j2, String str);

    public abstract void onDownloadStart();

    public abstract void onInstalled(long j, long j2, String str);

    public int getCurrentPercent() {
        return this.mCurrentPercent;
    }

    private void setCurrentPercent(int i) {
        this.mCurrentPercent = i;
    }

    @Override // com.ss.android.z.z.dl.a
    public void onDownloadStart(com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.z zVar) {
        if (dlVar == null) {
            return;
        }
        setCurrentPercent(0);
        onDownloadStart();
    }

    @Override // com.ss.android.z.z.dl.a
    public void onDownloadActive(com.ss.android.z.z.gc.gc gcVar, int i) {
        if (gcVar == null) {
            return;
        }
        setCurrentPercent(i);
        onDownloadActive(gcVar.dl, gcVar.f2124a, gcVar.gc);
    }

    @Override // com.ss.android.z.z.dl.a
    public void onDownloadPaused(com.ss.android.z.z.gc.gc gcVar, int i) {
        if (gcVar == null) {
            return;
        }
        setCurrentPercent(i);
        onDownloadPaused(gcVar.dl, gcVar.f2124a, gcVar.gc);
    }

    @Override // com.ss.android.z.z.dl.a
    public void onDownloadFailed(com.ss.android.z.z.gc.gc gcVar) {
        if (gcVar == null) {
            return;
        }
        onDownloadFailed(gcVar.dl, gcVar.f2124a, gcVar.gc);
    }

    @Override // com.ss.android.z.z.dl.a
    public void onInstalled(com.ss.android.z.z.gc.gc gcVar) {
        if (gcVar == null) {
            return;
        }
        setCurrentPercent(100);
        String str = gcVar.gc;
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        onInstalled(gcVar.dl, gcVar.f2124a, str);
    }

    @Override // com.ss.android.z.z.dl.a
    public void onDownloadFinished(com.ss.android.z.z.gc.gc gcVar) {
        if (gcVar == null) {
            return;
        }
        onDownloadFinished(gcVar.dl, gcVar.f2124a, gcVar.gc);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (!com.bytedance.sdk.openadsdk.ls.dl.a.z(gk.dl)) {
            pluginValueSet = com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).g();
        }
        switch (i) {
            case 223600:
                z();
                return null;
            case 223601:
                if (pluginValueSet != null) {
                    PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).g();
                    onDownloadStart((Function<SparseArray<Object>, Object>) pluginValueSetG.objectValue(223201, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetG.objectValue(223203, Function.class));
                }
                return null;
            case 223602:
                if (pluginValueSet != null) {
                    PluginValueSet pluginValueSetG2 = com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).g();
                    onDownloadActive((Function<SparseArray<Object>, Object>) pluginValueSetG2.objectValue(223607, Function.class), ((Integer) pluginValueSetG2.objectValue(223608, Integer.class)).intValue());
                }
                return null;
            case 223603:
                if (pluginValueSet != null) {
                    PluginValueSet pluginValueSetG3 = com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).g();
                    onDownloadPaused((Function<SparseArray<Object>, Object>) pluginValueSetG3.objectValue(223607, Function.class), ((Integer) pluginValueSetG3.objectValue(223608, Integer.class)).intValue());
                }
                return null;
            case 223604:
                if (pluginValueSet != null) {
                    onDownloadFailed((Function<SparseArray<Object>, Object>) com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).g().objectValue(223607, Function.class));
                }
                return null;
            case 223605:
                if (pluginValueSet != null) {
                    onInstalled((Function<SparseArray<Object>, Object>) com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).g().objectValue(223607, Function.class));
                }
                return null;
            case 223606:
                if (pluginValueSet != null) {
                    onDownloadFinished((Function<SparseArray<Object>, Object>) com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).g().objectValue(223607, Function.class));
                }
                return null;
            default:
                return null;
        }
    }

    private void onDownloadStart(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2) {
        if (function == null || com.bytedance.sdk.openadsdk.ls.dl.g(function) == null) {
            return;
        }
        onDownloadStart();
    }

    private void onDownloadActive(Function<SparseArray<Object>, Object> function, int i) {
        PluginValueSet pluginValueSetG;
        if (function == null || (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) == null) {
            return;
        }
        onDownloadActive(pluginValueSetG.longValue(223704), pluginValueSetG.longValue(223705), pluginValueSetG.stringValue(223706));
    }

    private void onDownloadPaused(Function<SparseArray<Object>, Object> function, int i) {
        PluginValueSet pluginValueSetG;
        if (function == null || (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) == null) {
            return;
        }
        onDownloadPaused(pluginValueSetG.longValue(223704), pluginValueSetG.longValue(223705), pluginValueSetG.stringValue(223706));
    }

    private void onDownloadFailed(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetG;
        if (function == null || (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) == null) {
            return;
        }
        onDownloadFailed(pluginValueSetG.longValue(223704), pluginValueSetG.longValue(223705), pluginValueSetG.stringValue(223706));
    }

    private void onInstalled(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetG;
        if (function == null || (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) == null) {
            return;
        }
        long jLongValue = pluginValueSetG.longValue(223704);
        long jLongValue2 = pluginValueSetG.longValue(223705);
        String strStringValue = pluginValueSetG.stringValue(223706);
        if (strStringValue == null) {
            strStringValue = "";
        }
        onInstalled(jLongValue, jLongValue2, strStringValue);
    }

    private void onDownloadFinished(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetG;
        if (function == null || (pluginValueSetG = com.bytedance.sdk.openadsdk.ls.dl.g(function)) == null) {
            return;
        }
        onDownloadFinished(pluginValueSetG.longValue(223704), pluginValueSetG.longValue(223705), pluginValueSetG.stringValue(223706));
    }
}
