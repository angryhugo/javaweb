function checkDelnull() {
	var name = form1.name.value;
	if (name == "") {
		alert("������Ҫɾ�����");
		return false;
	} 
	else 
	{
		if(confirm("ȷ��ɾ�� "+name+" ��")==true)
		{
			form1.submit();
			return true;
		}
		else
			return false;
	}
}