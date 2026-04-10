package com.bytedance.msdk.adapter.ks.base.proto;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.function.Function;
import java.util.function.IntSupplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AdnAdapterBaseFunction implements Function<SparseArray<Object>, Object>, IntSupplier {
    private static final int PROTO2_6800 = 2;
    private static final int PROTO2_6900 = 6900;
    private static final int PROTO2_7000 = 7000;

    private Object processReadyStatusForProto2(Integer num, Integer num2) {
        int iIntValue;
        if (num != null && num.intValue() > 0) {
            return num2;
        }
        try {
            iIntValue = num2.intValue();
        } catch (Throwable unused) {
        }
        return iIntValue != 1 ? iIntValue != 2 ? iIntValue != 3 ? iIntValue != 4 ? num2 : MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED : MediationConstant.AdIsReadyStatus.AD_IS_READY : MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        int iIntValue = ((Integer) MediationValueUtil.objectValue(sparseArray.get(-99999987), Integer.class, 0)).intValue();
        return iIntValue == -99999986 ? get() : applyFunction(iIntValue, sparseArray, (Class) MediationValueUtil.objectValue(sparseArray.get(-99999985), Class.class, null));
    }

    public abstract <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls);

    public abstract SparseArray<Object> get();

    @Override // java.util.function.IntSupplier
    public int getAsInt() {
        return 7000;
    }

    public Object isReadyStatusForProto2(Integer num, Object obj, Class cls) {
        if (num == null) {
            return null;
        }
        int iValueOf = 0;
        if (obj instanceof SparseArray) {
            iValueOf = (Integer) MediationValueUtil.objectValue(((SparseArray) obj).get(20068), Integer.class, 0);
        } else if (obj instanceof ValueSet) {
            iValueOf = Integer.valueOf(((ValueSet) obj).intValue(20068, 0));
        }
        return processReadyStatusForProto2(iValueOf, num);
    }
}
