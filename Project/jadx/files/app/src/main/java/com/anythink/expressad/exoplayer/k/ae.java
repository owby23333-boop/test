package com.anythink.expressad.exoplayer.k;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class ae {
    private static final int a = 4;
    private static final int b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9812c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9813d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9814e = 3;

    private ae() {
    }

    private static Uri a(Uri uri, String str) {
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.clearQuery();
        for (String str2 : uri.getQueryParameterNames()) {
            if (!str2.equals(str)) {
                Iterator<String> it = uri.getQueryParameters(str2).iterator();
                while (it.hasNext()) {
                    builderBuildUpon.appendQueryParameter(str2, it.next());
                }
            }
        }
        return builderBuildUpon.build();
    }

    private static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] iArrA = a(str2);
        if (iArrA[0] != -1) {
            sb.append(str2);
            a(sb, iArrA[1], iArrA[2]);
            return sb.toString();
        }
        int[] iArrA2 = a(str);
        if (iArrA[3] == 0) {
            sb.append((CharSequence) str, 0, iArrA2[3]);
            sb.append(str2);
            return sb.toString();
        }
        if (iArrA[2] == 0) {
            sb.append((CharSequence) str, 0, iArrA2[2]);
            sb.append(str2);
            return sb.toString();
        }
        if (iArrA[1] != 0) {
            int i2 = iArrA2[0] + 1;
            sb.append((CharSequence) str, 0, i2);
            sb.append(str2);
            return a(sb, iArrA[1] + i2, i2 + iArrA[2]);
        }
        if (str2.charAt(iArrA[1]) == '/') {
            sb.append((CharSequence) str, 0, iArrA2[1]);
            sb.append(str2);
            return a(sb, iArrA2[1], iArrA2[1] + iArrA[2]);
        }
        if (iArrA2[0] + 2 < iArrA2[1] && iArrA2[1] == iArrA2[2]) {
            sb.append((CharSequence) str, 0, iArrA2[1]);
            sb.append('/');
            sb.append(str2);
            return a(sb, iArrA2[1], iArrA2[1] + iArrA[2] + 1);
        }
        int iLastIndexOf = str.lastIndexOf(47, iArrA2[2] - 1);
        int i3 = iLastIndexOf == -1 ? iArrA2[1] : iLastIndexOf + 1;
        sb.append((CharSequence) str, 0, i3);
        sb.append(str2);
        return a(sb, iArrA2[1], i3 + iArrA[2]);
    }

    private static String a(StringBuilder sb, int i2, int i3) {
        int i4;
        int i5;
        if (i2 >= i3) {
            return sb.toString();
        }
        if (sb.charAt(i2) == '/') {
            i2++;
        }
        int iLastIndexOf = i2;
        int i6 = i3;
        while (true) {
            for (int i7 = iLastIndexOf; i7 <= i6; i7++) {
                if (i7 == i6) {
                    i4 = i7;
                } else if (sb.charAt(i7) == '/') {
                    i4 = i7 + 1;
                }
                int i8 = iLastIndexOf + 1;
                if (i7 == i8 && sb.charAt(iLastIndexOf) == '.') {
                    sb.delete(iLastIndexOf, i4);
                    i5 = i4 - iLastIndexOf;
                } else if (i7 == iLastIndexOf + 2 && sb.charAt(iLastIndexOf) == '.' && sb.charAt(i8) == '.') {
                    iLastIndexOf = sb.lastIndexOf("/", iLastIndexOf - 2) + 1;
                    int i9 = iLastIndexOf > i2 ? iLastIndexOf : i2;
                    sb.delete(i9, i4);
                    i5 = i4 - i9;
                } else {
                    iLastIndexOf = i7 + 1;
                }
                i6 -= i5;
            }
            return sb.toString();
        }
    }

    private static int[] a(String str) {
        int iIndexOf;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int iIndexOf2 = str.indexOf(35);
        if (iIndexOf2 != -1) {
            length = iIndexOf2;
        }
        int iIndexOf3 = str.indexOf(63);
        if (iIndexOf3 == -1 || iIndexOf3 > length) {
            iIndexOf3 = length;
        }
        int iIndexOf4 = str.indexOf(47);
        if (iIndexOf4 == -1 || iIndexOf4 > iIndexOf3) {
            iIndexOf4 = iIndexOf3;
        }
        int iIndexOf5 = str.indexOf(58);
        if (iIndexOf5 > iIndexOf4) {
            iIndexOf5 = -1;
        }
        int i2 = iIndexOf5 + 2;
        if (i2 < iIndexOf3 && str.charAt(iIndexOf5 + 1) == '/' && str.charAt(i2) == '/') {
            iIndexOf = str.indexOf(47, iIndexOf5 + 3);
            if (iIndexOf == -1 || iIndexOf > iIndexOf3) {
                iIndexOf = iIndexOf3;
            }
        } else {
            iIndexOf = iIndexOf5 + 1;
        }
        iArr[0] = iIndexOf5;
        iArr[1] = iIndexOf;
        iArr[2] = iIndexOf3;
        iArr[3] = length;
        return iArr;
    }

    private static Uri a(String str, String str2) {
        String strA;
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] iArrA = a(str2);
        if (iArrA[0] != -1) {
            sb.append(str2);
            a(sb, iArrA[1], iArrA[2]);
            strA = sb.toString();
        } else {
            int[] iArrA2 = a(str);
            if (iArrA[3] == 0) {
                sb.append((CharSequence) str, 0, iArrA2[3]);
                sb.append(str2);
                strA = sb.toString();
            } else if (iArrA[2] == 0) {
                sb.append((CharSequence) str, 0, iArrA2[2]);
                sb.append(str2);
                strA = sb.toString();
            } else if (iArrA[1] != 0) {
                int i2 = iArrA2[0] + 1;
                sb.append((CharSequence) str, 0, i2);
                sb.append(str2);
                strA = a(sb, iArrA[1] + i2, i2 + iArrA[2]);
            } else if (str2.charAt(iArrA[1]) == '/') {
                sb.append((CharSequence) str, 0, iArrA2[1]);
                sb.append(str2);
                strA = a(sb, iArrA2[1], iArrA2[1] + iArrA[2]);
            } else if (iArrA2[0] + 2 < iArrA2[1] && iArrA2[1] == iArrA2[2]) {
                sb.append((CharSequence) str, 0, iArrA2[1]);
                sb.append('/');
                sb.append(str2);
                strA = a(sb, iArrA2[1], iArrA2[1] + iArrA[2] + 1);
            } else {
                int iLastIndexOf = str.lastIndexOf(47, iArrA2[2] - 1);
                int i3 = iLastIndexOf == -1 ? iArrA2[1] : iLastIndexOf + 1;
                sb.append((CharSequence) str, 0, i3);
                sb.append(str2);
                strA = a(sb, iArrA2[1], i3 + iArrA[2]);
            }
        }
        return Uri.parse(strA);
    }
}
