package com.bumptech.glide.o;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.util.l;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: AndroidResourceSignature.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.bumptech.glide.load.c {
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.c f13806c;

    private a(int i2, com.bumptech.glide.load.c cVar) {
        this.b = i2;
        this.f13806c = cVar;
    }

    @NonNull
    public static com.bumptech.glide.load.c a(@NonNull Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.b(context));
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.b == aVar.b && this.f13806c.equals(aVar.f13806c);
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return l.a(this.f13806c, this.b);
    }

    @Override // com.bumptech.glide.load.c
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f13806c.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.b).array());
    }
}
