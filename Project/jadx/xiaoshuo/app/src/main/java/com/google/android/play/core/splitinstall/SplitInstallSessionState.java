package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class SplitInstallSessionState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<Intent> f6961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6962b;
    private final int c;
    private final int d;
    private final long e;
    private final long f;
    private final List<String> g;
    private final PendingIntent h;

    private SplitInstallSessionState(int i, int i2, int i3, long j, long j2, List<String> list, PendingIntent pendingIntent, List<Intent> list2) {
        this.f6962b = i;
        this.c = i2;
        this.d = i3;
        this.e = j;
        this.f = j2;
        this.g = list;
        this.h = pendingIntent;
        this.f6961a = list2;
    }

    public final SplitInstallSessionState a(int i) {
        return new SplitInstallSessionState(this.f6962b, i, this.d, this.e, this.f, this.g, this.h, this.f6961a);
    }

    public final long bytesDownloaded() {
        return this.e;
    }

    public final int errorCode() {
        return this.d;
    }

    public final List<String> moduleNames() {
        return new ArrayList(this.g);
    }

    public final PendingIntent resolutionIntent() {
        return this.h;
    }

    public final int sessionId() {
        return this.f6962b;
    }

    public final int status() {
        return this.c;
    }

    public final String toString() {
        int i = this.f6962b;
        int i2 = this.c;
        int i3 = this.d;
        long j = this.e;
        long j2 = this.f;
        String strValueOf = String.valueOf(this.g);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 183);
        sb.append("SplitInstallSessionState{sessionId=");
        sb.append(i);
        sb.append(", status=");
        sb.append(i2);
        sb.append(", errorCode=");
        sb.append(i3);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(",totalBytesToDownload=");
        sb.append(j2);
        sb.append(",moduleNames=");
        sb.append(strValueOf);
        sb.append(com.alipay.sdk.m.y.l.d);
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f;
    }

    public static SplitInstallSessionState a(Bundle bundle) {
        return new SplitInstallSessionState(bundle.getInt("session_id"), bundle.getInt("status"), bundle.getInt("error_code"), bundle.getLong("bytes_downloaded"), bundle.getLong("total_bytes_to_download"), bundle.getStringArrayList("module_names"), (PendingIntent) bundle.getParcelable("user_confirmation_intent"), bundle.getParcelableArrayList("split_file_intents"));
    }
}
