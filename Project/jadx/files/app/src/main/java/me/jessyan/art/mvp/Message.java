package me.jessyan.art.mvp;

import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class Message implements Parcelable {
    private static Message G;
    private static int H;
    public int A = -1;
    int B;
    Bundle C;
    e D;
    Message E;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f21197s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f21198t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f21199u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f21200v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f21201w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f21202x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Object[] f21203y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Messenger f21204z;
    private static final Object F = new Object();
    public static final Parcelable.Creator<Message> CREATOR = new a();

    class a implements Parcelable.Creator<Message> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        public Message createFromParcel(Parcel parcel) {
            Message messageD = Message.d();
            messageD.a(parcel);
            return messageD;
        }

        @Override // android.os.Parcelable.Creator
        public Message[] newArray(int i2) {
            return new Message[i2];
        }
    }

    public static Message d() {
        synchronized (F) {
            if (G == null) {
                return new Message();
            }
            Message message = G;
            G = message.E;
            message.E = null;
            message.B = 0;
            H--;
            return message;
        }
    }

    public void b() {
        e eVar = this.D;
        if (eVar == null) {
            throw new IllegalArgumentException("target is null");
        }
        eVar.handleMessage(this);
        c();
    }

    void c() {
        this.f21197s = 0;
        this.f21198t = 0;
        this.f21199u = 0;
        this.f21202x = null;
        this.f21203y = null;
        this.f21200v = null;
        this.f21201w = null;
        this.f21204z = null;
        this.A = -1;
        this.D = null;
        this.C = null;
        synchronized (F) {
            if (H < 50) {
                this.E = G;
                G = this;
                H++;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (this.D != null) {
            sb.append(" what=");
            sb.append(this.f21197s);
            if (!TextUtils.isEmpty(this.f21201w)) {
                sb.append(" presenter=");
                sb.append(this.f21201w);
            }
            if (!TextUtils.isEmpty(this.f21200v)) {
                sb.append(" str=");
                sb.append(this.f21200v);
            }
            if (this.f21198t != 0) {
                sb.append(" arg1=");
                sb.append(this.f21198t);
            }
            if (this.f21199u != 0) {
                sb.append(" arg2=");
                sb.append(this.f21199u);
            }
            if (this.f21202x != null) {
                sb.append(" obj=");
                sb.append(this.f21202x);
            }
            sb.append(" target=");
            sb.append(this.D.getClass().getName());
        } else {
            sb.append(" barrier=");
            sb.append(this.f21198t);
        }
        sb.append(" }");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f21197s);
        parcel.writeInt(this.f21198t);
        parcel.writeInt(this.f21199u);
        parcel.writeString(this.f21200v);
        parcel.writeString(this.f21201w);
        Object obj = this.f21202x;
        if (obj != null) {
            try {
                parcel.writeInt(1);
                parcel.writeParcelable((Parcelable) obj, i2);
            } catch (ClassCastException unused) {
                throw new RuntimeException("Can't marshal non-Parcelable objects across processes.");
            }
        } else {
            parcel.writeInt(0);
        }
        Object[] objArr = this.f21203y;
        if (objArr != null) {
            try {
                parcel.writeInt(1);
                parcel.writeParcelableArray((Parcelable[]) objArr, i2);
            } catch (ClassCastException unused2) {
                throw new RuntimeException("Can't marshal non-Parcelable objects across processes.");
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeBundle(this.C);
        Messenger.writeMessengerOrNullToParcel(this.f21204z, parcel);
        parcel.writeInt(this.A);
    }

    public static Message a(e eVar, Object[] objArr) {
        Message messageD = d();
        messageD.D = eVar;
        messageD.f21203y = objArr;
        return messageD;
    }

    public e a() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Parcel parcel) {
        this.f21197s = parcel.readInt();
        this.f21198t = parcel.readInt();
        this.f21199u = parcel.readInt();
        this.f21200v = parcel.readString();
        this.f21201w = parcel.readString();
        if (parcel.readInt() != 0) {
            this.f21202x = parcel.readParcelable(Message.class.getClassLoader());
        }
        if (parcel.readInt() != 0) {
            this.f21203y = parcel.readParcelableArray(Message.class.getClassLoader());
        }
        this.C = parcel.readBundle();
        this.f21204z = Messenger.readMessengerOrNullFromParcel(parcel);
        this.A = parcel.readInt();
    }
}
