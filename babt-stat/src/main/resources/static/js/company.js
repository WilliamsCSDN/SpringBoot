function goPage(pageNo,start,end){
	var url='/company/listUser?pageNo='+pageNo+'&startTime='+start+'&endTime='+end;
	window.location.href=url;
}

function jumpPage(){
	var pageNo=$("#jumpWhere").find("option:selected").text();
	var startTime=$("#backStartTime").val();
	var endTime=$("#backEndTime").val();
	goPage(pageNo,startTime,endTime)
}

function search(){
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	if(startTime==null||endTime==null){
		alert('请选择开始时间和结束时间')
		return
	}
	if(startTime>endTime){
		alert('开始时间必须小于或等于结束时间')
		return ;
	}
	goPage(1,startTime,endTime)
}