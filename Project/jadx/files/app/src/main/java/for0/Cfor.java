package for0;

/* JADX INFO: renamed from: for0.for, reason: invalid class name */
/* JADX INFO: compiled from: TaskStatus.java */
/* JADX INFO: loaded from: classes3.dex */
public enum Cfor {
    SUCCESS("success"),
    NOT_FOUND_DIR("not_found_download_dir"),
    NOT_FOUND_APK("not_fount_apk"),
    UNKNOWN("unknown");


    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f20807s;

    Cfor(String str) {
        this.f20807s = str;
    }

    public String f() {
        return this.f20807s;
    }
}
