package com.google.android.material.internal;

import android.os.Build;
import androidx.annotation.RestrictTo;
import java.util.Locale;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: ManufacturerUtils.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class d {
    public static boolean a() {
        return b() || d();
    }

    public static boolean b() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("lge");
    }

    public static boolean c() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU);
    }

    public static boolean d() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("samsung");
    }
}
