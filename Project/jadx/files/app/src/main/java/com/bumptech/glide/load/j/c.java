package com.bumptech.glide.load.j;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements com.bumptech.glide.load.a<ByteBuffer> {
    @Override // com.bumptech.glide.load.a
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull com.bumptech.glide.load.f fVar) throws Throwable {
        try {
            com.bumptech.glide.util.a.a(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable("ByteBufferEncoder", 3);
            return false;
        }
    }
}
