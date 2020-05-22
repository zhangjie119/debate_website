<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<header class="main-header">

    <!-- Logo -->
    <a href="${pageContext.request.contextPath}/index.jsp" class="logo">
        <span><b>三狗一男辩论网</b></span>
    </a>


    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <ul>
            <div  class="nav navbar-nav">
            <li>
                <a href="${pageContext.request.contextPath}/pages/front/videoPages/video-search.jsp">辩论赛视频</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/pages/front/draftPages/draft_search.jsp">辩论稿搜索</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/RandS/findAll">规则与赛事</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/forum/main">论坛</a>
            </li>
            </div>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <c:if test="${empty loginUser}">
                        <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="${pageContext.request.contextPath}/img/user0.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">未登录</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="${pageContext.request.contextPath}/img/user0.jpg" class="img-circle" alt="User Image">
                                <p>
                                    当前未登录
                                </p>
                            </li>
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="${pageContext.request.contextPath}/pages/login.jsp" class="btn btn-default btn-flat">登录</a>
                                </div>
                                <div class="pull-right">
                                    <a href="${pageContext.request.contextPath}/pages/register.jsp" class="btn btn-default btn-flat">注册</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    </c:if>
                    <c:if test="${not empty loginUser}">
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="${pageContext.request.contextPath}/img/user${loginUser.headpicture}.jpg" class="user-image" alt="UserImage">
                            <span class="hidden-xs">${loginUser.nickname}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="${pageContext.request.contextPath}/img/user${loginUser.headpicture}.jpg" class="img-circle" alt="UserImage">

                                <p>
                                    ${loginUser.nickname}
                                    </p>
                            </li>
                            <!-- Menu Body -->

                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <c:if test="${loginUser.isadmin == true}">
                                    <a href="${pageContext.request.contextPath}/pages/back/backstage_main.jsp" class="btn btn-default btn-flat">管理系统</a>
                                    </c:if>
                                    <c:if test="${loginUser.isadmin == false}">
                                    <a href="${pageContext.request.contextPath}/userCenter/main" class="btn btn-default btn-flat">个人中心</a>
                                    </c:if>
                                </div>
                                <div class="pull-right">
                                    <a href="${pageContext.request.contextPath}/user/logout" class="btn btn-default btn-flat">注销</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    </c:if>
                </ul>
            </div>
        </ul>
    </nav>
</header>