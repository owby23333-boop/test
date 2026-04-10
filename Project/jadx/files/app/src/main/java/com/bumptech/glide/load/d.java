package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.s;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: MultiTransformation.java */
/* JADX INFO: loaded from: classes2.dex */
public class d<T> implements i<T> {
    private final Collection<? extends i<T>> b;

    @SafeVarargs
    public d(@NonNull i<T>... iVarArr) {
        if (iVarArr.length == 0) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.b = Arrays.asList(iVarArr);
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.b.equals(((d) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // com.bumptech.glide.load.i
    @NonNull
    public s<T> transform(@NonNull Context context, @NonNull s<T> sVar, int i2, int i3) {
        Iterator<? extends i<T>> it = this.b.iterator();
        s<T> sVar2 = sVar;
        while (it.hasNext()) {
            s<T> sVarTransform = it.next().transform(context, sVar2, i2, i3);
            if (sVar2 != null && !sVar2.equals(sVar) && !sVar2.equals(sVarTransform)) {
                sVar2.recycle();
            }
            sVar2 = sVarTransform;
        }
        return sVar2;
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        Iterator<? extends i<T>> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().updateDiskCacheKey(messageDigest);
        }
    }
}
