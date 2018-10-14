layui.use(['layer', 'form','jquery'], function(){
    var layer = layui.layer
        ,$ = layui.jquery
        ,form = layui.form;

    //ContextPath
    var rt = $("#rt").val();

    //切换验证码
    $(".very img, .very a").click(function () {
        $(".code").attr("src","../code.jpg?t="+new Date());
    });

    //表单验证
    form.verify({
        username: function(value, item){ //value：表单的值、item：表单的DOM对象
            if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]{4,}$").test(value)){
                return '用户名不能有特殊字符';
            }
            if(/(^\_)|(\__)|(\_+$)/.test(value)){
                return '用户名首尾不能出现下划线\'_\'';
            }
            if(/^\d+\d+\d$/.test(value)){
                return '用户名不能全为数字';
            }
        }

        //我们既支持上述函数式的方式，也支持下述数组的形式
        //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
        ,pass: [
            /^[\S]{6,18}$/
            ,'密码必须6到18位，且不能出现空格'
        ]
        ,verycode: [
            /^[a-zA-Z0-9]{4,5}$/
            ,'验证码为4到5位的字母数字组成'
        ]
    });

    //登录表单监听（submit）事件
    form.on('submit(login)', function(data){
        // console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
        // console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        var params = data.field; //当前容器的全部表单字段，名值对形式：{name: value}

        var index = layer.load(1, {
            shade: [0.1,'black'] //0.1透明度的白色背景
        });

        $.ajax({
            url:rt+"/user/login.html",
            data:params,
            type:"POST",
            dataType:"JSON",
            success:function (re) {
               if( re.result == "1000" ){
                   layer.tips('验证码错误', '.verycode',{
                       tips:[4,'red']
                   });
               }else if( re.result == "1001" ){
                    layer.msg("用户名或密码错误",{icon : 5});
                }else if( re.result == "1002" ){
                    location.href= rt+"/house/list.html";
               }
            },error:function () {
                layer.msg("服务器错误",{icon: 5});
            },complete:function () {
                layer.close(index);
                $(".code").click();
            }
        });

        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

});