function check() {
	var psw1 = form1.password1.value;
	var psw2 = form1.password2.value;
	if (psw1 =="" || psw2 =="") {
		alert("请输入密码！");
		return false;
	} else if (psw1 == psw2) {
		form1.submit();
		return true;
	} else {
		alert("两次密码不一致！");
		return false;
	}
}