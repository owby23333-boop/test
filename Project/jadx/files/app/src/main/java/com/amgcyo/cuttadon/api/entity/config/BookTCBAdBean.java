package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BookTCBAdBean implements Serializable {
    private BaseStochasticBean bottom;
    private BaseStochasticBean center;
    private BaseStochasticBean index;
    private BaseStochasticBean source;
    private BaseStochasticBean table_plaque;
    private BaseStochasticBean top;

    public BaseStochasticBean getBottom() {
        return this.bottom;
    }

    public BaseStochasticBean getCenter() {
        return this.center;
    }

    public BaseStochasticBean getIndex() {
        return this.index;
    }

    public BaseStochasticBean getSource() {
        return this.source;
    }

    public BaseStochasticBean getTable_plaque() {
        return this.table_plaque;
    }

    public BaseStochasticBean getTop() {
        return this.top;
    }

    public void setBottom(BaseStochasticBean baseStochasticBean) {
        this.bottom = baseStochasticBean;
    }

    public void setCenter(BaseStochasticBean baseStochasticBean) {
        this.center = baseStochasticBean;
    }

    public void setIndex(BaseStochasticBean baseStochasticBean) {
        this.index = baseStochasticBean;
    }

    public void setSource(BaseStochasticBean baseStochasticBean) {
        this.source = baseStochasticBean;
    }

    public void setTable_plaque(BaseStochasticBean baseStochasticBean) {
        this.table_plaque = baseStochasticBean;
    }

    public void setTop(BaseStochasticBean baseStochasticBean) {
        this.top = baseStochasticBean;
    }
}
