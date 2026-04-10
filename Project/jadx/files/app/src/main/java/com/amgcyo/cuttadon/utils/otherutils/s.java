package com.amgcyo.cuttadon.utils.otherutils;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import com.ss.android.downloadlib.constants.EventConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KotlinNetworkUtil.kt */
/* JADX INFO: loaded from: classes.dex */
public final class s {
    @Nullable
    public static final Uri a(@NotNull Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", "/IMG_" + System.currentTimeMillis() + ".jpg");
        contentValues.put("relative_path", "DCIM/Pictures");
        contentValues.put(EventConstants.ExtraJson.MIME_TYPE, "image/JPEG");
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }
}
