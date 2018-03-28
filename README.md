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
* получение истории контента
* удаление элемента контента (по заданному идентификатору элемента контента)
* обновление контента
* поиск контента

### Работа с дочерними элементами контента
* получение дочерних комментариев
* получение дочерних вложений
* получение дочерних страниц (непосредственно имеющих родителем указанную страницу)
* REST wrapper для ChildContentService для случая когда Depth = ALL (незакончен, но есть рабочая заготовка, сейчас берутся только непосредственные дочерние элементы)
  * get Descendants (получение Map из дочерних элементов)
  * get Descendants of type (получение непосредственных дочерних элементов, отобранных по типу)

### Работа с вложениями
* добавление вложения
* обновление тела вложения (добавление новой версии файла-вложения с тем же именем)
* обновление сопровождающих данных вложения: 
    * имени файла-вложения
    * media-type
    * комментария
    * родительского контейнера вложения
    
### Работа с метками
* добавление списка меток
* получение списка меток
* удаление меток (todo: проверить работу функции для меток содержащих различные спец. символы ("/", "\\" и др.))

### Работа со свойствами контента (content properties)
Доступны CRUD-функции работы со свойствами контента: 

* Find all - GET /rest/content/{id}/property
* Create - POST /rest/content/{id}/property
* Find by key - GET /rest/content/{id}/property/{key}
* Update - PUT /rest/content/{id}/property/{key}
* Delete - DELETE /rest/content/{id}/property/{key}
* Create - POST /rest/content/{id}/property/{key}


### Работа с ограничениями (restriction)
Ограничения устанавливаются пользователями и отпределяют какие пользователи и/или группы могут просматривать/редактировать данный элемент контента
* получение ограничений установленный для данного элемента контента
* получение ограничений установленных для данного элемента контента отобранных по типу ограничения (read, update)

### Работа с шаблонами (blueprints)
* publishLegacyDraftOfBlueprint (не тестировал работу)
* publishSharedDraftOfBlueprint (не тестировал работу)

### Конвертация тела контента между различными форматами
Функция выполняет преобразования между различными представления тела контента.

Принимает параметром тело контента и формат в который мы хотим преобразовать контент.

Возвращается преобразованное тело контента в требуемом формате.

Но при этом свободной конвертации между любыми форматами нет.

Доступны только преобразования перечисленные в таблице:

|Source Representation|Destination Representation Supported   |
|---|---|
| storage  | 	view, export_view, styled_view, editor  |
| editor  |  storage |
|  view | None  |
|  export_view | None  |
|  styled_view | None  |

Вызов осуществляется через запрос POST contentbody/convert/{to}

### Работа с макросами
* получение для определённой версии, определенного контента, макроса с параметрами и телом макроса
    * по идентификатору макроса
    * по хешу макроса (функция для сохранения совместимости некоторых connect-приложений)
* получение для определённой версии контента тела макроса (по идентификатору этого макроса)

### Работа с группами и пользователями
* получить группы (список разбитый на страницы)
* получить группу по имени группы
* получить пользователей входящих в группу с указанным именем
### Поиск контента
* поиск по запросу CQL
* поиск по набору параметров, собираемых при помощи Conlfuence.SearchParams.builer() -- параметры (cql, limit, start, и др.)
### Управление наблюдателями
* наблюдает ли текущий пользователь за контентом с указанным id?
* наблюдает ли пользователь с указанным именем за контентом с указанным id?
* наблюдает ли пользователь с указанным userKey за контентом с указанным id?
* добавить текущего (отправляющего запрос) пользователя в качестве наблюдателя к контенту имеющему указанный ContentId 
* добавить в качестве наблюдателя контента с указанным id, пользователя с указанным username -- функция addWatcherByUserKey()
* добавить в качестве наблюдателя контента с указанным id, пользователя с указанным userKey -- функция addWatcherByUserKey()
* удалить текущего (отправляющего запрос) пользователя из списка наблюдателей контента с указанный ContentId 
* удалить из списка наблюдателей элемента контента, пользователя с указанным username -- функция addWatcherByUserKey()
* добавить в качестве наблюдателя контента с указанным id, пользователя с указанным userKey -- функция addWatcherByUserKey()
## Contributors
 
Alexander Pampushko
 
## License
 
BSD license