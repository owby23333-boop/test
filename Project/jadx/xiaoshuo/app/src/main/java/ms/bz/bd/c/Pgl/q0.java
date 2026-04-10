package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.yuewen.g72;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class q0 {
    public static String bf(Context context) {
        if (context == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(tg(context));
        try {
            Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            while (it.hasNext()) {
                String packageName = it.next().getPackageName();
                String str = context.getPackageManager().getApplicationInfo(packageName, 0).sourceDir;
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]");
                    sb.append(str);
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static String d(Context context) {
        int i;
        List list;
        JSONArray jSONArray = new JSONArray();
        if (context == null) {
            return jSONArray.toString();
        }
        String string = null;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(g72.g);
            Method declaredMethod = wifiManager.getClass().getDeclaredMethod(new String(pbly.e("6765745363616e526573756c7473")), new Class[0]);
            list = declaredMethod != null ? (List) declaredMethod.invoke(wifiManager, new Object[0]) : null;
        } catch (Throwable unused) {
        }
        if (list != null && list.size() > 0) {
            Collections.sort(list, new r0());
            for (i = 0; i < list.size() && i < 10; i++) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("ss", n1.e(((ScanResult) list.get(i)).SSID));
                    jSONObject.put("bs", n1.e(((ScanResult) list.get(i)).BSSID));
                    jSONArray.put(jSONObject);
                } catch (JSONException unused2) {
                }
            }
            string = jSONArray.toString();
            return string == null ? HttpUrl.PATH_SEGMENT_ENCODE_SET_URI : string.trim();
        }
        return jSONArray.toString();
    }

    public static String e(Context context) {
        if (context == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(tg(context));
        try {
            Iterator<InputMethodInfo> it = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList().iterator();
            while (it.hasNext()) {
                String packageName = it.next().getPackageName();
                if (!TextUtils.isEmpty(packageName) && sb.indexOf(packageName) < 0) {
                    sb.append("[<!>]");
                    sb.append(packageName);
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    private static String tg(Context context) {
        String string;
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
            if (TextUtils.isEmpty(string)) {
                return "null_";
            }
            if (string.contains("/")) {
                string = string.split("/")[0];
            }
        } catch (Throwable th) {
            try {
                string = "null_" + th.getMessage();
            } catch (Throwable unused) {
                return "null_";
            }
        }
        return string;
    }
}
