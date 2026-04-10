package com.bykv.vk.openvk.component.video.api;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.d.tg;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface e {

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.api.e$e, reason: collision with other inner class name */
    public interface InterfaceC0052e {
        void bf(e eVar);

        void bf(e eVar, int i);

        void d(e eVar);

        void e(e eVar);

        void e(e eVar, int i);

        void e(e eVar, int i, int i2);

        void e(e eVar, int i, int i2, int i3);

        void e(e eVar, long j);

        void e(e eVar, long j, long j2);

        void e(e eVar, com.bykv.vk.openvk.component.video.api.d.bf bfVar);

        void e(e eVar, JSONObject jSONObject, String str);

        void e(e eVar, boolean z);

        void ga(e eVar);

        void tg(e eVar);
    }

    void bf();

    void bf(int i);

    void bf(boolean z);

    boolean bh();

    void d();

    void e();

    void e(int i);

    void e(long j);

    void e(SurfaceTexture surfaceTexture);

    void e(SurfaceHolder surfaceHolder);

    void e(tg tgVar);

    void e(InterfaceC0052e interfaceC0052e);

    void e(boolean z);

    void e(boolean z, long j, boolean z2);

    long f();

    void ga();

    long k();

    int l();

    boolean m();

    SurfaceHolder p();

    boolean s();

    boolean t();

    void tg();

    SurfaceTexture v();

    boolean vn();

    long w();

    int wu();

    int xu();

    boolean zk();
}
