<%--
  Created by IntelliJ IDEA.
  User: 92564
  Date: 2020/5/7
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="tab-pane" id="article">
    <!-- .box-body -->
    <div class="box-body">
        <!-- 数据表格 -->
        <div class="table-box">
            <!--数据列表-->
            <table id="dataList" class="table table-bordered table-striped table-hover dataTable" style="text-align: center">
                <thead>
                <tr>
                    <th>标题</th>
                    <th>所属板块</th>
                    <th>发帖时间</th>
                    <th>审核状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${articleList}" var="article">
                    <tr>

                        <td><a href="${pageContext.request.contextPath}/forum/lookingArticle?fid=${article.fid}">${article.titles}</a></td>
                        <td>${article.bname}</td>
                        <td>${article.time}</td>
                        <td>
                            <c:if test="${article.status == 0}">
                                <div class="btn btn-warning">待审核</div>

                            </c:if>
                            <c:if test="${article.status == 1}">
                                <div class="btn btn-success">已通过</div>
                            </c:if>
                            <c:if test="${article.status == 2}">
                                <div class="btn btn-danger">未通过</div>
                            </c:if>
                        </td>
                        <div id="myModal${article.fid}" class="modal modal-primary" role="dialog">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title">${article.titles}</h4>
                                    </div>
                                    <div class="modal-body">
                                        <div class="box-body">
                                                ${article.fcontent}
                                        </div>
                                    </div>
                                </div>
                                <!-- /.modal-content -->
                            </div>
                            <!-- /.modal-dialog -->
                        </div>
                        <!-- /.modal -->

                        <td class="text-center">
                            <button type="button" class="btn glyphicon glyphicon-file" data-toggle="modal" data-target="#myModal${article.fid}"></button>
                            <button type="button" class="btn glyphicon glyphicon-trash" onclick="articleRefresh('${pageContext.request.contextPath}/userCenter/articleDelete?fid=${article.fid}')"></button>
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
