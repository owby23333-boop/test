package com.bytedance.adsdk.lottie.model.layer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.component.video.api.z;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class g extends e {
    private float fo;
    private float gz;
    private LottieAnimationView i;
    private volatile boolean kb;
    private final Runnable pf;
    private com.bykv.vk.openvk.component.video.z.a.a uy;
    private final Handler v;
    private TextureView wp;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public g(com.bytedance.adsdk.lottie.gz r3, com.bytedance.adsdk.lottie.model.layer.gz r4, final android.content.Context r5) {
        /*
            r2 = this;
            r2.<init>(r3, r4)
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2.gz = r4
            r2.fo = r4
            android.os.Handler r4 = new android.os.Handler
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            r4.<init>(r0)
            r2.v = r4
            com.bytedance.adsdk.lottie.model.layer.g$4 r4 = new com.bytedance.adsdk.lottie.model.layer.g$4
            r4.<init>()
            r2.pf = r4
            com.bytedance.adsdk.lottie.fo r4 = r2.e
            if (r4 == 0) goto La3
            if (r3 == 0) goto La3
            if (r5 == 0) goto La3
            com.bytedance.adsdk.lottie.LottieAnimationView r4 = r3.g()
            r2.i = r4
            if (r4 != 0) goto L2c
            return
        L2c:
            float r4 = com.bytedance.adsdk.lottie.gc.fo.z()
            com.bytedance.adsdk.lottie.fo r0 = r2.e
            int r0 = r0.z()
            float r0 = (float) r0
            float r0 = r0 * r4
            int r0 = (int) r0
            float r0 = (float) r0
            r2.gz = r0
            com.bytedance.adsdk.lottie.fo r0 = r2.e
            int r0 = r0.g()
            float r0 = (float) r0
            float r0 = r0 * r4
            int r4 = (int) r0
            float r4 = (float) r4
            r2.fo = r4
            com.bytedance.adsdk.lottie.tb r3 = r3.uf()
            if (r3 == 0) goto L68
            com.bytedance.adsdk.lottie.fo r4 = r2.e
            java.lang.String r4 = r4.wp()
            java.lang.String r3 = r3.z(r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L68
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: org.json.JSONException -> L64
            r4.<init>(r3)     // Catch: org.json.JSONException -> L64
            goto L69
        L64:
            r3 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r3)
        L68:
            r4 = 0
        L69:
            if (r4 == 0) goto La3
            java.lang.String r3 = "file_hash"
            java.lang.String r3 = r4.optString(r3)
            java.lang.String r0 = "video_url"
            java.lang.String r0 = r4.optString(r0)
            java.lang.String r1 = "video_duration"
            r4.optString(r1)
            java.lang.String r1 = "resolution"
            r4.optString(r1)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto La3
            android.view.TextureView r4 = new android.view.TextureView
            r4.<init>(r5)
            r2.wp = r4
            com.bytedance.adsdk.lottie.model.layer.g$1 r1 = new com.bytedance.adsdk.lottie.model.layer.g$1
            r1.<init>()
            r4.setSurfaceTextureListener(r1)
            com.bytedance.adsdk.lottie.LottieAnimationView r3 = r2.i
            com.bytedance.adsdk.lottie.model.layer.g$2 r4 = new com.bytedance.adsdk.lottie.model.layer.g$2
            r4.<init>()
            r3.addOnAttachStateChangeListener(r4)
            r2.pf()
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.lottie.model.layer.g.<init>(com.bytedance.adsdk.lottie.gz, com.bytedance.adsdk.lottie.model.layer.gz, android.content.Context):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, String str2, Context context, SurfaceTexture surfaceTexture) {
        v();
        com.bykv.vk.openvk.component.video.z.a.a aVar = new com.bykv.vk.openvk.component.video.z.a.a("uttie");
        this.uy = aVar;
        aVar.z(surfaceTexture);
        this.uy.z(new z.InterfaceC0029z() { // from class: com.bytedance.adsdk.lottie.model.layer.g.3
            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void dl(com.bykv.vk.openvk.component.video.api.z zVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void g(com.bykv.vk.openvk.component.video.api.z zVar, int i) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i, int i2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i, int i2, int i3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, long j) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, long j, long j2) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, JSONObject jSONObject, String str3) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, boolean z) {
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void g(com.bykv.vk.openvk.component.video.api.z zVar) {
                g.this.kb = true;
                zVar.dl(true);
            }

            @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
            public void z(com.bykv.vk.openvk.component.video.api.z zVar, com.bykv.vk.openvk.component.video.api.dl.g gVar) {
                com.bytedance.sdk.component.utils.wp.a("uttie-video", gVar.z() + ":" + gVar.g() + ":" + gVar.dl());
            }
        });
        com.bykv.vk.openvk.component.video.api.dl.dl dlVar = new com.bykv.vk.openvk.component.video.api.dl.dl();
        dlVar.dl(str);
        dlVar.gc(str2);
        this.uy.z(new com.bykv.vk.openvk.component.video.api.dl.a(com.bytedance.adsdk.lottie.gc.g.g(context), dlVar, null, 0, 0));
        this.uy.z(true);
        this.uy.z(true, 0L, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        if (this.uy != null) {
            if (this.kb) {
                this.uy.a();
            }
            this.uy.gc();
            this.uy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pf() {
        ViewParent parent = this.wp.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.wp);
        }
        ViewParent parent2 = this.i.getParent();
        if (parent2 instanceof ViewGroup) {
            this.wp.setTranslationX(2.1474836E9f);
            ((ViewGroup) parent2).addView(this.wp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ls() {
        this.v.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        ls();
        if (this.i != null) {
            this.v.postDelayed(this.pf, 40L);
        }
    }

    @Override // com.bytedance.adsdk.lottie.model.layer.e, com.bytedance.adsdk.lottie.model.layer.dl
    public void g(Canvas canvas, Matrix matrix, int i) {
        if (this.gz <= 0.0f || this.wp == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        z(i);
        float fGz = gz();
        z(this.wp, (int) this.gz, (int) this.fo);
        this.wp.setAlpha(fGz);
        this.wp.draw(canvas);
        canvas.restore();
    }

    private static void z(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
