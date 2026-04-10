package ho;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public final class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21106b;

    @NonNull
    public String c;

    @NonNull
    public String d;

    public class a implements Parcelable.Creator<d> {
        @Override // android.os.Parcelable.Creator
        public final d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final d[] newArray(int i) {
            return new d[i];
        }
    }

    public d(int i, int i2, @NonNull String str, @NonNull String str2) {
        this.f21105a = i;
        this.f21106b = i2;
        this.c = str;
        this.d = str2;
    }

    public final void a(Parcel parcel) {
        this.f21105a = parcel.readInt();
        this.f21106b = parcel.readInt();
        this.d = parcel.readString();
        this.c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f21105a == dVar.f21105a && this.f21106b == dVar.f21106b && this.c.equals(dVar.c) && this.d.equals(dVar.d);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f21105a), Integer.valueOf(this.f21106b), this.c, this.d);
    }

    public final String toString() {
        return "HandoffSession{activityInstanceId='" + this.f21105a + "', activityTaskId='" + this.f21106b + "', packageName='" + this.d + "', activityFullName='" + this.c + "'}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f21105a);
        parcel.writeInt(this.f21106b);
        parcel.writeString(this.d);
        parcel.writeString(this.c);
    }

    public d(Parcel parcel) {
        a(parcel);
    }
}
