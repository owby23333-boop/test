package com.taobao.accs.utl;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ta.utdid2.device.UTDevice;
import com.ut.mini.UTAnalytics;
import com.ut.mini.internal.UTOriginalCustomHitBuilder;
import java.util.Map;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes3.dex */
public final class UTMini {
    public static final int EVENTID_AGOO = 19999;
    public static final String PAGE_AGOO = "Page_Push";
    private static final String TAG = "UTMini";
    private static UTMini instance = new UTMini();

    private String _convertStringAToKVSString(String... strArr) {
        if (strArr != null && strArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null && strArr.length > 0) {
            boolean z2 = false;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (!TextUtils.isEmpty(strArr[i2])) {
                    if (z2) {
                        stringBuffer.append(",");
                    }
                    stringBuffer.append(strArr[i2]);
                    z2 = true;
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String convertObjectToString(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Integer) {
            return "" + ((Integer) obj).intValue();
        }
        if (obj instanceof Long) {
            return "" + ((Long) obj).longValue();
        }
        if (obj instanceof Double) {
            return "" + ((Double) obj).doubleValue();
        }
        if (obj instanceof Float) {
            return "" + ((Float) obj).floatValue();
        }
        if (obj instanceof Short) {
            return "" + ((int) ((Short) obj).shortValue());
        }
        if (!(obj instanceof Byte)) {
            return obj instanceof Boolean ? ((Boolean) obj).toString() : obj instanceof Character ? ((Character) obj).toString() : obj.toString();
        }
        return "" + ((int) ((Byte) obj).byteValue());
    }

    public static String getCommitInfo(int i2, String str, String str2, String str3, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("eventId=");
        sb.append(i2);
        sb.append(";arg1=");
        sb.append(str);
        sb.append(";arg2=");
        sb.append(str2);
        sb.append(";arg3=");
        sb.append(str3);
        if (map != null) {
            sb.append(";");
            sb.append("args=");
            sb.append(map.toString());
        }
        return sb.toString();
    }

    public static UTMini getInstance() {
        return instance;
    }

    private static String[] mapToArray(Map<String, String> map) {
        int i2 = 0;
        if (map == null || map.isEmpty()) {
            return new String[0];
        }
        String[] strArr = new String[map.size()];
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                strArr[i2] = "";
            } else {
                strArr[i2] = key + "=" + value;
            }
            i2++;
        }
        return strArr;
    }

    public final void commitEvent(int i2, String str, Object obj) {
        try {
            UTAnalytics.getInstance().getTracker("accs").send(new UTOriginalCustomHitBuilder(str, i2, convertObjectToString(obj), (String) null, (String) null, (Map) null).build());
        } catch (Throwable unused) {
        }
    }

    public final String getUtdId(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void onCaughException(Throwable th) {
    }

    public final void start(Application application, String str, String str2, String str3) {
        try {
            UTAnalytics.getInstance().setAppApplicationInstance(application, new w(this, str3, str));
            ALog.d(TAG, "start success", new Object[0]);
        } catch (Throwable th) {
            ALog.e(TAG, "start fail ", th, new Object[0]);
        }
    }

    public final void stop(Context context) {
    }

    public final void commitEvent(int i2, String str, Object obj, Object obj2) {
        try {
            UTAnalytics.getInstance().getTracker("accs").send(new UTOriginalCustomHitBuilder(str, i2, convertObjectToString(obj), convertObjectToString(obj2), (String) null, (Map) null).build());
        } catch (Throwable unused) {
        }
    }

    public final void commitEvent(int i2, String str, Object obj, Object obj2, Object obj3) {
        try {
            UTAnalytics.getInstance().getTracker("accs").send(new UTOriginalCustomHitBuilder(str, i2, convertObjectToString(obj), convertObjectToString(obj2), convertObjectToString(obj3), (Map) null).build());
        } catch (Throwable unused) {
        }
    }

    public final void commitEvent(int i2, String str, Object obj, Object obj2, Object obj3, String... strArr) {
        try {
            UTOriginalCustomHitBuilder uTOriginalCustomHitBuilder = new UTOriginalCustomHitBuilder(str, i2, convertObjectToString(obj), convertObjectToString(obj2), convertObjectToString(obj3), (Map) null);
            uTOriginalCustomHitBuilder.setProperty("_field_args", _convertStringAToKVSString(strArr));
            UTAnalytics.getInstance().getTracker("accs").send(uTOriginalCustomHitBuilder.build());
        } catch (Throwable unused) {
        }
    }

    public final void commitEvent(int i2, String str, Object obj, Object obj2, Object obj3, Map<String, String> map) {
        try {
            commitEvent(i2, str, obj, obj2, obj3, mapToArray(map));
        } catch (Throwable unused) {
        }
    }

    public static String getCommitInfo(int i2, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder();
        sb.append("eventId=");
        sb.append(i2);
        sb.append(";arg1=");
        sb.append(str);
        sb.append(";arg2=");
        sb.append(str2);
        sb.append(";arg3=");
        sb.append(str3);
        if (str4 != null) {
            sb.append(";");
            sb.append("args=");
            sb.append(str4);
        }
        return sb.toString();
    }
}
