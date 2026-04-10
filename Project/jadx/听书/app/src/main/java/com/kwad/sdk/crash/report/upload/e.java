package com.kwad.sdk.crash.report.upload;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static e aQD = new e(-11, "Please init.");
    public static e aQE = new e(-12, "error when zip_file");
    public static e aQF = new e(-13, "There is no valid network.");
    public static e aQG = new e(-14, "Token is invalid.");
    public static e aQH = new e(-15, "upload task execute frequence exceed.");
    public static e aQI = new e(-16, "process request fail.");
    public static e aQJ = new e(-17, "sever response error http code");
    public static e aQK = new e(-18, "sever response error result code");
    public static e aQL = new e(-19, "server bad response.");
    private final int aQM;
    private final String aQN;

    private e(int i, String str) {
        this.aQM = i;
        this.aQN = str;
    }

    public final String zb() {
        return this.aQN;
    }
}
