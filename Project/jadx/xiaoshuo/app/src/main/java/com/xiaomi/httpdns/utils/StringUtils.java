package com.xiaomi.httpdns.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class StringUtils {
    @NonNull
    public static List<String> a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (IpUtils.c(str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
