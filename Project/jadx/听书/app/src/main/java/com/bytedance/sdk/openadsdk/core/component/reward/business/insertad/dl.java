package com.bytedance.sdk.openadsdk.core.component.reward.business.insertad;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f935a;
    int dl;
    JSONArray e;
    String fo;
    int g;
    boolean gc;
    boolean gz;
    private boolean kb;
    boolean m;
    int uy;
    String z;

    private dl(String str, int i, int i2, int i3, boolean z2, JSONArray jSONArray, boolean z3, com.bytedance.sdk.openadsdk.core.component.reward.business.g.z zVar, int i4, boolean z4) {
        this.z = str;
        this.g = i;
        this.dl = i2;
        this.f935a = i3;
        this.gc = z2;
        this.e = jSONArray;
        this.gz = z3;
        this.fo = zVar.gz();
        this.uy = i4;
        this.kb = z4;
    }

    public String z() {
        return this.z;
    }

    public int g() {
        return this.g;
    }

    public int dl() {
        return this.dl;
    }

    public boolean a() {
        return this.gc;
    }

    public boolean gc() {
        return this.gz;
    }

    public String m() {
        return this.fo;
    }

    public int e() {
        return this.uy;
    }

    public Map<Integer, Boolean> gz() {
        HashMap map = new HashMap();
        for (int i = 0; i < this.e.length(); i++) {
            try {
                map.put((Integer) this.e.get(i), Boolean.TRUE);
            } catch (Exception unused) {
            }
        }
        return map;
    }

    public dl(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.z = jSONObject.optString("meta_md5");
            this.g = jSONObject.optInt("consume_time");
            this.dl = jSONObject.optInt("reduce_time");
            this.gc = jSONObject.optBoolean("is_video_completed");
            this.e = jSONObject.optJSONArray("reward_verify_array");
            this.gz = jSONObject.optBoolean("is_mute");
            this.fo = jSONObject.optString("play_again_string");
            this.uy = jSONObject.optInt("carousel_type");
            this.f935a = jSONObject.optInt("eternal_global_time");
            this.kb = jSONObject.optBoolean("first_ad_is_video");
        } catch (Exception unused) {
        }
    }

    public JSONObject fo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("meta_md5", this.z);
            jSONObject.put("consume_time", this.g);
            jSONObject.put("reduce_time", this.dl);
            jSONObject.put("is_video_completed", this.gc);
            jSONObject.put("is_user_interacted", this.m);
            jSONObject.put("reward_verify_array", this.e);
            jSONObject.put("is_mute", this.gz);
            jSONObject.put("play_again_string", this.fo);
            jSONObject.put("carousel_type", this.uy);
            jSONObject.put("eternal_global_time", this.f935a);
            jSONObject.put("first_ad_is_video", this.kb);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int uy() {
        return this.f935a;
    }

    public boolean kb() {
        return this.kb;
    }

    public static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f936a;
        int dl;
        int e;
        boolean fo;
        int g;
        JSONArray gc;
        int gz;
        boolean m;
        com.bytedance.sdk.openadsdk.core.component.reward.business.g.z uy;
        String z;

        public dl z() {
            return new dl(this.z, this.g, this.dl, this.gz, this.f936a, this.gc, this.m, this.uy, this.e, this.fo);
        }

        public z z(String str) {
            this.z = str;
            return this;
        }

        public z z(int i) {
            this.g = i;
            return this;
        }

        public z g(int i) {
            this.dl = i;
            return this;
        }

        public z z(boolean z) {
            this.f936a = z;
            return this;
        }

        public z z(Set<Integer> set) {
            this.gc = new JSONArray((Collection) set);
            return this;
        }

        public z g(boolean z) {
            this.m = z;
            return this;
        }

        public z z(com.bytedance.sdk.openadsdk.core.component.reward.business.g.z zVar) {
            this.uy = zVar;
            return this;
        }

        public z dl(int i) {
            this.e = i;
            return this;
        }

        public z a(int i) {
            this.gz = i;
            return this;
        }

        public z dl(boolean z) {
            this.fo = z;
            return this;
        }
    }
}
