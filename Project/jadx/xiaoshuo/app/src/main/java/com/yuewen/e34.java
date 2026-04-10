package com.yuewen;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class e34 {
    public static final vn1<e34> d = new vn1<>(new a());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f10481a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10482b;
    public int c;

    public class a implements kv3<e34> {
        @Override // com.yuewen.kv3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e34 get() {
            return e34.a(new JSONObject());
        }
    }

    public static e34 a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        e34 e34Var = new e34();
        e34Var.f10481a = jSONObject.optBoolean("tts_has_ad", true);
        e34Var.f10482b = jSONObject.optInt("tts_reward_video_time", 0);
        e34Var.c = jSONObject.optInt("tts_reward_value", 0);
        return e34Var;
    }

    public long b() {
        return ((long) this.c) * 60000;
    }

    public long c() {
        return ((long) this.f10482b) * 60000;
    }

    public boolean d() {
        return this.f10481a;
    }
}
