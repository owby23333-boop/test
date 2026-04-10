package com.bykv.vk.openvk.component.video.z.z;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.z.z.z.dl;
import com.bykv.vk.openvk.component.video.z.z.z.g;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class z extends MediaDataSource {
    public static final ConcurrentHashMap<String, z> z = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f122a;
    private long dl = -2147483648L;
    private final dl g;
    private final a gc;

    public z(Context context, a aVar) {
        this.f122a = context;
        this.gc = aVar;
        this.g = new g(context, aVar);
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        return this.g.z(j, bArr, i, i2);
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.dl == -2147483648L) {
            if (this.f122a == null || TextUtils.isEmpty(this.gc.ls())) {
                return -1L;
            }
            this.dl = this.g.dl();
            com.bykv.vk.openvk.component.video.api.m.dl.z("SdkMediaDataSource", "getSize: " + this.dl);
        }
        return this.dl;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        com.bykv.vk.openvk.component.video.api.m.dl.z("SdkMediaDataSource", "close: ", this.gc.ls());
        dl dlVar = this.g;
        if (dlVar != null) {
            dlVar.g();
        }
        z.remove(this.gc.p());
    }

    public a z() {
        return this.gc;
    }

    public static z z(Context context, a aVar) {
        z zVar = new z(context, aVar);
        z.put(aVar.p(), zVar);
        return zVar;
    }
}
