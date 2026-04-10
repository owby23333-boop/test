package com.duokan.reader.domain.bookshelf;

/* JADX INFO: loaded from: classes3.dex */
public class Bookmark extends Annotation {
    @Override // com.duokan.reader.domain.bookshelf.Annotation
    public Annotation copy() {
        Bookmark bookmark = new Bookmark();
        bookmark.setId(getId());
        bookmark.setBookId(getBookId());
        bookmark.setSample(getOriginalSample());
        bookmark.setAddedDate(getAddedDate());
        bookmark.setModifiedDate(getModifiedDate());
        bookmark.setEndAnchor(getEndAnchor());
        bookmark.setStartAnchor(getStartAnchor());
        bookmark.setAnnotationUuid(getAnnotationUuid());
        return bookmark;
    }

    @Override // com.duokan.reader.domain.bookshelf.Annotation
    public AnnotationType getType() {
        return AnnotationType.BOOKMARK;
    }
}
