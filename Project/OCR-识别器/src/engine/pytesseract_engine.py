"""Tesseract OCR 引擎实现"""
import pytesseract
from PIL import Image
import io
from typing import Optional, Dict, List
import numpy as np


class TesseractOCREngine:
    """Tesseract OCR 引擎"""
    
    def __init__(self, 
                 lang: str = 'chi_sim+eng+num',
                 tesseract_path: Optional[str] = None):
        """初始化
        
        Args:
            lang: 语言 (默认：chi_sim+eng+num)
            tesseract_path: Tesseract 安装路径
        """
        self.lang = lang
        self.tesseract_path = tesseract_path
        
        # 配置 Tesseract
        if tesseract_path:
            pytesseract.pytesseract.tesseract_cmd = tesseract_path
    
    def recognize(self, image: Image.Image) -> dict:
        """识别图像
        
        Args:
            image: PIL Image 对象
            
        Returns:
            识别结果
        """
        # 识别
        result = pytesseract.image_to_data(
            image,
            lang=self.lang,
            config='--psm 6 --oem 3 --lm 1'
        )
        
        # 解析结果
        blocks = []
        text = ""
        
        for i, (text_line, conf) in enumerate(zip(
            result['text'],
            result['conf']
        )):
            if conf > 0:  # 过滤无效识别
                block = {
                    'text': text_line.strip(),
                    'confidence': conf / 100.0,
                    'bbox': (0, 0, 0, 0),  # Tesseract 不提供精确 bbox
                    'rotation': None
                }
                blocks.append(block)
                text += text_line + '\n'
        
        return {
            'text': text.strip(),
            'blocks': blocks,
            'overall_confidence': sum(b['confidence'] for b in blocks) / max(len(blocks), 1)
        }
    
    def batch_recognize(self, images: List[Image.Image]) -> List[dict]:
        """批量识别
        
        Args:
            images: 图像列表
            
        Returns:
            结果列表
        """
        results = []
        
        for image in images:
            result = self.recognize(image)
            results.append(result)
        
        return results