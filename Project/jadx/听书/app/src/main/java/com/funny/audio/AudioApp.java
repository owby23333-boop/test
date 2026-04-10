package com.funny.audio;

import android.app.Application;
import android.content.pm.PackageManager;
import kotlin.Metadata;
import p000.hook;

/* JADX INFO: compiled from: AudioApp.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/funny/audio/AudioApp;", "Landroid/app/Application;", "()V", "onCreate", "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AudioApp extends Application {
    @Override // android.app.Application
    public void onCreate() throws PackageManager.NameNotFoundException {
        super.onCreate();
        AppManager.INSTANCE.init(this);
        hook.init();
    }
}
