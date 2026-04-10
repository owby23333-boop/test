package com.bytedance.sdk.openadsdk.mediation.bridge;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig;
import com.bytedance.sdk.openadsdk.mediation.z.z;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class MediationAdClassLoader extends z implements Bridge {
    private static volatile MediationAdClassLoader z;

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }

    private MediationAdClassLoader() {
    }

    public static MediationAdClassLoader getInstance() {
        if (z == null) {
            synchronized (MediationAdClassLoader.class) {
                z = new MediationAdClassLoader();
            }
        }
        return z;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8106) {
            z(MediationLoaderConfig.create(valueSet), valueSet);
            return null;
        }
        if (i == 8229) {
            return (T) z(valueSet.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow), valueSet.stringValue(8560));
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8106) {
            z(MediationLoaderConfig.create(valueSet), valueSet);
        } else if (i == 8229) {
            return (T) z(valueSet.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow, null), valueSet.stringValue(8560, null));
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            return valueSetValues.sparseArray();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Boolean z(java.lang.String r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L6
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L6
            return r1
        L6:
            r2 = move-exception
            com.bytedance.sdk.openadsdk.api.m.z(r2)
            java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L10 java.lang.NoClassDefFoundError -> L15 java.lang.ClassNotFoundException -> L17
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L10 java.lang.NoClassDefFoundError -> L15 java.lang.ClassNotFoundException -> L17
            return r1
        L10:
            r1 = move-exception
            com.bytedance.sdk.openadsdk.api.m.z(r1)
            goto L28
        L15:
            r2 = move-exception
            goto L18
        L17:
            r2 = move-exception
        L18:
            com.bytedance.sdk.openadsdk.api.m.z(r2)
            boolean r1 = r0.z(r1)
            if (r1 == 0) goto L28
            java.lang.String r1 = "TTMediationSDK"
            java.lang.String r2 = "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确"
            com.bytedance.sdk.openadsdk.api.m.gc(r1, r2)
        L28:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader.z(java.lang.String, java.lang.String):java.lang.Boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void z(com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig r5, com.bykv.vk.openvk.api.proto.ValueSet r6) {
        /*
            r4 = this;
            r0 = 0
            java.lang.String r1 = r5.getADNName()     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            java.util.function.Function r1 = com.bytedance.sdk.openadsdk.mediation.bridge.init.AdnManagerConfig.getAdapterManager(r1)     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            if (r1 == 0) goto L2e
            android.util.SparseArray r2 = new android.util.SparseArray     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            r2.<init>()     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            int r5 = r5.getManagerLoaderType()     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            r3 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            r2.put(r3, r5)     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            r3 = -99999985(0xfffffffffa0a1f0f, float:-1.7929173E35)
            r2.put(r3, r5)     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            java.lang.Object r5 = r1.apply(r2)     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            r4.z(r5, r6)     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            return
        L2e:
            java.lang.String r0 = r5.getClassName()     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            java.lang.Class r5 = java.lang.Class.forName(r0)     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            java.lang.Object r5 = r5.newInstance()     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            r4.z(r5, r6)     // Catch: java.lang.NoClassDefFoundError -> L3e java.lang.ClassNotFoundException -> L40 java.lang.InstantiationException -> L52 java.lang.IllegalAccessException -> L54
            return
        L3e:
            r5 = move-exception
            goto L41
        L40:
            r5 = move-exception
        L41:
            com.bytedance.sdk.openadsdk.api.m.z(r5)
            boolean r5 = r4.z(r0)
            if (r5 == 0) goto L51
            java.lang.String r5 = "TTMediationSDK"
            java.lang.String r6 = "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确"
            com.bytedance.sdk.openadsdk.api.m.gc(r5, r6)
        L51:
            return
        L52:
            r5 = move-exception
            goto L55
        L54:
            r5 = move-exception
        L55:
            r5.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.bridge.MediationAdClassLoader.z(com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationLoaderConfig, com.bykv.vk.openvk.api.proto.ValueSet):void");
    }

    private void z(Object obj, ValueSet valueSet) {
        SparseArray<Object> sparseArray = valueSet.sparseArray();
        if (obj instanceof Function) {
            Function function = (Function) obj;
            SparseArray sparseArray2 = new SparseArray();
            SparseArray<Object> sparseArray3 = null;
            sparseArray2.put(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, (Context) objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold), Context.class, null));
            Object objObjectValue = objectValue(sparseArray.get(8424), Object.class, null);
            if (objObjectValue instanceof ValueSet) {
                sparseArray3 = ((ValueSet) objObjectValue).sparseArray();
            } else if (objObjectValue instanceof SparseArray) {
                sparseArray3 = (SparseArray) objObjectValue;
            }
            if (sparseArray3 != null) {
                sparseArray2.put(8424, sparseArray3);
            } else {
                sparseArray2.put(8424, sparseArray);
            }
            sparseArray2.put(-99999987, 8241);
            sparseArray2.put(-99999985, Void.class);
            function.apply(sparseArray2);
        }
    }

    private boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("com.bytedance.msdk.adapter.");
    }
}
