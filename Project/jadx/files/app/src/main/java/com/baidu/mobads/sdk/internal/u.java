package com.baidu.mobads.sdk.internal;

import java.util.Observer;

/* JADX INFO: loaded from: classes2.dex */
public interface u {

    public enum a {
        NONE(-1, "未开始"),
        INITING(0, "下载准备中"),
        DOWNLOADING(1, "正在下载"),
        CANCELLED(2, "已取消下载"),
        COMPLETED(3, "下载完成"),
        ERROR(4, "下载失败"),
        COMPLETE_BUT_FILE_REMOVED(5, "下载完但文件异常"),
        PAUSED(6, "已暂停下载");


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f13176i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f13177j;

        a(int i2, String str) {
            this.f13176i = i2;
            this.f13177j = str;
        }

        public int b() {
            return this.f13176i;
        }

        public String c() {
            return this.f13177j;
        }
    }

    void a();

    void a(boolean z2);

    void addObserver(Observer observer);

    void b();

    void c();

    void d();

    String e();

    String f();

    String g();

    String h();

    String i();

    int j();

    float k();

    a l();

    void m();

    boolean n();
}
