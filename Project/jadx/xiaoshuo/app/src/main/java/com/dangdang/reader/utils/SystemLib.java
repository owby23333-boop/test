package com.dangdang.reader.utils;

import android.content.Context;
import android.graphics.Paint;
import android.os.PowerManager;
import android.text.TextUtils;
import com.dangdang.zframework.log.LogM;
import com.dangdang.zframework.utils.DateUtil;
import com.dangdang.zframework.utils.UiUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes10.dex */
public class SystemLib {
    public static final String LOCK_TAG = "LOCK_FULL";
    public static long sLastTime;

    public static final long[] convertStringArrayToLongArray(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        int length = strArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            try {
                LogM.d("convertStringArrayToLongArray:", i + ":" + strArr[i]);
                jArr[i] = Long.parseLong(strArr[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return null;
            }
        }
        return jArr;
    }

    public static final String filter(String str, char c, char c2) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == c) {
                charArray[i] = c2;
            }
        }
        return new String(charArray);
    }

    public static final int getFontOffset(Paint paint, int i) {
        paint.setTextSize(i);
        return getFontOffset(paint);
    }

    public static final PowerManager.WakeLock getFullLock(Context context) {
        return ((PowerManager) context.getSystemService("power")).newWakeLock(805306394, LOCK_TAG);
    }

    public static final String getNChar(String str, int i) {
        if (str == null || str.length() < i) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i / 2;
        stringBuffer.append(str.substring(0, i2));
        stringBuffer.append("...");
        int length = str.length();
        stringBuffer.append(str.substring(length - i2, length));
        return stringBuffer.toString();
    }

    public static String getTime() {
        return new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_7).format(new Date());
    }

    public static final void showTip(Context context, int i) {
        showTip(context, context.getResources().getString(i));
    }

    public static int stringToInt(String str, int i) {
        if (str == null) {
            return i;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return i;
        }
        try {
            return Integer.parseInt(strTrim);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static final void showTip(Context context, String str) {
        if (!TextUtils.isEmpty(str) && System.currentTimeMillis() - sLastTime >= 3000) {
            sLastTime = System.currentTimeMillis();
            UiUtil.showToast(context, str);
        }
    }

    public static final int getFontOffset(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return ((int) (((int) Math.ceil(fontMetrics.bottom - fontMetrics.top)) - paint.getTextSize())) >> 1;
    }

    public static int stringToInt(String str) {
        return stringToInt(str, 0);
    }
}
