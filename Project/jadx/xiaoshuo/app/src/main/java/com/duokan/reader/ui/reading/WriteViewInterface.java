package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public interface WriteViewInterface {

    public enum StrokeWidth {
        Light,
        Normal,
        Thick
    }

    void a();

    Bitmap b() throws IOException;

    void c(Bitmap bitmap, Bitmap bitmap2);

    void d(boolean z);

    void e(StrokeWidth strokeWidth);

    void f();

    void g();

    void h();

    boolean i();
}
