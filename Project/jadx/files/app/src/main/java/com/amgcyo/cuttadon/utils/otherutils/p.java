package com.amgcyo.cuttadon.utils.otherutils;

import android.text.TextUtils;
import android.widget.Toast;
import com.amgcyo.cuttadon.activity.base.BaseTitleBarActivity;
import com.amgcyo.cuttadon.api.entity.migrate.DaoliuData;
import com.amgcyo.cuttadon.api.entity.migrate.DaoliuUser;
import com.amgcyo.cuttadon.api.entity.other.LocalReadHistoryBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.database.AppDatabase;
import com.amgcyo.cuttadon.database.ReadHistoryDatabase;
import com.google.gson.GsonBuilder;
import java.util.List;

/* JADX INFO: compiled from: DaoliuUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class p {
    public static boolean a(DaoliuData daoliuData, BaseTitleBarActivity baseTitleBarActivity) {
        if (daoliuData == null || baseTitleBarActivity == null) {
            return false;
        }
        String json_book = daoliuData.getJson_book();
        baseTitleBarActivity.showLoading();
        if (!TextUtils.isEmpty(json_book)) {
            List<MkBook> listB = r.b(json_book, MkBook.class);
            if (!g.a((List<?>) listB)) {
                String str = "导流书籍大小：" + listB.size();
                com.amgcyo.cuttadon.database.f fVarA = AppDatabase.i().a();
                int i2 = 0;
                for (MkBook mkBook : listB) {
                    if (fVarA.insert(new MkBook(mkBook.getBook_id(), mkBook.getName(), mkBook.getAuthor(), mkBook.getForm(), mkBook.getImage(), mkBook.getIs_top(), mkBook.getIs_fatten(), mkBook.getFatten_num(), mkBook.getReading_datetime(), mkBook.getReading_chapter_key(), mkBook.getLast_read_chapterName(), mkBook.getLast_chapter_name(), mkBook.getRead_begin(), mkBook.getReading_chapter_path(), mkBook.getReading_site_id(), mkBook.getReading_site_path(), mkBook.getSite_path_reload(), mkBook.getJpush_status(), mkBook.getCrawl_book_id(), mkBook.getVertical_top(), mkBook.getWords_number())) > 0) {
                        i2++;
                        String str2 = "书籍信息：form " + mkBook.getForm() + "  " + mkBook.getBook_id() + "  " + mkBook.getLast_read_chapterName();
                    }
                }
                String str3 = "有书籍数据存在,count:" + i2 + " listsize:" + listB.size();
                if (i2 == listB.size()) {
                    Toast.makeText(baseTitleBarActivity, "书籍同步成功", 0).show();
                }
            }
        }
        String json_history = daoliuData.getJson_history();
        if (!TextUtils.isEmpty(json_history)) {
            List<LocalReadHistoryBean> listB2 = r.b(json_history, LocalReadHistoryBean.class);
            if (!g.a((List<?>) listB2) && !g.a((List<?>) listB2)) {
                com.amgcyo.cuttadon.database.a aVarA = ReadHistoryDatabase.b().a();
                int i3 = 0;
                for (LocalReadHistoryBean localReadHistoryBean : listB2) {
                    int form = localReadHistoryBean.getForm();
                    if (aVarA.insert(new LocalReadHistoryBean(32767, localReadHistoryBean.getBook_id(), form <= 0 ? 1 : form, localReadHistoryBean.getName(), localReadHistoryBean.getAuthor(), localReadHistoryBean.getImage(), localReadHistoryBean.getCreated_at(), localReadHistoryBean.getList_path(), localReadHistoryBean.getList_reload_path(), localReadHistoryBean.getStatus(), localReadHistoryBean.getComment_number(), localReadHistoryBean.getChapter_count(), localReadHistoryBean.getLast_chapter_name(), localReadHistoryBean.getUpdated_at())) > 0) {
                        i3++;
                    }
                }
                String str4 = "有书籍数据存在,count:" + i3 + " listsize:" + listB2.size();
                if (i3 == listB2.size()) {
                    baseTitleBarActivity.showMessage("阅读记录同步成功！");
                }
            }
        }
        baseTitleBarActivity.hideLoading();
        return true;
    }

    public static DaoliuUser a(DaoliuData daoliuData) {
        if (daoliuData == null) {
            return null;
        }
        String json_user = daoliuData.getJson_user();
        if (!TextUtils.isEmpty(json_user)) {
            DaoliuUser daoliuUser = (DaoliuUser) new GsonBuilder().setExclusionStrategies(new l0(new String[]{"invitation_code"})).create().fromJson(json_user, DaoliuUser.class);
            if (daoliuUser != null && daoliuUser.getUser_id() > 0) {
                String str = "daoliuuser：" + daoliuUser.toString();
                return daoliuUser;
            }
        }
        return null;
    }
}
