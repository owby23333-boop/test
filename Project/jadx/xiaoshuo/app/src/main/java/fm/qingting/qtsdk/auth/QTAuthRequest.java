package fm.qingting.qtsdk.auth;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes8.dex */
public class QTAuthRequest implements Parcelable {
    public static final Parcelable.Creator<QTAuthRequest> CREATOR = new Parcelable.Creator<QTAuthRequest>() { // from class: fm.qingting.qtsdk.auth.QTAuthRequest.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public QTAuthRequest createFromParcel(Parcel source) {
            return new QTAuthRequest(source);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public QTAuthRequest[] newArray(int size) {
            return new QTAuthRequest[size];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f21083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f21084b;

    public QTAuthRequest() {
    }

    public void a(String redirectUrl) {
        this.f21083a = redirectUrl;
    }

    public void b(String scope) {
        this.f21084b = scope;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.f21083a);
        dest.writeString(this.f21084b);
    }

    public QTAuthRequest(Parcel in) {
        this.f21083a = in.readString();
        this.f21084b = in.readString();
    }
}
