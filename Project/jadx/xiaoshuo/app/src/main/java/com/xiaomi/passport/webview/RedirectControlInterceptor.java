package com.xiaomi.passport.webview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes8.dex */
public class RedirectControlInterceptor implements UrlInterceptor {
    public static final Parcelable.Creator<RedirectControlInterceptor> CREATOR = new Parcelable.Creator<RedirectControlInterceptor>() { // from class: com.xiaomi.passport.webview.RedirectControlInterceptor.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedirectControlInterceptor createFromParcel(Parcel parcel) {
            return new RedirectControlInterceptor(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedirectControlInterceptor[] newArray(int i) {
            return new RedirectControlInterceptor[i];
        }
    };
    private static final String TAG = "RedirectControlInterceptor";
    private final UrlValidator mUrlValidator;

    public interface UrlValidator {
        boolean isUrlValid(String str);
    }

    public RedirectControlInterceptor(UrlValidator urlValidator) {
        this.mUrlValidator = urlValidator;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.xiaomi.passport.webview.UrlInterceptor
    public void release() {
    }

    @Override // com.xiaomi.passport.webview.UrlInterceptor
    public boolean shouldIntercept(Context context, String str) {
        if (this.mUrlValidator == null) {
            return false;
        }
        return !r1.isUrlValid(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
    }

    public RedirectControlInterceptor(Parcel parcel) {
        this.mUrlValidator = null;
    }
}
