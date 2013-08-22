function checkUpdPsw() {
	var opsw = form1.opsw.value;
	var npsw1 = form1.npsw1.value;
	var npsw2 = form1.npsw2.value;
	var regex=/^\w+$/ ;
	if (opsw == "") {
		alert("请输入旧密码！");
		return false;
	}else if (npsw1 == "" || npsw2=="") {
		alert("请输入新密码！");
		return false;
	}else if (npsw1 !=npsw2) {
		alert("两次新密码不一致！");
		return false;
	}else if (!npsw1.match(regex)) {
		alert("密码只能由字母数字和下划线组成！");
		return false;
	}else if (npsw1.length<6||npsw1.length>16) {
		alert("密码长度只能在6-16位！");
		return false;
	}else if (opsw ==npsw1) {
		alert("新密码与旧密码一致！");
		return false;
	} else {
		form1.submit();
		return true;
	}
}