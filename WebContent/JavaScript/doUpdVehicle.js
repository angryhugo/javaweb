function doUpdVehicle() {
	var model = form2.model.value;
	var color = form2.color.value;
	var manu = form2.manu.value;
	var date = form2.date.value;
	var price = form2.price.value;
	if (model == "") {
		alert("型号不能为空！");
		return false;
	} else if (color =="") {
		alert("颜色不能为空！");
		return false;
	} else if (manu == "") {
		alert("生产厂商不能为空！");
		return false;
	} else if (date == "") {
		alert("出厂年份不能为空！");
		return false;
	} else if (isNaN(date)) {
		alert("出厂年份必须为数字！");
		return false;
	} else if (date<2000 || date>2013) {
		alert("请输入有效的出厂年份！");
		return false;
	} else if (price == "") {
		alert("价格不能为空！");
		return false;
	} else if (isNaN(price)) {
		alert("价格必须为数字！");
		return false;
	} else {
		if (confirm("确定修改车辆信息？") == true) {
			form2.submit();
			return true;
		} else {
			return false;
		}
	}
}