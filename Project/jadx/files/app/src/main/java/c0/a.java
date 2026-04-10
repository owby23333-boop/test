package c0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.meituan.android.walle.WalleChannelReader;
import com.sntech.okhttpconnection.log.Cdo;
import com.ss.android.download.api.constant.BaseConstants;
import com.umeng.analytics.AnalyticsConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ChannelUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            String channel = null;
            jSONObject.put("channel", context.getSharedPreferences("prefs_sn_android", 0).getString("app_channel", null));
            String strA = a(context, "UMENG_CHANNEL");
            if (TextUtils.isEmpty(strA)) {
                try {
                    Class.forName("com.umeng.analytics.AnalyticsConfig");
                    strA = AnalyticsConfig.getChannel(context);
                } catch (ClassNotFoundException unused) {
                }
            }
            jSONObject.put(BaseConstants.CATEGORY_UMENG, strA);
            jSONObject.put("talkingData", a(context, "TD_CHANNEL_ID"));
            try {
                Class.forName("com.meituan.android.walle.WalleChannelReader");
                channel = WalleChannelReader.getChannel(context, "");
            } catch (ClassNotFoundException unused2) {
            }
            jSONObject.put("walle", channel);
        } catch (JSONException unused3) {
        }
        if (Cdo.m119do()) {
            String str = "channels: " + jSONObject;
        }
        return jSONObject;
    }

    public static String a(Context context, String str) {
        Bundle bundle;
        Object obj;
        String string;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && (bundle = applicationInfo.metaData) != null && (obj = bundle.get(str)) != null && (string = obj.toString()) != null) {
                    return string.trim();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
