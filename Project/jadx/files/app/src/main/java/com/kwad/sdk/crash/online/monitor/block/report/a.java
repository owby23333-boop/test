package com.kwad.sdk.crash.online.monitor.block.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends d {
    public static int HR = 1;
    private static volatile a ary;

    private a(Context context) {
        super(new com.kwad.sdk.crash.online.monitor.block.kwai.a(context, HR));
    }

    public static a by(Context context) {
        if (ary == null) {
            synchronized (a.class) {
                if (ary == null) {
                    ary = new a(context);
                }
            }
        }
        return ary;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public synchronized BlockReportAction e(@NonNull Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("aLog");
        if (columnIndex < 0) {
            return new BlockReportAction("");
        }
        try {
            return new BlockReportAction(new JSONObject(cursor.getString(columnIndex)));
        } catch (JSONException e2) {
            b.printStackTrace(e2);
            return new BlockReportAction("");
        }
    }

    @Override // com.kwad.sdk.core.report.d
    public final String getTag() {
        return "perfMonitor.BlockReportDBManager";
    }

    @Override // com.kwad.sdk.core.report.d
    public final String xg() {
        return "ksad_block_actions";
    }
}
