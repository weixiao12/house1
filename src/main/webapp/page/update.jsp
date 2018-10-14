<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<LINK rel=stylesheet type=text/css href="../css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>修改房屋信息发布</DT>
</DL>
<DIV class=box>
<FORM id=add_action method="post"  action="${rt}/house/update.html">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>标　　题：</TD>
    <TD><INPUT id=add_action_title class=text type=text name="title" value="${house.title}"> </TD></TR>
  <TR>
    <TD class=field>户　　型：</TD>
    <TD>
      <SELECT name="houseType.htypeId" class=text >
      <OPTION selected value="">不限</OPTION>
      <c:forEach items="${hts}" var="houseType">
        <OPTION <c:if test="${houseType.htypeId==house.houseType.htypeId}">selected</c:if> value="${houseType.htypeId}">${houseType.htypeName}</OPTION>
      </c:forEach>
    </SELECT>
    </TD></TR>
  <TR>
    <TD class=field>面　　积：</TD>
    <TD><INPUT id=add_action_floorage class=text type=text name="floorage" value="${house.floorage}"></TD></TR>
  <TR>
    <TD class=field>价　　格：</TD>
    <TD><INPUT id=add_action_price class=text type=text name="price" value="${house.price}"> </TD></TR>
  <TR>
    <TD class=field>房产证日期：</TD>
    <TD><INPUT id="pubDate"  class=text type=text name="pubdate" value='<fmt:formatDate value="${house.pubdate}" pattern="yyyy-MM-dd"/>'></TD></TR>
  <TR>
    <TD class=field>位　　置：</TD>
    <TD>区：<SELECT class=text name="street.district.districtId" id="district">
               <OPTION selected value="">请选择</OPTION>
            </SELECT>
      街：<SELECT class=text  name="street.streetId" id="street">
              <OPTION selected value="${house.street.streetId}">${house.street.streetName}</OPTION>
          </SELECT>
    </TD></TR><!--
						<tr>
							<td class="field">坐  标：</td>
							<td><input type="text" class="text" name="point" />
							</td>
						</tr>
						--><!--  <tr>
							<td class="field">Y 坐  标：</td>
							<td><input type="text" class="text" name="point.y" /></td>
						</tr>-->
  <TR>
    <TD class=field>联系方式：</TD>
    <TD><INPUT id=add_action_contact class=text type=text name="contact" value="${house.contact}"> </TD></TR>
  <TR>
    <TD class=field>详细信息：</TD>
    <TD><TEXTAREA name="description">${house.description}</TEXTAREA></TD></TR></TBODY></TABLE>
<DIV class=buttons><INPUT  value="修改" type="submit">
</DIV></DIV>
  <input type="hidden" value="${house.houseId}" name="houseId">
  <input type="hidden" id="districtId" value="${house.street.district.districtId}">
  <%-- 获取项目根路径 --%>
  <input type="hidden" id="rt" value="${rt}">
</FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
<script type="application/javascript" src="${rt}/layui/layui.js"></script>
<script src="${rt}/js/jquery-1.12.4.js"></script>
<script src="${rt}/js/update.js"></script>
