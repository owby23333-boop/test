import React, { useState } from 'react';

function Library() {
  const [books, setBooks] = useState([
    { id: 1, title: '小说一', author: '作者一', cover: '📚' },
    { id: 2, title: '小说二', author: '作者二', cover: '📖' },
    { id: 3, title: '小说三', author: '作者三', cover: '📕' },
  ]);
  const [uploading, setUploading] = useState(false);

  // 文件上传处理
  const handleFileUpload = async (event) => {
    const file = event.target.files[0];
    if (!file) return;

    setUploading(true);
    
    // 读取文件内容
    const text = await file.text();
    
    // 解析书籍内容
    const bookInfo = {
      id: Date.now(),
      title: '未命名书籍',
      author: '未知',
      content: text,
      cover: '📖'
    };
    
    // 添加到书架
    setBooks(prev => [...prev, bookInfo]);
    
    alert(`✅ 书籍 "${bookInfo.title}" 已添加！`);
    setUploading(false);
  };

  // 删除书籍
  const handleDelete = (bookId) => {
    setBooks(prev => prev.filter(book => book.id !== bookId));
  };

  return (
    <div className="library">
      <div className="library-header">
        <h2>我的书架</h2>
        <div className="upload-section">
          <input
            type="file"
            accept=".txt,.md,.epub"
            onChange={handleFileUpload}
            disabled={uploading}
          />
          <button disabled={uploading} className="upload-btn">
            {uploading ? '上传中...' : '📥 上传书籍'}
          </button>
        </div>
      </div>

      <div className="books-grid">
        {books.map(book => (
          <div key={book.id} className="book-card">
            <div className="book-cover">{book.cover}</div>
            <h3>{book.title}</h3>
            <p className="author">{book.author}</p>
            <button 
              className="read-btn"
              onClick={() => alert(`打开：${book.title}`)}
            >
              开始阅读
            </button>
            <button 
              className="delete-btn"
              onClick={() => handleDelete(book.id)}
            >
              删除
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Library;
