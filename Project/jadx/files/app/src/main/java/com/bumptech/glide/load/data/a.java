package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: AssetFileDescriptorLocalUriFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends l<AssetFileDescriptor> {
    public a(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.l
    public AssetFileDescriptor a(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.l
    public void a(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }
}
