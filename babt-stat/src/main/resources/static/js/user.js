function goPage(pageNo,companyId,start,end){
	var url='/user/list?pageNo='+pageNo+'&startTime='+start+'&endTime='+end+'&companyId='+companyId;
	window.location.href=url;
}

function jumpPage(){
	var pageNo=$("#jumpWhere").find("option:selected").text();
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	var companyId=$("#companyId").val();
	goPage(pageNo,companyId,startTime,endTime)
}

function search(){
	var startTime=$("#startTime").val();
	var endTime=$("#endTime").val();
	var companyId=$("#companyId").val();
	if(startTime==null||endTime==null){
		alert('请选择开始时间和结束时间')
		return
	}
	if(startTime>endTime){
		alert('开始时间必须小于或等于结束时间')
		return ;
	}
	goPage(1,companyId,startTime,endTime)
}

function searchLine(userId,companyId,dutyDate){
	var companyId=$("#currCompId").val();
	var userId=$("#currUserId").val();
	var dutyDate=$("#dutyDate").val();
	var url='/user/lines?dutyDate='+dutyDate+'&companyId='+companyId+'&userId='+userId;
	window.location.href=url;
}


function post(URL, PARAMS) {
	  var temp = document.createElement("form");
	  temp.action = URL;
	  temp.method = "post";
	  temp.style.display = "none";
	  for (var x in PARAMS) {
	    var opt = document.createElement("textarea");
	    opt.name = x;
	    opt.value = PARAMS[x];
	    // alert(opt.name)
	    temp.appendChild(opt);
	  }
	  document.body.appendChild(temp);
	  temp.submit();
	  return temp;
}

function jumpPage4check(){
	var pageNo=$("#jumpWhere").find("option:selected").text();
	var url='/check/list?pageNo='+pageNo;
	window.location.href=url;
}


