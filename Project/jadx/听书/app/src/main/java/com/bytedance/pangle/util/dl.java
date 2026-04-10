package com.bytedance.pangle.util;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static String[] z(File file) {
        String[] strArrZ = com.bytedance.pangle.util.z.g.z(file);
        return TextUtils.isEmpty(strArrZ[0]) ? com.bytedance.pangle.util.z.z.z(file) : strArrZ;
    }
}
