<#import "Parts/common.ftlh" as c>
<@c.page>

    <div class="row align-items-center">
        Фильтрация
        <form action="/main" method="get">
            <div class="m-3">
                <label for="filter">Фильтр</label>
                <input type="text" name="filter" id="filter" value="${filter}">
                <button type="submit" class="btn btn-primary">Найти</button>
            </div>
        </form>
    </div>

    <p class="d-inline-flex gap-1">
        <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false"
           aria-controls="collapseExample">
            Новое сообщение
        </a>
    </p>
    <div class="collapse" id="collapseExample">
        <div class="card card-body">
            <div class="row align-items-center">
                <form method="post" action="/main" enctype="multipart/form-data">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <div class="m-3">
                        <lable id="name">Сообщение</lable>
                        <input type="text" name="text" id="name" placeholder="Текст сообщения">
                    </div>
                    <div class="m-3">
                        <lable id="name">Тэг</lable>
                        <input type="text" name="tag" placeholder="Тэг">
                    </div>
                    <div class="m-3">
                        <input class="form-control" type="file" name="file" id="formFile">
                    </div>
                    <button type="submit" class="btn btn-primary">Отправить</button>
            </div>
            </form>
        </div>
    </div>
    </div>

    <div>Список сообщений</div>
    <div>
        <#list messages as message>
            <div>
                <b>${message.id}</b>
                <span>${message.text}</span>
                <i>${message.tag}</i>
                <strong>${message.author.username}</strong>
                <div>
                    <#if message.filename??>
                        <img src="/img/${message.filename}" alt="">
                    </#if>
                </div>
            </div>
        <#else>
            Нет сообщений
        </#list>
    </div>

</@c.page>