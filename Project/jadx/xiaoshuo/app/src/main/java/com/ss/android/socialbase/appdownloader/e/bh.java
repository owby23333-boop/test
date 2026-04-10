package com.ss.android.socialbase.appdownloader.e;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.w.a;
import com.iflytek.aikit.media.param.MscKeys;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class bh extends e {
    public bh(Context context, com.ss.android.socialbase.downloader.p.e eVar, String str) {
        super(context, eVar, str);
    }

    public static String e(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(MscKeys.KEY_VAL_SEP);
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append(a.p);
        }
        String string = stringBuffer.toString();
        return string.endsWith(a.p) ? string.substring(0, string.length() - 1) : string;
    }

    @Override // com.ss.android.socialbase.appdownloader.e.ga
    public Intent bf() {
        String strD = this.bf.d("s");
        String strE = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("bb"), strD);
        if (!TextUtils.isEmpty(strE) && strE.split(",").length == 2) {
            String strE2 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("bc"), strD);
            if (!TextUtils.isEmpty(strE2) && strE2.split(",").length == 2) {
                String[] strArrSplit = strE.split(",");
                String[] strArrSplit2 = strE2.split(",");
                String strE3 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("bd"), strD);
                String strE4 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("be"), strD);
                String strE5 = com.ss.android.socialbase.appdownloader.vn.d.e(this.bf.d("bf"), strD);
                HashMap map = new HashMap();
                map.put(strArrSplit[0], strArrSplit[1]);
                map.put(strArrSplit2[0], strArrSplit2[1]);
                map.put(strE3, this.d);
                Intent intent = new Intent();
                intent.setAction(strE5);
                intent.setData(Uri.parse(strE4 + e(map)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }
}
