<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<LINK rel=stylesheet type=text/css href="${rt}/layui/css/layui.css">
<LINK rel=stylesheet type=text/css href="${rt}/css/style.css">
<style type="text/css">
    .code{vertical-align: middle;height: 25px;cursor: pointer}
</style>
<META name=GENERATOR content="MSHTML 8.00.7601.17514">
</HEAD>
<BODY>
<DIV id=header class=wrap>
    <DIV id=logo><IMG src="../images/logo.gif"></DIV>
</DIV>
<DIV id=regLogin class=wrap>
    <DIV class=dialog>
        <DIV class=box>
            <H4>用户登录</H4>
            <FORM id=user method=post name=user  class="layui-form" action="">
                <DIV class=infos>
                    <TABLE class=field>
                        <TBODY>
                        <TR>
                            <TD colSpan=2></TD>
                        </TR>
                        <TR>
                            <TD class=field>用 户 名：</TD>
                            <TD><!-- <input type="text" class="text" name="name" /> -->
                                <INPUT  id=user_name class=text value="admin" lay-verType="tips" lay-verify="username" type=text name="userName"></TD>
                        </TR>
                        <TR>
                            <TD class=field>密　　码：</TD>
                            <TD><!-- <input type="password" class="text" name="password" /> -->
                                <INPUT id=user_password class=text value="111111" lay-verType="tips" lay-verify="pass" type=password name="password"></TD>
                        </TR>
                        <tr>
                            <td class="field">验 证 码：</td>
                            <td class="very">
                                <input type="text" id="verycode" lay-verType="tips" lay-verify="verycode" class="text verycode" name="veryCode" />
                                <img  class="code"  alt="" src="../code.jpg">
                                <a href="javascript:void(0);">看不清?</a>
                            </td>
                        </tr>

                        </TBODY>
                    </TABLE>
                    <input type="hidden" id="rt" value="${rt}">
                    <DIV class=buttons><INPUT value=登陆  lay-submit lay-filter="login" type=button>
                        <INPUT onclick='document.location="regs.jsp"' value=注册 type=button>
                    </DIV>
                </DIV>
            </FORM>
        </DIV>
    </DIV>
</DIV>
<DIV id=footer class=wrap>
    <DL>
        <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
        <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
    </DL>
</DIV>

<script type="application/javascript" src="${rt}/layui/layui.js"></script>
<script type="application/javascript" src="${rt}/js/login.js">


</script>
</BODY>
</HTML>
