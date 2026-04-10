"""简单的 OCR 测试脚本"""
import sys
sys.path.insert(0, 'PROJECT/OCR-识别器')

from PIL import Image
from pytesseract import image_to_string

def test_tesseract():
    """测试 Tesseract OCR"""
    print("=" * 50)
    print("🐟 Tesseract OCR 测试")
    print("=" * 50)
    
    # 创建测试图片（如果有文件的话）
    try:
        # 如果存在测试图片
        test_image = Image.open('test.png')
        
        # 识别
        text = image_to_string(test_image, lang='chi_sim+eng')
        
        print(f"\n📝 识别结果:")
        print(f"{text}")
        
        print(f"\n✅ Tesseract 测试成功！")
        
    except FileNotFoundError:
        print("\n⚠️ 没有找到测试图片 test.png")
        print("请创建一个测试图片或跳过测试")
        return
    
    except Exception as e:
        print(f"\n❌ 错误：{e}")

def test_easyocr():
    """测试 EasyOCR"""
    print("\n" + "=" * 50)
    print("🤖 EasyOCR 测试")
    print("=" * 50)
    
    try:
        import easyocr
        
        reader = easyocr.Reader(['ch_sim', 'en'], gpu=False)
        
        if test_image:
            result = reader.readtext(test_image)
            
            print(f"\n📝 识别结果:")
            for res in result:
                text = res[1][0]
                conf = res[2]
                print(f"文本：{text} 置信度：{conf:.2f}")
            
            print(f"\n✅ EasyOCR 测试成功！")
            
        else:
            print("⚠️ 没有找到测试图片")
            
    except Exception as e:
        print(f"\n❌ EasyOCR 错误：{e}")

if __name__ == '__main__':
    # 检查是否有测试图片
    try:
        test_image = Image.open('test.png')
        print("✅ 找到测试图片：test.png")
    except:
        test_image = None
        print("⚠️ 没有找到测试图片，跳过测试")
    
    # 运行测试
    test_tesseract()
    
    # 如果想测试 EasyOCR
    if test_image:
        test_easyocr()
    
    print("\n" + "=" * 50)
    print("🎉 OCR 测试完成！")
    print("=" * 50)
