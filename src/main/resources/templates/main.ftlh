<#import "Parts/common.ftlh" as c>
<#import "Parts/login.ftlh" as l>
<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">Список пользователей</a> </span>
</div>
<div>
    <form method="post" action="/main">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <lable id="name">Сообщение</lable>
        <input type="text" name="text" id="name" placeholder="Текст сообщения">
        <lable id="name">Тэг</lable>
        <input type="text" name="tag" placeholder="Тэг">
        <button type="submit">Отправить</button>
    </form>
</div>

<div>
    Фильтрация
    <form action="/main" method="get">
        <label for="filter">Фильтр</label>
        <input type="text" name="filter" id="filter" value="${filter}">
        <button type="submit">Найти</button>
    </form>
</div>

<div>Список сообщений</div>
<div>
   <#list messages as message>
    <div>
        <b>${message.id}</b>
        <span>${message.text}</span>
        <i>${message.tag}</i>
        <strong>${message.author.username}</strong>
    </div>
    <#else>
        Нет сообщений
    </#list>
</div>

</@c.page>