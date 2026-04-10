package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.NativeResponse;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class o implements NativeResponse.CustomizeMediaPlayer {
    private static final String a = "vstart";
    private static final String b = "vrepeatedplay";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f13155c = "vclose";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f13156d = "vreadyplay";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f13157e = "vplayfail";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f13158f = "vmute";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f13159g = "vfrozen";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f13160h = "vshow";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f13161i = "curTimeSec";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f13162j = "startTimeSec";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f13163k = "autoPlay";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f13164l = "reasonValue";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final dd f13165m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final a f13166n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f13167o = false;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f13168p = 0;

    public o(dd ddVar, a aVar) {
        this.f13165m = ddVar;
        this.f13166n = aVar;
    }

    private void a(String str, JSONObject jSONObject) {
        a aVar;
        JSONObject jSONObjectS;
        if (this.f13165m == null || (aVar = this.f13166n) == null || (jSONObjectS = aVar.S()) == null) {
            return;
        }
        try {
            jSONObjectS.put("msg", "sendVideoThirdLog");
            jSONObjectS.put("trackType", str);
            jSONObjectS.put("trackInfo", jSONObject);
            this.f13165m.a(jSONObjectS);
        } catch (Throwable th) {
            bq.a().d(th.getMessage());
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public String getVideoUrl() {
        a aVar = this.f13166n;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayError(int i2) {
        a(f13157e, a(this.f13168p, i2, this.f13167o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayFrozen(int i2) {
        a(f13159g, a(this.f13168p, i2, this.f13167o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportPlayerReady() {
        a(f13156d, a(0, 0, false, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoMuteChange(int i2, boolean z2) {
        a(f13158f, a(this.f13168p, i2, this.f13167o, z2 ? 2 : 1));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoPause(int i2, NativeResponse.VideoReason videoReason) {
        a(f13155c, a(this.f13168p, i2, this.f13167o, videoReason.getCode()));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoReplay() {
        this.f13168p = 0;
        a(b, a(0, 0, this.f13167o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoResume(int i2) {
        this.f13168p = i2;
        a(a, a(i2, i2, this.f13167o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoShow() {
        a(f13160h, a(0, 0, false, 7));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStart(boolean z2) {
        this.f13168p = 0;
        this.f13167o = z2;
        a(a, a(0, 0, this.f13167o, 0));
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.CustomizeMediaPlayer
    public void reportVideoStop(int i2, NativeResponse.VideoReason videoReason) {
        a(f13155c, a(this.f13168p, i2, this.f13167o, videoReason.getCode()));
    }

    private JSONObject a(int i2, int i3, boolean z2, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(f13162j, i2 / 1000);
            jSONObject.put(f13161i, i3 / 1000);
            jSONObject.put("autoPlay", z2);
            jSONObject.put(f13164l, i4);
        } catch (Throwable th) {
            bq.a().d(th.getMessage());
        }
        return jSONObject;
    }
}
