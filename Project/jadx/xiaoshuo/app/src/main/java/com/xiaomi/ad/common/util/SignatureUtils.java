package com.xiaomi.ad.common.util;

import android.text.TextUtils;
import com.alipay.sdk.m.w.a;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.ad.k;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class SignatureUtils {
    public static final String DELIMITER = "\n";
    public static final String HTTP_METHOD = "POST";
    public static final String TAG = "SignatureUtils";

    public static class UrlParser {
        public String mHost;
        public List<k> mParameters = new ArrayList();
        public String mPath;
        public String mUrl;

        public UrlParser(String str) {
            this.mUrl = str.trim();
            parseHostAndPath();
            parseParameters();
        }

        public static UrlParser parse(String str) {
            try {
                return new UrlParser(str);
            } catch (Exception e) {
                MLog.e(SignatureUtils.TAG, "Parse [" + str + "] failed!", e);
                return null;
            }
        }

        private void parseHostAndPath() {
            int iIndexOf = this.mUrl.indexOf("://");
            if (iIndexOf >= 0) {
                String str = this.mUrl;
                String strSubstring = str.substring(iIndexOf + 3, str.length());
                int iIndexOf2 = strSubstring.indexOf("/");
                this.mHost = strSubstring.substring(0, iIndexOf2);
                this.mPath = strSubstring.substring(iIndexOf2, strSubstring.contains("?") ? strSubstring.indexOf("?") : strSubstring.length());
            }
        }

        private void parseParameters() {
            List<k> list;
            k kVar;
            for (String str : truncateUrlPage(this.mUrl).split("[&]")) {
                String[] strArrSplit = str.split("[=]");
                if (strArrSplit.length > 1) {
                    list = this.mParameters;
                    kVar = new k(strArrSplit[0], strArrSplit[1]);
                } else if (strArrSplit[0] != "") {
                    list = this.mParameters;
                    kVar = new k(strArrSplit[0], "");
                }
                list.add(kVar);
            }
        }

        private String truncateUrlPage(String str) {
            String str2;
            String strTrim = str.trim();
            String[] strArrSplit = strTrim.split("[?]");
            if (strTrim.length() <= 1 || strArrSplit.length <= 1 || (str2 = strArrSplit[1]) == null) {
                return null;
            }
            return str2;
        }
    }

    public static String sign(String str, String str2) {
        UrlParser urlParser = UrlParser.parse(str);
        if (urlParser == null) {
            return null;
        }
        return sign(urlParser.mHost, urlParser.mUrl, urlParser.mParameters, str2);
    }

    public static String sign(String str, String str2, String str3, String str4) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str3);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                arrayList.add(new k(next, jSONObject.optString(next)));
            }
            return sign(str, str2, arrayList, str4);
        } catch (Exception unused) {
            MLog.e(TAG, "sign");
            return null;
        }
    }

    public static String sign(String str, String str2, List<k> list, String str3) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (list != null) {
            sb.append("POST");
            sb.append(DELIMITER);
            sb.append(str);
            sb.append(DELIMITER);
            sb.append(str2);
            sb.append(DELIMITER);
            HashMap map = new HashMap();
            ArrayList<String> arrayList = new ArrayList();
            for (k kVar : list) {
                if (kVar != null && !TextUtils.isEmpty(kVar.a())) {
                    String strA = kVar.a();
                    if (!map.containsKey(strA)) {
                        arrayList.add(strA);
                    }
                    map.put(strA, kVar);
                }
            }
            Collections.sort(arrayList);
            for (String str4 : arrayList) {
                if (sb2.length() > 0) {
                    sb2.append(a.p);
                }
                sb2.append(URLEncoder.encode(str4));
                sb2.append(MscKeys.KEY_VAL_SEP);
                sb2.append(URLEncoder.encode(((k) map.get(str4)).b()));
            }
        }
        sb2.append("&appSecret=");
        sb2.append(str3);
        sb.append(sb2.toString());
        return HashUtils.getMd5(sb.toString().replaceAll("\\+", "%20"));
    }
}
