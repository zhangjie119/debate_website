<%@ page import="com.debateweb.entity.User" %>
<%@ page import="static javax.swing.text.html.CSS.getAttribute" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 92564
  Date: 2020/3/23
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
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
                <a href="${pageContext.request.contextPath}/pages/front/video-search.jsp">辩论赛视频</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/pages/front/draft_search.jsp">辩论稿搜索</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/RandS/findAll">辩论规则技巧</a>
            </li>
            <li>
                <a href="#" data-toggle="tab">辩论新闻</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/forum/main">论坛</a>
            </li>
            </div>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- Messages: style can be found in dropdown.less-->
                    <li class="dropdown messages-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-envelope-o"></i>
                            <span class="label label-success">4</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有4个邮件</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li>
                                        <!-- start message -->
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="${pageContext.request.contextPath}/img/user2.jpg" class="img-circle" alt="User Image">
                                            </div>
                                            <h4>
                                                系统消息
                                                <small><i class="fa fa-clock-o"></i> 5 分钟前</small>
                                            </h4>
                                            <p>欢迎登录系统?</p>
                                        </a>
                                    </li>
                                    <!-- end message -->
                                    <li>
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="${pageContext.request.contextPath}/img/user3.jpg" class="img-circle" alt="User Image">
                                            </div>
                                            <h4>
                                                团队消息
                                                <small><i class="fa fa-clock-o"></i> 2 小时前</small>
                                            </h4>
                                            <p>你有新的任务了</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="${pageContext.request.contextPath}/img/user4.jpg" class="img-circle" alt="User Image">
                                            </div>
                                            <h4>
                                                Developers
                                                <small><i class="fa fa-clock-o"></i> Today</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="${pageContext.request.contextPath}/img/user3.jpg" class="img-circle" alt="User Image">
                                            </div>
                                            <h4>
                                                Sales Department
                                                <small><i class="fa fa-clock-o"></i> Yesterday</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <div class="pull-left">
                                                <img src="${pageContext.request.contextPath}/img/user4.jpg" class="img-circle" alt="User Image">
                                            </div>
                                            <h4>
                                                Reviewers
                                                <small><i class="fa fa-clock-o"></i> 2 days</small>
                                            </h4>
                                            <p>Why not buy a new awesome theme?</p>
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">See All Messages</a></li>
                        </ul>
                    </li>
                    <!-- Notifications: style can be found in dropdown.less -->
                    <li class="dropdown notifications-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-bell-o"></i>
                            <span class="label label-warning">10</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有10个新消息</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-users text-aqua"></i> 5 new members joined today
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-warning text-yellow"></i> Very long description here that may not
                                            fit into the page and may cause design problems
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-users text-red"></i> 5 new members joined
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-shopping-cart text-green"></i> 25 sales made
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-user text-red"></i> You changed your username
                                        </a>
                                    </li>
                                </ul>
                            </li>
                            <li class="footer"><a href="#">View all</a></li>
                        </ul>
                    </li>
                    <!-- Tasks: style can be found in dropdown.less -->
                    <li class="dropdown tasks-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="fa fa-flag-o"></i>
                            <span class="label label-danger">9</span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="header">你有9个新任务</li>
                            <li>
                                <!-- inner menu: contains the actual data -->
                                <ul class="menu">
                                    <li>
                                        <!-- Task item -->
                                        <a href="#">
                                            <h3>
                                                Design some buttons
                                                <small class="pull-right">20%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-aqua" style="width: 20%" role="progressbar" aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">20% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                    <li>
                                        <!-- Task item -->
                                        <a href="#">
                                            <h3>
                                                Create a nice theme
                                                <small class="pull-right">40%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-green" style="width: 40%" role="progressbar" aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">40% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                    <li>
                                        <!-- Task item -->
                                        <a href="#">
                                            <h3>
                                                Some task I need to do
                                                <small class="pull-right">60%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-red" style="width: 60%" role="progressbar" aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">60% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                    <li>
                                        <!-- Task item -->
                                        <a href="#">
                                            <h3>
                                                Make beautiful transitions
                                                <small class="pull-right">80%</small>
                                            </h3>
                                            <div class="progress xs">
                                                <div class="progress-bar progress-bar-yellow" style="width: 80%" role="progressbar" aria-valuenow="20"
                                                     aria-valuemin="0" aria-valuemax="100">
                                                    <span class="sr-only">80% Complete</span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                    <!-- end task item -->
                                </ul>
                            </li>
                            <li class="footer">
                                <a href="#">View all tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- User Account: style can be found in dropdown.less -->
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
                                    <a href="${pageContext.request.contextPath}/pages/back/backstage_main.jsp" class="btn btn-default btn-flat">后台管理系统</a>
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