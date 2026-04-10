package com.anythink.pd;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.china.activity.ApkConfirmDialogActivity;
import com.anythink.china.b.a;
import com.anythink.china.common.c;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATEventInterface;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.IExHandler;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.i;
import com.anythink.core.common.e.j;
import com.anythink.core.common.f.b;
import com.anythink.core.common.k.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ExHandler implements IExHandler {
    public static final String JSON_REQUEST_BOOT_MARK = "boot_mark";
    public static final String JSON_REQUEST_CPU = "cpu";
    public static final String JSON_REQUEST_IMEI = "imei";
    public static final String JSON_REQUEST_INSTALL_TS = "install_ts";
    public static final String JSON_REQUEST_ISAGENT = "isagent";
    public static final String JSON_REQUEST_ISROOT = "isroot";
    public static final String JSON_REQUEST_MAC = "mac";
    public static final String JSON_REQUEST_OAID = "oaid";
    public static final String JSON_REQUEST_SSID = "wifi_name";
    public static final String JSON_REQUEST_UPDATE_MARK = "update_mark";
    public static final String JSON_REQUEST_UPDATE_TS = "update_ts";
    int macOpen = 1;
    int imeiOpen = 1;

    @Override // com.anythink.core.api.IExHandler
    public boolean checkDebuggerDevice(Context context, String str) {
        String strB = a.b();
        if (TextUtils.isEmpty(strB)) {
            strB = p.b(context, g.f6799o, "oaid", "");
        }
        return TextUtils.equals(str, strB);
    }

    @Override // com.anythink.core.api.IExHandler
    public int checkDownloadType(i iVar, j jVar) {
        return com.anythink.china.common.a.a(n.a().g()).b(iVar);
    }

    @Override // com.anythink.core.api.IExHandler
    public ATEventInterface createDownloadListener(ATBaseAdAdapter aTBaseAdAdapter, BaseAd baseAd, ATEventInterface aTEventInterface) {
        return new c(aTBaseAdAdapter, baseAd, aTEventInterface);
    }

    @Override // com.anythink.core.api.IExHandler
    public String fillCDataParam(String str) {
        if (str == null) {
            return "";
        }
        String strD = this.imeiOpen == 1 ? a.d(n.a().g()) : "";
        String strA = this.macOpen == 1 ? a.a() : "";
        String strB = a.b();
        if (strD == null) {
            strD = "";
        }
        String strReplaceAll = str.replaceAll("at_device1", strD);
        if (strA == null) {
            strA = "";
        }
        return strReplaceAll.replaceAll("at_device2", strA).replaceAll("at_device3", strB != null ? strB : "");
    }

    @Override // com.anythink.core.api.IExHandler
    public void fillRequestData(JSONObject jSONObject, com.anythink.core.c.a aVar) {
        String strF = aVar != null ? aVar.F() : "";
        if (TextUtils.isEmpty(strF)) {
            try {
                jSONObject.put("mac", a.a());
                jSONObject.put("imei", a.d(n.a().g()));
                jSONObject.put("oaid", a.b());
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject(strF);
            this.macOpen = jSONObject2.optInt("m");
            this.imeiOpen = jSONObject2.optInt("i");
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put("mac", this.macOpen == 1 ? a.a() : "");
            jSONObject.put("imei", this.imeiOpen == 1 ? a.d(n.a().g()) : "");
            jSONObject.put("oaid", a.b());
        } catch (Exception unused3) {
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public void fillRequestDeviceData(JSONObject jSONObject, int i2) {
        if ((i2 & 1) == 1) {
            try {
                if (!TextUtils.isEmpty(a.d())) {
                    jSONObject.put(JSON_REQUEST_ISROOT, Integer.parseInt(a.d()));
                }
            } catch (Throwable unused) {
            }
            try {
                if (!TextUtils.isEmpty(a.e())) {
                    jSONObject.put(JSON_REQUEST_ISAGENT, Integer.parseInt(a.e()));
                }
            } catch (Throwable unused2) {
            }
            try {
                jSONObject.put("wifi_name", a.c());
            } catch (Throwable unused3) {
            }
            try {
                if (!TextUtils.isEmpty(a.f())) {
                    jSONObject.put(JSON_REQUEST_INSTALL_TS, Long.parseLong(a.f()));
                }
            } catch (Throwable unused4) {
            }
            try {
                if (!TextUtils.isEmpty(a.g())) {
                    jSONObject.put(JSON_REQUEST_UPDATE_TS, Long.parseLong(a.g()));
                }
            } catch (Throwable unused5) {
            }
            try {
                jSONObject.put("cpu", a.h());
            } catch (Throwable unused6) {
            }
        }
        if ((i2 & 2) == 2) {
            try {
                jSONObject.put(JSON_REQUEST_BOOT_MARK, a.i());
                jSONObject.put(JSON_REQUEST_UPDATE_MARK, a.j());
            } catch (Throwable unused7) {
            }
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public void fillTestDeviceData(JSONObject jSONObject, com.anythink.core.c.a aVar) {
        String strF = aVar != null ? aVar.F() : "";
        if (TextUtils.isEmpty(strF)) {
            try {
                String strD = a.d(n.a().g());
                if (TextUtils.isEmpty(strD)) {
                    strD = "";
                }
                jSONObject.put("IMEI", strD);
                jSONObject.put("OAID", a.c(n.a().g()));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        try {
            JSONObject jSONObject2 = new JSONObject(strF);
            this.macOpen = jSONObject2.optInt("m");
            this.imeiOpen = jSONObject2.optInt("i");
        } catch (Exception unused2) {
        }
        try {
            String strD2 = a.d(n.a().g());
            if (this.imeiOpen != 1 || TextUtils.isEmpty(strD2)) {
                strD2 = "";
            }
            jSONObject.put("IMEI", strD2);
            jSONObject.put("OAID", a.c(n.a().g()));
        } catch (Exception unused3) {
        }
    }

    @Override // com.anythink.core.api.IExHandler
    public String getUniqueId(Context context) {
        return a.b(context);
    }

    @Override // com.anythink.core.api.IExHandler
    public void handleOfferClick(Context context, j jVar, i iVar, String str, String str2, Runnable runnable, b bVar) {
        com.anythink.china.common.a.a(context).a(context, jVar, iVar, str, str2, runnable, bVar);
    }

    @Override // com.anythink.core.api.IExHandler
    public void initDeviceInfo(Context context) {
        a.a(context);
    }

    @Override // com.anythink.core.api.IExHandler
    public void openApkConfirmDialog(Context context, i iVar, j jVar, com.anythink.core.common.f.a aVar) {
        ApkConfirmDialogActivity.a(context, iVar, aVar);
    }
}
