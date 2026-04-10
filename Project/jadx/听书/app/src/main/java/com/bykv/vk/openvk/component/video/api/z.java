package com.bykv.vk.openvk.component.video.api;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.dl.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface z {

    /* JADX INFO: renamed from: com.bykv.vk.openvk.component.video.api.z$z, reason: collision with other inner class name */
    public interface InterfaceC0029z {
        void dl(z zVar);

        void g(z zVar);

        void g(z zVar, int i);

        void z(z zVar);

        void z(z zVar, int i);

        void z(z zVar, int i, int i2);

        void z(z zVar, int i, int i2, int i3);

        void z(z zVar, long j);

        void z(z zVar, long j, long j2);

        void z(z zVar, com.bykv.vk.openvk.component.video.api.dl.g gVar);

        void z(z zVar, JSONObject jSONObject, String str);

        void z(z zVar, boolean z);
    }

    void a();

    void dl();

    void dl(boolean z);

    SurfaceHolder e();

    boolean fo();

    long fv();

    void g();

    void g(int i);

    void g(boolean z);

    void gc();

    SurfaceTexture gz();

    boolean i();

    long js();

    int kb();

    long ls();

    boolean m();

    int p();

    boolean pf();

    boolean uy();

    boolean v();

    int wp();

    void z();

    void z(float f);

    void z(int i);

    void z(long j);

    void z(SurfaceTexture surfaceTexture);

    void z(SurfaceHolder surfaceHolder);

    void z(a aVar);

    void z(InterfaceC0029z interfaceC0029z);

    void z(boolean z);

    void z(boolean z, long j, boolean z2);
}
