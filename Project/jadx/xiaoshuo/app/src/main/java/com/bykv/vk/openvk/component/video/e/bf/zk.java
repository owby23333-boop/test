package com.bykv.vk.openvk.component.video.e.bf;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.w.a;
import com.iflytek.aikit.media.param.MscKeys;
import com.xiaomi.mipush.sdk.Constants;
import com.yuewen.gm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zk {
    public final List<bf> bf;
    public final e d;
    public final d e;

    public static final class bf {
        public final String bf;
        public final String e;

        public bf(String str, String str2) {
            this.e = str;
            this.bf = str2;
        }

        public static bf e(String str) throws tg {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                throw new tg("request header format error, header: " + str);
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1).trim();
            if (strTrim.length() != 0 && strTrim2.length() != 0) {
                return new bf(strTrim, strTrim2);
            }
            throw new tg("request header format error, header: " + str);
        }

        public String toString() {
            return "Header{name='" + this.e + "', value='" + this.bf + "'}";
        }
    }

    public static final class d {
        final String bf;
        final String d;
        final String e;

        private d(String str, String str2, String str3) {
            this.e = str;
            this.bf = str2;
            this.d = str3;
        }

        public static d e(String str) throws tg {
            int iIndexOf = str.indexOf(32);
            if (iIndexOf == -1) {
                throw new tg("request line format error, line: " + str);
            }
            int iLastIndexOf = str.lastIndexOf(32);
            if (iLastIndexOf <= iIndexOf) {
                throw new tg("request line format error, line: " + str);
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1, iLastIndexOf).trim();
            String strTrim3 = str.substring(iLastIndexOf + 1).trim();
            if (strTrim.length() != 0 && strTrim2.length() != 0 && strTrim3.length() != 0) {
                return new d(strTrim, strTrim2, strTrim3);
            }
            throw new tg("request line format error, line: " + str);
        }

        public String toString() {
            return "RequestLine{method='" + this.e + "', path='" + this.bf + "', version='" + this.d + "'}";
        }
    }

    public static final class e {
        final String bf;
        final String d;
        final int e;
        final int ga;
        final List<String> p;
        final int tg;
        final String vn;

        private e(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.e = i;
            this.bf = str;
            this.d = str2;
            this.tg = i2;
            this.ga = i3;
            this.vn = str3;
            this.p = list;
        }

        public static e e(d dVar, List<bf> list) throws tg {
            String str;
            int i;
            int i2;
            int iIndexOf = dVar.bf.indexOf("?");
            if (iIndexOf == -1) {
                throw new tg("path format error, path: " + dVar.bf);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String strDecode = null;
            String strDecode2 = null;
            int i3 = 0;
            for (String str3 : dVar.bf.substring(iIndexOf + 1).split(a.p)) {
                String[] strArrSplit = str3.split(MscKeys.KEY_VAL_SEP);
                if (strArrSplit.length == 2) {
                    if ("rk".equals(strArrSplit[0])) {
                        strDecode = Uri.decode(strArrSplit[1]);
                    } else if ("k".equals(strArrSplit[0])) {
                        strDecode2 = Uri.decode(strArrSplit[1]);
                    } else if (strArrSplit[0].startsWith("u")) {
                        arrayList.add(Uri.decode(strArrSplit[1]));
                    } else if (gm.a.f11595a.equals(strArrSplit[0]) && com.bykv.vk.openvk.component.video.e.d.e.bf(strArrSplit[1]) == 1) {
                        i3 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(strDecode) || TextUtils.isEmpty(strDecode2)) {
                throw new tg("rawKey or key is empty, path: " + dVar.bf);
            }
            if (list != null) {
                i2 = 0;
                int i4 = 0;
                for (bf bfVar : list) {
                    if (bfVar != null && "Range".equalsIgnoreCase(bfVar.e)) {
                        int iIndexOf2 = bfVar.bf.indexOf(MscKeys.KEY_VAL_SEP);
                        if (iIndexOf2 == -1) {
                            throw new tg("Range format error, Range: " + bfVar.bf);
                        }
                        if (!"bytes".equalsIgnoreCase(bfVar.bf.substring(0, iIndexOf2).trim())) {
                            throw new tg("Range format error, Range: " + bfVar.bf);
                        }
                        String strSubstring = bfVar.bf.substring(iIndexOf2 + 1);
                        if (strSubstring.contains(",")) {
                            throw new tg("Range format error, Range: " + bfVar.bf);
                        }
                        int iIndexOf3 = strSubstring.indexOf(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        if (iIndexOf3 == -1) {
                            throw new tg("Range format error, Range: " + bfVar.bf);
                        }
                        String strTrim = strSubstring.substring(0, iIndexOf3).trim();
                        String strTrim2 = strSubstring.substring(iIndexOf3 + 1).trim();
                        try {
                            if (strTrim.length() > 0) {
                                i2 = Integer.parseInt(strTrim);
                            }
                            if (strTrim2.length() > 0 && i2 > (i4 = Integer.parseInt(strTrim2))) {
                                throw new tg("Range format error, Range: " + bfVar.bf);
                            }
                            str2 = bfVar.bf;
                        } catch (NumberFormatException unused) {
                            throw new tg("Range format error, Range: " + bfVar.bf);
                        }
                    }
                }
                i = i4;
                str = str2;
            } else {
                str = null;
                i = 0;
                i2 = 0;
            }
            if (!arrayList.isEmpty()) {
                return new e(i3, strDecode, strDecode2, i2, i, str, arrayList);
            }
            throw new tg("no url found: path: " + dVar.bf);
        }

        public String toString() {
            return "Extra{flag=" + this.e + ", rawKey='" + this.bf + "', key='" + this.d + "', from=" + this.tg + ", to=" + this.ga + ", urls=" + this.p + '}';
        }
    }

    public static final class tg extends Exception {
        public tg(String str) {
            super(str);
        }
    }

    public zk(d dVar, List<bf> list, e eVar) {
        this.e = dVar;
        this.bf = list;
        this.d = eVar;
    }

    public static zk e(InputStream inputStream) throws tg, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bykv.vk.openvk.component.video.e.d.e.e));
        ArrayList arrayList = new ArrayList();
        d dVarE = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                break;
            }
            String strTrim = line.trim();
            if (dVarE == null) {
                dVarE = d.e(strTrim);
            } else {
                arrayList.add(bf.e(strTrim));
            }
        }
        if (dVarE != null) {
            return new zk(dVarE, arrayList, e.e(dVarE, arrayList));
        }
        throw new tg("request line is null");
    }

    public String toString() {
        return "Request{requestLine=" + this.e + ", headers=" + this.bf + ", extra=" + this.d + '}';
    }

    public static String e(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String strE = null;
        do {
            if (strE != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            strE = e(sb, str, str2, list);
        } while (strE.length() > 3072);
        return strE;
    }

    private static String e(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk");
        sb.append(MscKeys.KEY_VAL_SEP);
        sb.append(Uri.encode(str));
        sb.append(a.p);
        sb.append("k");
        sb.append(MscKeys.KEY_VAL_SEP);
        sb.append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(a.p);
            sb.append("u");
            sb.append(i);
            sb.append(MscKeys.KEY_VAL_SEP);
            sb.append(Uri.encode(list.get(i)));
        }
        return sb.toString();
    }
}
