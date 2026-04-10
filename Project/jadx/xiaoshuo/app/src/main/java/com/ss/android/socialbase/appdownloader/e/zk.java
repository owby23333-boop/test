package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alipay.sdk.m.w.a;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class zk extends e {
    private String ga;
    private String tg;

    public zk(Context context, com.ss.android.socialbase.downloader.p.e eVar, String str, String str2, String str3) {
        super(context, eVar, str);
        this.tg = str2;
        this.ga = str3;
    }

    @Override // com.ss.android.socialbase.appdownloader.e.ga
    public Intent bf() {
        String str;
        String strD = this.bf.d("s");
        String strE = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("ak"), strD);
        String strE2 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("am"), strD);
        String strE3 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d(a.w), strD);
        String strSubstring = null;
        if (!TextUtils.isEmpty(strE3) && strE3.split(",").length == 2) {
            String[] strArrSplit = strE3.split(",");
            String strE4 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("al"), strD);
            String strE5 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d(LiveConfigKey.AUDIO), strD);
            if (!TextUtils.isEmpty(strE5) && strE5.split(",").length == 2) {
                String[] strArrSplit2 = strE5.split(",");
                JSONObject jSONObjectTg = this.bf.tg("download_dir");
                if (jSONObjectTg != null) {
                    String strOptString = jSONObjectTg.optString("dir_name");
                    if (TextUtils.isEmpty(strOptString) || !strOptString.contains("%s")) {
                        str = this.ga;
                    } else {
                        try {
                            str = String.format(strOptString, this.ga);
                        } catch (Throwable unused) {
                            str = this.ga;
                        }
                    }
                    strSubstring = str;
                    if (strSubstring.length() > 255) {
                        strSubstring = strE4.substring(strSubstring.length() - 255);
                    }
                }
                Intent intent = new Intent(strE);
                intent.putExtra(strArrSplit2[0], strArrSplit2[1]);
                intent.putExtra(strE2, this.tg);
                intent.putExtra(strE4, strSubstring);
                intent.putExtra(strArrSplit[0], Integer.parseInt(strArrSplit[1]));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
