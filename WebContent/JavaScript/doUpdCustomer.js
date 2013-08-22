function doUpdCustomer() {
	var name = form2.name.value;
	var age = form2.age.value;
	var address = form2.address.value;
	var contact = form2.contact.value;
	if (name == "") {
		alert("客户姓名不能为空！");
		return false;
	} else if (isNaN(age)) {
		alert("年龄必须为数字！");
		return false;
	} else if (age == "") {
		alert("请输入年龄！");
		return false;
	} else if (contact == "") {
		alert("请输入联系方式！");
		return false;
	} else if (isNaN(contact)) {
		alert("请输入正确的联系方式！");
		return false;
	} else if (address == "") {
		alert("请输入地址！");
		return false;
	} else {
		if (confirm("确定修改客户信息？") == true) {
			form2.submit();
			return true;
		} else {
			return false;
		}
	}
}