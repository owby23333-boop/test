package com.bykv.vk.openvk.component.video.z.g;

import android.net.Uri;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    public final z dl;
    public final List<g> g;
    public final dl z;

    public fo(dl dlVar, List<g> list, z zVar) {
        this.z = dlVar;
        this.g = list;
        this.dl = zVar;
    }

    public static fo z(InputStream inputStream) throws IOException, a {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bykv.vk.openvk.component.video.z.dl.z.z));
        ArrayList arrayList = new ArrayList();
        dl dlVarZ = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                break;
            }
            String strTrim = line.trim();
            if (dlVarZ == null) {
                dlVarZ = dl.z(strTrim);
            } else {
                arrayList.add(g.z(strTrim));
            }
        }
        if (dlVarZ == null) {
            throw new a("request line is null");
        }
        return new fo(dlVarZ, arrayList, z.z(dlVarZ, arrayList));
    }

    static final class dl {
        final String dl;
        final String g;
        final String z;

        private dl(String str, String str2, String str3) {
            this.z = str;
            this.g = str2;
            this.dl = str3;
        }

        static dl z(String str) throws a {
            int iIndexOf = str.indexOf(32);
            if (iIndexOf == -1) {
                throw new a("request line format error, line: ".concat(String.valueOf(str)));
            }
            int iLastIndexOf = str.lastIndexOf(32);
            if (iLastIndexOf <= iIndexOf) {
                throw new a("request line format error, line: ".concat(String.valueOf(str)));
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1, iLastIndexOf).trim();
            String strTrim3 = str.substring(iLastIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0 || strTrim3.length() == 0) {
                throw new a("request line format error, line: ".concat(String.valueOf(str)));
            }
            return new dl(strTrim, strTrim2, strTrim3);
        }

        public String toString() {
            return "RequestLine{method='" + this.z + "', path='" + this.g + "', version='" + this.dl + "'}";
        }
    }

    public static final class g {
        public final String g;
        public final String z;

        public g(String str, String str2) {
            this.z = str;
            this.g = str2;
        }

        static g z(String str) throws a {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                throw new a("request header format error, header: ".concat(String.valueOf(str)));
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0) {
                throw new a("request header format error, header: ".concat(String.valueOf(str)));
            }
            return new g(strTrim, strTrim2);
        }

        public String toString() {
            return "Header{name='" + this.z + "', value='" + this.g + "'}";
        }
    }

    static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f107a;
        final String dl;
        final List<String> e;
        final String g;
        final int gc;
        final String m;
        final int z;

        private z(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.z = i;
            this.g = str;
            this.dl = str2;
            this.f107a = i2;
            this.gc = i3;
            this.m = str3;
            this.e = list;
        }

        static z z(dl dlVar, List<g> list) throws a {
            String str;
            int i;
            int i2;
            int iIndexOf = dlVar.g.indexOf("?");
            if (iIndexOf == -1) {
                throw new a("path format error, path: " + dlVar.g);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String strDecode = null;
            String strDecode2 = null;
            int i3 = 0;
            for (String str3 : dlVar.g.substring(iIndexOf + 1).split("&")) {
                String[] strArrSplit = str3.split("=");
                if (strArrSplit.length == 2) {
                    if ("rk".equals(strArrSplit[0])) {
                        strDecode = Uri.decode(strArrSplit[1]);
                    } else if (t.f1872a.equals(strArrSplit[0])) {
                        strDecode2 = Uri.decode(strArrSplit[1]);
                    } else if (strArrSplit[0].startsWith("u")) {
                        arrayList.add(Uri.decode(strArrSplit[1]));
                    } else if ("f".equals(strArrSplit[0]) && com.bykv.vk.openvk.component.video.z.dl.z.g(strArrSplit[1]) == 1) {
                        i3 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(strDecode) || TextUtils.isEmpty(strDecode2)) {
                throw new a("rawKey or key is empty, path: " + dlVar.g);
            }
            if (list != null) {
                i2 = 0;
                int i4 = 0;
                for (g gVar : list) {
                    if (gVar != null && HttpHeaders.RANGE.equalsIgnoreCase(gVar.z)) {
                        int iIndexOf2 = gVar.g.indexOf("=");
                        if (iIndexOf2 == -1) {
                            throw new a("Range format error, Range: " + gVar.g);
                        }
                        if (!"bytes".equalsIgnoreCase(gVar.g.substring(0, iIndexOf2).trim())) {
                            throw new a("Range format error, Range: " + gVar.g);
                        }
                        String strSubstring = gVar.g.substring(iIndexOf2 + 1);
                        if (strSubstring.contains(",")) {
                            throw new a("Range format error, Range: " + gVar.g);
                        }
                        int iIndexOf3 = strSubstring.indexOf("-");
                        if (iIndexOf3 == -1) {
                            throw new a("Range format error, Range: " + gVar.g);
                        }
                        String strTrim = strSubstring.substring(0, iIndexOf3).trim();
                        String strTrim2 = strSubstring.substring(iIndexOf3 + 1).trim();
                        try {
                            if (strTrim.length() > 0) {
                                i2 = Integer.parseInt(strTrim);
                            }
                            if (strTrim2.length() > 0 && i2 > (i4 = Integer.parseInt(strTrim2))) {
                                throw new a("Range format error, Range: " + gVar.g);
                            }
                            str2 = gVar.g;
                        } catch (NumberFormatException unused) {
                            throw new a("Range format error, Range: " + gVar.g);
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
            if (arrayList.isEmpty()) {
                throw new a("no url found: path: " + dlVar.g);
            }
            return new z(i3, strDecode, strDecode2, i2, i, str, arrayList);
        }

        public String toString() {
            return "Extra{flag=" + this.z + ", rawKey='" + this.g + "', key='" + this.dl + "', from=" + this.f107a + ", to=" + this.gc + ", urls=" + this.e + '}';
        }
    }

    static String z(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String strZ = null;
        do {
            if (strZ != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            strZ = z(sb, str, str2, list);
        } while (strZ.length() > 3072);
        return strZ;
    }

    private static String z(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk=").append(Uri.encode(str));
        sb.append("&k=").append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append("&u").append(i).append("=").append(Uri.encode(list.get(i)));
        }
        return sb.toString();
    }

    public String toString() {
        return "Request{requestLine=" + this.z + ", headers=" + this.g + ", extra=" + this.dl + '}';
    }

    static final class a extends Exception {
        a(String str) {
            super(str);
        }
    }
}
