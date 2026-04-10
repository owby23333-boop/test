package com.bumptech.glide.load.k.f;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.File;

/* JADX INFO: compiled from: FileDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements g<File, File> {
    @Override // com.bumptech.glide.load.g
    public boolean a(@NonNull File file, @NonNull f fVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.g
    public s<File> a(@NonNull File file, int i2, int i3, @NonNull f fVar) {
        return new b(file);
    }
}
