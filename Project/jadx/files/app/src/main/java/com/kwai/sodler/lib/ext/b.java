package com.kwai.sodler.lib.ext;

import com.kwai.sodler.lib.a.a;
import com.kwai.sodler.lib.a.f;
import com.kwai.sodler.lib.h;

/* JADX INFO: loaded from: classes3.dex */
public interface b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> {

    public static class a extends C0473b<com.kwai.sodler.lib.kwai.a, com.kwai.sodler.lib.b.a> {
    }

    /* JADX INFO: renamed from: com.kwai.sodler.lib.ext.b$b, reason: collision with other inner class name */
    public static class C0473b<P extends com.kwai.sodler.lib.a.a, R extends f<P>> implements b<P, R> {
        @Override // com.kwai.sodler.lib.ext.b
        public void a(R r2) {
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void a(R r2, P p2) {
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void a(R r2, PluginError pluginError) {
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void b(R r2) {
        }

        @Override // com.kwai.sodler.lib.ext.b
        public void c(R r2) {
        }
    }

    public static class c extends C0473b<h, com.kwai.sodler.lib.b.c> {
    }

    void a(R r2);

    void a(R r2, P p2);

    void a(R r2, PluginError pluginError);

    void b(R r2);

    void c(R r2);
}
