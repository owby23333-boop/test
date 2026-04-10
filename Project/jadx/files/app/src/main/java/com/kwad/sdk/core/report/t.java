package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class t extends d {
    private static volatile t ajt;
    private final List<r> aju;

    private t(Context context) {
        super(new s(context, s.HR));
        this.aju = new ArrayList();
        this.aju.add(new k());
    }

    public static t bg(Context context) {
        if (ajt == null) {
            synchronized (t.class) {
                if (ajt == null) {
                    ajt = new t(context);
                }
            }
        }
        return ajt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public synchronized q e(@NonNull Cursor cursor) {
        try {
            JSONObject jSONObject = new JSONObject(cursor.getString(cursor.getColumnIndex("aLog")));
            int size = this.aju.size() - 1;
            if (size >= 0) {
                return this.aju.get(size).g(jSONObject);
            }
            return new q(jSONObject);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            return new q("");
        }
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String getTag() {
        return "ReportActionDBManager";
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String xg() {
        return "ksad_actions";
    }
}
