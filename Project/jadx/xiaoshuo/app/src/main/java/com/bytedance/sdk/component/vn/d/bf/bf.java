package com.bytedance.sdk.component.vn.d.bf;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.vn.d;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class bf implements com.bytedance.sdk.component.vn.d.e {
    private static final Map<String, com.bytedance.sdk.component.vn.e> bf = new HashMap();
    private e e;

    private bf(String str, Context context) {
        this.e = e.e(str, context);
    }

    public static com.bytedance.sdk.component.vn.e e(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        if (context == null) {
            context = d.getContext();
        }
        Map<String, com.bytedance.sdk.component.vn.e> map = bf;
        com.bytedance.sdk.component.vn.e eVar = map.get(str);
        if (eVar != null) {
            return eVar;
        }
        bf bfVar = new bf(str, context);
        map.put(str, bfVar);
        return bfVar;
    }

    @Override // com.bytedance.sdk.component.vn.e
    public int bf(String str, int i) {
        return this.e.bf(str, i);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public long bf(String str, long j) {
        return this.e.bf(str, j);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public float bf(String str, float f) {
        return this.e.bf(str, f);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public boolean bf(String str, boolean z) {
        return this.e.bf(str, z);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public String bf(String str, String str2) {
        return this.e.bf(str, str2);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public Set<String> bf(String str, Set<String> set) {
        return this.e.bf(str, set);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, int i) {
        this.e.e(str, i);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void bf() {
        this.e.bf();
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, long j) {
        this.e.e(str, j);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, float f) {
        this.e.e(str, f);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, boolean z) {
        this.e.e(str, z);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, String str2) {
        this.e.e(str, str2);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, Set<String> set) {
        this.e.e(str, set);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public Map<String, ?> e() {
        return this.e.e();
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str) {
        this.e.e(str);
    }
}
