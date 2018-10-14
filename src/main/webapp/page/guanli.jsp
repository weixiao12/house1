<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<LINK rel=stylesheet type=text/css href="${rt}/css/style.css">

<META name=GENERATOR ></HEAD>
<BODY>
<DIV id=header class=wrap>
<DIV id=logo><IMG src="../images/logo.gif"></DIV>
<DIV class=search><LABEL class="ui-green searchs"><a href="${rt}/house/gotoPubish.html" title="">发布房屋信息</a></LABEL>
  <LABEL class="ui-green searchs"><a href="${rt}/house/exit.html" title="">退出</a></LABEL>
</DIV>

  <FORM id="myForm" method=get action="${rt}/house/list.html">
  <!-- 当前页数 -->
    <input id="pageNo" name="pageNo" type="hidden" value="${result.pageNo}"/>
  </FORM>

</DIV>
<DIV class="main wrap">
<DIV id=houseArea>
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
      <TD class=house-price><SPAN>${pg.price}</SPAN>元/月</TD>
      <TD class=house-type><a href="${rt}/page/addPhotoInfo.jsp?houseId=${pg.houseId}" title="">图片管理</a></TD>
      <TD class=house-price> <a href="${rt}/house/gotoUpdate.html?houseId=${pg.houseId}" title="">修改|</a>
                              <a href="${rt}/house/delete.html?houseId=${pg.houseId}" title="">删除</a></TD>
    </TR>


  </c:forEach>

</TBODY>
</TABLE></DIV>
<DIV class=pager>
<UL>
  <LI class=current><A href="javascript:gotoFirst()">首页</A></LI>
  <LI><A href="javascript:gotoPrev()">上一页</A></LI>
  <LI><A href="javascript:gotoNext()">下一页</A></LI>
  <LI><A href="javascript:gotoLast()">末页</A></LI></UL>
  <SPAN class=total>${result.pageNo}/${result.pageCount}页</SPAN> <label>共${result.rowCount}条记录</label> </DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV></BODY></HTML>
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
