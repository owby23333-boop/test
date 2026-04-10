package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b;
import com.bytedance.msdk.api.qatools.IGMEventCallBack;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a aVar, boolean z2) {
        if (aVar != null && b.J().w()) {
            try {
                Object objInvoke = Class.forName("com.bytedance.qatool.QAEventToolsUtil").getMethod("getEventCallBack", new Class[0]).invoke(null, new Object[0]);
                if (objInvoke instanceof IGMEventCallBack) {
                    IGMEventCallBack iGMEventCallBack = (IGMEventCallBack) objInvoke;
                    if (z2) {
                        iGMEventCallBack.EventReportByV3(aVar.d());
                    } else {
                        iGMEventCallBack.EventReportByV1(aVar.d());
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
