package com.kwad.sdk.crash.online.monitor.block;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class BlockEvent extends com.kwad.sdk.core.response.a.a {
    public long blockTimeThreshold;
    public long blockDuration = 0;
    public long blockLoopInterval = 100;
    public long calcBlockOverhead = 0;
    public String currentActivity = "";
    public String processName = "";
    public List<a> stackTraceSample = new ArrayList();

    public static class a extends com.kwad.sdk.core.response.a.a {
        public long aPG;
        public boolean aPH = false;
        public String aPI;
        public long aPJ;
        public int repeatCount;
    }
}
