package com.bytedance.msdk.z;

import android.text.TextUtils;
import com.bytedance.msdk.core.g;
import com.bytedance.msdk.gz.io;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z {
    public static String z(String str, String str2, String str3) {
        return TextUtils.isEmpty(str3) ? str2 : (TextUtils.equals(str, MediationConstant.ADN_GDT) || TextUtils.equals(str, MediationConstant.ADN_PANGLE)) ? str2 + "_" + str3 : str2;
    }

    public static String z(String str, String str2) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (TextUtils.equals(str, MediationConstant.ADN_PANGLE)) {
            String[] strArrSplit2 = str2.split("message:");
            if (strArrSplit2 != null && strArrSplit2.length > 0) {
                String str3 = strArrSplit2[0];
                if (!TextUtils.isEmpty(str3) && (strArrSplit = str3.trim().split(":")) != null && strArrSplit.length >= 2) {
                    String str4 = strArrSplit[1];
                    if (!TextUtils.isEmpty(str4)) {
                        return str4.trim();
                    }
                }
            }
            return "";
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] charArray = str2.toCharArray();
        int i = 0;
        while (true) {
            if (i >= charArray.length) {
                break;
            }
            char c = charArray[i];
            if (c >= '0' && c <= '9') {
                sb.append(c);
                if (i == charArray.length - 1) {
                    arrayList.add(sb.toString());
                    break;
                }
            } else if (sb.length() > 0) {
                arrayList.add(sb.toString());
                sb.delete(0, sb.length());
            }
            if (arrayList.size() > 0) {
                return (String) arrayList.get(0);
            }
            i++;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append("_");
        }
        if (sb2.length() > 0) {
            sb2.delete(sb2.length() - 1, sb2.length());
        }
        return sb2.toString();
    }

    public static boolean z() {
        boolean zDl = io.dl(g.getContext());
        boolean zG = io.g(g.getContext());
        if (g.g().wp()) {
            return zDl || zG;
        }
        return false;
    }
}
