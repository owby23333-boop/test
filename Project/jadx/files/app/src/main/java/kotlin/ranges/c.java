package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.collections.u;

/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends u {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f20972s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f20973t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f20974u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final int f20975v;

    public c(int i2, int i3, int i4) {
        this.f20975v = i4;
        this.f20972s = i3;
        boolean z2 = true;
        if (this.f20975v <= 0 ? i2 < i3 : i2 > i3) {
            z2 = false;
        }
        this.f20973t = z2;
        this.f20974u = this.f20973t ? i2 : this.f20972s;
    }

    @Override // kotlin.collections.u
    public int a() {
        int i2 = this.f20974u;
        if (i2 != this.f20972s) {
            this.f20974u = this.f20975v + i2;
        } else {
            if (!this.f20973t) {
                throw new NoSuchElementException();
            }
            this.f20973t = false;
        }
        return i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20973t;
    }
}
