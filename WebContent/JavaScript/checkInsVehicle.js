function checkInsVehicle() {
	var model = form1.model.value;
	var color = form1.color.value;
	var manu = form1.manu.value;
	var price = form1.price.value;
	if (model == "") {
		alert("型号不能为空！");
		return false;
	} else if (color == "") {
		alert("颜色不能为空！");
		return false;
	} else if (manu == "") {
		alert("生产厂商不能为空！");
		return false;
	} else if (price == "") {
		alert("价格不能为空！");
		return false;
	} else if (isNaN(price)) {
		alert("价格必须为数字！");
		return false;
	} else {
		if (confirm("确定录入车辆信息？") == true) {
			form1.submit();
			return true;
		} else {
			return false;
		}
	}
}