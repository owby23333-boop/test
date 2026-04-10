import React from 'react';

function Settings() {
  return (
    <div className="settings">
      <h2>设置</h2>

      <div className="setting-group">
        <h3>阅读设置</h3>
        <div className="setting-item">
          <label>字体：</label>
          <select>
            <option selected>微软雅黑</option>
            <option>宋体</option>
            <option>楷体</option>
            <option>仿宋</option>
          </select>
        </div>

        <div className="setting-item">
          <label>主题：</label>
          <select>
            <option>浅色</option>
            <option selected>深色</option>
            <option>护眼</option>
          </select>
        </div>
      </div>

      <div className="setting-group">
        <h3>外观设置</h3>
        <div className="setting-item">
          <label>背景色：</label>
          <input type="color" defaultValue="#1a1a2e" />
        </div>

        <div className="setting-item">
          <label>文字颜色：</label>
          <input type="color" defaultValue="#e0e0e0" />
        </div>
      </div>

      <div className="setting-group">
        <h3>其他设置</h3>
        <div className="setting-item">
          <label>默认字体大小：</label>
          <input type="number" defaultValue="16" min="12" max="32" />
        </div>

        <div className="setting-item">
          <label>默认行间距：</label>
          <select>
            <option>单倍行距</option>
            <option selected>1.25 倍行距</option>
            <option>1.5 倍行距</option>
          </select>
        </div>
      </div>

      <button className="save-btn">保存设置</button>
    </div>
  );
}

export default Settings;
