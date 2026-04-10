package com.sntech.net.utils;

import android.content.Context;
import com.sntech.net.utils.Cif;

/* JADX INFO: renamed from: com.sntech.net.utils.do, reason: invalid class name */
/* JADX INFO: compiled from: AppUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class Cdo {
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String m104do(Context context) {
        try {
            return Cif.C0506if.m106do(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
