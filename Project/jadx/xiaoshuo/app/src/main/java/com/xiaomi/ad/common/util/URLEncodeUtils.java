package com.xiaomi.ad.common.util;

import com.alipay.sdk.m.w.a;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.ad.k;
import java.net.URLEncoder;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class URLEncodeUtils {
    public static final String TAG = "URLEncodeUtils";

    public static String fromParamListToString(List<k> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (k kVar : list) {
                try {
                    if (kVar.b() != null) {
                        stringBuffer.append(URLEncoder.encode(kVar.a(), "UTF-8"));
                        stringBuffer.append(MscKeys.KEY_VAL_SEP);
                        stringBuffer.append(URLEncoder.encode(kVar.b(), "UTF-8"));
                        stringBuffer.append(a.p);
                    }
                } catch (Exception e) {
                    MLog.i(TAG, "Failed to convert from param list to string: " + e.toString());
                    MLog.i(TAG, "pair: " + kVar.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }
}
