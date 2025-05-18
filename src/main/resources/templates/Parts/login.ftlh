<#macro login path>
    <form action="${path}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div>
            <label> Username : </label>
            <input type="text" name="username"/>
        </div>
        <div>
            <label> Password:</label>
            <input type="password" name="password"/>
        </div>
        <div><input type="submit" value="Sign In"/></div>
    </form>
</#macro>