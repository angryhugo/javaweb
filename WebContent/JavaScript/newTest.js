function check() {
	var psw1 = form1.password1.value;
	var psw2 = form1.password2.value;
	if (psw1 =="" || psw2 =="") {
		alert("���������룡");
		return false;
	} else if (psw1 == psw2) {
		form1.submit();
		return true;
	} else {
		alert("�������벻һ�£�");
		return false;
	}
}