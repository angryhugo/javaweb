function checkUpdnull() {
	var id = form1.id.value;
	if (id == "") {
		alert("请输入要修改的项！");
		return false;
	} else {
		form1.submit();
		return true;
	}
}