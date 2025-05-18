<#macro login path>
    <form action="${path}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div>
            <label for="username">Username : </label>
            <input type="text" name="username" id="username"/>
        </div>
        <div>
            <label for="password">Password: </label>
            <input type="password" name="password" id="password"/>
        </div>
        <div><input type="submit" value="Sign In"/></div>
    </form>
</#macro>