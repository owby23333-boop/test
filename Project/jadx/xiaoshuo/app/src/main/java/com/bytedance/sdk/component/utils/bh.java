package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.fasterxml.jackson.core.JsonPointer;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class bh {
    private static volatile bh d;
    private volatile boolean bf = false;
    private Map<String, String> e;
    private Context tg;

    private bh(Context context) {
        if (context != null && this.tg == null) {
            this.tg = context.getApplicationContext();
            e();
        }
        this.tg = context;
    }

    private static String bf(String str) {
        int iIndexOf = str.indexOf(47);
        int iIndexOf2 = str.indexOf(59);
        if (iIndexOf < 0) {
            return null;
        }
        String strTrim = str.substring(0, iIndexOf).trim();
        Locale locale = Locale.ENGLISH;
        String lowerCase = strTrim.toLowerCase(locale);
        if (!d(lowerCase)) {
            return null;
        }
        int i = iIndexOf + 1;
        String lowerCase2 = (iIndexOf2 < 0 ? str.substring(i) : str.substring(i, iIndexOf2)).trim().toLowerCase(locale);
        if (!d(lowerCase2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
        sb.append(lowerCase);
        sb.append(JsonPointer.SEPARATOR);
        sb.append(lowerCase2);
        return sb.toString();
    }

    private static boolean d(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!e(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static String ga(String str) {
        int iIndexOf;
        return (str == null || str.isEmpty() || (iIndexOf = str.indexOf(46)) < 0 || iIndexOf >= str.length() + (-1)) ? "" : str.substring(iIndexOf + 1);
    }

    private String tg(String str) {
        String str2;
        String strGa = ga(str);
        if (strGa.isEmpty()) {
            return null;
        }
        e();
        Map<String, String> map = this.e;
        if (map == null || map.isEmpty()) {
            return null;
        }
        do {
            str2 = this.e.get(strGa);
            if (str2 == null) {
                strGa = ga(strGa);
            }
            if (str2 != null) {
                break;
            }
        } while (!strGa.isEmpty());
        return str2;
    }

    private void vn(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return;
        }
        if (strTrim.charAt(0) == '#') {
            return;
        }
        String strReplaceAll = strTrim.replaceAll("\\s*#.*", "");
        if (strReplaceAll.indexOf(61) <= 0) {
            String[] strArrSplit = strReplaceAll.split("\\s+");
            for (int i = 1; i < strArrSplit.length; i++) {
                e(strArrSplit[i], strArrSplit[0]);
            }
            return;
        }
        Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(strReplaceAll);
        if (matcher.find()) {
            String strSubstring = matcher.group().substring(5);
            if (strSubstring.charAt(0) == '\"') {
                strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
            }
            Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(strReplaceAll);
            if (matcher2.find()) {
                String strSubstring2 = matcher2.group().substring(5);
                if (strSubstring2.charAt(0) == '\"') {
                    strSubstring2 = strSubstring2.substring(1, strSubstring2.length() - 1);
                }
                for (String str2 : strSubstring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                    e(str2, strSubstring);
                }
            }
        }
    }

    public static String e(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("http") && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith("/")) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return e(context).e(str);
    }

    public static bh e(Context context) {
        if (d == null) {
            synchronized (bh.class) {
                if (d == null) {
                    d = new bh(context);
                }
            }
        }
        return d;
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTg = tg(str);
        if (TextUtils.isEmpty(strTg)) {
            return null;
        }
        return bf(strTg);
    }

    private static boolean e(char c) {
        return c > ' ' && c < 127 && "()<>@,;:/[]?=\\\"".indexOf(c) < 0;
    }

    private void e() {
        if (this.tg == null || this.bf) {
            return;
        }
        synchronized (this) {
            if (!this.bf) {
                List list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>() { // from class: com.bytedance.sdk.component.utils.bh.1
                    @Override // java.security.PrivilegedAction
                    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                    public List<String> run() {
                        BufferedReader bufferedReader;
                        InputStream inputStream = null;
                        try {
                            ArrayList arrayList = new ArrayList();
                            InputStream inputStreamOpen = bh.this.tg.getAssets().open("tt_mime_type.pro");
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
                                while (true) {
                                    try {
                                        String line = bufferedReader.readLine();
                                        if (line == null) {
                                            break;
                                        }
                                        if (!TextUtils.isEmpty(line)) {
                                            arrayList.add(line);
                                        }
                                    } catch (Throwable unused) {
                                        inputStream = inputStreamOpen;
                                        try {
                                            List<String> listEmptyList = Collections.emptyList();
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable unused3) {
                                                }
                                            }
                                            return listEmptyList;
                                        } finally {
                                        }
                                    }
                                }
                                if (inputStreamOpen != null) {
                                    try {
                                        inputStreamOpen.close();
                                    } catch (Throwable unused4) {
                                    }
                                }
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused5) {
                                }
                                return arrayList;
                            } catch (Throwable unused6) {
                                bufferedReader = null;
                            }
                        } catch (Throwable unused7) {
                            bufferedReader = null;
                        }
                    }
                });
                this.e = new HashMap(list.size());
                String strSubstring = "";
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = strSubstring + ((String) it.next());
                    if (str.endsWith("\\")) {
                        strSubstring = str.substring(0, str.length() - 1);
                    } else {
                        vn(str);
                        strSubstring = "";
                    }
                }
                if (!strSubstring.isEmpty()) {
                    vn(strSubstring);
                }
                this.bf = true;
            }
        }
    }

    private void e(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || this.e.containsKey(str)) {
            return;
        }
        this.e.put(str, str2);
    }
}
