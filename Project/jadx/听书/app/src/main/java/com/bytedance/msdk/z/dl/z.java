package com.bytedance.msdk.z.dl;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.api.a.v;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.msdk.z.z.a {
    @Override // com.bytedance.msdk.z.z.a
    public void a() {
    }

    @Override // com.bytedance.msdk.z.z.a
    public void e() {
    }

    @Override // com.bytedance.msdk.z.z.a
    public Map<String, Object> g(Context context, Map<String, Object> map) {
        return null;
    }

    @Override // com.bytedance.msdk.z.z.a
    public long gc() {
        return 0L;
    }

    @Override // com.bytedance.msdk.z.z.a
    public int m() {
        return 0;
    }

    @Override // com.bytedance.msdk.z.z.a
    public int z(com.bytedance.msdk.api.a.dl dlVar) {
        return 0;
    }

    @Override // com.bytedance.msdk.z.z.a
    public String z() {
        return g() + ".0";
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    @Override // com.bytedance.msdk.z.z.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String z(android.content.Context r19, java.util.Map<java.lang.String, java.lang.Object> r20) {
        /*
            Method dump skipped, instruction units count: 611
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.z.dl.z.z(android.content.Context, java.util.Map):java.lang.String");
    }

    private void gz() {
        fo();
    }

    @Override // com.bytedance.msdk.z.z.a
    public String g() {
        return com.bytedance.sdk.gromore.init.z.dl();
    }

    @Override // com.bytedance.msdk.z.z.a
    public String dl() {
        return com.bytedance.sdk.gromore.init.z.a();
    }

    private void fo() {
        g.g(g.z(g.z(), "personal_ads_type", com.bytedance.msdk.core.z.kb().g().e() ? "0" : "1"));
    }

    @Override // com.bytedance.msdk.z.z.a
    public void z(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        Object obj = map.get(com.bytedance.msdk.z.z.z.gc);
        int iIntValue = obj instanceof Integer ? ((Integer) obj).intValue() : 0;
        if (iIntValue == 0 || iIntValue == 1) {
            com.bytedance.sdk.gromore.init.z.z(iIntValue);
        }
    }

    @Override // com.bytedance.msdk.z.z.a
    public void z(v vVar, SparseArray<Object> sparseArray) {
        com.bytedance.msdk.core.z.kb().g().g(sparseArray);
        gz();
    }

    @Override // com.bytedance.msdk.z.z.g
    public void z(Context context, Map<String, Object> map, com.bytedance.msdk.z.z.dl dlVar) {
        fo();
        dlVar.z();
    }
}
