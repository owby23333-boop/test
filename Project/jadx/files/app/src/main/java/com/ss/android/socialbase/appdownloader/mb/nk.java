package com.ss.android.socialbase.appdownloader.mb;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.expressad.foundation.g.a;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class nk extends mb {
    public nk(Context context, DownloadSetting downloadSetting, String str) {
        super(context, downloadSetting, str);
    }

    public static String mb(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append("=");
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        String string = stringBuffer.toString();
        return string.endsWith(DispatchConstants.SIGN_SPLIT_SYMBOL) ? string.substring(0, string.length() - 1) : string;
    }

    @Override // com.ss.android.socialbase.appdownloader.mb.h
    public Intent ox() {
        String strOptString = this.ox.optString("s");
        String strMb = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("bb"), strOptString);
        if (!TextUtils.isEmpty(strMb) && strMb.split(",").length == 2) {
            String strMb2 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("bc"), strOptString);
            if (!TextUtils.isEmpty(strMb2) && strMb2.split(",").length == 2) {
                String[] strArrSplit = strMb.split(",");
                String[] strArrSplit2 = strMb2.split(",");
                String strMb3 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString(a.L), strOptString);
                String strMb4 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("be"), strOptString);
                String strMb5 = com.ss.android.socialbase.appdownloader.u.b.mb(this.ox.optString("bf"), strOptString);
                HashMap map = new HashMap();
                map.put(strArrSplit[0], strArrSplit[1]);
                map.put(strArrSplit2[0], strArrSplit2[1]);
                map.put(strMb3, this.b);
                Intent intent = new Intent();
                intent.setAction(strMb5);
                intent.setData(Uri.parse(strMb4 + mb(map)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
