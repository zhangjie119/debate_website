<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<form class="form-horizontal" action="/userCenter/informationUpdate">
    <div class="form-group">
        <label for="nickName" class="col-sm-2 control-label">昵称</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="nickName" name="nickName" value="${loginUser.nickname}">
        </div>

    </div>
    <div class="form-group">
        <label for="sex" class="col-sm-2 control-label">性别</label>
        <div class="col-sm-10">
            <select id="sex" name="sex" class="form-control select2">
                <option <c:if test="${loginUser.sex eq '男'}"> selected="selected" </c:if> >男</option>
                <option <c:if test="${loginUser.sex eq '女'}"> selected="selected" </c:if> >女</option>
                <option <c:if test="${loginUser.sex eq '跨性别者'}"> selected="selected" </c:if> >跨性别者</option>
                <option <c:if test="${loginUser.sex eq '其他'}"> selected="selected" </c:if> >其他</option>
                <option <c:if test="${loginUser.sex eq '保密'}"> selected="selected" </c:if> >保密</option>
            </select>
        </div>

    </div>
    <div class="form-group">
        <label for="phoneNum" class="col-sm-2 control-label">电话</label>

        <div class="col-sm-10">
            <input type="tel" maxlength="11" class="form-control" id="phoneNum" name="phoneNum" value="${loginUser.phonenum}">
        </div>
    </div>
    <div class="form-group">
        <label for="email" class="col-sm-2 control-label">邮箱</label>

        <div class="col-sm-10">
            <input type="email" class="form-control" id="email" name="email" value="${loginUser.email}">
        </div>

    </div>
    <div class="form-group">
        <label for="birthday" class="col-sm-2 control-label">生日</label>

        <div class="col-sm-10">
            <input type="date" class="form-control" id="birthday" name="birthday" value="${loginUser.birthday}">
        </div>
    </div>
    <div class="form-group">
        <label for="notes" class="col-sm-2 control-label">简介</label>

        <div class="col-sm-10">
            <textarea class="form-control" id="notes" name="notes">${loginUser.notes}</textarea>
        </div>
    </div>
    <div class="form-group">
        <label for="address" class="col-sm-2 control-label">住址</label>

        <div class="col-sm-10">
            <input type="text" class="form-control" id="address" name="address" value="${loginUser.address}">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <br>
            <button type="submit" class="btn btn-danger">确认修改</button>

            <button type="button" class="btn btn-info" onclick="informationRefresh('${pageContext.request.contextPath}/userCenter/information')">放弃修改</button>
        </div>
    </div>
</form>