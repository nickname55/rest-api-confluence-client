## Описание проекта
 
REST-клиент для взаимодействия с Confluence
 
## Мотивация
 
Для интеграции с Confluence различных сервисов и быстрого переноса данных между различными инстансами Confluence

## Доступные функции
### Работа с областями
* получение списка всех областей
* создание области
* создание приватной (доступной только создателю) области
* удаление области
* обновление описания и/или имени области
### Работа с контентом
* получение контента (страниц, блогпостов) из определённой области
* получение контента по идентификатору
* добавление контента
### Работа с макросами
* получение для определённой версии контента тела макроса (по идентификатору этого макроса)
### Работа с группами и пользователями
* получить группы (список разбитый на страницы)
* получить группу по имени группы
* получить пользователей входящих в группу с указанным именем
### Поиск контента
* поиск по запросу CQL
* поиск по набору параметров, собираемых при помощи Conlfuence.SearchParams.builer() -- параметры (cql, limit, start, и др.)
### Управление наблюдателями
* наблюдает ли текущий пользователь за контентом с указанным id
* наблюдает ли пользователь с указанным именем за контентом с указанным id
* наблюдает ли пользователь с указанным userKey за контентом с указанным id
 
## Contributors
 
Alexander Pampushko
 
## License
 
BSD license