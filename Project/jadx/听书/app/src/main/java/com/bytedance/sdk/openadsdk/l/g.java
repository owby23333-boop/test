package com.bytedance.sdk.openadsdk.l;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTC;
import com.bytedance.sdk.openadsdk.api.TTILog;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.sdk.openadsdk.mediation.z.z {
    private Object g;
    private TTILog z;

    public g(Object obj) {
        if (obj instanceof TTILog) {
            this.z = (TTILog) obj;
        }
        this.g = obj;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ab A[RETURN] */
    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T applyFunction(int r5, com.bykv.vk.openvk.api.proto.ValueSet r6, java.lang.Class<T> r7) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.l.g.applyFunction(int, com.bykv.vk.openvk.api.proto.ValueSet, java.lang.Class):java.lang.Object");
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.z.z
    public SparseArray<Object> get() {
        SparseArray<Object> sparseArray = new SparseArray<>(1);
        sparseArray.put(-99999978, Boolean.TRUE);
        return sparseArray;
    }

    private static String g(Object obj) {
        TTC ttc;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Class) {
            ttc = (TTC) ((Class) obj).getAnnotation(TTC.class);
        } else {
            ttc = (TTC) obj.getClass().getAnnotation(TTC.class);
        }
        return ttc == null ? "" : ttc.value();
    }

    public static boolean z(Object obj) {
        if (obj != null) {
            try {
                if (((TTC) obj.getClass().getAnnotation(TTC.class)) != null) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
