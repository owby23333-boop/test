import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route, Link, NavLink } from 'react-router-dom';
import Library from './pages/Library';
import Reader from './pages/Reader';
import Settings from './pages/Settings';

function App() {
  const [currentTheme, setCurrentTheme] = useState('light');

  return (
    <Router>
      <div className={`app ${currentTheme}`}>
        <header>
          <h1>📖 小说阅读器</h1>
          <nav>
            <NavLink to="/" activeClassName="active">
              书架
            </NavLink>
            <NavLink to="/reader" activeClassName="active">
              阅读
            </NavLink>
            <NavLink to="/settings" activeClassName="active">
              设置
            </NavLink>
            <button onClick={() => setCurrentTheme(currentTheme === 'light' ? 'dark' : 'light')}>
              🌓 切换主题
            </button>
          </nav>
        </header>
        
        <main>
          <Routes>
            <Route path="/" element={<Library />} />
            <Route path="/reader" element={<Reader />} />
            <Route path="/settings" element={<Settings />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;
