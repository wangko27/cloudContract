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
                    <a class="navbar-brand" href="${pageContext.request.contextPath}">
                        vi8 application
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
                    <!-- Logged user is admin -->
                    <!-- Article title -->
                    <h2>${it.entity.article.title}</h2>
                    <!-- Show Edit/Delete links -->
                    <a href="${it.entity.article.id}" class="btn btn-info btn-xs" type="button">
                        <i class="glyphicon glyphicon-edit"></i>
                        编辑
                    </a>
                    <a href="${it.entity.article.id}" class="btn btn-danger btn-xs" type="button" id="delete-article">
                        <i class="glyphicon glyphicon-exclamation-sign"></i>
                        删除
                    </a>
                    <br>
                    <br>
                    <!-- Article category and tags -->
                    <div class="category-tags text-muted">
                        <hr>
                        <small>
                            <a id="author" href="/PortalApplication/user/1">
                                <strong>admin</strong>
                            </a>
                            &nbsp;
                            <fmt:formatDate value="${it.entity.article.lastModified}" type="both"/>
                            &nbsp;|&nbsp;

                            <a href="/category/${it.entity.article.category.name}">
                                ${it.entity.article.category.name}
                            </a>
                        </small>
                        <hr>
                    </div>
                    <!-- View count, last modified -->
                    <small class="text-muted">
                        <i class="glyphicon glyphicon-check"></i>
                        查看:${it.entity.article.viewCount}
                    </small>
                    <!-- Article content -->
                    <div class="article-content">
                        ${it.entity.article.content}
                    </div>
                    <hr>
                    <!-- Comments-message -->
                    <h3 id="comments" class="comment-message">评论: <span id="comment-count">${it.entity.article.commentCount}</span></h3>
                    <!-- Message for not registered users -->
                    <!-- Add comment form -->
                    <form data-toggle="validator" onsubmit="return false">
                        <h4><span id="comment-validation" class="label label-danger"></span></h4>
                        <textarea id="comment-content" class="form-control" name="content" maxlength="500" rows="2" required="" placeholder="请输入留言内容"></textarea>
                        <button id="commentSubmit" class="btn btn-default" type="submit" disabled="disabled">
                            发送
                        </button>
                        <button id="reset" class="btn btn-default" type="reset">
                            重置
                        </button>
                    </form>
                    <!-- List of comments -->
                    <div id="comment-list"><div class="comment" style="display: block;"><a href="/PortalApplication/user/1"><strong>admin</strong></a>&nbsp;&nbsp;-&nbsp;&nbsp;<small><i class="glyphicon glyphicon-time"></i>&nbsp;May 30, 2015 12:46:57 PM</small><br>fdfdfd</div><div class="comment" style="display: block;"><a href="/PortalApplication/user/1"><strong>admin</strong></a>&nbsp;&nbsp;-&nbsp;&nbsp;<small><i class="glyphicon glyphicon-time"></i>&nbsp;May 30, 2015 12:46:57 PM</small><br>dfdfd</div>

                    </div>

                    <script type="text/javascript" src="/PortalApplication/resources/js/app/inputs.js"></script>
                    <script>
                        // add comment ajax-request
                        $("#commentSubmit").click(function () {
                            var content = $("#comment-content").val();
                            $.post('/PortalApplication/article/44/addcomment',
                                    {"articleId": "44", "content": content}, function (response) {
                                if (response === "ok") {
                                    $("#comment-content").val("");
                                    $("#comment-list")
                                            .prepend("<div class='comment'><a href='/PortalApplication/user/1'>"
                                                    + "<strong>admin</strong></a>"
                                                    + "&nbsp;&nbsp;-&nbsp;&nbsp;<small><i class='glyphicon glyphicon-time'></i>"
                                                    + "&nbsp;May 30, 2015 12:46:57 PM"
                                                    + "</small><br>" + content + "</div>")
                                            .children(':first').hide().fadeIn(1500);
                                    var count = $("#comment-count").text();
                                    if (count === "") {
                                        $("h3#comments").html("评论: "
                                                + "<span id='comment-count'>1</span>");
                                    } else {
                                        $("#comment-count").text(++count);
                                    }
                                } else {
                                    $("#comment-validation").text(response).show().delay(1500).fadeOut(1500);
                                }
                            });
                            return false;
                        });

                        $("#delete-article").click(function () {
                            var message = "cn" === "ru"
                                    ? "Вы уверены?"
                                    : "Are you sure?";
                            if (confirm(message)) {
                                location.href = "/PortalApplication/article/44/delete";
                            }
                            ;
                            return false;
                        });
                    </script>

                </div>
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
                                <c:forEach var="category" items="${categories}">
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
                            <c:forEach var="tag" items="${tags}">
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
