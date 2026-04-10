package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends d {
    public static int Nv = 1;
    private static volatile a aPV;

    @Override // com.kwad.sdk.core.report.d
    public final String Ip() {
        return "ksad_block_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String[] Iq() {
        return new String[]{"aLog"};
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }

    public static a cc(Context context) {
        if (aPV == null) {
            synchronized (a.class) {
                if (aPV == null) {
                    aPV = new a(context);
                }
            }
        }
        return aPV;
    }

    private a(Context context) {
        super(new com.kwad.sdk.crash.online.monitor.block.a.a(context, Nv));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public synchronized BlockReportAction f(Cursor cursor) {
        try {
        } catch (JSONException e) {
            c.printStackTrace(e);
            return new BlockReportAction("");
        }
        return new BlockReportAction(new JSONObject(cursor.getString(0)));
    }
}
