package com.bytedance.sdk.openadsdk.ats.z;

import android.text.TextUtils;
import com.bytedance.sdk.component.a.kb;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements kb {
    private g g = new g();
    private z dl = new z();
    private boolean z = !this.g.z();

    @Override // com.bytedance.sdk.component.a.kb
    public String get(String str) {
        String str2 = this.g.z() ? this.g.get(str) : "";
        return (this.z && TextUtils.isEmpty(str2)) ? this.dl.get(str) : str2;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public int getInt(String str) {
        int i = this.g.z() ? this.g.getInt(str) : Integer.MAX_VALUE;
        return (this.z && i == Integer.MAX_VALUE) ? this.dl.getInt(str) : i;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public long getLong(String str) {
        long j = this.g.z() ? this.g.getLong(str) : Long.MAX_VALUE;
        return (this.z && j == 2147483647L) ? this.dl.getLong(str) : j;
    }

    @Override // com.bytedance.sdk.component.a.kb
    public boolean getBoolean(String str) {
        boolean z = this.g.z() ? this.g.getBoolean(str) : false;
        return (!this.z || z) ? z : this.dl.getBoolean(str);
    }

    @Override // com.bytedance.sdk.component.a.kb
    public void set(String str, String str2) {
        if (this.g.z()) {
            this.g.set(str, str2);
        }
    }
}
