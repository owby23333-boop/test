package anetwork.channel.entity;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.aidl.d;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
final class a implements Parcelable.Creator<BodyHandlerEntry> {
    a() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BodyHandlerEntry createFromParcel(Parcel parcel) {
        BodyHandlerEntry bodyHandlerEntry = new BodyHandlerEntry(null);
        bodyHandlerEntry.f570s = d.a.a(parcel.readStrongBinder());
        return bodyHandlerEntry;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BodyHandlerEntry[] newArray(int i2) {
        return new BodyHandlerEntry[i2];
    }
}
