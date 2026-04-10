package com.bumptech.glide.load.k.g;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.engine.s;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: GifDrawableEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements com.bumptech.glide.load.h<c> {
    @Override // com.bumptech.glide.load.h
    @NonNull
    public EncodeStrategy a(@NonNull com.bumptech.glide.load.f fVar) {
        return EncodeStrategy.SOURCE;
    }

    @Override // com.bumptech.glide.load.a
    public boolean a(@NonNull s<c> sVar, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) throws Throwable {
        try {
            com.bumptech.glide.util.a.a(sVar.get().b(), file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("GifEncoder", 5);
            return false;
        }
    }
}
