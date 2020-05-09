<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="tab-pane" id="information">
    <div class="box-body">
        <strong>用户名</strong>
        <i class="text-muted">
            &emsp;&emsp;
            ${loginUser.username}
        </i>
        <hr>
        <strong>昵称</strong>
        <i class="text-muted">
            &emsp;&emsp;&emsp;
            ${loginUser.nickname}
        </i>
        <hr>
        <strong>性别</strong>
        <i class="text-muted">
            &emsp;&emsp;&emsp;
            ${loginUser.sex}
        </i>
        <hr>
        <strong>电话</strong>
        <i class="text-muted">
            &emsp;&emsp;&emsp;
            ${loginUser.phonenum}
        </i>
        <hr>
        <strong>邮箱</strong>
        <i class="text-muted">
            &emsp;&emsp;&emsp;
            ${loginUser.email}
        </i>
        <hr>
        <strong>生日</strong>
        <i class="text-muted">
            &emsp;&emsp;&emsp;
            ${loginUser.birthday}
        </i>
        <hr>
        <strong>简介</strong>
        <i class="text-muted">
            &emsp;&emsp;&emsp;
            ${loginUser.notes}
        </i>
        <hr>
        <strong>住址</strong>
        <i class="text-muted">
            &emsp;&emsp;&emsp;
            ${loginUser.address}
        </i>
        <hr>
        <button class="btn btn-danger" onclick="informationRefresh('${pageContext.request.contextPath}/userCenter/informationRevise')">修改</button>
    </div>
</div>