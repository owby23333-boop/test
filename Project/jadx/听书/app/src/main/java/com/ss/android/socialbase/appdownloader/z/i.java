package com.ss.android.socialbase.appdownloader.z;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class i extends z {
    public i(Context context, com.ss.android.socialbase.downloader.i.z zVar, String str) {
        super(context, zVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.z.gc
    public Intent g() {
        String strDl = this.g.dl("s");
        String strZ = com.ss.android.socialbase.appdownloader.m.dl.z(this.g.dl("bb"), strDl);
        if (!TextUtils.isEmpty(strZ) && strZ.split(",").length == 2) {
            String strZ2 = com.ss.android.socialbase.appdownloader.m.dl.z(this.g.dl("bc"), strDl);
            if (!TextUtils.isEmpty(strZ2) && strZ2.split(",").length == 2) {
                String[] strArrSplit = strZ.split(",");
                String[] strArrSplit2 = strZ2.split(",");
                String strZ3 = com.ss.android.socialbase.appdownloader.m.dl.z(this.g.dl("bd"), strDl);
                String strZ4 = com.ss.android.socialbase.appdownloader.m.dl.z(this.g.dl("be"), strDl);
                String strZ5 = com.ss.android.socialbase.appdownloader.m.dl.z(this.g.dl("bf"), strDl);
                HashMap map = new HashMap();
                map.put(strArrSplit[0], strArrSplit[1]);
                map.put(strArrSplit2[0], strArrSplit2[1]);
                map.put(strZ3, this.dl);
                Intent intent = new Intent();
                intent.setAction(strZ5);
                intent.setData(Uri.parse(strZ4 + z(map)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }

    public static String z(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append("&");
        }
        String string = stringBuffer.toString();
        return string.endsWith("&") ? string.substring(0, string.length() - 1) : string;
    }
}
