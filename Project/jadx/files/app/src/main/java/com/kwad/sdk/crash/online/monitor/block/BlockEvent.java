package com.kwad.sdk.crash.online.monitor.block;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class BlockEvent extends com.kwad.sdk.core.response.kwai.a {
    public long blockTimeThreshold;
    public long blockDuration = 0;
    public long blockLoopInterval = 100;
    public long calcBlockOverhead = 0;
    public String currentActivity = "";
    public String processName = "";
    public List<a> stackTraceSample = new ArrayList();

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public long ari;
        public boolean arj = false;
        public String ark;
        public long arl;
        public int repeatCount;
    }
}
