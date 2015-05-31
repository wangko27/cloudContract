<%-- 
    Document   : add
    Created on : 2015-5-30, 17:38:09
    Author     : youyou
--%>
<%-- 
    Document   : details
    Created on : 2015-5-30, 12:32:20
    Author     : youyou
--%>
<%-- 
    Document   : index
    Created on : 2015-5-28, 22:16:06
    Author     : youyou
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <div class="col-xs-9">
                    <form method="post" action="${pageContext.request.contextPath}/article/create" data-toggle="validator">
                        <!-- Article title -->
                        <div class="form-group">
                            <input id="article-title" name="title" type="text" class="form-control" maxlength="100"
                                   placeholder="文章标题"
                                   required data-error=""/>
                        </div>
                        <!-- Article category -->
                        <div class="form-group">
                            <select id="category" class="form-control" name="categoryName">
                                <option disabled="disabled" selected="selected">
                                    栏目
                                </option>
                                <c:forEach var="category" items="${it.entity.categories}">
                                    <option><c:out value="${category.name}" /></option>
                                </c:forEach>
                            </select>
                        </div>
                        <!-- Article tags -->
                        <input id="tags" type="text" name="tagString"
                               class="form-control" placeholder="标签"/>
                        <!-- Article preview -->
                        <div class="form-group">
                            <div class="help-block with-errors"></div>
                            <textarea class="form-control" name="preview" rows="2" maxlength="255"
                                      placeholder="预览"
                                      required data-error="验证信息"></textarea>
                        </div>

                        <!-- Article content -->
                        <div class="form-group">
                            <h4><form:errors path="content" class="label label-danger" /></h4>
                            <div class="help-block with-errors"></div>
                            <textarea id="summernote" name="content">内同</textarea>
                        </div>

                        <!-- Buttons -->
                        <button class="btn btn-primary" type="submit">保存</button>
                        <a class="btn btn-default" href="#">
                            取消
                        </a>
                    </form>
                </div>
                <!--//col9 END-->
                <div class = "col-xs-3" >
                    <!-- Add article url -->
                    <h4><a href="#">添加文章</a></h4>
                    <hr>
                    <!-- About -->
                    <div class="sidebar-module">
                        <h4>关于我们</h4>
                        <p>Some info about this portal.</p>
                    </div>
                    <hr>

                    <!-- Categories -->
                    <div class="panel panel-default">
                        <div class="panel-heading">栏目列表</div>
                        <div class="panel-body">
                            <ol class="list-unstyled">
                                <c:forEach var="category" items="${it.entity.categories}">
                                    <li>
                                        <a class="sidebar-categories" href="#">
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/app/article/add.js"/></script>
<script>
    // Summernote editor

    $('#summernote').summernote({
        height: 400,
        //lang: "zh_CN",
        onImageUpload: function (files, editor, welEditable) {
            sendFile(files[0], editor, welEditable);
        }
    });

    // Set article category selected for article-edit
    if ("${category}" !== "") {
        $("select#category").val("${category}");
    }
</script>
</body>
</html>

