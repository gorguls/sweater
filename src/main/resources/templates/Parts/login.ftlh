<#macro login path isRegisterForm>

    <form action="${path}" method="post">

        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <div class="mb-3">
            <label for="username" class="form-lable">Username : </label>
            <div class="col-sm-10">
                <input type="text" name="username" id="username" class="form-control" />
            </div>
        </div>
        <div class="mb-3">
            <label for="password" class="form-lable">Password: </label>
            <div class="col-sm-10">
                <input type="password" name="password" id="password" class="form-control"/>
            </div>
        </div>
        <div>
            <button type="submit" class="btn btn-primary"><#if isRegisterForm>Sign on<#else>Sign in</#if></button>
        </div>
    </form>
   <#if !isRegisterForm><a href="/registration">Зарегистрироваться</a></#if>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Выйти</button>
    </form>
</#macro>