package com.bumptech.glide.util.m;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: StateVerifier.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    @NonNull
    public static c b() {
        return new b();
    }

    public abstract void a();

    abstract void a(boolean z2);

    /* JADX INFO: compiled from: StateVerifier.java */
    private static class b extends c {
        private volatile boolean a;

        b() {
            super();
        }

        @Override // com.bumptech.glide.util.m.c
        public void a() {
            if (this.a) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.bumptech.glide.util.m.c
        public void a(boolean z2) {
            this.a = z2;
        }
    }

    private c() {
    }
}
