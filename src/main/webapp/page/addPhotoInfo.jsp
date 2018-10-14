<%@ page language="java" pageEncoding="UTF-8"%>

<style>
	#choosePhotoDiv{
		position: relative;
	}
	#choosePhotoDiv img{width:50px;}
	#choosePhotoDiv input{
		width:50px;height:50px;cursor:pointer;
		position:absolute;left:0;top:0;opacity:0;
	}
	#photoPreview{overflow: hidden;}
	#photoPreview img{
		max-width:100px;float:left;margin:10px;
	}
</style>
<form action="${rt}/house/addPic.html" method="post">
	<div id="choosePhotoDiv">
		<input id="photoFile" type="file" multiple="multiple" onchange="doFileChange(this)"/>
		<img src="${rt}/imgs/camera.png"/>
	</div>
	<img id="loading" src="${rt}/imgs/loading.gif" width="100" style="display:none;'"/>
	<div id="photoPreviewCommit"></div>

	<input type="hidden" name="houseId" value="${param['houseId']}"/>
	<input type="submit" value="提交"/>
</form>
<div id="photoPreview"></div>
<script src="${rt}/js/jquery.min.js"></script>
<script src="${rt}/js/lrz/lrz.bundle.js"></script>
<script>
	function doFileChange(fileElm){
		for(var i = 0; i<fileElm.files.length; i++){
			lrz(fileElm.files[i], {width:900}).then(function(resultObj){
				$("#photoPreview").append("<img src='"+ resultObj.base64 +"'/>");
				$("#photoPreviewCommit").append("<input type='hidden' name='imgBase64' value='"+resultObj.base64+"'/>");
			});
		}
	}

// 	function doFileChange(fileElm){
// 		var reader = new FileReader();
// 		var index = 0;
		
// 		$("#loading").show();
		
// 		reader.onload = function(e){
// 			//获得文件的内容
// 			console.log(index);
// 			//base64 -->  图片的内容，字符串格式
// 			$("#photoPreview").append("<img src='"+ e.target.result +"'/>");
// 			index++;
			
// 			if(index < fileElm.files.length){
// 				reader.readAsDataURL(fileElm.files[index]);
// 			}else{
// 				$("#loading").hide();
// 			}
			
// 		}
		
// 		reader.readAsDataURL(fileElm.files[index]);
		
// 		var reader = new FileReader();
// 		reader.onload = function(e){
// 			$("#photoPreview").append("<img src='"+ e.target.result +"'/>");
//         	//console.log(e.target.result);
// 			console.log(1111);
// 		}
		
// 		for(var i = 0; i<fileElm.files.length; i++){
// 			reader.readAsDataURL(fileElm.files[i]);
// 		}
// 	}
</script>