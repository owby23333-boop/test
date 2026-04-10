package com.xiaomi.accounts;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.xiaomi.accounts.IAccountManagerResponse;
import com.xiaomi.accountsdk.utils.AccountLogger;

/* JADX INFO: loaded from: classes5.dex */
public class AccountManagerResponse implements Parcelable {
    public static final Parcelable.Creator<AccountManagerResponse> CREATOR = new Parcelable.Creator<AccountManagerResponse>() { // from class: com.xiaomi.accounts.AccountManagerResponse.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountManagerResponse createFromParcel(Parcel parcel) {
            return new AccountManagerResponse(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountManagerResponse[] newArray(int i) {
            return new AccountManagerResponse[i];
        }
    };
    private static final String TAG = "AccountAuthenticator";
    private IAccountManagerResponse mAccountAuthenticatorResponse;

    public AccountManagerResponse(IAccountManagerResponse iAccountManagerResponse) {
        this.mAccountAuthenticatorResponse = iAccountManagerResponse;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void onError(int i, String str) {
        AccountLogger.log(TAG, "AccountAuthenticatorResponse.onError: " + i + ", " + str);
        try {
            this.mAccountAuthenticatorResponse.onError(i, str);
        } catch (RemoteException unused) {
        }
    }

    public void onRequestContinued() {
        AccountLogger.log(TAG, "AccountAuthenticatorResponse.onRequestContinued");
        try {
            this.mAccountAuthenticatorResponse.onRequestContinued();
        } catch (RemoteException unused) {
        }
    }

    public void onResult(Bundle bundle) {
        bundle.keySet();
        AccountLogger.log(TAG, "AccountAuthenticatorResponse.onResult");
        try {
            this.mAccountAuthenticatorResponse.onResult(bundle);
        } catch (RemoteException unused) {
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.mAccountAuthenticatorResponse.asBinder());
    }

    public AccountManagerResponse(Parcel parcel) {
        this.mAccountAuthenticatorResponse = IAccountManagerResponse.Stub.asInterface(parcel.readStrongBinder());
    }
}
