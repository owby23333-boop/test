package com.yuewen;

import com.xiaomi.ad.common.util.SignatureUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class pt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SimpleDateFormat f16200a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static String a(long j) {
        return f16200a.format(new Date(j));
    }

    public static String b(long j) {
        if (j > TimeUnit.SECONDS.toMillis(10L)) {
            return "10+";
        }
        int i = (int) (j / 1000);
        if (((int) (j - ((long) (i * 1000)))) > 500) {
            return i + ".5-" + (i + 1);
        }
        return i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i + ".5";
    }

    public static void c(StringBuilder sb, Object obj) {
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            sb.append("[");
            for (int i = 0; i < jSONArray.length(); i++) {
                c(sb, jSONArray.opt(i));
                sb.append(",");
            }
            sb.append("]");
        } else if (obj instanceof JSONObject) {
            sb.append(d((JSONObject) obj));
        } else {
            sb.append(obj);
        }
        sb.append(SignatureUtils.DELIMITER);
    }

    public static String d(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder("{");
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            sb.append(next);
            sb.append(":");
            c(sb, jSONObject.opt(next));
        }
        sb.append(com.alipay.sdk.m.y.l.d);
        return sb.toString();
    }
}
