package com.xiaomi.onetrack.util.oaid.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes8.dex */
public interface g extends IInterface {

    public static abstract class a extends Binder implements g {

        /* JADX INFO: renamed from: com.xiaomi.onetrack.util.oaid.a.g$a$a, reason: collision with other inner class name */
        public static class C0552a implements g {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private IBinder f7731a;

            public C0552a(IBinder iBinder) {
                this.f7731a = iBinder;
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.g
            public boolean a() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f7731a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    if (parcelObtain2.readInt() != 0) {
                        return false;
                    }
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return true;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    th.printStackTrace();
                    return false;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f7731a;
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.g
            public String b() {
                String string;
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f7731a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Throwable unused) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    string = null;
                }
                parcelObtain2.recycle();
                parcelObtain.recycle();
                return string;
            }

            @Override // com.xiaomi.onetrack.util.oaid.a.g
            public boolean c() {
                return false;
            }
        }
    }

    boolean a();

    String b();

    boolean c();
}
