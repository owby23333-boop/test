package com.yEWweUO.jbB1g.jbB1g.jbB1g.jbB1g;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.function.Function;

/* JADX INFO: loaded from: classes4.dex */
public class g {

    public interface a {
        void useOriginLoader();
    }

    public static void a(Context context, MediationAdSlotValueSet mediationAdSlotValueSet, Function function, Function function2, a aVar) {
        boolean zA = a(mediationAdSlotValueSet, function);
        a(mediationAdSlotValueSet);
        boolean zA2 = zA ? a(context, function, function2) : false;
        if ((zA && zA2) || aVar == null) {
            return;
        }
        aVar.useOriginLoader();
    }

    private static void a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean z = false;
        Object obj = false;
        if (mediationAdSlotValueSet != null && mediationAdSlotValueSet.getExtraObject() != null) {
            obj = mediationAdSlotValueSet.getExtraObject().get("load_can_log");
        }
        if ((obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
            z = true;
        }
        t.f2524a = z;
    }

    private static boolean a(Context context, Function function, Function function2) {
        if (context == null || function == null || function2 == null) {
            return false;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, 20000);
        sparseArray.put(-99999985, null);
        boolean z = function2 instanceof AdnAdapterBridgeWrapper;
        Object bridge = function2;
        if (z) {
            bridge = ((AdnAdapterBridgeWrapper) function2).getBridge();
        }
        sparseArray.put(10010, bridge);
        sparseArray.put(10011, MediationConstant.ADN_GDT);
        sparseArray.put(10000, context);
        function.apply(sparseArray);
        return true;
    }

    private static boolean a(MediationAdSlotValueSet mediationAdSlotValueSet, Function function) {
        return TextUtils.equals((mediationAdSlotValueSet == null || mediationAdSlotValueSet.getExtraObject() == null) ? "" : (String) mediationAdSlotValueSet.getExtraObject().get("load_type"), "load_plugin_gdt_adapter_v2") && function != null;
    }
}
