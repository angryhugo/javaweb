function checkdate() {
	var date = form1.sdate.value;
	if (date == "") {
		alert("��ѡ�����ڣ�");
		return false;
	} else {
		if (confirm("ȷ��¼�����ۼ�¼��") == true) {
			form1.submit();
			return true;
		}
		else
			return false;
	}
}