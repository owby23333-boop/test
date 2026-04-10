import React, { useState } from 'react';

function Reader() {
  const [currentBook, setCurrentBook] = useState(null);
  const [fontSize, setFontSize] = useState(16);
  const [lineHeight, setLineHeight] = useState(1.5);
  const [autoPlay, setAutoPlay] = useState(false);
  const [playing, setPlaying] = useState(false);
  const [progress, setProgress] = useState(0);

  // 模拟书籍列表
  const books = [
    { id: 1, title: '小说一', content: '第一章 开始...' },
    { id: 2, title: '小说二', content: '第二章 继续...' },
  ];

  // 加载书籍
  const loadBook = (bookId) => {
    const book = books.find(b => b.id === bookId);
    if (book) {
      setCurrentBook(book);
      setProgress(0);
    }
  };

  // TTS 朗读控制
  const toggleTTS = () => {
    setPlaying(!playing);
    if (playing) {
      // 停止朗读
      window.speechSynthesis.cancel();
    } else {
      // 开始朗读
      const utterance = new SpeechSynthesisUtterance(currentBook?.content || '');
      utterance.lang = 'zh-CN';
      utterance.rate = 1;
      window.speechSynthesis.speak(utterance);
    }
  };

  if (!currentBook) {
    return (
      <div className="reader">
        <div className="reader-toolbar">
          <h2>📖 阅读器</h2>
          <button className="tts-btn" onClick={toggleTTS}>
            {playing ? '⏸️ 暂停' : '🔊 朗读'}
          </button>
        </div>

        <div className="book-selection">
          <h3>选择书籍</h3>
          {books.map(book => (
            <button
              key={book.id}
              className="book-select-btn"
              onClick={() => loadBook(book.id)}
            >
              📚 {book.title}
            </button>
          ))}
        </div>

        <div className="reader-info">
          <p>请选择一本书籍开始阅读</p>
        </div>
      </div>
    );
  }

  return (
    <div className="reader">
      <div className="reader-toolbar">
        <button className="back-btn" onClick={() => setCurrentBook(null)}>
          ← 返回
        </button>
        <div className="book-title">{currentBook.title}</div>
        <button className="tts-btn" onClick={toggleTTS}>
          {playing ? '⏸️ 暂停' : '🔊 朗读'}
        </button>
      </div>

      <div className="reader-content">
        <div 
          className="reader-text"
          style={{
            fontSize: `${fontSize}px`,
            lineHeight: lineHeight,
          }}
        >
          <p>{currentBook.content}</p>
          <p>继续阅读...</p>
        </div>

        <div className="reader-controls">
          <div className="control-group">
            <label>字体大小：</label>
            <input
              type="range"
              min="12"
              max="24"
              value={fontSize}
              onChange={(e) => setFontSize(Number(e.target.value))}
            />
          </div>

          <div className="control-group">
            <label>行间距：</label>
            <select
              value={lineHeight}
              onChange={(e) => setLineHeight(Number(e.target.value))}
            >
              <option value={1}>单倍行距</option>
              <option value={1.25} selected>1.25 倍行距</option>
              <option value={1.5}>1.5 倍行距</option>
              <option value={2}>2 倍行距</option>
            </select>
          </div>

          <div className="control-group">
            <button onClick={() => setProgress(p => p - 10)}>⏮️ 上一章</button>
            <span>{Math.round(progress)}%</span>
            <button onClick={() => setProgress(p => p + 10)}>⏭️ 下一章</button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Reader;
