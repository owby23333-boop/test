package me.jessyan.art.base;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import me.jessyan.art.d.f;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseService extends Service {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected CompositeDisposable f21144s;

    public abstract void a();

    protected void b() {
        CompositeDisposable compositeDisposable = this.f21144s;
        if (compositeDisposable != null) {
            compositeDisposable.clear();
        }
    }

    public boolean c() {
        return true;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (c()) {
            f.a().a(this);
        }
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (c()) {
            f.a().b(this);
        }
        b();
        this.f21144s = null;
    }
}
