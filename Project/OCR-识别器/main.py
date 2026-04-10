"""OCR 识别器主程序"""
import sys
from pathlib import Path
from PIL import Image
import argparse

# 添加项目路径
sys.path.insert(0, str(Path(__file__).parent))

from src.engine.paddleocr_engine import PaddleOCREngine
from src.engine.pytesseract_engine import TesseractOCREngine
from src.engine.easyocr_engine import EasyOCREngine
from src.processor.image_preprocess import ImagePreprocessor
from src.processor.text_correction import TextCorrector


class OCRProcessor:
    """OCR 处理器"""
    
    def __init__(self, engine_type: str = 'paddleocr', use_gpu: bool = True):
        """初始化
        
        Args:
            engine_type: 引擎类型 (paddleocr/pytesseract/easyocr)
            use_gpu: 是否使用 GPU
        """
        self.engine_type = engine_type
        self.use_gpu = use_gpu
        
        # 创建引擎
        if engine_type == 'paddleocr':
            self.engine = PaddleOCREngine(use_gpu=use_gpu)
        elif engine_type == 'pytesseract':
            self.engine = TesseractOCREngine()
        else:
            self.engine = EasyOCREngine(use_gpu=use_gpu)
        
        # 创建预处理器
        self.preprocessor = ImagePreprocessor()
        
        # 创建文本修正器
        self.corrector = TextCorrector()
    
    def recognize(self, image: Image.Image) -> dict:
        """识别单张图像
        
        Args:
            image: PIL Image 对象
            
        Returns:
            识别结果字典
        """
        # 预处理
        processed_image = self.preprocessor.preprocess(image)
        
        # 识别
        result = self.engine.recognize(processed_image)
        
        # 修正文本
        result = self._correct_text(result)
        
        return result
    
    def recognize_from_file(self, image_path: str) -> dict:
        """从文件识别
        
        Args:
            image_path: 图片路径
            
        Returns:
            识别结果
        """
        image = Image.open(image_path)
        return self.recognize(image)
    
    def _correct_text(self, result: dict) -> dict:
        """修正识别结果中的文本
        
        Args:
            result: 原始识别结果
            
        Returns:
            修正后的结果
        """
        blocks = []
        
        for block in result['blocks']:
            text, conf = self.corrector.correct(
                block['text'],
                block['confidence']
            )
            blocks.append({
                'text': text,
                'confidence': conf,
                'bbox': block['bbox'],
                'rotation': block.get('rotation')
            })
        
        return {
            'text': '\n'.join([b['text'] for b in blocks]),
            'blocks': blocks,
            'confidence': result.get('overall_confidence', 0.9)
        }
    
    def batch_recognize(self, image_paths: list) -> list:
        """批量识别
        
        Args:
            image_paths: 图片路径列表
            
        Returns:
            结果列表
        """
        results = []
        
        for path in image_paths:
            try:
                result = self.recognize_from_file(path)
                results.append({
                    'path': path,
                    'success': True,
                    'result': result
                })
            except Exception as e:
                results.append({
                    'path': path,
                    'success': False,
                    'error': str(e)
                })
        
        return results


def main():
    """主函数"""
    parser = argparse.ArgumentParser(description='OCR 识别器')
    parser.add_argument('--image', type=str, help='单张图片路径')
    parser.add_argument('--input', type=str, help='批量识别输入目录')
    parser.add_argument('--output', type=str, help='输出文件路径')
    parser.add_argument('--engine', type=str, default='paddleocr',
                       choices=['paddleocr', 'pytesseract', 'easyocr'])
    parser.add_argument('--gpu', action='store_true', help='使用 GPU')
    
    args = parser.parse_args()
    
    # 创建处理器
    processor = OCRProcessor(
        engine_type=args.engine,
        use_gpu=args.gpu
    )
    
    # 处理
    if args.image:
        # 单张图片
        result = processor.recognize_from_file(args.image)
        print(f"识别结果:")
        print(f"文本：{result['text']}")
        print(f"置信度：{result['confidence']:.2f}")
    elif args.input:
        # 批量处理
        import os
        image_paths = [
            os.path.join(args.input, f) 
            for f in os.listdir(args.input) 
            if f.lower().endswith(('.png', '.jpg', '.jpeg', '.bmp', '.tiff'))
        ]
        
        results = processor.batch_recognize(image_paths)
        
        # 保存结果
        if args.output:
            with open(args.output, 'w', encoding='utf-8') as f:
                import json
                json.dump(results, f, ensure_ascii=False, indent=2)
        
        # 打印摘要
        success_count = sum(1 for r in results if r['success'])
        print(f"处理完成：{success_count}/{len(results)} 张成功")
    else:
        print("用法：python main.py --image <图片路径> 或 --input <输入目录> --output <输出文件>")


if __name__ == '__main__':
    main()