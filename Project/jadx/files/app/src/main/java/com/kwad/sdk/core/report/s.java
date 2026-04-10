package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends c {
    public static int HR = 1;
    private static String ajs = "CREATE TABLE IF NOT EXISTS ksad_actions (actionId varchar(60) primary key, aLog TEXT)";

    public s(@Nullable Context context, int i2) {
        super(context, "ksadrep.db", i2, ajs);
    }
}
