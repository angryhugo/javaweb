function checkInsVehicle() {
	var model = form1.model.value;
	var color = form1.color.value;
	var manu = form1.manu.value;
	var price = form1.price.value;
	if (model == "") {
		alert("�ͺŲ���Ϊ�գ�");
		return false;
	} else if (color == "") {
		alert("��ɫ����Ϊ�գ�");
		return false;
	} else if (manu == "") {
		alert("�������̲���Ϊ�գ�");
		return false;
	} else if (price == "") {
		alert("�۸���Ϊ�գ�");
		return false;
	} else if (isNaN(price)) {
		alert("�۸����Ϊ���֣�");
		return false;
	} else {
		if (confirm("ȷ��¼�복����Ϣ��") == true) {
			form1.submit();
			return true;
		} else {
			return false;
		}
	}
}