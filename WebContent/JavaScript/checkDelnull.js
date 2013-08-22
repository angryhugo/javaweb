function checkDelnull() {
	var name = form1.name.value;
	if (name == "") {
		alert("请输入要删除的项！");
		return false;
	} 
	else 
	{
		if(confirm("确定删除 "+name+" 吗？")==true)
		{
			form1.submit();
			return true;
		}
		else
			return false;
	}
}