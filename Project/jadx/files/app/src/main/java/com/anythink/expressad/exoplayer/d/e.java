package com.anythink.expressad.exoplayer.d;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.k.af;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Parcelable, Comparator<a> {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.anythink.expressad.exoplayer.d.e.1
        private static e a(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ e[] newArray(int i2) {
            return new e[i2];
        }

        private static e[] a(int i2) {
            return new e[i2];
        }
    };

    @Nullable
    public final String a;
    public final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a[] f8811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8812d;

    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.expressad.exoplayer.d.e.a.1
            private static a a(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ a[] newArray(int i2) {
                return new a[i2];
            }

            private static a[] a(int i2) {
                return new a[i2];
            }
        };

        @Nullable
        public final String a;
        public final String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f8813c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f8814d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f8815e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final UUID f8816f;

        public a(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, (byte) 0);
        }

        private boolean b(a aVar) {
            return a() && !aVar.a() && a(aVar.f8816f);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final boolean equals(@Nullable Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            a aVar = (a) obj;
            return af.a((Object) this.a, (Object) aVar.a) && af.a((Object) this.b, (Object) aVar.b) && af.a(this.f8816f, aVar.f8816f) && Arrays.equals(this.f8813c, aVar.f8813c);
        }

        public final int hashCode() {
            if (this.f8815e == 0) {
                int iHashCode = this.f8816f.hashCode() * 31;
                String str = this.a;
                this.f8815e = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.b.hashCode()) * 31) + Arrays.hashCode(this.f8813c);
            }
            return this.f8815e;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f8816f.getMostSignificantBits());
            parcel.writeLong(this.f8816f.getLeastSignificantBits());
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeByteArray(this.f8813c);
            parcel.writeByte(this.f8814d ? (byte) 1 : (byte) 0);
        }

        private a(UUID uuid, String str, byte[] bArr, byte b) {
            this(uuid, (String) null, str, bArr);
        }

        public final boolean a(UUID uuid) {
            return com.anythink.expressad.exoplayer.b.bh.equals(this.f8816f) || uuid.equals(this.f8816f);
        }

        private a(UUID uuid, @Nullable String str, String str2, byte[] bArr) {
            this.f8816f = (UUID) com.anythink.expressad.exoplayer.k.a.a(uuid);
            this.a = str;
            this.b = (String) com.anythink.expressad.exoplayer.k.a.a(str2);
            this.f8813c = bArr;
            this.f8814d = false;
        }

        public final boolean a() {
            return this.f8813c != null;
        }

        a(Parcel parcel) {
            this.f8816f = new UUID(parcel.readLong(), parcel.readLong());
            this.a = parcel.readString();
            this.b = parcel.readString();
            this.f8813c = parcel.createByteArray();
            this.f8814d = parcel.readByte() != 0;
        }
    }

    public e(List<a> list) {
        this(null, false, (a[]) list.toArray(new a[list.size()]));
    }

    @Nullable
    public static e a(@Nullable e eVar, @Nullable e eVar2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (eVar != null) {
            str = eVar.a;
            for (a aVar : eVar.f8811c) {
                if (aVar.a()) {
                    arrayList.add(aVar);
                }
            }
        } else {
            str = null;
        }
        if (eVar2 != null) {
            if (str == null) {
                str = eVar2.a;
            }
            int size = arrayList.size();
            for (a aVar2 : eVar2.f8811c) {
                if (aVar2.a() && !a(arrayList, size, aVar2.f8816f)) {
                    arrayList.add(aVar2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new e(str, arrayList);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(a aVar, a aVar2) {
        a aVar3 = aVar;
        a aVar4 = aVar2;
        return com.anythink.expressad.exoplayer.b.bh.equals(aVar3.f8816f) ? com.anythink.expressad.exoplayer.b.bh.equals(aVar4.f8816f) ? 0 : 1 : aVar3.f8816f.compareTo(aVar4.f8816f);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            if (af.a((Object) this.a, (Object) eVar.a) && Arrays.equals(this.f8811c, eVar.f8811c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f8812d == 0) {
            String str = this.a;
            this.f8812d = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f8811c);
        }
        return this.f8812d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeTypedArray(this.f8811c, 0);
    }

    private e(String str, List<a> list) {
        this(str, false, (a[]) list.toArray(new a[list.size()]));
    }

    private e(a... aVarArr) {
        this((String) null, aVarArr);
    }

    private e(@Nullable String str, a... aVarArr) {
        this(str, true, aVarArr);
    }

    private e(@Nullable String str, boolean z2, a... aVarArr) {
        this.a = str;
        aVarArr = z2 ? (a[]) aVarArr.clone() : aVarArr;
        Arrays.sort(aVarArr, this);
        this.f8811c = aVarArr;
        this.b = aVarArr.length;
    }

    e(Parcel parcel) {
        this.a = parcel.readString();
        this.f8811c = (a[]) parcel.createTypedArray(a.CREATOR);
        this.b = this.f8811c.length;
    }

    @Deprecated
    private a a(UUID uuid) {
        for (a aVar : this.f8811c) {
            if (aVar.a(uuid)) {
                return aVar;
            }
        }
        return null;
    }

    public final a a(int i2) {
        return this.f8811c[i2];
    }

    public final e a(@Nullable String str) {
        return af.a((Object) this.a, (Object) str) ? this : new e(str, false, this.f8811c);
    }

    private static int a(a aVar, a aVar2) {
        if (com.anythink.expressad.exoplayer.b.bh.equals(aVar.f8816f)) {
            return com.anythink.expressad.exoplayer.b.bh.equals(aVar2.f8816f) ? 0 : 1;
        }
        return aVar.f8816f.compareTo(aVar2.f8816f);
    }

    private static boolean a(ArrayList<a> arrayList, int i2, UUID uuid) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (arrayList.get(i3).f8816f.equals(uuid)) {
                return true;
            }
        }
        return false;
    }
}
