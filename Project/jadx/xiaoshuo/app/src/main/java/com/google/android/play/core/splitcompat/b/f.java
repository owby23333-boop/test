package com.google.android.play.core.splitcompat.b;

import java.io.File;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
final class f implements a {
    @Override // com.google.android.play.core.splitcompat.b.a
    public final void a(ClassLoader classLoader, Set<File> set) {
        c.b(classLoader, set);
    }

    @Override // com.google.android.play.core.splitcompat.b.a
    public final boolean a(ClassLoader classLoader, File file, File file2, boolean z) {
        return c.a(classLoader, file, file2, z, new d());
    }
}
