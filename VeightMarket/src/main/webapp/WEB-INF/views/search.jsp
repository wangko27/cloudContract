<%-- 
    Document   : index
    Created on : 2015-5-28, 22:16:06
    Author     : youyou
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>管理员登录 - 云合同银行</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/summernote.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/tokenfield-typeahead.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-tokenfield.min.css"/>
        <!-- Application styles -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app/header.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app/signin-signup.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app/footer.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/app/common.css"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"/></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap-maxlength.min.js"/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap-tokenfield.min.js"/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/typeahead.jquery.min.js"/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bloodhound.min.js"/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/summernote.min.js"/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/summernote-ru-RU.js"/></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/validator.min.js"/></script>
</head>
<body>
    <div id = "wrap">
        <div class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">
                        首页
                    </a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="#">
                                首页
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                关于我们
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                联系我们
                            </a>
                        </li>
                    </ul>
                    <!-- Search form -->
                    <div class="col-xs-3">
                        <form class="navbar-form navbar-left" action="#" method="post"
                              data-toggle="validator">
                            <div class="input-group input-group-sm">
                                <input type="text" name="fragment" class="form-control" required
                                       placeholder="搜索">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="submit">Go!</button>
                                </span>
                            </div>
                        </form>
                    </div>

                    <!-- SignIn, SignUp, Profile, Logout -->
                    <ul class="nav navbar-nav navbar-right">
                        <li class="hide">
                            <a href="#">
                                <i class="glyphicon glyphicon-new-window"></i>
                                注册新用户
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                <i class="glyphicon glyphicon-log-in"></i>
                                登录
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <strong>
                                    wangko27
                                </strong>
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="个#">
                                        <i class="glyphicon glyphicon-user"></i>
                                        个人中心
                                    </a>
                                </li>
                                <li>
                                    <a href="退出">
                                        <i class="glyphicon glyphicon-off"></i>
                                        退出
                                    </a>
                                </li>
                            </ul>
                        </li>
                        <!-- Choose language -->
                        <li class="divider-vertical"></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class = "container" >
            <div class = "row" >
                <div class = "col-xs-9" >
                    <!--显示文章列表-->
                    <c:forEach var="article" items="${it.entity.page.content}">
                        <div class="article">
                            <!-- Show articles per page -->
                            <!-- Comment count -->
                            <h4 class="pull-right">
                                <a href="#comments">
                                    <i class="glyphicon glyphicon-comment"></i>
                                    ${article.commentCount}
                                </a>
                            </h4>

                            <!-- Article title -->
                            <h3><a href="${pageContext.request.contextPath}/article/${article.id}"> ${article.title}</a></h3>

                            <!-- Article category and tags -->
                            <div class="category-tags text-muted">
                                <hr>
                                <small>

                                    <a id="author" href="#">
                                        <strong>wangko27</strong>
                                    </a>
                                    <fmt:formatDate value="${article.lastModified}" type="both" />
                                    &nbsp;|&nbsp;
                                    <a href="#">
                                        ${article.category.name}
                                    </a>
                                    <c:forEach var="tag" items="${article.tags}">
                                        <a href="#">
                                            ${tag.name}
                                        </a>&nbsp;
                                    </c:forEach>
                                </small>
                                <hr>
                            </div>
                            <!-- Article preview -->
                            <p class="article-preview">
                                ${article.preview}
                                <a href="${pageContext.request.contextPath}/article/${article.id}">
                                    详细信息 &raquo;
                                </a>
                            </p>
                        </div>
                    </c:forEach>
                    <!--显示文章列表//END-->
                    <hr>
                    <h4>没有文章</h4>
                    <hr>
                </div>
                <div class = "col-xs-3" >
                    <!-- Add article url -->
                    <h4><a href="#">添加文章</a></h4>
                    <hr>
                    <!-- About -->
                    <div class="sidebar-module">
                        <h4>关于我们</h4>
                        <p>关于我们需要改成关于我.</p>
                    </div>
                    <hr>

                    <!-- Categories -->
                    <div class="panel panel-default">
                        <div class="panel-heading">栏目列表</div>
                        <div class="panel-body">
                            <ol class="list-unstyled">
                                <c:forEach var="category" items="${categories}">
                                    <li>
                                        <a class="sidebar-categories" href="${pageContext.request.contextPath}/search/category/${category.name}">
                                            ${category.name}
                                        </a>
                                        (${category.articleCount})
                                    </li>
                                </c:forEach>
                            </ol>
                        </div>
                    </div>
                    <hr>

                    <!-- Tags -->
                    <div class="panel panel-default">
                        <div class="panel-heading">标签</div>
                        <div class="panel-body">
                            <c:forEach var="tag" items="${it.entity.tags}">
                                <a class="sidebar-categories tag${tag.scale}" href="#"
                                   title="${tag.articleCount} articles">
                                    ${tag.name}
                                </a>
                            </c:forEach>
                        </div>
                    </div>
                    <hr>

                    <!-- Links -->
                    <div class="panel panel-default">
                        <div class="panel-heading">友情链接</div>
                        <div class="panel-body">
                            <ol class="list-unstyled">
                                <li><a href="https://github.com/oleg-filippov/newsportal">Project on GitHub</a></li>
                                <li><a href="http://hackerwins.github.io/summernote/">Summernote WYSIWYG editor</a></li>
                                <li><a href="http://twitter.github.io/typeahead.js/">Typeahead</a></li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="footer">
        <div class="container">
            &copy; (2014) <a href="${pageContext.request.contextPath}">Newsportal</a>.
            Design with <a href="http://getbootstrap.com/">Twitter Bootstrap</a> <span
                class="pull-right"><a href="#">Back to top</a></span>
        </div>
    </div>
</body>
</html>