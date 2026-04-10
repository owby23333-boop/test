package dagger.internal;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static <T> T a(T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }

    public static <T> T a(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }
}
