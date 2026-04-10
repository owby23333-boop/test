package com.amgcyo.cuttadon.api.entity.migrate;

import com.amgcyo.cuttadon.api.entity.config.NotifyBean;
import com.open.hule.library.entity.TipsBean;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class MigrateData implements Serializable {
    private MigrateBean migrate;
    private NotifyBean notify;
    private TipsBean tips;

    public MigrateBean getMigrate() {
        return this.migrate;
    }

    public NotifyBean getNotify() {
        return this.notify;
    }

    public TipsBean getTips() {
        return this.tips;
    }

    public void setMigrate(MigrateBean migrateBean) {
        this.migrate = migrateBean;
    }

    public void setNotify(NotifyBean notifyBean) {
        this.notify = notifyBean;
    }

    public void setTips(TipsBean tipsBean) {
        this.tips = tipsBean;
    }
}
