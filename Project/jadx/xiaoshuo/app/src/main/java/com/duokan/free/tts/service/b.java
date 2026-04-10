package com.duokan.free.tts.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.duokan.free.tts.data.CatalogItem;
import com.duokan.free.tts.data.DkDataSource;
import com.duokan.free.tts.data.TTSIndex;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public interface b {

    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3716a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f3717b = 1;
        public static final int c = 2;

        void a(@NonNull Exception exc);

        void b(@NonNull CatalogItem catalogItem, int i);

        default void c() {
        }
    }

    /* JADX INFO: renamed from: com.duokan.free.tts.service.b$b, reason: collision with other inner class name */
    public interface InterfaceC0243b {
        public static final int d0 = 1;
        public static final int e0 = 2;
        public static final int f0 = 3;

        void a(@NonNull Exception exc);

        void c(List<CatalogItem> list, int i);
    }

    @Nullable
    CatalogItem a();

    @Nullable
    String b();

    void c(@NonNull DkDataSource dkDataSource, a aVar);

    @Nullable
    JSONObject d();

    boolean e(@NonNull TTSIndex tTSIndex);

    void f(@NonNull DkDataSource dkDataSource, a aVar);

    void g(boolean z, @NonNull InterfaceC0243b interfaceC0243b);

    void h(@NonNull DkDataSource dkDataSource, boolean z, @NonNull InterfaceC0243b interfaceC0243b);

    void i(@NonNull a aVar);

    void j(@NonNull DkDataSource dkDataSource, boolean z, @NonNull InterfaceC0243b interfaceC0243b);

    void k(@NonNull a aVar);

    void l(boolean z, @NonNull InterfaceC0243b interfaceC0243b);

    @Nullable
    CatalogItem o();

    void release();
}
