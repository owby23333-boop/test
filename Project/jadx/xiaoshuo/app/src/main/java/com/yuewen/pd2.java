package com.yuewen;

import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class pd2 implements zg4 {
    @Override // com.yuewen.zg4
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(Uri.parse(str).getScheme(), "tbopen");
    }

    @Override // com.yuewen.zg4
    public boolean b() {
        return true;
    }
}
