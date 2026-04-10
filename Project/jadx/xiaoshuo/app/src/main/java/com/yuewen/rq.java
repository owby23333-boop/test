package com.yuewen;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes5.dex */
public class rq {
    public static String[] a(String str) {
        LinkedList linkedList = new LinkedList();
        for (String str2 : str.split(",")) {
            try {
                String[] strArrSplit = str2.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                if (strArrSplit.length == 1) {
                    linkedList.add(strArrSplit[0]);
                } else if (strArrSplit.length == 2) {
                    long jLongValue = Long.valueOf(strArrSplit[1]).longValue();
                    for (long jLongValue2 = Long.valueOf(strArrSplit[0]).longValue(); jLongValue2 <= jLongValue; jLongValue2++) {
                        linkedList.add("" + jLongValue2);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    public static String b(String... strArr) {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = Integer.valueOf(strArr[i]).intValue();
        }
        Arrays.sort(iArr);
        LinkedList<String> linkedList = new LinkedList();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 == length - 1 || iArr[i3] + 1 != iArr[i3 + 1]) {
                if (i3 == i2) {
                    linkedList.add("" + iArr[i2]);
                } else {
                    linkedList.add(iArr[i2] + Constants.ACCEPT_TIME_SEPARATOR_SERVER + iArr[i3]);
                }
                i2 = i3 + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : linkedList) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str);
        }
        return sb.toString();
    }
}
