"""图像预处理"""
from PIL import Image
import cv2
import numpy as np
from typing import Optional, Tuple


class ImagePreprocessor:
    """图像预处理器"""
    
    def __init__(self, 
                 brightness: float = 1.0,
                 contrast: float = 1.0,
                 gamma: float = 1.0):
        self.brightness = brightness
        self.contrast = contrast
        self.gamma = gamma
    
    def preprocess(self, image: Image.Image) -> Image.Image:
        """预处理图像
        
        Args:
            image: 输入图像
            
        Returns:
            预处理后的图像
        """
        # 转换色彩空间
        if len(image.mode) == 4:  # RGBA
            image = image.convert('RGB')
        elif len(image.mode) == 3:
            image = image.convert('L')
        
        img = np.array(image)
        
        # 亮度调整
        img = self._adjust_brightness(img)
        
        # 对比度调整
        img = self._adjust_contrast(img)
        
        # 去噪
        img = self._denoise(img)
        
        # 二值化
        img = self._binarize(img)
        
        return Image.fromarray(img)
    
    def _adjust_brightness(self, img: np.ndarray) -> np.ndarray:
        """调整亮度"""
        if self.brightness != 1.0:
            alpha = 1.0 + (self.brightness - 1.0) * 0.5
            img = cv2.convertScaleAbs(img, alpha=alpha)
        return img
    
    def _adjust_contrast(self, img: np.ndarray) -> np.ndarray:
        """调整对比度"""
        if self.contrast != 1.0:
            alpha = 1.0 + (self.contrast - 1.0) * 0.3
            beta = 0
            img = cv2.convertScaleAbs(img, alpha=alpha, beta=beta)
        return img
    
    def _denoise(self, img: np.ndarray) -> np.ndarray:
        """去噪"""
        # 使用双边滤波去噪
        kernel_size = min(5, max(1, int(5 * img.shape[0] / 1000)))
        img = cv2.bilateralFilter(img, d=kernel_size, sigmaColor=75, sigmaSpace=75)
        return img
    
    def _binarize(self, img: np.ndarray) -> np.ndarray:
        """二值化"""
        # 自适应阈值
        img = cv2.adaptiveThreshold(
            img, 255, cv2.ADAPTIVE_THRESH_GAUSSIAN_C,
            cv2.THRESH_BINARY, 11, 2
        )
        return img