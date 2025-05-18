<#import "Parts/common.ftlh" as c>
<#import "Parts/login.ftlh" as l>
<@c.page>
 <#if message??>${message}</#if>
    <@l.login "/registration" />
</@c.page>