function checkUpdPsw() {
	var opsw = form1.opsw.value;
	var npsw1 = form1.npsw1.value;
	var npsw2 = form1.npsw2.value;
	var regex=/^\w+$/ ;
	if (opsw == "") {
		alert("����������룡");
		return false;
	}else if (npsw1 == "" || npsw2=="") {
		alert("�����������룡");
		return false;
	}else if (npsw1 !=npsw2) {
		alert("���������벻һ�£�");
		return false;
	}else if (!npsw1.match(regex)) {
		alert("����ֻ������ĸ���ֺ��»�����ɣ�");
		return false;
	}else if (npsw1.length<6||npsw1.length>16) {
		alert("���볤��ֻ����6-16λ��");
		return false;
	}else if (opsw ==npsw1) {
		alert("�������������һ�£�");
		return false;
	} else {
		form1.submit();
		return true;
	}
}