<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"  isELIgnored="false" %>

<!-- 导航侧栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user${loginUser.headpicture}.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${loginUser.nickname}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>
            <li id="admin-index"><a href="${pageContext.request.contextPath}/pages/back/backstage_main.jsp"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <li class="treeview"><a href="#"> <i class="fa fa-youtube-play"></i>
                <span>视频管理</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
								</span>


            </a>
                <ul class="treeview-menu">
                    <li id="vedio-list"><a href="${pageContext.request.contextPath}/video/findAll?page=1&size=5"> <i class="fa fa-circle-o"></i> 视频列表
                    </a></li>
                    <li id="vedio-add"><a href="${pageContext.request.contextPath}/pages/back/videoPages/video-add.jsp"> <i class="fa fa-circle-o"></i> 添加视频
                    </a></li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-file-text"></i>
                <span>稿件管理</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
								</span>
            </a>
                <ul class="treeview-menu">

                    <li id="draft-list"><a href="${pageContext.request.contextPath}/draft/findAll?page=1&size=5"> <i class="fa fa-circle-o"></i> 稿件列表
                    </a></li>
                    <li id="draft-add"><a href="${pageContext.request.contextPath}/pages/back/draftPages/draft-add.jsp"> <i class="fa fa-circle-o"></i> 稿件添加
                    </a></li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-gavel"></i>
                <span>规则管理</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
								</span>
            </a>
                <ul class="treeview-menu">
                    <li id="rule-list"><a href="${pageContext.request.contextPath}/rule/findAll">
                        <i class="fa fa-circle-o"></i> 规则列表
                    </a></li>
                    <li id="event-list"><a href="${pageContext.request.contextPath}/event/findAll">
                        <i class="fa fa-circle-o"></i> 赛事列表
                    </a></li>
                    <li id="rule-add"><a href="${pageContext.request.contextPath}/pages/back/rulePages/rule-add.jsp">
                        <i class="fa fa-circle-o"></i> 添加规则
                    </a></li>
                    <li id="event-add"><a href="${pageContext.request.contextPath}/pages/back/eventPages/event-add.jsp">
                        <i class="fa fa-circle-o"></i> 添加赛事
                    </a></li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-commenting"></i>
                <span>论坛管理</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
								</span>
            </a>
                <ul class="treeview-menu">
                    <li id="article-list"><a href="${pageContext.request.contextPath}/article/findAll?page=1&size=5">
                        <i class="fa fa-circle-o"></i> 帖子列表
                    </a></li>
                    <li id="plate-list"><a href="${pageContext.request.contextPath}/plate/findAll?page=1&size=8">
                        <i class="fa fa-circle-o"></i> 板块列表
                    </a></li>
                    <li id="article-check"><a href="${pageContext.request.contextPath}/article/check">
                        <i class="fa fa-circle-o"></i> 帖子审核
                    </a></li>
                </ul>
            </li>
            <li class="treeview"><a href="#"> <i class="fa fa-male"></i>
                <span>人员管理</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i>
								</span>
            </a>
                <ul class="treeview-menu">

                    <li id="user-manager"><a href="${pageContext.request.contextPath}/user/findAll?page=1&size=8">
                        <i class="fa fa-circle-o"></i> 用户管理
                    </a></li>
                    <li id="admin-manager"><a href="${pageContext.request.contextPath}/admin/findAll?page=1&size=8"> <i class="fa fa-circle-o"></i> 管理员管理
                    </a></li>

                </ul>
            </li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 -->