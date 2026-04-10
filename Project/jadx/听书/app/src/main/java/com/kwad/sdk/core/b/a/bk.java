package com.kwad.sdk.core.b.a;

import com.kwad.components.core.webview.jshandler.au;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bk implements com.kwad.sdk.core.d<au.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((au.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((au.b) bVar, jSONObject);
    }

    private static void a(au.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.appName = jSONObject.optString("appName");
        if (JSONObject.NULL.toString().equals(bVar.appName)) {
            bVar.appName = "";
        }
        bVar.pkgName = jSONObject.optString("pkgName");
        if (JSONObject.NULL.toString().equals(bVar.pkgName)) {
            bVar.pkgName = "";
        }
        bVar.version = jSONObject.optString("version");
        if (JSONObject.NULL.toString().equals(bVar.version)) {
            bVar.version = "";
        }
        bVar.versionCode = jSONObject.optInt(DefaultUpdateParser.APIKeyLower.VERSION_CODE);
        bVar.aeb = jSONObject.optLong("appSize");
        bVar.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
        if (JSONObject.NULL.toString().equals(bVar.md5)) {
            bVar.md5 = "";
        }
        bVar.url = jSONObject.optString("url");
        if (JSONObject.NULL.toString().equals(bVar.url)) {
            bVar.url = "";
        }
        bVar.icon = jSONObject.optString("icon");
        if (JSONObject.NULL.toString().equals(bVar.icon)) {
            bVar.icon = "";
        }
        bVar.sX = jSONObject.optString("desc");
        if (JSONObject.NULL.toString().equals(bVar.sX)) {
            bVar.sX = "";
        }
    }

    private static JSONObject b(au.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.appName != null && !bVar.appName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appName", bVar.appName);
        }
        if (bVar.pkgName != null && !bVar.pkgName.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "pkgName", bVar.pkgName);
        }
        if (bVar.version != null && !bVar.version.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "version", bVar.version);
        }
        if (bVar.versionCode != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, DefaultUpdateParser.APIKeyLower.VERSION_CODE, bVar.versionCode);
        }
        if (bVar.aeb != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "appSize", bVar.aeb);
        }
        if (bVar.md5 != null && !bVar.md5.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, TKDownloadReason.KSAD_TK_MD5, bVar.md5);
        }
        if (bVar.url != null && !bVar.url.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "url", bVar.url);
        }
        if (bVar.icon != null && !bVar.icon.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "icon", bVar.icon);
        }
        if (bVar.sX != null && !bVar.sX.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "desc", bVar.sX);
        }
        return jSONObject;
    }
}
