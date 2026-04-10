package com.sntech.okhttpconnection.log;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.sntech.okhttpconnection.log.Ccatch;
import com.sntech.okhttpconnection.log.Cif;
import java.io.File;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import okhttp3.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.sntech.okhttpconnection.log.do, reason: invalid class name */
/* JADX INFO: compiled from: Const.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cdo {

    /* JADX INFO: renamed from: break, reason: not valid java name */
    public static String f104break;

    /* JADX INFO: renamed from: case, reason: not valid java name */
    public static final Map<String, String> f105case;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static final MediaType f106do;

    /* JADX INFO: renamed from: else, reason: not valid java name */
    public static boolean f107else;

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static String f108for;

    /* JADX INFO: renamed from: goto, reason: not valid java name */
    public static final Object f109goto;

    /* JADX INFO: renamed from: if, reason: not valid java name */
    public static Context f110if;

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public static String f111new;

    /* JADX INFO: renamed from: this, reason: not valid java name */
    public static final Object f112this;

    /* JADX INFO: renamed from: try, reason: not valid java name */
    public static Celse f113try;

    static {
        Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
        f106do = MediaType.parse("application/json; charset=utf-8");
        f105case = new HashMap();
        HashSet hashSet = new HashSet();
        hashSet.add("127.0.0.1");
        hashSet.add("192.168.1.15");
        hashSet.add("192.168.1.15:8080");
        m116do(hashSet);
        f109goto = new Object();
        f112this = new Object();
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m118do(Map<String, String> map) {
        Map<String, String> map2 = f105case;
        synchronized (map2) {
            if (map != null) {
                ((HashMap) map2).clear();
                ((HashMap) map2).putAll(map);
            }
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static Pattern m116do(Set<String> set) {
        if (set == null || set.size() == 0) {
            return null;
        }
        Iterator<String> it = set.iterator();
        String str = "";
        while (it.hasNext()) {
            str = str + it.next() + com.anythink.expressad.foundation.g.a.bQ;
        }
        return Pattern.compile(str.substring(0, str.lastIndexOf(124)));
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String m115do(Context context) {
        try {
            File file = new File(context.getFilesDir(), "snc_did.data");
            strM140do = file.exists() ? Cthis.m140do(file.getPath()) : null;
            if (TextUtils.isEmpty(strM140do)) {
                strM140do = Cif.Cfor.m134do(UUID.randomUUID().toString().getBytes());
                FileWriter fileWriter = new FileWriter(file);
                try {
                    fileWriter.write(strM140do);
                    fileWriter.close();
                } finally {
                }
            }
            return strM140do;
        } catch (Exception e2) {
            if (m119do()) {
                e2.printStackTrace();
            }
            return strM140do;
        }
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static boolean m119do() {
        Celse celse = f113try;
        return celse != null && celse.f115for;
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static void m117do(Ccatch.Cif cif) {
        String string;
        Context context = f110if;
        String strM120do = f113try.m120do();
        String str = null;
        if (((HashMap) Cnew.f122do).isEmpty() && (string = context.getSharedPreferences("sn_prefs_logs", 0).getString("dig_domains", null)) != null) {
            try {
                Cnew.m139do(new JSONObject(string));
            } catch (JSONException e2) {
                if (m119do()) {
                    e2.printStackTrace();
                }
            }
        }
        String host = Uri.parse(strM120do).getHost();
        if (!TextUtils.isEmpty(host) && ((HashMap) Cnew.f122do).containsKey(host)) {
            List list = (List) ((HashMap) Cnew.f122do).get(host);
            if (list != null && list.size() != 0) {
                int size = list.size();
                double dRandom = Math.random();
                double d2 = size;
                Double.isNaN(d2);
                int i2 = ((int) ((dRandom * d2) + 0.5d)) - 1;
                if (i2 < 0) {
                    i2 = 0;
                }
                str = (String) list.get(i2);
            }
            if (!TextUtils.isEmpty(str)) {
                strM120do = strM120do.replaceFirst(host, str);
            }
        }
        Set<String> set = cif.f102new;
        synchronized (f109goto) {
            if (set != null) {
                HashSet hashSet = new HashSet(set);
                hashSet.add("127.0.0.1");
                hashSet.add("192.168.1.15");
                hashSet.add("192.168.1.15:8080");
                try {
                    hashSet.add(new URL(strM120do).getHost());
                } catch (MalformedURLException unused) {
                }
                m116do(hashSet);
            }
        }
        Set<String> set2 = cif.f100for;
        synchronized (f112this) {
            m116do(set2);
        }
    }
}
