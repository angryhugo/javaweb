function doUpdCustomer() {
	var name = form2.name.value;
	var age = form2.age.value;
	var address = form2.address.value;
	var contact = form2.contact.value;
	if (name == "") {
		alert("�ͻ���������Ϊ�գ�");
		return false;
	} else if (isNaN(age)) {
		alert("�������Ϊ���֣�");
		return false;
	} else if (age == "") {
		alert("���������䣡");
		return false;
	} else if (contact == "") {
		alert("��������ϵ��ʽ��");
		return false;
	} else if (isNaN(contact)) {
		alert("��������ȷ����ϵ��ʽ��");
		return false;
	} else if (address == "") {
		alert("�������ַ��");
		return false;
	} else {
		if (confirm("ȷ���޸Ŀͻ���Ϣ��") == true) {
			form2.submit();
			return true;
		} else {
			return false;
		}
	}
}