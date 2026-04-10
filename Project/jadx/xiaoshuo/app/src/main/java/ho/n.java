package ho;

/* JADX INFO: loaded from: classes8.dex */
public final class n {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21118a;

        static {
            int[] iArr = new int[b.values().length];
            f21118a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21118a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21118a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum b {
        APP_INTENT,
        /* JADX INFO: Fake field, exist only in values array */
        FILE,
        BROWSER
    }

    public static int a(b bVar) {
        int i = a.f21118a[bVar.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? -1 : 2;
        }
        return 1;
    }
}
