package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.ITTProvider;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.l.z;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class TTMultiProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (z() != null) {
            return z().query(uri, strArr, str, strArr2, str2);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return z() != null ? z().getType(uri) : "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        if (z() != null) {
            return z().insert(uri, contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (z() != null) {
            return z().delete(uri, str, strArr);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (z() != null) {
            return z().update(uri, contentValues, str, strArr);
        }
        return 0;
    }

    private ITTProvider z() {
        if (TTAdSdk.getAdManager() == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("proto2_ittprovider", true);
        return new z(TTAdSdk.getAdManager().getExtra(Function.class, bundle));
    }
}
