package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bytedance.adsdk.ugeno.g.dl;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.eo;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends dl<NativeVideoView> {
    private com.bykv.vk.openvk.component.video.api.dl.dl cb;
    private z dt;
    private String k;
    private na o;
    private String wo;
    private String wx;
    private boolean yt;
    private boolean z;

    public g(Context context) {
        super(context);
        this.yt = false;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public NativeVideoView z() {
        NativeVideoView nativeVideoView = new NativeVideoView(this.g);
        nativeVideoView.z(this);
        return nativeVideoView;
    }

    private void lw() {
        if (this.z) {
            if (!TextUtils.isEmpty(this.wx)) {
                try {
                    this.o = com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(this.wx));
                    this.wx = null;
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
            na naVar = this.o;
            if (naVar == null) {
                this.o = new na();
                this.cb = new com.bykv.vk.openvk.component.video.api.dl.dl();
                return;
            }
            com.bykv.vk.openvk.component.video.api.dl.dl dlVarV = tf.v(naVar);
            this.cb = dlVarV;
            if (dlVarV == null) {
                this.cb = new com.bykv.vk.openvk.component.video.api.dl.dl();
                return;
            }
            return;
        }
        this.o = new na();
        this.cb = new com.bykv.vk.openvk.component.video.api.dl.dl();
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        lw();
        this.cb.dl(this.wo);
        this.cb.z(this.i + "x" + this.v);
        this.cb.g(this.k);
        this.o.z(this.cb);
        ((NativeVideoView) this.gc).setMaterialMeta(this.o);
        ((NativeVideoView) this.gc).setIsAutoPlay(true);
        ((NativeVideoView) this.gc).setIsQuiet(this.yt);
        ((NativeVideoView) this.gc).setVisibility(0);
        ((NativeVideoView) this.gc).setEnableAutoCheck(false);
        ((NativeVideoView) this.gc).z(this.g, 25, this.k);
        ((NativeVideoView) this.gc).z(0L, true, false);
        ((NativeVideoView) this.gc).z(this.k);
        com.bykv.vk.openvk.component.video.api.a.dl nativeVideoController = ((NativeVideoView) this.gc).getNativeVideoController();
        if (nativeVideoController != null) {
            z zVar = new z();
            this.dt = zVar;
            nativeVideoController.z(zVar);
        }
    }

    public void a(boolean z2) {
        this.yt = z2;
        if (this.gc == 0 || ((NativeVideoView) this.gc).getNativeVideoController() == null) {
            return;
        }
        ((NativeVideoView) this.gc).getNativeVideoController().g(z2);
    }

    public boolean gz() {
        if (this.gc != 0 && ((NativeVideoView) this.gc).getNativeVideoController() != null) {
            return ((NativeVideoView) this.gc).getNativeVideoController().js();
        }
        return this.yt;
    }

    public void jq() {
        z((com.bytedance.sdk.openadsdk.core.multipro.g.z) null);
    }

    public void z(com.bytedance.sdk.openadsdk.core.multipro.g.z zVar) {
        na naVar;
        if (uy() != null && (naVar = this.o) != null) {
            if (naVar.ou() == 0) {
                int iOptInt = uy().optInt("image_mode");
                this.o.ti(iOptInt);
                this.o.z(new eo(uy()));
                if (iOptInt == 166) {
                    this.o.ec(-2);
                    ((NativeVideoView) this.gc).setPlayerType(-2);
                }
            }
        } else {
            ((NativeVideoView) this.gc).setPlayerType(0);
        }
        if (zVar != null) {
            com.bykv.vk.openvk.component.video.api.a.dl nativeVideoController = ((NativeVideoView) this.gc).getNativeVideoController();
            nativeVideoController.a(zVar.f1272a);
            nativeVideoController.g(zVar.gz);
            if (zVar.z) {
                nativeVideoController.g(0L);
            } else {
                nativeVideoController.g(zVar.e);
            }
        }
        ((NativeVideoView) this.gc).a();
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(JSONObject jSONObject) {
        super.z(jSONObject);
    }

    public void sv() {
        if (this.gc != 0) {
            ((NativeVideoView) this.gc).M_();
        }
    }

    public void f() {
        if (this.gc != 0) {
            ((NativeVideoView) this.gc).gz();
            if (this.z) {
                ((NativeVideoView) this.gc).z(true, false);
            } else {
                ((NativeVideoView) this.gc).z(this.k);
            }
        }
    }

    public void yx() {
        if (this.gc != 0) {
            ((NativeVideoView) this.gc).gc();
            ((NativeVideoView) this.gc).z(this.k);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "coverSrc":
                this.k = str2;
                break;
            case "src":
                this.wo = str2;
                break;
            case "isLp":
                try {
                    this.z = Boolean.valueOf(str2).booleanValue();
                    if (this.gc != 0) {
                        ((NativeVideoView) this.gc).setLp(this.z);
                    }
                    break;
                } catch (Exception unused) {
                    return;
                }
                break;
            case "mate":
                this.wx = str2;
                break;
        }
    }

    public void z(Map<String, Object> map) {
        if (this.gc != 0) {
            ((NativeVideoView) this.gc).setExtraMap(map);
        }
    }

    public boolean qd() {
        com.bykv.vk.openvk.component.video.api.z zVarP;
        if (this.gc == 0 || ((NativeVideoView) this.gc).getNativeVideoController() == null || (zVarP = ((NativeVideoView) this.gc).getNativeVideoController().p()) == null) {
            return false;
        }
        return zVarP.i();
    }

    public boolean zx() {
        com.bykv.vk.openvk.component.video.api.z zVarP;
        if (this.gc == 0 || ((NativeVideoView) this.gc).getNativeVideoController() == null || (zVarP = ((NativeVideoView) this.gc).getNativeVideoController().p()) == null) {
            return false;
        }
        return zVarP.fo();
    }

    public void b() {
        if (zx()) {
            if (this.gc != 0) {
                ((NativeVideoView) this.gc).fv();
            }
        } else if (qd()) {
            f();
        } else {
            sv();
        }
    }

    public void gc(boolean z2) {
        if (this.gc != 0) {
            ((NativeVideoView) this.gc).setNeedNativeVideoPlayBtnVisible(z2);
        }
    }

    private class z implements dl.z {
        dl.z z;

        private z() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.a.dl.z
        public void z(long j, int i) {
            if (g.this.z) {
                if (g.this.gc != null) {
                    ((NativeVideoView) g.this.gc).setComplete(true);
                }
                if (g.this.gc != null) {
                    ((NativeVideoView) g.this.gc).z(true, true);
                }
            }
            dl.z zVar = this.z;
            if (zVar != null) {
                zVar.z(j, i);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.a.dl.z
        public void g(long j, int i) {
            dl.z zVar = this.z;
            if (zVar != null) {
                zVar.g(j, i);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.a.dl.z
        public void z() {
            dl.z zVar = this.z;
            if (zVar != null) {
                zVar.z();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.a.dl.z
        public void z(long j, long j2) {
            dl.z zVar = this.z;
            if (zVar != null) {
                zVar.z(j, j2);
            }
        }
    }
}
