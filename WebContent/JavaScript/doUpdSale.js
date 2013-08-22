function doUpdSale() {
	var sname = form2.sname.value;
	var cname= form2.cname.value;
	var vnum = form2.vnum.value;
	var sdate = form2.sdate.value;
	var amount = form2.amount.value;
	if (sname == "") {
		alert("销售员不能为空！");
		return false;
	} else if (cname =="") {
		alert("客户不能为空！");
		return false;
	} else if (vnum == "") {
		alert("车辆编号不能为空！");
		return false;
	} else if (sdate == "") {
		alert("销售日期不能为空！");
		return false;
	} else if (amount == "") {
		alert("数量不能为空！");
		return false;
	} else if (isNaN(amount)) {
		alert("数量必须为数字！");
		return false;
	} else {
		if (confirm("确定修改销售信息？") == true) {
			form2.submit();
			return true;
		} else {
			return false;
		}
	}
}