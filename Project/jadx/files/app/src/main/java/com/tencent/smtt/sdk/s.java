package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: loaded from: classes3.dex */
class s {
    private DexLoader a;

    public s(DexLoader dexLoader) {
        this.a = null;
        this.a = dexLoader;
    }

    public String a(Context context) {
        Object objNewInstance;
        Object objInvokeMethod;
        DexLoader dexLoader = this.a;
        return (dexLoader == null || (objNewInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null || (objInvokeMethod = this.a.invokeMethod(objNewInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "getCurWDPDecodeType", new Class[]{Context.class}, context)) == null) ? "" : String.valueOf(objInvokeMethod);
    }

    public void a(Context context, String str) {
        Object objNewInstance;
        DexLoader dexLoader = this.a;
        if (dexLoader == null || (objNewInstance = dexLoader.newInstance("com.tencent.tbs.utils.TbsVideoUtilsProxy", new Class[0], new Object[0])) == null) {
            return;
        }
        this.a.invokeMethod(objNewInstance, "com.tencent.tbs.utils.TbsVideoUtilsProxy", "deleteVideoCache", new Class[]{Context.class, String.class}, context, str);
    }
}
