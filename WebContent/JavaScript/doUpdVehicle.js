function doUpdVehicle() {
	var model = form2.model.value;
	var color = form2.color.value;
	var manu = form2.manu.value;
	var date = form2.date.value;
	var price = form2.price.value;
	if (model == "") {
		alert("�ͺŲ���Ϊ�գ�");
		return false;
	} else if (color =="") {
		alert("��ɫ����Ϊ�գ�");
		return false;
	} else if (manu == "") {
		alert("�������̲���Ϊ�գ�");
		return false;
	} else if (date == "") {
		alert("������ݲ���Ϊ�գ�");
		return false;
	} else if (isNaN(date)) {
		alert("������ݱ���Ϊ���֣�");
		return false;
	} else if (date<2000 || date>2013) {
		alert("��������Ч�ĳ�����ݣ�");
		return false;
	} else if (price == "") {
		alert("�۸���Ϊ�գ�");
		return false;
	} else if (isNaN(price)) {
		alert("�۸����Ϊ���֣�");
		return false;
	} else {
		if (confirm("ȷ���޸ĳ�����Ϣ��") == true) {
			form2.submit();
			return true;
		} else {
			return false;
		}
	}
}