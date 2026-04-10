package com.xiaomi.passport.webview;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.passport.utils.HttpCookies;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class RemoveAllCookiesULPT implements UrlLoadPrepareTask {
    public static final Parcelable.Creator<RemoveAllCookiesULPT> CREATOR = new Parcelable.Creator<RemoveAllCookiesULPT>() { // from class: com.xiaomi.passport.webview.RemoveAllCookiesULPT.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoveAllCookiesULPT createFromParcel(Parcel parcel) {
            return new RemoveAllCookiesULPT(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RemoveAllCookiesULPT[] newArray(int i) {
            return new RemoveAllCookiesULPT[i];
        }
    };

    public RemoveAllCookiesULPT() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.xiaomi.passport.webview.UrlLoadPrepareTask
    public void execute(Context context, WeakReference<Context> weakReference, Map<String, String> map, Map<String, String> map2) {
        HttpCookies.clear();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
    }

    public RemoveAllCookiesULPT(Parcel parcel) {
    }
}
