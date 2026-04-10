package com.yuewen;

import androidx.annotation.NonNull;
import com.duokan.free.tts.service.e;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.PresetBookType;
import com.duokan.reader.ui.store.data.cms.Advertisement;
import com.duokan.reader.ui.store.data.cms.Fiction;
import com.duokan.reader.ui.store.fiction.data.FictionItem;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class lm2 extends com.duokan.reader.domain.bookshelf.b {
    public static final int P1 = 9;
    public static final int Q1 = 6;
    public static final int R1 = 3;
    public int M1;
    public boolean N1;
    public PresetBookType O1;

    public lm2(com.duokan.reader.domain.bookshelf.d dVar, long j) {
        super(dVar, j, BookPackageType.PRESET, BookType.TRIAL, BookState.NORMAL, true, false);
        this.N1 = false;
        this.O1 = PresetBookType.NORMAL_PRESET;
    }

    public static lm2 p4(@NonNull com.duokan.reader.domain.bookshelf.d dVar, long j, @NonNull JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return null;
        }
        lm2 lm2Var = new lm2(dVar, j);
        lm2Var.l3(System.currentTimeMillis());
        lm2Var.D3(jSONObject.optString(e.c.f3725a));
        lm2Var.b0(jSONObject.optString("title"));
        lm2Var.o3(jSONObject.optString("authors"));
        lm2Var.S3(jSONObject.optString("cover"));
        lm2Var.u3(new FictionItem((Fiction) sb1.c(jSONObject.toString(), Fiction.class), new Advertisement(), i));
        return lm2Var;
    }

    public PresetBookType q4() {
        return this.O1;
    }

    public boolean r4() {
        return this.N1;
    }

    public void s4(boolean z) {
        this.N1 = z;
    }

    public void t4(PresetBookType presetBookType) {
        this.O1 = presetBookType;
    }

    public JSONObject u4() throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(e.c.f3725a, n1());
        jSONObject.put("title", a());
        jSONObject.put("authors", c());
        jSONObject.put("cover", b());
        return jSONObject;
    }
}
