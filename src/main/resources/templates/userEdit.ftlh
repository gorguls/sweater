<#import "Parts/common.ftlh" as c>
<@c.page>
    <h2>User edit form</h2>
    <form action="/user" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="hidden"  name="userId" value="${user.id}">
        <input type="text" name="username" value="${user.username}" >
        <#list roles as role>
            <div>
                <lable id="${role}">${role}</lable>
                <input type="checkbox" name="${role}" id="${role}" ${user.roles?seq_contains(role)?string("cheked", "")}>
            </div>
        </#list>
        <button type="submit">Сохранить</button>
    </form>
</@c.page>