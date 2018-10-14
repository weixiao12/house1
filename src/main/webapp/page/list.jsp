<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<LINK rel=stylesheet type=text/css href="${rt}/css/style.css">
<META name=GENERATOR content="MSHTML 8.00.7601.17514"></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV></DIV>
<DIV id=navbar class=wrap>
<DL class="search clearfix">
  <FORM id="myForm" method=get action="${rt}/house/list.html">
  <DT>
  <UL>
    <LI class=bold>房屋信息</LI>
    <LI>标题：<INPUT class=text type=text name="title" value="${house.title}">
      <LABEL class=ui-blue>
        <INPUT onclick="doSubmit()" value=搜索房屋 type=button name=search>
      </LABEL>
    </LI></UL></DT>
  <DD>
  <UL>
    <LI class=first>价格 </LI>
    <LI>
      <SELECT name=priceScore>
            <OPTION selected value="">不限</OPTION>
          <OPTION <c:if test="${house.priceScore == '0-1000'}">selected</c:if> value=0-1000>1000元以下</OPTION>
            <OPTION <c:if test="${house.priceScore == '1000-3000'}">selected</c:if> value=1000-3000>1000元—3000元</OPTION>
            <OPTION <c:if test="${house.priceScore == '3000-1000000'}">selected</c:if> value=3000-1000000>3000元以上</OPTION>
    </SELECT>
    </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房屋位置</LI>
    <LI><SELECT id=street name="street.streetId">
          <OPTION selected  value="">不限</OPTION>
          <c:forEach items="${sts}" var="street">
            <OPTION <c:if test="${house.street.streetId == street.streetId}">selected</c:if> value="${street.streetId}">${street.streetName}</OPTION>
          </c:forEach>

        </SELECT> </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>房型</LI>
    <LI><SELECT name="houseType.typeId">
      <OPTION selected value="">不限</OPTION>
      <c:forEach items="${hts}" var="houseType">
        <OPTION <c:if test="${house.houseType.htypeId == houseType.htypeId}">selected</c:if> value="${houseType.htypeId}">${houseType.htypeName}</OPTION>
      </c:forEach>
    </SELECT>
  </LI></UL></DD>
  <DD>
  <UL>
    <LI class=first>面积 </LI>
    <LI><SELECT name="floorageScore">
          <OPTION selected value="">不限</OPTION>
          <OPTION <c:if test="${house.floorageScore == '0-40'}">selected</c:if> value=0-40>40以下</OPTION>
          <OPTION <c:if test="${house.floorageScore == '40-100'}">selected</c:if> value=40-100>40-100</OPTION>
           <OPTION <c:if test="${house.floorageScore == '100-500'}">selected</c:if> value=100-500>100-500</OPTION>
          <OPTION <c:if test="${house.floorageScore == '500-1000000'}">selected</c:if> value=500-1000000>500以上</OPTION>
      </SELECT>
    </LI></UL></DD>
    <a href="${rt}/house/list.html">清除选择</a>
    <!-- 当前页数 -->
    <input id="pageNo" name="pageNo" type="hidden" value="${result.pageNo}"/>
  </FORM>
    </DL></DIV>
<DIV class="main wrap">
<TABLE class=house-list>
  <TBODY>

  <c:forEach items="${result.data}" var="pg" varStatus="i">
    <TR>
      <TD class=house-thumb><span><A href="${rt}/house/get.html?houseId=${pg.houseId}" target="_blank"><img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>
      <TD>
        <DL>
          <DT><A href="${rt}/house/get.html?houseId=${pg.houseId}" target="_blank">${pg.title}</A></DT>
          <DD>${pg.street.district.districtName}${pg.street.streetName},${pg.floorage}平米<BR>联系方式：${pg.houseUser.telephone} </DD></DL></TD>
      <TD class=house-type>${pg.houseType.htypeName}</TD>
      <TD class=house-price><SPAN>${pg.price}</SPAN>元/月</TD></TR>

  </c:forEach>


  <%--<TR class=odd>--%>
    <%--<TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>--%>
    <%--<TD>--%>
      <%--<DL>--%>
        <%--<DT><A href="details.jsp" target="_blank">大房子</A></DT>--%>
        <%--<DD>海淀区中关村大街,100平米<BR>联系方式：123456789 </DD></DL></TD>--%>
    <%--<TD class=house-type>一室一厅</TD>--%>
    <%--<TD class=house-price><SPAN>230.0</SPAN>元/月</TD></TR>--%>
  <%--<TR>--%>
    <%--<TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>--%>
    <%--<TD>--%>
      <%--<DL>--%>
        <%--<DT><A href="details.jsp" target="_blank">123</A></DT>--%>
        <%--<DD>海淀区中关村大街,123平米<BR>联系方式：123 </DD></DL></TD>--%>
    <%--<TD class=house-type>一室一厅</TD>--%>
    <%--<TD class=house-price><SPAN>123.0</SPAN>元/月</TD></TR>--%>
  <%--<TR class=odd>--%>
    <%--<TD class=house-thumb><span><A href="details.jsp" target="_blank"><img src="../images/thumb_house.gif" width="100" height="75" alt=""></a></span></TD>--%>
    <%--<TD>--%>
      <%--<DL>--%>
        <%--<DT><A href="details.jsp" target="_blank">jjjj</A></DT>--%>
        <%--<DD>海淀区中关村大街,123平米<BR>联系方式：ff </DD></DL></TD>--%>
    <%--<TD class=house-type>一室一厅</TD>--%>
    <%--<TD class=house-price><SPAN>123.0</SPAN>元/月</TD></TR>--%>
  <TR>无租房信息</TR></TBODY></TABLE>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:gotoFirst()">首页</A></LI>
  <LI><A href="javascript:gotoPrev()">上一页</A></LI>
  <LI><A href="javascript:gotoNext()">下一页</A></LI>
  <LI><A href="javascript:gotoLast()">末页</A></LI></UL>
  <SPAN class=total>${result.pageNo}/${result.pageCount}页</SPAN> <label>共${result.rowCount}条记录</label></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
<script type="application/javascript" src="${rt}/layui/layui.js"></script>
<script type="application/javascript" src="${rt}/js/jquery-1.12.4.js"></script>

<script>
    // layui.use(['layer', 'form','jquery'], function(){
    //     var layer = layui.layer
    //         ,$ = layui.jquery
    //         ,form = layui.form;

        function doSubmit(){
        gotoFirst();
    }
    function gotoFirst(){
        document.getElementById("pageNo").value = "1";
        document.getElementById("myForm").submit();
    }
    function gotoPrev(){
        var pageNo = document.getElementById("pageNo").value;
        if( pageNo > 1 ){
            document.getElementById("pageNo").value = parseInt(pageNo) - 1;
            document.getElementById("myForm").submit()
        }
    }
    function gotoNext(){
        var pageNo = document.getElementById("pageNo").value;
        if( pageNo < ${result.pageCount} ){
            document.getElementById("pageNo").value = parseInt(pageNo) + 1;
            document.getElementById("myForm").submit()
        }
    }
    function gotoLast(){
        document.getElementById("pageNo").value = "${result.pageCount}";
        document.getElementById("myForm").submit();
    }

    $("#myForm select").change(function () {
        $("#pageNo").val(1);
        $("#myForm").submit();
    });



    // });
</script>