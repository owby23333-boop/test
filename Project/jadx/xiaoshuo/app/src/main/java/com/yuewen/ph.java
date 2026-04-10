package com.yuewen;

import android.net.Uri;

/* JADX INFO: loaded from: classes12.dex */
public class ph extends qh {
    public long f;
    public Uri g;

    public ph(String str, String str2) {
        super(str, str2);
    }

    @Override // com.yuewen.qh
    public boolean a() {
        return this.g != null;
    }

    @Override // com.yuewen.qh
    public String toString() {
        return "BackupInfo29{id=" + this.f + ", uri=" + this.g + ", fileName='" + this.f16520a + "', folder='" + this.f16521b + "', size=" + this.c + ", lastModifyTime=" + this.d + '}';
    }
}
