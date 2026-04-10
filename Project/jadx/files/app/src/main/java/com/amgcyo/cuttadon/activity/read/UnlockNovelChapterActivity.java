package com.amgcyo.cuttadon.activity.read;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.api.entity.other.Slippage;
import com.amgcyo.cuttadon.database.AppDatabase;

/* JADX INFO: loaded from: classes.dex */
public class UnlockNovelChapterActivity extends MyBaseUnlockActivity {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private Slippage f2731s0;

    @Override // com.amgcyo.cuttadon.activity.read.MyBaseUnlockActivity
    public void getData(@NonNull Bundle bundle) {
        this.f2731s0 = (Slippage) bundle.getSerializable("Slippage");
        Slippage slippage = this.f2731s0;
        if (slippage == null) {
            n();
            return;
        }
        String platform = slippage.getPlatform();
        int style = this.f2731s0.getStyle();
        if (TextUtils.isEmpty(platform) || style <= 0) {
            n();
        } else {
            b(platform, style);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MyBaseUnlockActivity
    public void saveData() {
        Slippage slippage;
        if (this.f2727o0 == null || (slippage = this.f2731s0) == null) {
            return;
        }
        int catalog_id = slippage.getCatalog_id();
        int book_id = this.f2727o0.getBook_id();
        com.amgcyo.cuttadon.utils.otherutils.g0.a().b("unlock_" + book_id + "_" + catalog_id, true);
        com.amgcyo.cuttadon.database.f fVarA = AppDatabase.i().a();
        if (fVarA.i(book_id) != null) {
            int catalog_id2 = this.f2731s0.getCatalog_id();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            this.f2727o0.setReading_chapter_key(catalog_id2);
            this.f2727o0.setReading_datetime(jCurrentTimeMillis);
            this.f2727o0.setRead_begin(0);
            this.f2727o0.setVertical_top(0);
            if (this.f2731s0.getReadModel() == 0) {
                fVarA.a(catalog_id2, jCurrentTimeMillis, book_id, 0, 0);
            } else if (1 == this.f2731s0.getReadModel()) {
                fVarA.a(catalog_id2, jCurrentTimeMillis, this.f2727o0.getUpdated(), book_id, 0, 0, this.f2731s0.getChapterName());
            }
        }
    }
}
