package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: AnimatorDurationScaleProvider.java */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {
    private static float a = 1.0f;

    public float a(@NonNull ContentResolver contentResolver) {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 17 ? Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) : i2 == 16 ? Settings.System.getFloat(contentResolver, "animator_duration_scale", 1.0f) : a;
    }
}
