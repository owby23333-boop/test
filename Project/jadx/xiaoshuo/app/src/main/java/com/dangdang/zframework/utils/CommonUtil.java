package com.dangdang.zframework.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.dangdang.zframework.log.LogM;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes10.dex */
public class CommonUtil {
    public static String getPermanentId(Context context) {
        SharedPreferences preferences = new ConfigManager(context.getApplicationContext()).getPreferences();
        Locale locale = Locale.US;
        String str = new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_4, locale).format(new Date());
        LogM.i("getPermanentId", "getPermanentId.year=" + str);
        if (!str.equals(preferences.getString("init_permanentId", str))) {
            return preferences.getString("init_permanentId", str);
        }
        String str2 = new SimpleDateFormat("yyyyMMddhhmmssSSS", locale).format(new Date()) + getRandomInt(100000, Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST) + getRandomInt(100000, Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST) + getRandomInt(100000, Constants.MAX_VALID_TIME_FOR_REGISTRATION_REQUEST);
        LogM.d("LogM", "permanentId=:" + str2);
        SharedPreferences.Editor editorEdit = preferences.edit();
        editorEdit.putString("init_permanentId", str2);
        editorEdit.commit();
        return str2;
    }

    public static int getRandomInt(int i, int i2) {
        return ((int) (Math.random() * ((double) ((i2 - i) + 1)))) + i;
    }
}
