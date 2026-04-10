package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.Log;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import kotlin.io.encoding.Base64;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class pbln extends pblm {
    private SDKMonitor e;

    public class pgla implements SDKMonitor.IGetExtendParams {
        final /* synthetic */ String bf;
        final /* synthetic */ JSONObject e;

        public pgla(pbln pblnVar, JSONObject jSONObject, String str) {
            this.e = jSONObject;
            this.bf = str;
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblm
    public void bf(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject) {
        SDKMonitor sDKMonitor = this.e;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorApiError(j, j2, str, str2, str3, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblm
    public void e(long j, long j2, String str, String str2, String str3, int i, JSONObject jSONObject) {
        SDKMonitor sDKMonitor = this.e;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorSLA(j, j2, str, str2, str3, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblm
    public void e(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        if (this.e == null) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put((String) pblk.a(16777217, 0, 0L, "a80281", new byte[]{99, Utf8.REPLACEMENT_BYTE, 81, 80, Ascii.SO, 37, 103, Ascii.ETB, 96, 111, 117}), str);
            jSONObject4.put((String) pblk.a(16777217, 0, 0L, "a92173", new byte[]{115, 58, 85, 64, Ascii.SI, 43, 112, 1}), jSONObject);
            jSONObject4.put((String) pblk.a(16777217, 0, 0L, "20b260", new byte[]{46, 55, 5, 84, 0, 36}), jSONObject2);
            jSONObject4.put((String) pblk.a(16777217, 0, 0L, "6ff52e", new byte[]{43, 107, 18, 100, Ascii.NAK, 102, 39}), jSONObject3);
            jSONObject4.toString();
            Log.e((String) pblk.a(16777217, 0, 0L, "4e6e2c", new byte[]{8, 66, 113, 48, 62, 81, Ascii.DC4}), jSONObject4.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (jSONObject.length() > 0 || jSONObject2.length() > 0) {
            this.e.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblm
    public boolean e(String str) {
        JSONObject jSONObject;
        String str2;
        String string;
        Context contextBf = ms.bz.bd.c.Pgl.pgla.e().bf();
        String string2 = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        try {
            string = jSONObject.getString((String) pblk.a(16777217, 0, 0L, "6ee3c4", new byte[]{52, 99, Ascii.GS, 120, 93, 42, 49}));
            try {
                string2 = jSONObject.getString((String) pblk.a(16777217, 0, 0L, "71bf0d", new byte[]{46, 60, 2, 6, 48, 114, Base64.padSymbol, Ascii.DC4}));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray((String) pblk.a(16777217, 0, 0L, "901418", new byte[]{43, Base64.padSymbol, 76, 70, 7, 40, Ascii.SI, 35, 76, 119}));
                JSONArray jSONArray2 = jSONObject.getJSONArray((String) pblk.a(16777217, 0, 0L, "88df2c", new byte[]{59, Utf8.REPLACEMENT_BYTE, 7, Ascii.GS, Ascii.US, 96, Ascii.SO, 43, Ascii.EM, 37}));
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList2.add(jSONArray2.getString(i2));
                }
                if (arrayList.size() <= 0 || arrayList2.size() <= 0) {
                    return false;
                }
                SDKMonitorUtils.setConfigUrl(string, arrayList);
                SDKMonitorUtils.setDefaultReportUrl(string, arrayList2);
            } catch (JSONException unused2) {
                str2 = string2;
                string2 = string;
                string = string2;
                string2 = str2;
            }
        } catch (JSONException unused3) {
            str2 = null;
        }
        jSONObject.remove((String) pblk.a(16777217, 0, 0L, "0a6b32", new byte[]{34, 108, 75, 16, 5, 34, 6, 114, 75, 33}));
        jSONObject.remove((String) pblk.a(16777217, 0, 0L, "0c0a44", new byte[]{51, 100, 83, Ascii.SUB, Ascii.EM, 55, 6, 112, 77, 34}));
        SDKMonitorUtils.initMonitor(contextBf, string, jSONObject, new pgla(this, jSONObject, string2));
        this.e = SDKMonitorUtils.getInstance(string);
        return true;
    }
}
