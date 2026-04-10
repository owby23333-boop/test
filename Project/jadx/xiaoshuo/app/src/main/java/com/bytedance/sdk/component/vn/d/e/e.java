package com.bytedance.sdk.component.vn.d.e;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.sdk.component.vn.d.e {
    private static final Map<String, com.bytedance.sdk.component.vn.e> bf = new HashMap();
    private String e;

    private e(String str) {
        this.e = str;
    }

    public static com.bytedance.sdk.component.vn.e bf(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        Map<String, com.bytedance.sdk.component.vn.e> map = bf;
        com.bytedance.sdk.component.vn.e eVar = map.get(str);
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(str);
        map.put(str, eVar2);
        return eVar2;
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, int i) {
        bf.e(this.e, str, Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, long j) {
        bf.e(this.e, str, Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, float f) {
        bf.e(this.e, str, Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, boolean z) {
        bf.e(this.e, str, Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.component.vn.e
    public int bf(String str, int i) {
        return bf.e(this.e, str, i);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, String str2) {
        bf.e(this.e, str, str2);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public long bf(String str, long j) {
        return bf.e(this.e, str, j);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str, Set<String> set) {
        bf.e(this.e, str, set);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public float bf(String str, float f) {
        return bf.e(this.e, str, f);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public Map<String, ?> e() {
        return bf.bf(this.e);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public boolean bf(String str, boolean z) {
        return bf.e(this.e, str, z);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void e(String str) {
        bf.e(this.e, str);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public String bf(String str, String str2) {
        return bf.bf(this.e, str, str2);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public Set<String> bf(String str, Set<String> set) {
        return bf.bf(this.e, str, set);
    }

    @Override // com.bytedance.sdk.component.vn.e
    public void bf() {
        bf.e(this.e);
    }
}
