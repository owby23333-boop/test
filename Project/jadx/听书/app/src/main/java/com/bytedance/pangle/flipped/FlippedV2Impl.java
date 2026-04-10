package com.bytedance.pangle.flipped;

import android.util.Log;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.log.IZeusReporter;
import com.bytedance.sdk.openadsdk.hh.m;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class FlippedV2Impl implements dl {
    private static final String TAG = "FlippedV2Impl";

    private native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);

    static {
        m.z("pangleflipped");
    }

    @Override // com.bytedance.pangle.flipped.dl
    public void invokeHiddenApiRestrictions() {
        GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "v2");
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method declaredMethod = getDeclaredMethod(cls, "getRuntime", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = getDeclaredMethod(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(objInvoke, new String[]{"L"});
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().saveRecord(IZeusReporter.ZEUS_STAGE_FLIPPED, "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
            com.bytedance.sdk.openadsdk.api.m.gc(TAG, "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
        }
    }
}
