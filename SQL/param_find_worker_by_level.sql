SELECT w.id          id,
       w.level       level,
       w.name        name,
       w.birthday    birthday,
       w.salary      salary
 FROM worker w
WHERE LOWER(w.level) LIKE LOWER('%' || ? || '%')
ORDER BY salary desc;