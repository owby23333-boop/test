package com.yuewen.openapi.track;

import android.os.Build;
import android.util.DisplayMetrics;
import androidx.webkit.ProxyConfig;
import com.dangdang.zframework.utils.DateUtil;
import com.duokan.reader.domain.store.DkStoreBookInfo;
import com.yuewen.b;
import com.yuewen.openapi.OpenSDKMemoryCache;
import com.yuewen.openapi.utils.CommonUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class TrackUtil {
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtil.DATE_FORMAT_TYPE_2);

    public static void track(String str, String str2) {
        track(str, str2, null);
    }

    public static void wrapCommonData(JSONObject jSONObject) throws JSONException {
        jSONObject.put(TrackConstants.APP_FLAG, OpenSDKMemoryCache.getAppFlag());
        jSONObject.put("imei", OpenSDKMemoryCache.getImei());
        jSONObject.put("version", 1);
        jSONObject.put("platform", DkStoreBookInfo.PLATFORM);
        jSONObject.put(TrackConstants.LOG_TIME, simpleDateFormat.format(new Date(System.currentTimeMillis())));
        jSONObject.put(TrackConstants.CNAME, "freeopensdk");
        jSONObject.put("guid", OpenSDKMemoryCache.getGuid());
        jSONObject.put("model", Build.MODEL);
        jSONObject.put("brand", Build.BRAND);
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        DisplayMetrics displayMetrics = OpenSDKMemoryCache.getContext().getResources().getDisplayMetrics();
        jSONObject.put(TrackConstants.SHW, displayMetrics.widthPixels + ProxyConfig.MATCH_ALL_SCHEMES + displayMetrics.heightPixels);
        try {
            jSONObject.put(TrackConstants.NETWORK_TYPE, "");
            jSONObject.put(TrackConstants.CLIENTIP, CommonUtil.getIPAddress(OpenSDKMemoryCache.getContext()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void track(String str, String str2, Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
            wrapCommonData(jSONObject);
            jSONObject.put(TrackConstants.EVENT_ID, str);
            jSONObject.put(TrackConstants.EVENT_TYPE, str2);
            b.g().a(jSONObject, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
