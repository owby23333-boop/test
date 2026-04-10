package com.kwad.sdk.core.e.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: loaded from: classes3.dex */
public interface d extends IInterface {

    public static final class a implements d {
        private IBinder ahq;

        public a(IBinder iBinder) {
            this.ahq = iBinder;
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.ahq;
        }

        @Override // com.kwad.sdk.core.e.a.d
        public final String getSerID(String str, String str2, String str3) {
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                parcelObtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                parcelObtain.writeString(str);
                parcelObtain.writeString(str2);
                parcelObtain.writeString(str3);
                this.ahq.transact(1, parcelObtain, parcelObtain2, 0);
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

    String getSerID(String str, String str2, String str3);
}
