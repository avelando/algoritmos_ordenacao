import contextlib
import os
import timeit
from functools import partial
from vetores.vetores import *
from ordenacao.bubble_sort import bubble_sort
from ordenacao.insertion_sort import insertion_sort
from ordenacao.quick_sort import quick_sort
from ordenacao.selection_sort import selection_sort
from ordenacao.merge_sort import merge_sort
from ordenacao.counting_sort import counting_sort

algoritmos = [
    bubble_sort,
    insertion_sort,
    quick_sort,
    selection_sort,
    merge_sort,
    counting_sort
]

vetores = [
    # list_100,
    # list_500,
    # list_1k,
    list_5k,
    list_30k,
    list_80k,
    list_100k,
    list_150k,
    list_200k
]

for vetor in vetores:
    print("Vetor de tamanho: ", len(vetor))

    for algoritmo in algoritmos:
        print("Algoritmo: ", algoritmo.__name__)

        # Desative a saída padrão durante a execução
        with open(os.devnull, 'w') as fnull:
            with contextlib.redirect_stdout(fnull):
                # Utilize timeit para medir o tempo de execução
                tempo_execucao = timeit.timeit(lambda: algoritmo(vetor[:]), number=1)

        # Converta o tempo para milissegundos
        tempo_ms = tempo_execucao * 1000

        print("Tempo de execução: {:.4f} milissegundos".format(tempo_ms))
        print("Tempo de execução: {:.4f} segundos".format(tempo_execucao))
        print("")
