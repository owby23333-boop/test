package com.bytedance.sdk.openadsdk.core.iq;

import android.graphics.Color;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1150a;
    private int e;
    private String g;
    private int gc;
    private int gz;
    private int i;
    private g kb;
    private int m;
    private int pf;
    private z v;
    private g wp;
    private int z;
    private boolean dl = false;
    private String fo = "#008DEA";
    private String uy = "点击查看";

    public int z() {
        return this.z;
    }

    public void z(int i) {
        this.z = i;
    }

    public String g() {
        if (this.f1150a == 4 && !com.bytedance.sdk.openadsdk.core.uy.ls().z(com.bytedance.sdk.openadsdk.core.zw.getContext())) {
            this.g = "点击跳转至详情页或第三方应用";
        } else if (this.f1150a == 7 && !com.bytedance.sdk.openadsdk.core.uy.ls().g(com.bytedance.sdk.openadsdk.core.zw.getContext())) {
            this.g = "点击跳转至详情页或第三方应用";
        }
        return this.g;
    }

    public boolean dl() {
        return this.dl;
    }

    public void z(String str) {
        if (TextUtils.isEmpty(str)) {
            this.dl = true;
            int i = this.f1150a;
            if (i == 3) {
                this.g = "跳转至详情页或第三方应用";
                return;
            }
            if (i == 4) {
                this.g = "前往详情页或第三方应用";
                return;
            } else if (i == 5 || i == 7) {
                this.g = "前往详情页或第三方应用";
                return;
            } else {
                this.g = "点击跳转至详情页或第三方应用";
                return;
            }
        }
        this.g = str;
    }

    public int a() {
        return this.gc;
    }

    public void g(int i) {
        this.gc = i;
    }

    public int gc() {
        return this.m;
    }

    public void dl(int i) {
        this.m = i;
    }

    public int m() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public int e() {
        return this.gz;
    }

    public void gc(int i) {
        this.gz = i;
    }

    public void m(int i) {
        this.pf = i;
    }

    public int gz() {
        return this.pf;
    }

    public int fo() {
        if (this.f1150a == 4 && !com.bytedance.sdk.openadsdk.core.uy.ls().z(com.bytedance.sdk.openadsdk.core.zw.getContext())) {
            this.f1150a = 0;
        } else if (this.f1150a == 7 && !com.bytedance.sdk.openadsdk.core.uy.ls().g(com.bytedance.sdk.openadsdk.core.zw.getContext())) {
            this.f1150a = 0;
        }
        return this.f1150a;
    }

    public void e(int i) {
        this.f1150a = i;
    }

    public String uy() {
        return this.fo;
    }

    public void g(String str) {
        try {
            Color.parseColor(str);
            this.fo = str;
        } catch (Throwable unused) {
            this.fo = "#008DEA";
        }
    }

    public String kb() {
        return this.uy;
    }

    public void dl(String str) {
        if (TextUtils.isEmpty(str)) {
            int i = this.f1150a;
            if (i == 7) {
                this.uy = "扭动手机";
                return;
            } else if (i == 5) {
                this.uy = "向上滑动";
                return;
            } else {
                if (i == 4) {
                    this.uy = "摇一摇";
                    return;
                }
                return;
            }
        }
        this.uy = str;
    }

    public void z(JSONObject jSONObject) {
        this.kb = new g(jSONObject, 14);
    }

    public void g(JSONObject jSONObject) {
        this.wp = new g(jSONObject, 20);
    }

    public g wp() {
        return this.kb;
    }

    public g i() {
        return this.wp;
    }

    public void z(JSONObject jSONObject, int i) {
        this.v = new z(jSONObject, i);
    }

    public z v() {
        return this.v;
    }

    public class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1151a;
        int dl;
        int g;
        int z;

        public int z() {
            return this.z;
        }

        public int g() {
            return this.g;
        }

        public int dl() {
            return this.dl;
        }

        public int a() {
            return this.f1151a;
        }

        public JSONObject gc() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("left_margin", 30);
                jSONObject.put("right_margin", 30);
                jSONObject.put("top_margin", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
                jSONObject.put("bottom_margin", 40);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public z(JSONObject jSONObject, int i) {
            this.z = 30;
            this.g = 30;
            this.dl = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
            this.f1151a = 40;
            if (jSONObject == null) {
                if (i == 2) {
                    this.dl = 40;
                    this.f1151a = 20;
                    return;
                }
                return;
            }
            int iOptInt = jSONObject.optInt("left_margin", 30);
            this.z = iOptInt;
            if (iOptInt < 0 || iOptInt > b.this.p()) {
                this.z = 30;
            }
            int iOptInt2 = jSONObject.optInt("right_margin", 30);
            this.g = iOptInt2;
            if (iOptInt2 < 0 || iOptInt2 > b.this.p()) {
                this.g = 30;
            }
            if (i == 2) {
                int iOptInt3 = jSONObject.optInt("top_margin", 40);
                this.dl = iOptInt3;
                if (iOptInt3 < 0 || iOptInt3 > b.this.ls()) {
                    this.dl = 40;
                }
                int iOptInt4 = jSONObject.optInt("bottom_margin", 20);
                this.f1151a = iOptInt4;
                if (iOptInt4 < 0 || iOptInt4 > b.this.ls()) {
                    this.f1151a = 20;
                    return;
                }
                return;
            }
            int iOptInt5 = jSONObject.optInt("top_margin", MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS);
            this.dl = iOptInt5;
            if (iOptInt5 < 0 || iOptInt5 > b.this.ls()) {
                this.dl = MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS;
            }
            int iOptInt6 = jSONObject.optInt("bottom_margin", 40);
            this.f1151a = iOptInt6;
            if (iOptInt6 < 0 || iOptInt6 > b.this.ls()) {
                this.f1151a = 40;
            }
        }
    }

    public class g {
        int z;

        public JSONObject z() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("font_size", this.z);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public g(JSONObject jSONObject, int i) {
            this.z = 14;
            if (jSONObject == null) {
                return;
            }
            this.z = jSONObject.optInt("font_size", i);
        }

        public int g() {
            return this.z;
        }
    }

    public int pf() {
        return this.i;
    }

    public void gz(int i) {
        if (i <= 0 || i >= ls()) {
            this.i = 5;
        } else {
            this.i = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ls() {
        return com.bytedance.sdk.openadsdk.core.un.oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), com.bytedance.sdk.openadsdk.core.un.oq.gc(com.bytedance.sdk.openadsdk.core.zw.getContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int p() {
        return com.bytedance.sdk.openadsdk.core.un.oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext(), com.bytedance.sdk.openadsdk.core.un.oq.a(com.bytedance.sdk.openadsdk.core.zw.getContext()));
    }
}
