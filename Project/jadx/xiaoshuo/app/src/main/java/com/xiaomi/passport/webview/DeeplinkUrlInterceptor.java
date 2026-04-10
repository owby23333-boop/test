package com.xiaomi.passport.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.accountsdk.utils.AccountLogger;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes8.dex */
public class DeeplinkUrlInterceptor implements UrlInterceptor {
    public static final Parcelable.Creator<DeeplinkUrlInterceptor> CREATOR = new Parcelable.Creator<DeeplinkUrlInterceptor>() { // from class: com.xiaomi.passport.webview.DeeplinkUrlInterceptor.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeeplinkUrlInterceptor createFromParcel(Parcel parcel) {
            return new DeeplinkUrlInterceptor(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeeplinkUrlInterceptor[] newArray(int i) {
            return new DeeplinkUrlInterceptor[i];
        }
    };
    public static final String TAG = "DeeplinkUrlInterceptor";

    public DeeplinkUrlInterceptor() {
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
        if (!TextUtils.isEmpty(str) && !str.startsWith("http:") && !str.startsWith("https:")) {
            try {
                Intent uri = Intent.parseUri(str, 1);
                if (str.startsWith("smsto") || str.startsWith("tel") || str.startsWith("mailto")) {
                    uri.addFlags(268435456);
                }
                uri.setComponent(null);
                uri.setSelector(null);
                uri.addCategory("android.intent.category.BROWSABLE");
                try {
                    context.startActivity(uri);
                    return true;
                } catch (Exception e) {
                    AccountLogger.log("WebViewWithState", "Exception " + e.getLocalizedMessage());
                    return false;
                }
            } catch (URISyntaxException e2) {
                AccountLogger.log("WebViewWithState", "URISyntaxException " + e2.getLocalizedMessage());
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public DeeplinkUrlInterceptor(Parcel parcel) {
    }
}
