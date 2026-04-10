package com.bumptech.glide.load.resource.bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ExifInterfaceImageHeaderParser.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(27)
public final class o implements ImageHeaderParser {
    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull InputStream inputStream, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException {
        int attributeInt = new ExifInterface(inputStream).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 0) {
            return -1;
        }
        return attributeInt;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @NonNull
    public ImageHeaderParser.ImageType getType(@NonNull ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(@NonNull ByteBuffer byteBuffer, @NonNull com.bumptech.glide.load.engine.x.b bVar) throws IOException {
        return a(com.bumptech.glide.util.a.d(byteBuffer), bVar);
    }
}
