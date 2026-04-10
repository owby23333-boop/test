package kotlin.text;

/* JADX INFO: compiled from: Char.kt */
/* JADX INFO: loaded from: classes3.dex */
class c extends b {
    public static final boolean a(char c2, char c3, boolean z2) {
        if (c2 == c3) {
            return true;
        }
        if (z2) {
            return Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
        }
        return false;
    }
}
