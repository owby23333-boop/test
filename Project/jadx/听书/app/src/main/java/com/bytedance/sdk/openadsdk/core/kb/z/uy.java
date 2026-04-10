package com.bytedance.sdk.openadsdk.core.kb.z;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.kb.z.m;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class uy implements ITTDownloadVisitor {
    public static final String EXTRA_DOWN_INFO_KEY = "open_ad_sdk_download_extra";

    public TTDownloadEventLogger getTTDownloadEventLogger() {
        return null;
    }

    private uy() {
    }

    public static ITTDownloadVisitor create() {
        return new uy();
    }

    public void checkAutoControl(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.kb.dl.g.z zVarZ;
        na naVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(EXTRA_DOWN_INFO_KEY);
        if (jSONObjectOptJSONObject == null || !oq.z() || (zVarZ = com.bytedance.sdk.openadsdk.core.kb.dl.g.z.z(jSONObjectOptJSONObject)) == null || (naVar = zVarZ.z) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.kb.fo.z(str, naVar);
    }

    public JSONObject getDownloadSettings() {
        JSONObject jSONObjectG = com.bytedance.sdk.openadsdk.core.kb.fo.g();
        try {
            if (!zw.g().hh()) {
                jSONObjectG.put("enable_app_install_receiver", 0);
            }
        } catch (Exception unused) {
        }
        return jSONObjectG;
    }

    public String initPath(boolean z) {
        return com.bytedance.sdk.openadsdk.core.kb.fo.z(z);
    }

    public void requestPermission(Activity activity, String[] strArr, ITTPermissionCallback iTTPermissionCallback) {
        fo.requestPermission(activity, strArr, iTTPermissionCallback);
    }

    public boolean hasPermission(Context context, String str) {
        return fo.hasPermission(context, str);
    }

    public void execute(int i, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        e.execute(i, str, map, iTTHttpCallback);
    }

    public void postBody(String str, byte[] bArr, String str2, ITTHttpCallback iTTHttpCallback) {
        e.postBody(str, bArr, str2, 0, iTTHttpCallback);
    }

    public AlertDialog showDialogBySelf(Activity activity, boolean z, DialogBuilder dialogBuilder) {
        return gz.showDialogBySelf(activity, z, dialogBuilder);
    }

    public void showDialogByDelegate(WeakReference<Context> weakReference, boolean z, DialogBuilder dialogBuilder) {
        gz.showDialogByDelegate(weakReference, z, dialogBuilder);
    }

    public boolean isOpenSdkEvent(String str) {
        return com.bytedance.sdk.openadsdk.core.kb.a.fo.z(str);
    }

    public void clearAllData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.m.dl(new File(str));
    }

    public boolean getAppIsBackground() {
        return com.bytedance.sdk.openadsdk.core.uy.ls().z();
    }

    public void executeLogUpload(TTDownloadEventModel tTDownloadEventModel, boolean z) {
        if (isPangolinDownloadReport(tTDownloadEventModel)) {
            try {
                com.bytedance.sdk.component.uy.e.z(m.z.build(tTDownloadEventModel, z), 5);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean isPangolinDownloadReport(TTDownloadEventModel tTDownloadEventModel) {
        JSONObject extJson;
        if (tTDownloadEventModel == null || (extJson = tTDownloadEventModel.getExtJson()) == null) {
            return false;
        }
        String strOptString = extJson.optString("ad_extra_data");
        if (TextUtils.isEmpty(strOptString)) {
            return false;
        }
        try {
            return new JSONObject(strOptString).optJSONObject(EXTRA_DOWN_INFO_KEY) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}
