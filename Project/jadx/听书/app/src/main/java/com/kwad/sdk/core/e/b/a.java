package com.kwad.sdk.core.e.b;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: com.kwad.sdk.core.e.b.a$a, reason: collision with other inner class name */
    public static final class C0403a implements a {
        private final IBinder aGc;

        public C0403a(IBinder iBinder) {
            this.aGc = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aGc;
        }

        public final String getID() {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                this.aGc.transact(3, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string = parcelObtain2.readString();
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return string;
            } catch (Exception unused) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                return null;
            } catch (Throwable th) {
                parcelObtain.recycle();
                parcelObtain2.recycle();
                throw th;
            }
        }
    }
}
