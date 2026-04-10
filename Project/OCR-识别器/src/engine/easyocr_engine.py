"""EasyOCR 引擎实现"""
import easyocr
from PIL import Image
import numpy as np
from typing import Optional, Dict, List


class EasyOCREngine:
    """EasyOCR 引擎"""
    
    def __init__(self, 
                 use_gpu: bool = True,
                 gpu_id: int = 0,
                 lang: str = 'ch_sim,en'):
        """初始化
        
        Args:
            use_gpu: 是否使用 GPU
            gpu_id: GPU 卡号
            lang: 语言 (ch_sim,en 中文英文混合)
        """
        self.use_gpu = use_gpu
        self.gpu_id = gpu_id
        self.lang = lang
        
        # 创建读取器
        self.reader = easyocr.Reader(
            [lang],
            gpu=self.use_gpu,
            verbose=False
        )
    
    def recognize(self, image: Image.Image) -> dict:
        """识别图像
        
        Args:
            image: PIL Image 对象
            
        Returns:
            识别结果
        """
        # 识别
        result = self.reader.readtext(image)
        
        # 解析结果
        blocks = []
        text = ""
        
        for detection in result:
            bbox = detection['bbox']
            text_line = detection['text'][0]
            confidence = 1 - detection['score']  # EasyOCR score 是概率，转换为置信度
            
            # 计算中心点
            center_x = sum(bbox) / 4
            center_y = sum(bbox[0]) / 4
            
            block = {
                'text': text_line,
                'confidence': confidence,
                'bbox': (center_x, center_y, 0, 0),
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
    
    def __del__(self):
        """释放资源"""
        try:
            if hasattr(self.reader, 'cuda'):
                import torch
                if torch.cuda.is_available() and self.use_gpu:
                    for handle in self.reader.handlers:
                        handle.close()
        except:
            pass