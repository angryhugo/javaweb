function checkdate() {
	var date = form1.sdate.value;
	if (date == "") {
		alert("请选择日期！");
		return false;
	} else {
		if (confirm("确定录入销售记录吗？") == true) {
			form1.submit();
			return true;
		}
		else
			return false;
	}
}