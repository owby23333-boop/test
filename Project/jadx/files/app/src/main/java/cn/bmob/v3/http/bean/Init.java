package cn.bmob.v3.http.bean;

/* JADX INFO: loaded from: classes.dex */
public class Init {
    private String api;
    private String file;

    /* JADX INFO: renamed from: io, reason: collision with root package name */
    private String f2164io;
    private boolean isUp;
    private Migration migration;
    private String other;
    private String push;
    private long timestamp;
    private int upyunVer;

    public String getApi() {
        return this.api;
    }

    public String getFile() {
        return this.file;
    }

    public String getIo() {
        return this.f2164io;
    }

    public Migration getMigration() {
        return this.migration;
    }

    public String getOther() {
        return this.other;
    }

    public String getPush() {
        return this.push;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getUpyunVer() {
        return this.upyunVer;
    }

    public boolean isUp() {
        return this.isUp;
    }

    public void setApi(String str) {
        this.api = str;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setIo(String str) {
        this.f2164io = str;
    }

    public void setMigration(Migration migration) {
        this.migration = migration;
    }

    public void setOther(String str) {
        this.other = str;
    }

    public void setPush(String str) {
        this.push = str;
    }

    public void setTimestamp(long j2) {
        this.timestamp = j2;
    }

    public void setUp(boolean z2) {
        this.isUp = z2;
    }

    public void setUpyunVer(int i2) {
        this.upyunVer = i2;
    }
}
