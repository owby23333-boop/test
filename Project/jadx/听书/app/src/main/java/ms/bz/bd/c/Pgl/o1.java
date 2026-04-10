package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.sdk.component.utils.wp;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayList;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class o1 extends pblw {
    private SDKMonitor z;

    final class pgla implements SDKMonitor.IGetExtendParams {
        final /* synthetic */ String g;
        final /* synthetic */ JSONObject z;

        pgla(JSONObject jSONObject, String str) {
            this.z = jSONObject;
            this.g = str;
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void g(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.z;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorApiError(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void z(long j, long j2, String str, String str2, int i) {
        SDKMonitor sDKMonitor = this.z;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorSLA(j, j2, str, (String) null, str2, i, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void z(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28895c", new byte[]{16, 54, 74, 95, 14, 117, 35, 60, 127, 108, 45, 46, 103, 66, 13, 89, 48, Ascii.ETB, 104, 110, 38, 40, 11, 94, 15, 102, 39, 16, 106, 108, 45, 59, 70, 72, 74, 57, 124, 84, 41});
        if (this.z == null) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "218b31", new byte[]{48, 54, 89, 0, 5, 37, 52, Ascii.RS, 104, Utf8.REPLACEMENT_BYTE, 38}), str);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d7d139", new byte[]{118, 52, 3, SignedBytes.MAX_POWER_OF_TWO, 11, 33, 117, 15}), jSONObject);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4e2978", new byte[]{40, 98, 85, 95, 1, 44}), jSONObject2);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "157b25", new byte[]{44, 56, 67, 51, Ascii.NAK, 54, 32}), jSONObject3);
            wp.a((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1d042f", new byte[]{13, 67, 119, 97, 62, 84, 17}), jSONObject4.toString());
        } catch (JSONException e) {
            wp.z(e);
        }
        if (jSONObject.length() > 0 || jSONObject2.length() > 0) {
            this.z.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final boolean z(String str) {
        JSONObject jSONObject;
        String str2;
        String string;
        Context contextG = pblv.z().g();
        String string2 = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3662ab", new byte[]{49, 49, 72});
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        try {
            string = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dffdb7", new byte[]{102, 96, Ascii.RS, 47, 92, 41, 99}));
            try {
                string2 = jSONObject.getString((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "166135", new byte[]{40, 59, 86, 81, 51, 35, 59, 19}));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "37d1a7", new byte[]{33, 58, Ascii.EM, 67, 87, 39, 5, 36, Ascii.EM, 114}));
                JSONArray jSONArray2 = jSONObject.getJSONArray((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "995c48", new byte[]{58, 62, 86, Ascii.CAN, Ascii.EM, 59, 15, 42, 72, 32}));
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
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a46430", new byte[]{99, 51, 72, 127, 5});
                string = string2;
                string2 = str2;
            }
        } catch (JSONException unused3) {
            str2 = null;
        }
        jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3a0675", new byte[]{33, 108, 77, 68, 1, 37, 5, 114, 77, 117}));
        jSONObject.remove((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b4887c", new byte[]{97, 51, 91, 67, Ascii.SUB, 96, 84, 39, 69, 123}));
        SDKMonitorUtils.initMonitor(contextG, string, jSONObject, new pgla(jSONObject, string2));
        this.z = SDKMonitorUtils.getInstance(string);
        return true;
    }
}
