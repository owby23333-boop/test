package me.jessyan.art.c.e;

import android.content.Context;
import androidx.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import me.jessyan.art.f.g;

/* JADX INFO: compiled from: ImageLoader.java */
/* JADX INFO: loaded from: classes3.dex */
@Singleton
public final class c {

    @Nullable
    @Inject
    a a;

    @Inject
    public c() {
    }

    public <T extends b> void a(Context context, T t2) {
        g.a(this.a, "Please implement BaseImageLoaderStrategy and call GlobalConfigModule.Builder#imageLoaderStrategy(BaseImageLoaderStrategy) in the applyOptions method of ConfigModule");
        this.a.loadImage(context, t2);
    }

    @Nullable
    public a a() {
        return this.a;
    }
}
