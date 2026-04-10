package com.kwad.sdk.crash;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static final double aOI = Runtime.getRuntime().maxMemory();
    public static final Pattern aOJ = Pattern.compile("/data/user");
    public static final Pattern aOK = Pattern.compile("/data");
    public static final Pattern aOL = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern aOM = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int aON = 10;
    public static String aOO = "sessionId";
}
