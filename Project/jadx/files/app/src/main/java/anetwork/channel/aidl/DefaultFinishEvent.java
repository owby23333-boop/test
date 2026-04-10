package anetwork.channel.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ErrorConstant;
import anetwork.channel.statist.StatisticData;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class DefaultFinishEvent implements Parcelable, d.a.e {
    public static final Parcelable.Creator<DefaultFinishEvent> CREATOR = new i();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    Object f500s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f501t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    String f502u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    StatisticData f503v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final RequestStatistic f504w;

    public DefaultFinishEvent(int i2) {
        this(i2, null, null, null);
    }

    public void a(Object obj) {
        this.f500s = obj;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // d.a.e
    public StatisticData e() {
        return this.f503v;
    }

    @Override // d.a.e
    public int f() {
        return this.f501t;
    }

    public Object getContext() {
        return this.f500s;
    }

    @Override // d.a.e
    public String getDesc() {
        return this.f502u;
    }

    public String toString() {
        return "DefaultFinishEvent [code=" + this.f501t + ", desc=" + this.f502u + ", context=" + this.f500s + ", statisticData=" + this.f503v + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f501t);
        parcel.writeString(this.f502u);
        StatisticData statisticData = this.f503v;
        if (statisticData != null) {
            parcel.writeSerializable(statisticData);
        }
    }

    public DefaultFinishEvent(int i2, String str, Request request) {
        this(i2, str, request, request != null ? request.a : null);
    }

    static DefaultFinishEvent a(Parcel parcel) {
        DefaultFinishEvent defaultFinishEvent = new DefaultFinishEvent(0);
        try {
            defaultFinishEvent.f501t = parcel.readInt();
            defaultFinishEvent.f502u = parcel.readString();
            defaultFinishEvent.f503v = (StatisticData) parcel.readSerializable();
        } catch (Throwable unused) {
        }
        return defaultFinishEvent;
    }

    private DefaultFinishEvent(int i2, String str, Request request, RequestStatistic requestStatistic) {
        this.f503v = new StatisticData();
        this.f501t = i2;
        this.f502u = str == null ? ErrorConstant.getErrMsg(i2) : str;
        this.f504w = requestStatistic;
    }
}
