package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.anythink.expressad.foundation.d.c;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class lz extends mb {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f18068h;
    private String hj;

    public lz(Context context, DownloadSetting downloadSetting, String str, String str2, String str3) {
        super(context, downloadSetting, str);
        this.hj = str2;
        this.f18068h = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        String str;
        String strOptString = this.ox.optString("s");
        String strMb = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("ak"), strOptString);
        String strMb2 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("am"), strOptString);
        String strMb3 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("an"), strOptString);
        String strSubstring = null;
        if (!TextUtils.isEmpty(strMb3) && strMb3.split(",").length == 2) {
            String[] strArrSplit = strMb3.split(",");
            String strMb4 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString(c.bl), strOptString);
            String strMb5 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("ao"), strOptString);
            if (!TextUtils.isEmpty(strMb5) && strMb5.split(",").length == 2) {
                String[] strArrSplit2 = strMb5.split(",");
                JSONObject jSONObjectOptJSONObject = this.ox.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
                    if (TextUtils.isEmpty(strOptString2) || !strOptString2.contains("%s")) {
                        str = this.f18068h;
                    } else {
                        try {
                            str = String.format(strOptString2, this.f18068h);
                        } catch (Throwable unused) {
                            str = this.f18068h;
                        }
                    }
                    strSubstring = str;
                    if (strSubstring.length() > 255) {
                        strSubstring = strMb4.substring(strSubstring.length() - 255);
                    }
                }
                Intent intent = new Intent(strMb);
                intent.putExtra(strArrSplit2[0], strArrSplit2[1]);
                intent.putExtra(strMb2, this.hj);
                intent.putExtra(strMb4, strSubstring);
                intent.putExtra(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
