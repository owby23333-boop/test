package com.bytedance.msdk.adapter.ks;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.adapter.ks.base.MediationInitBaseFunction;
import com.bytedance.msdk.adapter.ks.base.config.MediationInitConfig;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.vngXfu2tT4u.i;

/* JADX INFO: loaded from: classes2.dex */
public class KsAdapterConfiguration extends MediationInitBaseFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f333a = false;
    private volatile i b;

    @Override // com.bytedance.msdk.adapter.ks.base.MediationInitBaseFunction
    public <T> T callFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8101) {
            return BuildConfig.ADAPTER_VERSION;
        }
        if (i == 8104) {
            try {
                return (T) getProxyInitConfigInstance().b();
            } catch (Throwable unused) {
                return "0.0";
            }
        }
        if (i == 8105) {
            return (T) this.mInitConfig.getGromoreVersion();
        }
        if (i == 8124) {
            this.mInitConfig.setMediationCustomControllerValueSet(MediationValueUtil.objectValue(sparseArray.get(8517), Object.class, null));
            if (this.f333a) {
                getProxyInitConfigInstance().a();
            }
        }
        return null;
    }

    public i getProxyInitConfigInstance() {
        if (this.b == null) {
            synchronized (i.class) {
                if (this.b == null) {
                    this.b = new i();
                }
            }
        }
        return this.b;
    }

    @Override // com.bytedance.msdk.adapter.ks.base.MediationInitBaseFunction
    public void realInitAdn(Context context, MediationInitConfig mediationInitConfig) {
        synchronized (KsAdapterConfiguration.class) {
            if (this.f333a) {
                notifySuccess();
            } else {
                getProxyInitConfigInstance().a(context, this, mediationInitConfig);
            }
        }
    }

    public void setInitSuccess(boolean z) {
        this.f333a = z;
    }
}
