package com.bytedance.sdk.openadsdk.core.un;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gk {
    private String z;

    public static gk z() {
        return new gk();
    }

    private gk() {
        g();
    }

    private void g() {
        File fileZ;
        Context context = com.bytedance.sdk.openadsdk.core.zw.getContext();
        if (context == null) {
            return;
        }
        try {
            if ("mounted".equals(com.bytedance.sdk.openadsdk.hh.dl.z()) && (fileZ = com.bytedance.sdk.openadsdk.api.plugin.g.z(context, "TTCache")) != null) {
                fileZ.mkdirs();
                this.z = fileZ.getPath();
            }
            if (TextUtils.isEmpty(this.z)) {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.g.z(context), "TTCache");
                file.mkdirs();
                this.z = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    public void z(Thread thread, Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String string = stringWriter.toString();
            zContains = string != null ? string.contains(TTAdConstant.class.getPackage().getName()) : false;
            com.bytedance.sdk.openadsdk.core.e.a.z().z(thread, th);
        } catch (Throwable unused) {
        }
        if (zContains) {
            g(thread, th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x010f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g(java.lang.Thread r17, java.lang.Throwable r18) {
        /*
            Method dump skipped, instruction units count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.un.gk.g(java.lang.Thread, java.lang.Throwable):void");
    }

    private void dl() {
        try {
            com.bytedance.sdk.openadsdk.core.component.splash.z.z.z().dl();
        } catch (Throwable unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.z.z.z.z().g();
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.gk.gz.z();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.component.adexpress.z.g.g.g();
            com.bytedance.sdk.openadsdk.core.ugeno.gc.z.g().m();
        } catch (Throwable unused4) {
        }
        try {
            Function<SparseArray<Object>, Object> functionOq = com.bytedance.sdk.openadsdk.core.uy.ls().oq();
            if (functionOq != null) {
                functionOq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(7).z(Void.class).g());
            }
        } catch (Throwable unused5) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.dl.dl.z().uy();
            com.bytedance.sdk.openadsdk.core.dl.a.z().zw();
            com.bytedance.sdk.openadsdk.core.dl.gc.z().ls();
        } catch (Throwable unused6) {
        }
    }
}
