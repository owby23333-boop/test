package com.bumptech.glide.load.k.g;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.s;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: StreamGifDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements com.bumptech.glide.load.g<InputStream, c> {
    private final List<ImageHeaderParser> a;
    private final com.bumptech.glide.load.g<ByteBuffer, c> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.x.b f13748c;

    public j(List<ImageHeaderParser> list, com.bumptech.glide.load.g<ByteBuffer, c> gVar, com.bumptech.glide.load.engine.x.b bVar) {
        this.a = list;
        this.b = gVar;
        this.f13748c = bVar;
    }

    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        return !((Boolean) fVar.a(i.b)).booleanValue() && com.bumptech.glide.load.b.getType(this.a, inputStream, this.f13748c) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.g
    public s<c> a(@NonNull InputStream inputStream, int i2, int i3, @NonNull com.bumptech.glide.load.f fVar) throws IOException {
        byte[] bArrA = a(inputStream);
        if (bArrA == null) {
            return null;
        }
        return this.b.a(ByteBuffer.wrap(bArrA), i2, i3, fVar);
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 != -1) {
                    byteArrayOutputStream.write(bArr, 0, i2);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            Log.isLoggable("StreamGifDecoder", 5);
            return null;
        }
    }
}
