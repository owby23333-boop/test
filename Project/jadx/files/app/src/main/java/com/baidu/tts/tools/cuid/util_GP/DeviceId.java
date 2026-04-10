package com.baidu.tts.tools.cuid.util_GP;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceId {
    private static final String S_DEFAULT_SOURCE = "mini0";
    private static final String S_PREFIX = "0newiqr3";
    private static CuidV3Bean sCachedCuidInfo = null;
    private static volatile String sFirstSrc = "";
    private static String sSource = "";
    private final Context mContext;

    private DeviceId(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static String getCUID(Context context) {
        return getOrCreateCUIDInfo(context).getFinalCUID();
    }

    private CuidV3Bean getCuidBean() {
        CuidV3Bean cuidV3BeanCreateFromV3Storage = CuidV3Bean.createFromV3Storage(this.mContext);
        boolean z2 = cuidV3BeanCreateFromV3Storage == null;
        if (cuidV3BeanCreateFromV3Storage == null) {
            CuidV2Bean cuidV2BeanCreateFromV2Storage = CuidV2Bean.createFromV2Storage(this.mContext);
            if (cuidV2BeanCreateFromV2Storage == null) {
                cuidV3BeanCreateFromV3Storage = CuidV3Bean.generate(this.mContext, getSource());
            } else {
                cuidV2BeanCreateFromV2Storage.fixCuid();
                cuidV3BeanCreateFromV3Storage = CuidV3Bean.createFromV2Bean(cuidV2BeanCreateFromV2Storage);
            }
        }
        if (z2) {
            cuidV3BeanCreateFromV3Storage.store(this.mContext);
        }
        CuidV2Bean.deleteIfNeed(this.mContext);
        return cuidV3BeanCreateFromV3Storage;
    }

    public static String getDeviceID(Context context) {
        return getOrCreateCUIDInfo(context).getDeviceId();
    }

    private static CuidV3Bean getOrCreateCUIDInfo(Context context) {
        if (sCachedCuidInfo == null) {
            synchronized (CuidV3Bean.class) {
                if (sCachedCuidInfo == null) {
                    SystemClock.uptimeMillis();
                    sCachedCuidInfo = new DeviceId(context).getCuidBean();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return sCachedCuidInfo;
    }

    static String getSource() {
        if (TextUtils.isEmpty(sSource)) {
            sSource = "0newiqr3mini0";
        }
        return sSource;
    }

    public static void setSource(String str) {
        if (!DeviceIdUtil.isLegalSrc(str, 5)) {
            throw new IllegalArgumentException("expect src only letter or number , less than 6");
        }
        synchronized (CuidV3Bean.class) {
            if (TextUtils.isEmpty(sFirstSrc)) {
                sFirstSrc = str;
                int length = 5 - str.length();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(S_PREFIX);
                stringBuffer.append(str);
                for (int i2 = 0; i2 < length; i2++) {
                    stringBuffer.append("0");
                }
                sSource = stringBuffer.toString().trim();
            }
        }
    }
}
