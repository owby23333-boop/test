package com.kwad.sdk.core.report;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public final class p extends c {
    public static int Nv = 1;
    private static String aHP = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public p(Context context, int i) {
        super(context, "ksadrep.db", i, aHP);
    }
}
