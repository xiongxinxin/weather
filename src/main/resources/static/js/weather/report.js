/**
 * report页面下拉框事件 
 * author:xiong.xinxin
 */

$(function(){
	$("#selectCityId").change(function(){
		var cityId = $("#selectCityId").val();
		window.location.href = cityId;
	})
});