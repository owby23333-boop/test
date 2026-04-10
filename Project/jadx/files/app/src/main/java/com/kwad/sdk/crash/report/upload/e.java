package com.kwad.sdk.crash.report.upload;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static e asd = new e(-11, "Please init.");
    public static e ase = new e(-12, "error when zip_file");
    public static e asf = new e(-13, "There is no valid network.");
    public static e asg = new e(-14, "Token is invalid.");
    public static e ash = new e(-15, "upload task execute frequence exceed.");
    public static e asi = new e(-16, "process request fail.");
    public static e asj = new e(-17, "sever response error http code");
    public static e ask = new e(-18, "sever response error result code");
    public static e asl = new e(-19, "server bad response.");
    private final int asm;
    private final String asn;

    private e(int i2, String str) {
        this.asm = i2;
        this.asn = str;
    }

    public final String At() {
        return this.asn;
    }
}
