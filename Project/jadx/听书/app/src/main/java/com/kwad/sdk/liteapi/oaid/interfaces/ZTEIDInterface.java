package com.kwad.sdk.liteapi.oaid.interfaces;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.kwad.sdk.liteapi.LiteApiLogger;

/* JADX INFO: loaded from: classes4.dex */
public interface ZTEIDInterface extends IInterface {
    String getOAID();

    public static final class a implements ZTEIDInterface {
        private IBinder aGc;

        public a(IBinder iBinder) {
            this.aGc = iBinder;
        }

        @Override // com.kwad.sdk.liteapi.oaid.interfaces.ZTEIDInterface
        public final String getOAID() {
            String string;
            Parcel parcelObtain = Parcel.obtain();
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                try {
                    parcelObtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.aGc.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                    string = parcelObtain2.readString();
                } catch (Exception e) {
                    LiteApiLogger.printStackTrace(e);
                    parcelObtain.recycle();
                    parcelObtain2.recycle();
                    string = null;
                }
                return string;
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.aGc;
        }
    }
}
