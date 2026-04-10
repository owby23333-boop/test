package com.bytedance.sdk.openadsdk.mediation.bridge.init;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.mediation.z.z;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class MediationInitCLassLoader extends z {
    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public SparseArray<Object> get() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i != 8100) {
            return null;
        }
        z(valueSet);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> void z(com.bykv.vk.openvk.api.proto.ValueSet r6) {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig r0 = com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.create(r6)
            r1 = 0
            boolean r2 = r0.isCustom()     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            if (r2 == 0) goto L21
            com.bykv.vk.openvk.api.proto.ValueSet r2 = r0.getCustomInitConfigValueSet()     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            if (r2 == 0) goto L21
            r1 = 1
            com.bykv.vk.openvk.api.proto.ValueSet r0 = r0.getCustomInitConfigValueSet()     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            r2 = 8536(0x2158, float:1.1961E-41)
            java.lang.String r0 = r0.stringValue(r2)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            goto L66
        L21:
            java.lang.String r2 = r0.getAdapterManagerClassName()     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            java.lang.String r3 = r0.getADNName()     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            if (r2 == 0) goto L32
            if (r3 == 0) goto L32
            boolean r2 = com.bytedance.sdk.openadsdk.mediation.bridge.init.AdnManagerConfig.initAdnManager(r2, r3)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            goto L33
        L32:
            r2 = r1
        L33:
            if (r2 == 0) goto L3a
            java.util.function.Function r2 = com.bytedance.sdk.openadsdk.mediation.bridge.init.AdnManagerConfig.getAdapterManager(r3)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            goto L3b
        L3a:
            r2 = 0
        L3b:
            if (r2 == 0) goto L5e
            android.util.SparseArray r0 = new android.util.SparseArray     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            r0.<init>()     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            r3 = 10000(0x2710, float:1.4013E-41)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            r4 = -99999987(0xfffffffffa0a1f0d, float:-1.7929169E35)
            r0.put(r4, r3)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            r4 = -99999985(0xfffffffffa0a1f0f, float:-1.7929173E35)
            r0.put(r4, r3)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            java.lang.Object r0 = r2.apply(r0)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            r5.z(r0, r6)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            return
        L5e:
            java.lang.String r0 = r0.getClassName()     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
        L66:
            java.lang.Object r0 = r0.newInstance()     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            r5.z(r0, r6)     // Catch: java.lang.Throwable -> L6e java.lang.NoClassDefFoundError -> L73 java.lang.ClassNotFoundException -> L75
            return
        L6e:
            r6 = move-exception
            com.bytedance.sdk.openadsdk.api.m.z(r6)
            return
        L73:
            r6 = move-exception
            goto L76
        L75:
            r6 = move-exception
        L76:
            com.bytedance.sdk.openadsdk.api.m.z(r6)
            if (r1 != 0) goto L82
            java.lang.String r6 = "TTMediationSDK"
            java.lang.String r0 = "当前接入的ADN-Adapter版本可能不适配，68版本起SDK和所有Adapter都需要升级，请检查接入的版本是否正确"
            com.bytedance.sdk.openadsdk.api.m.gc(r6, r0)
        L82:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.mediation.bridge.init.MediationInitCLassLoader.z(com.bykv.vk.openvk.api.proto.ValueSet):void");
    }

    private void z(Object obj, ValueSet valueSet) {
        if (obj instanceof Function) {
            Function function = (Function) obj;
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, TTAppContextHolder.getContext());
            sparseArray.put(8424, valueSet == null ? null : valueSet.sparseArray());
            sparseArray.put(-99999987, 8240);
            sparseArray.put(-99999985, Void.class);
            function.apply(sparseArray);
        }
    }
}
