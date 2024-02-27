import time
import random

def bubble_sort(arr):
    n = len(arr)
    for i in range(n):
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

def selection_sort(arr):
    n = len(arr)
    for i in range(n):
        min_index = i
        for j in range(i+1, n):
            if arr[j] < arr[min_index]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]

def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key

def merge_sort(arr):
    if len(arr) > 1:
        mid = len(arr) // 2
        left_half = arr[:mid]
        right_half = arr[mid:]

        merge_sort(left_half)
        merge_sort(right_half)

        i = j = k = 0

        while i < len(left_half) and j < len(right_half):
            if left_half[i] < right_half[j]:
                arr[k] = left_half[i]
                i += 1
            else:
                arr[k] = right_half[j]
                j += 1
            k += 1

        while i < len(left_half):
            arr[k] = left_half[i]
            i += 1
            k += 1

        while j < len(right_half):
            arr[k] = right_half[j]
            j += 1
            k += 1

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr[0]
        less = [x for x in arr[1:] if x <= pivot]
        greater = [x for x in arr[1:] if x > pivot]
        return quick_sort(less) + [pivot] + quick_sort(greater)

def counting_sort(arr):
    if not arr:
        return arr
    
    max_value = max(arr)
    counting_array = [0] * (max_value + 1)

    for num in arr:
        counting_array[num] += 1

    sorted_array = []
    for i in range(len(counting_array)):
        sorted_array.extend([i] * counting_array[i])

    return sorted_array

def bucket_sort(arr, num_buckets):
    max_value = max(arr, default=0)
    bucket_size = max_value // num_buckets + 1
    buckets = [[] for _ in range(num_buckets)]

    start_time = time.time()
    for num in arr:
        bucket_index = num // bucket_size
        buckets[bucket_index].append(num)

    sorted_array = []
    for bucket in buckets:
        sorted_bucket = counting_sort(bucket)
        sorted_array.extend(sorted_bucket)

    bucket_time = (time.time() - start_time) * 1000
    return sorted_array, bucket_time

def run_tests(array_sizes, num_buckets):
    for size in array_sizes:
        data = [random.randint(1, 1000) for _ in range(size)]

        start_time = time.time()
        bubble_sort(data.copy())
        bubble_time = (time.time() - start_time) * 1000

        start_time = time.time()
        selection_sort(data.copy())
        selection_time = (time.time() - start_time) * 1000

        start_time = time.time()
        insertion_sort(data.copy())
        insertion_time = (time.time() - start_time) * 1000

        start_time = time.time()
        merge_sort(data.copy())
        merge_time = (time.time() - start_time) * 1000

        start_time = time.time()
        quick_sort(data.copy())
        quick_time = (time.time() - start_time) * 1000

        start_time = time.time()
        counting_sort(data.copy())
        counting_time = (time.time() - start_time) * 1000

        sorted_data, bucket_time = bucket_sort(data.copy(), num_buckets)

        print(f"== Tamanho do Vetor: {size} == {num_buckets} baldes usados ==")
        print(f"Bubble Sort - {bubble_time:.2f} ms ({bubble_time / 1000:.3f} s)")
        print(f"Selection Sort - {selection_time:.2f} ms ({selection_time / 1000:.3f} s)")
        print(f"Insertion Sort - {insertion_time:.2f} ms ({insertion_time / 1000:.3f} s)")
        print(f"Merge Sort - {merge_time:.2f} ms ({merge_time / 1000:.3f} s)")
        print(f"Quick Sort - {quick_time:.2f} ms ({quick_time / 1000:.3f} s)")
        print(f"Counting Sort - {counting_time:.2f} ms ({counting_time / 1000:.3f} s)")
        print()

if __name__ == "__main__":
    array_sizes = [100, 500, 1000, 5000, 30000, 80000, 100000, 150000, 200000]
    num_buckets = [5, 6, 7, 8, 10, 15, 18, 20, 50]
    for buckets in num_buckets:
        run_tests(array_sizes, buckets)