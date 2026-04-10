# bubble_sort.py
def bubble_sort(arr):
    n = len(arr)
    # Bubble sort implementation
    for i in range(n):
        swapped = False
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                swapped = True
        if not swapped:
            break
    return arr

# --- 测试用例 ---
if __name__ == "__main__":
    # 待排序数组
    data = [64, 34, 25, 12, 22, 11, 90]
    print(f"原始数组: {data}")

    # 执行排序
    sorted_data = bubble_sort(data.copy()) # 使用副本进行排序
    print(f"排序后数组: {sorted_data}")