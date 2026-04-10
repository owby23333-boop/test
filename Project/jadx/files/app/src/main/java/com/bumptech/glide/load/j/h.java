package com.bumptech.glide.load.j;

import com.bumptech.glide.load.j.j;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: Headers.java */
/* JADX INFO: loaded from: classes2.dex */
public interface h {
    public static final h a;

    /* JADX INFO: compiled from: Headers.java */
    class a implements h {
        a() {
        }

        @Override // com.bumptech.glide.load.j.h
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    static {
        new a();
        a = new j.a().a();
    }

    Map<String, String> getHeaders();
}
