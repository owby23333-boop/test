package ho;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.text.TextUtils;
import com.xiaomi.dist.handoff.sdk.HandoffSession;
import com.xiaomi.dist.handoff.sdk.callback.DeepLinkCallback;
import ho.c;

/* JADX INFO: loaded from: classes8.dex */
public interface h extends IInterface {

    public static abstract class a extends Binder implements h {
        public a() {
            attachInterface(this, "com.xiaomi.dist.handoff.ISessionHostCallback");
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            DeepLinkCallback deepLinkCallback;
            DeepLinkCallback deepLinkCallback2;
            if (i == 1598968902) {
                parcel2.writeString("com.xiaomi.dist.handoff.ISessionHostCallback");
                return true;
            }
            if (i == 1) {
                parcel.enforceInterface("com.xiaomi.dist.handoff.ISessionHostCallback");
                HandoffSession handoffSession = ((c.f) this).f21104a.get();
                String strB = e.b(handoffSession != null ? handoffSession.f7330b : null);
                j.b("HH", "getDeepLink: uri.length=", Integer.valueOf(strB.length()));
                parcel2.writeNoException();
                parcel2.writeString(strB);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface("com.xiaomi.dist.handoff.ISessionHostCallback");
                HandoffSession handoffSession2 = ((c.f) this).f21104a.get();
                String strB2 = e.b(handoffSession2 != null ? handoffSession2.c : null);
                if (TextUtils.isEmpty(strB2) || (!strB2.startsWith("http://") && !strB2.startsWith("https://"))) {
                    strB2 = "";
                }
                j.b("HH", "getAppLink: uri.length=", Integer.valueOf(strB2.length()));
                parcel2.writeNoException();
                parcel2.writeString(strB2);
                return true;
            }
            if (i == 3) {
                parcel.enforceInterface("com.xiaomi.dist.handoff.ISessionHostCallback");
                boolean zA = ((c.f) this).a();
                parcel2.writeNoException();
                parcel2.writeInt(zA ? 1 : 0);
                return true;
            }
            if (i == 4) {
                parcel.enforceInterface("com.xiaomi.dist.handoff.ISessionHostCallback");
                j.b("HH", "onSaveSessionState", (Object[]) null);
                HandoffSession handoffSession3 = ((c.f) this).f21104a.get();
                byte[] bArrOnSaveState = (handoffSession3 == null || (deepLinkCallback = handoffSession3.d) == null) ? new byte[0] : deepLinkCallback.onSaveState();
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrOnSaveState);
                return true;
            }
            if (i != 5) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface("com.xiaomi.dist.handoff.ISessionHostCallback");
            byte[] bArrCreateByteArray = parcel.createByteArray();
            j.b("HH", "onRestoreSessionState", (Object[]) null);
            HandoffSession handoffSession4 = ((c.f) this).f21104a.get();
            if (handoffSession4 != null && (deepLinkCallback2 = handoffSession4.d) != null) {
                deepLinkCallback2.onRestoreState(bArrCreateByteArray);
            }
            parcel2.writeNoException();
            return true;
        }
    }
}
