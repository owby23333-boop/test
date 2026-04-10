package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamAssetPathFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends b<InputStream> {
    public m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.b
    public InputStream a(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.load.data.b
    public void a(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
