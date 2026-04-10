package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsMediaPlayer;

/* JADX INFO: loaded from: classes3.dex */
class p {
    private DexLoader a;
    private Object b;

    public p(DexLoader dexLoader, Context context) {
        this.a = null;
        this.b = null;
        this.a = dexLoader;
        this.b = this.a.newInstance("com.tencent.tbs.player.TbsMediaPlayerProxy", new Class[]{Context.class}, context);
    }

    public void a(float f2) {
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", NativeAdvancedJsUtils.f8238h, new Class[]{Float.TYPE}, Float.valueOf(f2));
    }

    public void a(int i2) {
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "subtitle", new Class[]{Integer.TYPE}, Integer.valueOf(i2));
    }

    public void a(long j2) {
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "seek", new Class[]{Long.TYPE}, Long.valueOf(j2));
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setSurfaceTexture", new Class[]{SurfaceTexture.class}, surfaceTexture);
    }

    public void a(TbsMediaPlayer.TbsMediaPlayerListener tbsMediaPlayerListener) {
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "setPlayerListener", new Class[]{Object.class}, tbsMediaPlayerListener);
    }

    public void a(String str, Bundle bundle) {
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "startPlay", new Class[]{String.class, Bundle.class}, str, bundle);
    }

    public boolean a() {
        return this.b != null;
    }

    public float b() {
        Float f2 = (Float) this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "getVolume", new Class[0], new Object[0]);
        if (f2 != null) {
            return f2.floatValue();
        }
        return 0.0f;
    }

    public void b(int i2) {
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", com.anythink.expressad.exoplayer.k.o.b, new Class[]{Integer.TYPE}, Integer.valueOf(i2));
    }

    public void c() {
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", com.anythink.expressad.foundation.d.c.cb, new Class[0], new Object[0]);
    }

    public void d() {
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", "play", new Class[0], new Object[0]);
    }

    public void e() {
        this.a.invokeMethod(this.b, "com.tencent.tbs.player.TbsMediaPlayerProxy", com.anythink.expressad.foundation.d.c.cf, new Class[0], new Object[0]);
    }
}
