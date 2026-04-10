package com.funny.audio.media_player.analysis;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnalysisResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/funny/audio/media_player/analysis/AnalysisResult;", "", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "setHeaders", "(Ljava/util/Map;)V", "success", "", "getSuccess", "()Z", "setSuccess", "(Z)V", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnalysisResult {
    private Map<String, String> headers;
    private boolean success;
    private String url = "";

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final void setSuccess(boolean z) {
        this.success = z;
    }
}
