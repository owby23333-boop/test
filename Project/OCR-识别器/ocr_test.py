"""
OCR 测试脚本 - 修正版本
用法：python ocr_test.py
"""

from easyocr import Reader
import os

def test_ocr(image_path='test.png'):
    """
    OCR 测试函数
    
    Args:
        image_path: 图片路径
    """
    print('=' * 60)
    print('🤖 EasyOCR OCR 识别测试')
    print('=' * 60)
    
    # 检查文件是否存在
    if not os.path.exists(image_path):
        print(f'❌ 文件不存在：{image_path}')
        return
    
    # 读取图片
    print(f'✅ 读取图片：{image_path}')
    
    # 创建 EasyOCR 读取器（不使用 GPU）
    print('🤖 创建 EasyOCR 读取器...')
    reader = Reader(['ch_sim', 'en'], gpu=False)
    print('   ✅ 读取器已就绪')
    
    # 识别
    print('🔍 开始识别...')
    result = reader.readtext(image_path)
    
    # 打印结果
    print('=' * 60)
    print('📝 识别结果:')
    print('=' * 60)
    
    if not result:
        print('⚠️ 没有识别到文字')
        return
    
    for i, detection in enumerate(result, 1):
        # 修正数据结构访问
        # detection 是列表：[bbox, text, confidence]
        # detection[1] 是字符串还是列表？让我们看看
        
        # 正确的结构是：[bbox_tuple, text_string, confidence_float]
        bbox = detection[0]
        text = detection[1]
        confidence = detection[2]
        
        print(f'\n{i}. 文本：{text}')
        print(f'   置信度：{confidence:.2f}')
        print(f'   位置：{bbox}')
        print('-' * 40)
    
    # 统计
    total_text = '\n'.join([d[1] for d in result])
    avg_score = sum(d[2] for d in result) / len(result)
    
    print('\n' + '=' * 60)
    print('📊 识别摘要:')
    print('=' * 60)
    print(f'识别到的文字:\n{total_text}')
    print(f'平均置信度：{avg_score:.2f}')
    print(f'识别到的行数：{len(result)}')
    print('=' * 60)
    print('✅ OCR 测试完成！')
    print('=' * 60)


if __name__ == '__main__':
    import sys
    
    # 获取图片路径
    if len(sys.argv) > 1:
        image_path = sys.argv[1]
    else:
        image_path = 'PROJECT/OCR-识别器/test.png'
    
    # 运行测试
    test_ocr(image_path)
