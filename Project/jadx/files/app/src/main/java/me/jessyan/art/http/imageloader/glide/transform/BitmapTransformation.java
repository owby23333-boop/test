package me.jessyan.art.http.imageloader.glide.transform;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.x.e;
import com.bumptech.glide.load.i;
import com.bumptech.glide.util.l;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BitmapTransformation implements i<Bitmap> {
    @Override // com.bumptech.glide.load.c
    public abstract boolean equals(Object obj);

    @Override // com.bumptech.glide.load.c
    public abstract int hashCode();

    protected void setCanvasBitmapDensity(@NonNull Bitmap bitmap, @NonNull Bitmap bitmap2) {
        bitmap2.setDensity(bitmap.getDensity());
    }

    protected abstract Bitmap transform(@NonNull Context context, @NonNull e eVar, @NonNull Bitmap bitmap, int i2, int i3);

    @Override // com.bumptech.glide.load.i
    @NonNull
    public final s<Bitmap> transform(@NonNull Context context, @NonNull s<Bitmap> sVar, int i2, int i3) {
        if (!l.b(i2, i3)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i2 + " or height: " + i3 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        e eVarD = c.a(context).d();
        Bitmap bitmap = sVar.get();
        if (i2 == Integer.MIN_VALUE) {
            i2 = bitmap.getWidth();
        }
        int i4 = i2;
        if (i3 == Integer.MIN_VALUE) {
            i3 = bitmap.getHeight();
        }
        Bitmap bitmapTransform = transform(context.getApplicationContext(), eVarD, bitmap, i4, i3);
        return bitmap.equals(bitmapTransform) ? sVar : com.bumptech.glide.load.resource.bitmap.e.a(bitmapTransform, eVarD);
    }

    @Override // com.bumptech.glide.load.c
    public abstract void updateDiskCacheKey(@NonNull MessageDigest messageDigest);
}
