package anet.channel.strategy;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private final ConcurrentHashMap<String, String> a = new ConcurrentHashMap<>();
    private boolean b = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Taobao */
    public static class a {
        public static c a = new c();

        private a() {
        }
    }

    public void a(boolean z2) {
        this.b = z2;
    }

    public void b(String str) {
        this.a.put(str, "http");
    }

    public String a(String str) {
        if (!this.b) {
            return null;
        }
        String str2 = this.a.get(str);
        if (str2 != null) {
            return str2;
        }
        this.a.put(str, "https");
        return "https";
    }
}
