# 문제

```
동물 보호소에 가장 먼저 들어온 동물의 이름을 조회하는 SQL 문을 작성해주세요.
```

# 풀이

```sql
SELECT NAME
FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1
```

상위 n개 원소 조회시 LIMIT 사용


