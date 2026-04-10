package com.bytedance.sdk.openadsdk.api.plugin.z;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.plugin.Plugin;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements Function<SparseArray<Object>, Object> {
    private static volatile z z;

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    private Plugin z(ValueSet valueSet) {
        if (valueSet == null) {
            return null;
        }
        String strStringValue = valueSet.stringValue(0);
        if (TextUtils.isEmpty(strStringValue)) {
            return null;
        }
        return Zeus.getPlugin(strStringValue);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object apply(android.util.SparseArray<java.lang.Object> r4) {
        /*
            Method dump skipped, instruction units count: 264
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.z.z.apply(android.util.SparseArray):java.lang.Object");
    }
}
