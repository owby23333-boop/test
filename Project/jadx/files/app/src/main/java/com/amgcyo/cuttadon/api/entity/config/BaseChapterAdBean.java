package com.amgcyo.cuttadon.api.entity.config;

/* JADX INFO: loaded from: classes.dex */
public class BaseChapterAdBean extends BaseStochasticBean {
    private int back;
    private int interval_min;
    private int loading;
    private int play;
    private int style;

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean
    public int getBack() {
        return this.back;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean
    public int getInterval_min() {
        return this.interval_min;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean
    public int getLoading() {
        return this.loading;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean
    public int getPlay() {
        return this.play;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean
    public int getStyle() {
        return this.style;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean
    public void setBack(int i2) {
        this.back = i2;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean
    public void setInterval_min(int i2) {
        this.interval_min = i2;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean
    public void setLoading(int i2) {
        this.loading = i2;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean
    public void setPlay(int i2) {
        this.play = i2;
    }

    @Override // com.amgcyo.cuttadon.api.entity.config.BaseStochasticBean
    public void setStyle(int i2) {
        this.style = i2;
    }
}
