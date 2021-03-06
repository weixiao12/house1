layui.use(['layer', 'form','jquery','laydate'], function() {
    var layer = layui.layer
        , $ = layui.jquery
        ,laydate = layui.laydate
        , form = layui.form;

    laydate.render({
        elem: '#pubDate' //指定元素
    });

});



    var streetArr = new Array();
$(function () {
    var rt = $("#rt").val();
    var url =  rt+"/district/getAll.html";
    $.post( url, null, function (data) {
            var districtId = $("#districtId").val();
            for(var i=0; i < data.length; i++){
                    if( districtId == data[i].districtId ){
                        $("#district").append("<OPTION selected value='"+data[i].districtId+"'>"+data[i].districtName+"</OPTION>");
                    }else {
                    $("#district").append("<OPTION  value='"+data[i].districtId+"'>"+data[i].districtName+"</OPTION>");
                    }
                    streetArr['d_'+data[i].districtId] = data[i].streets;
            }
    },"json" );
});

    $("#district").change(function () {
        $("#street option").remove();
        var index = 'd_'+$(this).val();
        var streets = streetArr[index];
        $("#street").append("<OPTION value=''>请选择</OPTION>");
        for( var i = 0; i < streets.length; i++ ){
            $("#street").append("<OPTION value='"+streets[i].streetId+"'>"+streets[i].streetName+"</OPTION>");
        }
    });
