function checkInsCustomer() {
	var name = form1.name.value;
	var age = form1.age.value;
	var address = form1.address.value;
	var contact = form1.contact.value;
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
	}  else if (isNaN(contact)) {
		alert("��������ȷ����ϵ��ʽ��");
		return false;
	}else if (address == "") {
		alert("�������ַ��");
		return false;
	} else {
		if (confirm("ȷ��¼��ͻ���Ϣ��") == true) {
			form1.submit();
			return true;
		} else {
			return false;
		}
	}
}