package com.xiaomi.passport.ui.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.phonenum.data.AccountCertification;

/* JADX INFO: loaded from: classes8.dex */
public class PhoneAccount implements Parcelable {
    public static final Parcelable.Creator<PhoneAccount> CREATOR = new Parcelable.Creator<PhoneAccount>() { // from class: com.xiaomi.passport.ui.data.PhoneAccount.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneAccount createFromParcel(Parcel parcel) {
            return new PhoneAccount(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhoneAccount[] newArray(int i) {
            return new PhoneAccount[i];
        }
    };
    public final AccountCertification accountCertification;
    public final RegisterUserInfo registerUserInfo;

    public PhoneAccount(@NonNull AccountCertification accountCertification, @NonNull RegisterUserInfo registerUserInfo) {
        this.accountCertification = accountCertification;
        this.registerUserInfo = registerUserInfo;
    }

    public boolean canLogin() {
        return !canRegister();
    }

    public boolean canRegister() {
        return this.registerUserInfo.status == RegisterUserInfo.RegisterStatus.STATUS_NOT_REGISTERED;
    }

    public boolean canShowUserAvatar() {
        return this.registerUserInfo.status == RegisterUserInfo.RegisterStatus.STATUS_REGISTERED_NOT_RECYCLED;
    }

    public boolean canShowUserName() {
        return canShowUserAvatar();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.accountCertification, i);
        parcel.writeParcelable(this.registerUserInfo, i);
    }

    public PhoneAccount(Parcel parcel) {
        this.accountCertification = (AccountCertification) parcel.readParcelable(AccountCertification.class.getClassLoader());
        this.registerUserInfo = (RegisterUserInfo) parcel.readParcelable(RegisterUserInfo.class.getClassLoader());
    }
}
