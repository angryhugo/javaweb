function check() {
	var rdolist = form1.RadioGroup1;
	var user = form1.username.value;
	var psw = form1.password.value;
	if (user == "" || psw == "") {
		alert("�������û������룡");
		return false;
	} else {
		for ( var i = 0; i < rdolist.length; i++) {
			if (rdolist[i].checked) {
				url= rdolist[i].value;
				document.forms[0].action=url;
				form1.submit();
				//window.location.href = rdolist[i].value;
				return true;
			}
		}
	}
}