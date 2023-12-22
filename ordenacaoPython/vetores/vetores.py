import random

def list_create(tamanho):
    return [random.randint(1, 1000) for _ in range(tamanho)]

list_100 = list_create(100)
list_500 = list_create(500)
list_1k = list_create(1000)
list_5k = list_create(5000)
list_30k = list_create(30000)
list_80k = list_create(80000)
list_100k = list_create(100000)
list_150k = list_create(150000)
list_200k = list_create(200000)