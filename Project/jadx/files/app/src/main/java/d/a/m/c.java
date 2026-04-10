package d.a.m;

import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static final CopyOnWriteArrayList<b> a = new CopyOnWriteArrayList<>();

    public static b a(int i2) {
        return a.get(i2);
    }

    public static int a() {
        return a.size();
    }
}
