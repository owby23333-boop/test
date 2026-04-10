package com.bumptech.glide.load.k.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.bumptech.glide.load.engine.s;
import java.util.List;

/* JADX INFO: compiled from: ResourceDrawableDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements com.bumptech.glide.load.g<Uri, Drawable> {
    private final Context a;

    public f(Context context) {
        this.a = context.getApplicationContext();
    }

    @DrawableRes
    private int b(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return a(context, uri);
        }
        if (pathSegments.size() == 1) {
            return a(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull Uri uri, @NonNull com.bumptech.glide.load.f fVar) {
        return uri.getScheme().equals("android.resource");
    }

    @Override // com.bumptech.glide.load.g
    @Nullable
    public s<Drawable> a(@NonNull Uri uri, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) {
        Context contextA = a(uri, uri.getAuthority());
        return e.a(b.a(this.a, contextA, b(contextA, uri)));
    }

    @NonNull
    private Context a(Uri uri, String str) {
        if (str.equals(this.a.getPackageName())) {
            return this.a;
        }
        try {
            return this.a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.a.getPackageName())) {
                return this.a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    @DrawableRes
    private int a(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, DispatchConstants.ANDROID);
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    @DrawableRes
    private int a(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }
}
