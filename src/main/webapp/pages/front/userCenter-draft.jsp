<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!-- /.tab-pane -->
<div class="tab-pane" id="draft">
    <!-- .box-body -->
    <div class="box-body">
        <!-- 数据表格 -->
        <div class="table-box">
            <!--数据列表-->
            <table id="draftDataList" class="table table-bordered table-striped table-hover dataTable" style="text-align: center">
                <thead>
                <tr>
                    <th>辩题</th>
                    <th>学校</th>
                    <th>类型</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${draftList}" var="draft">
                    <tr>
                        <td><a href="javascript:window.open('${pageContext.request.contextPath}/draft/reading?did=${draft.did}')">${draft.draftname}</a></td>
                        <td>${draft.draftschool}</td>
                        <td>${draft.drafttype}</td>

                        <td class="text-center">
                            <button class="btn glyphicon glyphicon-download-alt" onclick="window.location.href='${draft.address}'"></button>
                            <button class="btn glyphicon glyphicon-pencil" onclick="window.location.href='${pageContext.request.contextPath}/userCenter/draftRevise?did=${draft.did}'" ></button>
                            <button class="btn glyphicon glyphicon-trash" onclick="draftRefresh('${pageContext.request.contextPath}/userCenter/draftDelete?did=${draft.did}')"></button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <!--数据列表/-->
        </div>
        <!-- 数据表格 /-->
    </div>
    <!-- /.box-body -->
</div>
<!-- /.tab-pane -->