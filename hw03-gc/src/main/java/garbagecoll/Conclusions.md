Статистика по трем сборщикам мусора CMS, G1, ParallelGC

Out of loop with OOM exception

 ParNew
 
| # min | gc call count | gc duration in ms |
|-------|:-------------:|------------------:|
|     1 |             1 |               751 |
|     3 |             1 |               251 |
|     6 |             1 |               334 |
|     8 |             1 |                 0 |
|    10 |             3 |                 0 |


ConcurrentMarkSweep                       

| # min | gc call count | gc duration in ms |
|-------|:-------------:|------------------:|
|     3 |             1 |              5427 |
|     4 |             8 |             42003 |
|     5 |             9 |             47800 |
|     6 |            14 |             25160 |
|     7 |            26 |              9175 |
|     8 |            24 |             10502 |
|     9 |            25 |             11788 |
|    10 |            36 |             32510 |
|    11 |            56 |             59564 |
|    12 |             7 |              7150 |



Out of loop with OOM exception


 G1 Young Generation   
 
| # min | gc call count | gc duration in ms |
|-------|:-------------:|------------------:|
|     0 |             3 |               130 |
|     1 |             2 |               157 |
|     2 |             1 |               108 |
|     3 |             1 |               125 |
|     4 |             1 |               130 |
|     5 |             1 |               144 |
|     6 |             2 |               261 |
|     7 |             2 |               160 |
|     8 |             3 |               155 |
|     9 |             5 |               313 |
|    10 |            12 |               176 |
|    11 |            10 |                 8 |


 G1 Old Generation                         
 
| # min | gc call count | gc duration in ms |
|-------|:-------------:|------------------:|
|     9 |             1 |               723 |
|    10 |            10 |              7480 |
|    11 |            19 |             14926 |


Out of loop with OOM exception

 PS MarkSweep                              
 
| # min | gc call count | gc duration in ms |
|-------|:-------------:|-----------------: |
|     6 |             1 |              1774 |
|     8 |             1 |               899 |
|     9 |             2 |              2094 |
|    10 |            46 |             54532 |
|    11 |             7 |              8419 |

 PS Scavenge                               
 
| # min | gc call count | gc duration in ms |
|-------|:-------------:|-----------------: |
|     1 |             1 |               126 |
|     2 |             1 |               192 |
|     4 |             1 |               191 |
|     6 |             1 |               186 |


На базе собранных статистических данных можно сделать вывод, 
что наибольшее время живучести показал сборщик CMS, 
но при этом среднее время сборки у него больше, чем
у остальных. Оптимальные показатели по среднему времени
затраченному на сборку и живучетси имеет сборщик G1.
Поэтому для данной задачи можно использовать либо CMS,
либо G1 в зависимости от требований. Если нужно максимальное
время работы то лучше применить CMS, если важна скорость
работы, то лучше применить G1
