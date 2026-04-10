package com.bytedance.sdk.openadsdk.core.kb;

import com.bytedance.sdk.openadsdk.core.zw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m implements a {
    private List<a> z = new ArrayList();
    private dl g = new dl(zw.g().bm());

    public m() {
        this.z.add(new gc(this.g));
        this.z.add(new e(this.g));
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a
    public boolean z(String str, String str2, String str3, int i, String str4, String str5, int i2, String str6, String str7) {
        Iterator<a> it = this.z.iterator();
        while (it.hasNext()) {
            if (it.next().z(str, str2, str3, i, str4, str5, i2, str6, str7)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.kb.a
    public boolean z(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        Iterator<a> it = this.z.iterator();
        while (it.hasNext()) {
            if (it.next().z(str, str2, str3, str4, i, str5, str6)) {
                return true;
            }
        }
        return false;
    }
}
