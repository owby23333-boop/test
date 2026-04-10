package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;

/* JADX INFO: compiled from: ParcelFileDescriptorBitmapDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(21)
public final class u implements com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> {
    private final l a;

    public u(l lVar) {
        this.a = lVar;
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull com.bumptech.glide.load.f fVar) {
        return a(parcelFileDescriptor) && this.a.a(parcelFileDescriptor);
    }

    private boolean a(@NonNull ParcelFileDescriptor parcelFileDescriptor) {
        return !("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER) || "HONOR".equalsIgnoreCase(Build.MANUFACTURER)) || parcelFileDescriptor.getStatSize() <= 536870912;
    }

    @Override // com.bumptech.glide.load.g
    @Nullable
    public com.bumptech.glide.load.engine.s<Bitmap> a(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return this.a.a(parcelFileDescriptor, i2, i3, fVar);
    }
}
