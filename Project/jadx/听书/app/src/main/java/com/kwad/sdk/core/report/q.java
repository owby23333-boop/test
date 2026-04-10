package com.kwad.sdk.core.report;

import android.content.Context;
import android.database.Cursor;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public class q extends d {
    private static volatile q aHQ;
    private o aHR;

    @Override // com.kwad.sdk.core.report.d
    protected final String Ip() {
        return "ksad_actions";
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String[] Iq() {
        return new String[]{"aLog", "actionId"};
    }

    @Override // com.kwad.sdk.core.report.d
    protected final String getTag() {
        return "ReportActionDBManager";
    }

    private q(Context context) {
        super(new p(context, p.Nv));
        this.aHR = new i();
    }

    public static q bD(Context context) {
        if (aHQ == null) {
            synchronized (q.class) {
                if (aHQ == null) {
                    aHQ = new q(context);
                }
            }
        }
        return aHQ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.d
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public synchronized n f(Cursor cursor) {
        String string = cursor.getString(0);
        String string2 = cursor.getString(1);
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).BO()) {
            return this.aHR.Z(string2, string);
        }
        return this.aHR.Z(string2, string);
    }
}
