package com.google.android.play.core.splitcompat;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes7.dex */
final class h implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Set f6947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ o f6948b;
    private final /* synthetic */ ZipFile c;

    public h(Set set, o oVar, ZipFile zipFile) {
        this.f6947a = set;
        this.f6948b = oVar;
        this.c = zipFile;
    }

    @Override // com.google.android.play.core.splitcompat.j
    public final void a(k kVar, File file, boolean z) throws IOException {
        this.f6947a.add(file);
        if (z) {
            return;
        }
        Log.i("SplitCompat", String.format("NativeLibraryExtractor: split '%s' has native library '%s' that does not exist; extracting from '%s!%s' to '%s'", this.f6948b.a(), kVar.f6949a, this.f6948b.b().getAbsolutePath(), kVar.f6950b.getName(), file.getAbsolutePath()));
        d.b(this.c, kVar.f6950b, file);
    }
}
