package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.k;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class b<T extends k> {
    private f<T> a;
    private Handler b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f1670c = new AtomicBoolean(false);

    public b(String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.a<T> aVar, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_if122.a<T> aVar2, f.b bVar, f.a aVar3) {
        this.a = new f<>(str, aVar, aVar2, bVar, aVar3);
    }

    public void a() {
        if (this.f1670c.get()) {
            Message messageObtainMessage = this.b.obtainMessage();
            messageObtainMessage.what = 2;
            this.b.sendMessage(messageObtainMessage);
        }
    }

    public void a(@NonNull T t2) {
        if (this.f1670c.get()) {
            Message messageObtainMessage = this.b.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.obj = t2;
            this.b.sendMessage(messageObtainMessage);
        }
    }

    public void b() {
        AtomicBoolean atomicBoolean;
        synchronized (this) {
            AtomicBoolean atomicBoolean2 = this.f1670c;
            if ((atomicBoolean2 == null || !atomicBoolean2.get()) && this.a.getLooper() == null && (atomicBoolean = this.f1670c) != null && !atomicBoolean.get()) {
                this.a.start();
                this.b = new Handler(this.a.getLooper(), this.a);
                Message messageObtainMessage = this.b.obtainMessage();
                messageObtainMessage.what = 5;
                this.b.sendMessage(messageObtainMessage);
                this.f1670c.set(true);
            }
        }
    }
}
