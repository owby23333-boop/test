package com.xiaomi.onetrack.util.oaid.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.alipay.sdk.m.p0.a;

/* JADX INFO: loaded from: classes8.dex */
public interface f extends IInterface {

    public static class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private IBinder f7730a;

        public a(IBinder iBinder) {
            this.f7730a = iBinder;
        }

        @Override // com.xiaomi.onetrack.util.oaid.a.f
        public String a() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken(a.AbstractBinderC0033a.f1903a);
                this.f7730a.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                string = parcelObtain2.readString();
            } catch (Throwable th) {
                parcelObtain2.recycle();
                parcelObtain.recycle();
                th.printStackTrace();
                string = null;
            }
            parcelObtain2.recycle();
            parcelObtain.recycle();
            return string;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.f7730a;
        }
    }

    public static abstract class b extends Binder implements f {
        public b() {
            attachInterface(this, a.AbstractBinderC0033a.f1903a);
        }

        public f a(IBinder iBinder) {
            if (iBinder == null || iBinder.queryLocalInterface(a.AbstractBinderC0033a.f1903a) == null) {
                return null;
            }
            return new a(iBinder);
        }
    }

    String a();
}
