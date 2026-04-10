package anet.channel.monitor;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public enum NetworkSpeed {
    Slow("弱网络", 1),
    Fast("强网络", 5);

    private final String a;
    private final int b;

    NetworkSpeed(String str, int i2) {
        this.a = str;
        this.b = i2;
    }

    public static NetworkSpeed valueOfCode(int i2) {
        return i2 == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.b;
    }

    public String getDesc() {
        return this.a;
    }
}
