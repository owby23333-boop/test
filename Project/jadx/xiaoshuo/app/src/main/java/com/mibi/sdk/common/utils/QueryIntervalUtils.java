package com.mibi.sdk.common.utils;

import android.text.TextUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes13.dex */
public class QueryIntervalUtils {
    private static final String TAG = "QueryIntervalUtils";

    public static int[] getQueryInterval(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 0) {
            String[] strArrSplit = str.split(",");
            ArrayList arrayList = new ArrayList();
            for (String str2 : strArrSplit) {
                try {
                    arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                } catch (Exception e) {
                    MibiLog.d(TAG, str2, e);
                }
            }
            if (arrayList.size() > 0) {
                int[] iArr = new int[arrayList.size()];
                for (int i = 0; i < arrayList.size(); i++) {
                    iArr[i] = ((Integer) arrayList.get(i)).intValue();
                }
                return iArr;
            }
        }
        return null;
    }
}
