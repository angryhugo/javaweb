function doUpdSalesman() {
	var name = form2.name.value;
	var age = form2.age.value;
	var address = form2.address.value;
	var education = form2.education.value;
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
		if (confirm("ȷ���޸�Ա����Ϣ��") == true) {
			form2.submit();
			return true;
		} else {
			return false;
		}
	}
}