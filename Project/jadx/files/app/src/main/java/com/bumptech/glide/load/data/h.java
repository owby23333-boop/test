package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: FileDescriptorAssetPathFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends b<AssetFileDescriptor> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.b
    public AssetFileDescriptor a(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.b
    public void a(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }
}
