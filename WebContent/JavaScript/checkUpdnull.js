function checkUpdnull() {
	var id = form1.id.value;
	if (id == "") {
		alert("������Ҫ�޸ĵ��");
		return false;
	} else {
		form1.submit();
		return true;
	}
}