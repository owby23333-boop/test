package s0;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: compiled from: AbstractC0055o_a.java */
/* JADX INFO: loaded from: classes4.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: s0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractC0055o_a.java */
    public static abstract class AbstractBinderC0596a extends Binder implements a {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final /* synthetic */ int f21697s = 0;

        /* JADX INFO: renamed from: s0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractC0055o_a.java */
        public static class C0597a implements a {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public IBinder f21698s;

            public C0597a(IBinder iBinder) {
                this.f21698s = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21698s;
            }
        }
    }
}
