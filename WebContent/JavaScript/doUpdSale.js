function doUpdSale() {
	var sname = form2.sname.value;
	var cname= form2.cname.value;
	var vnum = form2.vnum.value;
	var sdate = form2.sdate.value;
	var amount = form2.amount.value;
	if (sname == "") {
		alert("����Ա����Ϊ�գ�");
		return false;
	} else if (cname =="") {
		alert("�ͻ�����Ϊ�գ�");
		return false;
	} else if (vnum == "") {
		alert("������Ų���Ϊ�գ�");
		return false;
	} else if (sdate == "") {
		alert("�������ڲ���Ϊ�գ�");
		return false;
	} else if (amount == "") {
		alert("��������Ϊ�գ�");
		return false;
	} else if (isNaN(amount)) {
		alert("��������Ϊ���֣�");
		return false;
	} else {
		if (confirm("ȷ���޸�������Ϣ��") == true) {
			form2.submit();
			return true;
		} else {
			return false;
		}
	}
}