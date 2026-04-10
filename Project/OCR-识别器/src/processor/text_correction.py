"""文本修正"""
from typing import List, Tuple
import re


class TextCorrector:
    """文本修正器"""
    
    def __init__(self):
        # 常见错误修正表
        self.errors = {
            '0': 'O', 'O': '0',
            '1': 'I', 'I': '1',
            'b': '6', '6': 'b',
            'd': '0', '0': 'd',
            'cl': 'ol', 'Ol': 'Ol',
            'a': '4', '4': 'a',
            'q': 'g', 'g': 'q',
        }
        
        # 常见中文错误（可扩展）
        self.chinese_errors = {}
    
    def correct(self, text: str, confidence: float) -> Tuple[str, float]:
        """修正文本
        
        Args:
            text: 原始文本
            confidence: 置信度
            
        Returns:
            (修正后的文本，新置信度)
        """
        if confidence > 0.9:  # 高置信度直接返回
            return text, confidence
        
        # 应用错误修正
        corrected = text
        for wrong, right in self.errors.items():
            pattern = re.compile(wrong)
            corrected = pattern.sub(right, corrected)
        
        # 计算新置信度
        new_confidence = min(confidence + 0.05, 0.99)
        
        return corrected, new_confidence
    
    def correct_batch(self, texts: List[Tuple[str, float]]) -> List[Tuple[str, float]]:
        """批量修正文本
        
        Args:
            texts: (文本，置信度) 列表
            
        Returns:
            修正后的列表
        """
        return [
            (self.correct(text, conf)[0], 
             self.correct(text, conf)[1])
            for text, conf in texts
        ]