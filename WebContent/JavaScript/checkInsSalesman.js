function checkInsSalesman() {
	var name = form1.name.value;
	var age = form1.age.value;
	var address = form1.address.value;
	var education = form1.education.value;
	if (name == "") {
		alert("Ա����������Ϊ�գ�");
		return false;
	} else if (isNaN(age)) {
		alert("�������Ϊ���֣�");
		return false;
	} else if (age == "") {
		alert("���������䣡");
		return false;
	} else if (address == "") {
		alert("�����뼮�ᣡ");
		return false;
	} else if (education == "") {
		alert("������ѧ����");
		return false;
	} else {
		if (confirm("ȷ��¼��Ա����Ϣ��") == true) {
			form1.submit();
			return true;
		} else {
			return false;
		}
	}
}