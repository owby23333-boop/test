package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
final class xf {
    private static bm<String> z = new bm<String>() { // from class: com.bytedance.embedapplog.xf.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.bm
        /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
        public String z(Object... objArr) {
            SharedPreferences sharedPreferences = (SharedPreferences) objArr[0];
            String string = sharedPreferences.getString("cdid", "");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
            String string2 = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("cdid", string2).apply();
            return string2;
        }
    };

    static String z(SharedPreferences sharedPreferences) {
        return z.g(sharedPreferences);
    }
}
