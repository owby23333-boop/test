package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
final class xn {
    private static ev<String> e = new ev<String>() { // from class: com.bytedance.embedapplog.xn.1
        @Override // com.bytedance.embedapplog.ev
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String e(Object... objArr) {
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

    public static String e(SharedPreferences sharedPreferences) {
        return e.bf(sharedPreferences);
    }
}
