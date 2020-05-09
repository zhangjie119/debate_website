<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="active tab-pane" id="video">
    <div class="box-body" >
        <!-- 数据表格 -->
        <div class="table-box">
            <!--数据列表-->
            <table id="videoDataList" class="table table-bordered table-striped table-hover dataTable" style="text-align: center">
                <thead>
                <tr>
                    <th>辩题</th>
                    <th>赛事</th>
                    <th>正方</th>
                    <th>反方</th>
                    <th>明星辩手</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${videoList}" var="video">
                    <tr>
                        <td>${video.debatesubject}</td>
                        <td>${video.racename}</td>
                        <td>${video.pros}</td>
                        <td>${video.cons}</td>
                        <td>${video.stardebater}</td>
                        <td class="text-center">
                            <button class="btn glyphicon glyphicon-play" onclick="window.open('${video.address}')" ></button>
                            <button class="btn glyphicon glyphicon-pencil" onclick="window.location.href='${pageContext.request.contextPath}/userCenter/videoRevise?vid=${video.vid}'" ></button>
                            <button class="btn glyphicon glyphicon-trash" onclick="videoRefresh('${pageContext.request.contextPath}/userCenter/videoDelete?vid=${video.vid}')" ></button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <!--数据列表/-->
        </div>
        <!-- 数据表格 /-->
    </div>
</div>
<!-- /.tab-pane -->