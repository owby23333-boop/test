package com.amgcyo.cuttadon.activity.comic;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.activity.read.MyBaseUnlockActivity;
import com.amgcyo.cuttadon.api.entity.adbean.NormalAdParams;
import com.amgcyo.cuttadon.api.entity.comic.ComicChapter;
import com.amgcyo.cuttadon.api.entity.comic.ZymkChapter;
import com.amgcyo.cuttadon.api.entity.config.BaseAd;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.utils.otherutils.g0;

/* JADX INFO: loaded from: classes.dex */
public class UnlockComicChapterActivity extends MyBaseUnlockActivity {

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private ZymkChapter f2405s0;

    @Override // com.amgcyo.cuttadon.activity.read.MyBaseUnlockActivity
    public void getData(@NonNull Bundle bundle) {
        ComicChapter comicChapter = (ComicChapter) bundle.getSerializable("comicChapterTag");
        if (comicChapter == null) {
            n();
            return;
        }
        this.f2405s0 = comicChapter.getZymkChapter();
        if (this.f2405s0 == null) {
            n();
            return;
        }
        NormalAdParams adParams = comicChapter.getAdParams();
        if (adParams == null) {
            n();
            return;
        }
        BaseAd baseAd = adParams.getBaseAd();
        if (baseAd == null) {
            n();
            return;
        }
        String platform = baseAd.getPlatform();
        int style = baseAd.getStyle();
        if (TextUtils.isEmpty(platform) || style <= 0) {
            n();
        } else {
            b(platform, style);
        }
    }

    @Override // com.amgcyo.cuttadon.activity.read.MyBaseUnlockActivity
    public void saveData() {
        ZymkChapter zymkChapter;
        if (this.f2727o0 == null || (zymkChapter = this.f2405s0) == null) {
            return;
        }
        int index = zymkChapter.getIndex();
        int book_id = this.f2727o0.getBook_id();
        g0.a().b("unlock_" + book_id + "_" + this.f2405s0.getId() + "_" + index, true);
        com.amgcyo.cuttadon.database.f fVarA = AppDatabase.i().a();
        if (fVarA.i(book_id) != null) {
            fVarA.a(index, System.currentTimeMillis() / 1000, this.f2727o0.getUpdated(), book_id, 0, 0, this.f2405s0.getName());
        }
        this.f2727o0.setReading_chapter_key(index);
        this.f2727o0.setRead_begin(0);
    }
}
