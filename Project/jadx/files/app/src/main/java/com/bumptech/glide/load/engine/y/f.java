package com.bumptech.glide.load.engine.y;

import android.content.Context;
import com.bumptech.glide.load.engine.y.d;
import java.io.File;

/* JADX INFO: compiled from: InternalCacheDiskCacheFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends d {

    /* JADX INFO: compiled from: InternalCacheDiskCacheFactory.java */
    class a implements d.a {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // com.bumptech.glide.load.engine.y.d.a
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            String str = this.b;
            return str != null ? new File(cacheDir, str) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
