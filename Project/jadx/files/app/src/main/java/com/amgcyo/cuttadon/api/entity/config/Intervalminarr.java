package com.amgcyo.cuttadon.api.entity.config;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Intervalminarr implements Serializable {
    private List<Integer> Awaken;
    private List<Integer> ChapterRead;
    private List<Integer> ComicsChapterRead;
    private List<Integer> ComicsExemptAd;
    private List<Integer> ErrAd;
    private List<Integer> ExemptAd;
    private List<Integer> ListeningBook;
    private List<Integer> VideoAddBook;

    public List<Integer> getAwaken() {
        return this.Awaken;
    }

    public List<Integer> getChapterRead() {
        return this.ChapterRead;
    }

    public List<Integer> getComicsChapterRead() {
        return this.ComicsChapterRead;
    }

    public List<Integer> getComicsExemptAd() {
        return this.ComicsExemptAd;
    }

    public List<Integer> getErrAd() {
        return this.ErrAd;
    }

    public List<Integer> getExemptAd() {
        return this.ExemptAd;
    }

    public List<Integer> getListeningBook() {
        return this.ListeningBook;
    }

    public List<Integer> getVideoAddBook() {
        return this.VideoAddBook;
    }

    public void setAwaken(List<Integer> list) {
        this.Awaken = list;
    }

    public void setChapterRead(List<Integer> list) {
        this.ChapterRead = list;
    }

    public void setComicsChapterRead(List<Integer> list) {
        this.ComicsChapterRead = list;
    }

    public void setComicsExemptAd(List<Integer> list) {
        this.ComicsExemptAd = list;
    }

    public void setErrAd(List<Integer> list) {
        this.ErrAd = list;
    }

    public void setExemptAd(List<Integer> list) {
        this.ExemptAd = list;
    }

    public void setListeningBook(List<Integer> list) {
        this.ListeningBook = list;
    }

    public void setVideoAddBook(List<Integer> list) {
        this.VideoAddBook = list;
    }
}
