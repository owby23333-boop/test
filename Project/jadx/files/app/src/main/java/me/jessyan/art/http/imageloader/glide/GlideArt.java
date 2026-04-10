package me.jessyan.art.http.imageloader.glide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class GlideArt {
    private GlideArt() {
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    public static void enableHardwareBitmaps() {
        com.bumptech.glide.c.i();
    }

    @NonNull
    public static com.bumptech.glide.c get(@NonNull Context context) {
        return com.bumptech.glide.c.a(context);
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context) {
        return com.bumptech.glide.c.c(context);
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    @Deprecated
    public static void init(com.bumptech.glide.c cVar) {
        com.bumptech.glide.c.a(cVar);
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    public static void tearDown() {
        com.bumptech.glide.c.j();
    }

    @NonNull
    public static GlideRequests with(@NonNull Context context) {
        return (GlideRequests) com.bumptech.glide.c.e(context);
    }

    @Nullable
    public static File getPhotoCacheDir(@NonNull Context context, @NonNull String str) {
        return com.bumptech.glide.c.a(context, str);
    }

    @SuppressLint({"VisibleForTests"})
    @VisibleForTesting
    public static void init(@NonNull Context context, @NonNull com.bumptech.glide.d dVar) {
        com.bumptech.glide.c.a(context, dVar);
    }

    @NonNull
    public static GlideRequests with(@NonNull Activity activity) {
        return (GlideRequests) com.bumptech.glide.c.a(activity);
    }

    @NonNull
    public static GlideRequests with(@NonNull FragmentActivity fragmentActivity) {
        return (GlideRequests) com.bumptech.glide.c.a(fragmentActivity);
    }

    @NonNull
    public static GlideRequests with(@NonNull Fragment fragment) {
        return (GlideRequests) com.bumptech.glide.c.a(fragment);
    }

    @NonNull
    @Deprecated
    public static GlideRequests with(@NonNull android.app.Fragment fragment) {
        return (GlideRequests) com.bumptech.glide.c.a(fragment);
    }

    @NonNull
    public static GlideRequests with(@NonNull View view) {
        return (GlideRequests) com.bumptech.glide.c.a(view);
    }
}
