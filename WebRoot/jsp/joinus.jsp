<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>joinus page</title>

<link rel="stylesheet" href="css/joinus.css" />

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>

	<form action='UserInfo_saveUserInfo'  class="login"  method="post">
    <div class='title'>加入我们</div>
    <hr class='line'>
    <div class='row' class='row1'>
      <div class="fieldabel">姓名</div>
      <input type="text" class="field" name="userName" />
    </div>

    <div class='row'>
      <div class="fieldabel">学号</div>
      <input type="text" class="field" name="userSId" />
    </div>

    <div class='row'>
      <div class="fieldabel">专业</div>
      <input type="text" class="field" name="userMajor" />
    </div>

    <div class='row'>
      <div class="fieldabel">班级</div>
      <input type="text" class="field" name="userClass" />
    </div>

    <div class='row'>
      <div class="fieldabel">手机号</div>
      <input type="text" class="field" name="userPhone" />
    </div>

    <div class='row'>
      <div class="fieldabel">邮箱</div>
      <input type="text" class="field" name="userEmail" />
    </div>

    <div class='bigrow'>
      <div class="bigfieldabel">个人简介</div>
      <textarea class="bigfield" name="userIntroduce" placeholder="不超过50字喵~"></textarea>
    </div>

    <div class="foot">
      <button type="submit" class="button1">提交</button>
      <button type="reset" class="button2">重置</button>
    </div>

  </form>

  </body>
</html>
