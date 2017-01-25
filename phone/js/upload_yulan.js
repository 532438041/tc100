// JavaScript Document
$(document).ready(function(){  
			$("body").append('<form action="" method="post" id="upchuan0">');
			$("body").append('<form action="" method="post" id="upchuan1">');
			
			for(var i=0;i<=1;i++){
			$("#upchuan"+i).append('<input id='+"upload"+ i +' type="file" accept="image/jpeg,image/bmp" />');
			$("#upchuan"+i).append('<input id='+"sub"+ i +' type="submit" name='+"name"+ i +' />');
			}
			
			$("#sixcm1").click(function(){
				fileSelect(sixcm,'#upload'+0);
			});
			$("#sixcun").click(function(){
				fileSelect(sixcm,'#upload'+0);
			});
			$("#tencm1").click(function(){
				fileSelect2(tencm,'#upload'+1);
			});
			$("#tencun").click(function(){
				fileSelect2(tencm,'#upload'+1);
			});
	 
  	function fileSelect(id1,id2) {
        $(id2).click(); 
		 $(function() {
		 $(id2).change(function(e) {
		 var file = e.target.files[0]
		 preview1(file)
		 })
		 })
		function preview1(file) {
		 var img = new Image();
		 var url = img.src = URL.createObjectURL(file);
		 var $img = $(img);
		 
		 img.onload = function() {
		 URL.revokeObjectURL(url);
		 $(id1).empty();
		 $(id1).append($img);
		 $(id1).css("background","#fff");
		 if(img.width>=img.height){
			$(img).width("80%");
			var top = ($("#sixcm").height()-$(img).height())/2 +"px";
			$(img).css("paddingTop",top)
		 }else{
			$(img).height("80%");
			$(img).css("paddingTop","10%");
		 }
		 
		 }
		 }
		 function preview2(file) {
		 var reader = new FileReader()
		 reader.onload = function(e) {
		 var $img = $('<img>').attr("src", e.target.result);
		 $(id1).empty().append($img);
		 }
		 reader.readAsDataURL(file)
		 }
	};
	function fileSelect2(id1,id2) {
        $(id2).click(); 
		 $(function() {
		 $(id2).change(function(e) {
		 var file = e.target.files[0]
		 preview3(file)
		 })
		 })
		function preview3(file) {
		 var img = new Image();
		 var url = img.src = URL.createObjectURL(file);
		 var $img = $(img);
		 
		 img.onload = function() {
		 URL.revokeObjectURL(url);
		 $(id1).empty();
		 $(id1).append($img);
		 $(id1).css("background","#fff");
		 if(img.width>=img.height){
			$(img).width("80%");
			var top = ($("#sixcm").height()-$(img).height())/2 +"px";
			$(img).css("paddingTop",top)
		 }else{
			$(img).height("80%");
			$(img).css("paddingTop","10%");
		 }
		 
		 }
		 }
		 function preview2(file) {
		 var reader = new FileReader()
		 reader.onload = function(e) {
		 var $img = $('<img>').attr("src", e.target.result);
		 $(id1).empty().append($img);
		 }
		 reader.readAsDataURL(file)
		 }
	};
	
	  
});
