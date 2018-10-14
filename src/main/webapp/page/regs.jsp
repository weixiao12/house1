<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<LINK rel=stylesheet type=text/css href="${rt}/css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新用户注册</DT>
  <DD class=past>填写个人信息</DD></DL>
<DIV class=box>
<FORM  id="myForm">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><INPUT class=text type=text name="userName"> </TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><INPUT class=text type=password id="password" name="password"></TD></TR>
  <TR>
    <TD class=field>确认密码：</TD>
    <TD><INPUT class=text type=password id="repassword"> </TD></TR>
  <TR>
    <TD class=field>电　　话：</TD>
    <TD><INPUT class=text type=text name="telephone"> </TD></TR>
  <TR>
    <TD class=field>用户姓名：</TD>
    <TD><INPUT class=text type=text name="realName"> </TD></TR></TBODY></TABLE>
<DIV class=buttons>
<INPUT onclick="javascript:check()" value=立即注册 type=button>
  <%-- 获取项目根路径 --%>
  <input type="hidden" id="rt" value="${rt}">
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
<script src="${rt}/js/jquery-1.12.4.js"></script>
<script>
    function check() {
        var password = $("#password").val();
        var repassword  = $("#repassword").val();
        if( password != repassword ){
            alert("两次输入的密码不一致");
        }else {
            //注册
            var rt = $("#rt").val();
            var url = rt+"/user/reg.html";
            var param = $("#myForm").serialize();
            $.post( url, param, function (data) {
                alert("注册成功");
                if( data.result == "1003" ){
                        location.href = rt+"/page/login.jsp";
                }
            },"json" );

        }

    }

</script>
