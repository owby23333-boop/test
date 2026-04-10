package a0;

import com.anythink.core.api.ATSDK;
import com.baidu.mobads.sdk.api.AdSettings;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.kwad.sdk.api.KsAdSDK;
import com.qq.e.comm.managers.status.SDKStatus;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: VersionUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static String a() {
        try {
            return AdSettings.getSDKVersion();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b() {
        try {
            return SDKStatus.getSDKVersion();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static JSONObject c() throws JSONException {
        String sDKVersion;
        String str;
        String sDKVersion2;
        String sDKVersionName = "";
        JSONObject jSONObject = new JSONObject();
        try {
            sDKVersion = TTAdSdk.getAdManager().getSDKVersion();
        } catch (Throwable unused) {
            sDKVersion = "";
        }
        jSONObject.put("CSJ", sDKVersion);
        try {
            str = (String) Class.forName("com.bytedance.sdk.openadsdk.TTAdManager").getMethod("getPluginVersion", new Class[0]).invoke(Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk").getMethod("getAdManager", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Exception unused2) {
            str = "";
        }
        jSONObject.put("CSJ_PLUGIN", str);
        jSONObject.put("YLH", b());
        try {
            sDKVersion2 = KsAdSDK.getSDKVersion();
        } catch (Throwable unused3) {
            sDKVersion2 = "";
        }
        jSONObject.put("KUAISHOU", sDKVersion2);
        try {
            sDKVersionName = ATSDK.getSDKVersionName();
        } catch (Throwable unused4) {
        }
        jSONObject.put("TOPON", sDKVersionName);
        jSONObject.put("BQT", a());
        return jSONObject;
    }
}
