package com.mibi.sdk.common.account.loader;

import android.accounts.Account;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.mibi.sdk.common.account.AccountToken;
import com.mibi.sdk.common.exception.PaymentException;

/* JADX INFO: loaded from: classes13.dex */
public class FakeAccountLoader implements AccountLoader {
    public static final Parcelable.Creator<AccountLoader> CREATOR = new Parcelable.Creator<AccountLoader>() { // from class: com.mibi.sdk.common.account.loader.FakeAccountLoader.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AccountLoader createFromParcel(Parcel parcel) {
            return new FakeAccountLoader();
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: newArray, reason: merged with bridge method [inline-methods] */
        public AccountLoader[] newArray2(int i) {
            return new FakeAccountLoader[i];
        }
    };

    public static boolean isFakeAccount(Account account) {
        if (account == null) {
            return false;
        }
        return TextUtils.equals("-1", account.name);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.mibi.sdk.common.account.loader.AccountLoader
    public AccountToken getAccountToken() {
        return new AccountToken("-1", "", "", "");
    }

    @Override // com.mibi.sdk.common.account.loader.AccountLoader
    public String getUserId() {
        return "-1";
    }

    @Override // com.mibi.sdk.common.account.loader.AccountLoader
    public boolean isAccountChanged(Context context) {
        return false;
    }

    @Override // com.mibi.sdk.common.account.loader.AccountLoader
    public void load(Context context) throws PaymentException {
    }

    @Override // com.mibi.sdk.common.account.loader.AccountLoader
    public void reload(Context context) throws PaymentException {
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }
}
