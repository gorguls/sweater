<#import "Parts/common.ftlh" as c>
<#import "Parts/login.ftlh" as l>
<@c.page>
    ${message}
    <@l.login "/registration" />
</@c.page>