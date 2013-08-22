function doUpdSalesman() {
	var name = form2.name.value;
	var age = form2.age.value;
	var address = form2.address.value;
	var education = form2.education.value;
	if (name == "") {
		alert("员工姓名不能为空！");
		return false;
	} else if (isNaN(age)) {
		alert("年龄必须为数字！");
		return false;
	} else if (age == "") {
		alert("请输入年龄！");
		return false;
	} else if (address == "") {
		alert("请输入籍贯！");
		return false;
	} else if (education == "") {
		alert("请输入学历！");
		return false;
	} else {
		if (confirm("确定修改员工信息？") == true) {
			form2.submit();
			return true;
		} else {
			return false;
		}
	}
}