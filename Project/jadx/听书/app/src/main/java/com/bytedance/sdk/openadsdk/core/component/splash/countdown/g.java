package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.l;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class g implements l.z {
    private z g;
    private AtomicBoolean dl = new AtomicBoolean(true);
    protected final l z = new l(Looper.getMainLooper(), this);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f997a = 5;
    private int gc = 1;

    public interface z {
        void z();

        void z(int i);
    }

    private void dl() {
        this.z.removeMessages(1);
        this.gc = 1;
    }

    public void z() {
        dl();
    }

    public void z(boolean z2) {
        this.dl.set(z2);
        if (!this.dl.get()) {
            a();
        } else {
            gc();
        }
    }

    private void a() {
        try {
            this.z.removeMessages(1);
        } catch (Throwable unused) {
        }
    }

    private void gc() {
        try {
            this.z.sendEmptyMessage(1);
        } catch (Throwable unused) {
        }
    }

    public void g() {
        dl();
        this.z.sendEmptyMessage(1);
    }

    public void z(z zVar) {
        this.g = zVar;
    }

    public void z(int i) {
        this.f997a = i;
        dl();
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what == 1) {
            m();
        }
    }

    private void m() {
        try {
            int i = this.gc;
            if (i >= this.f997a + 1) {
                z zVar = this.g;
                if (zVar != null) {
                    zVar.z();
                    return;
                }
                return;
            }
            int i2 = i + 1;
            this.gc = i2;
            z zVar2 = this.g;
            if (zVar2 != null) {
                zVar2.z(i2);
            }
            this.z.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }
}
