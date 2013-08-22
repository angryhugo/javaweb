$(document).ready(function() {
	$("tr").mouseover(function() {
		$(this).addClass("over");
	});

	$("tr").mouseout(function() {
		$(this).removeClass("over");
	});
	
	$("tr:even").addClass("even");
	
	$("#theTable").tablesorter({
		sortList:[[0,0]],//��һ��0��ʾ���յ�һ������ �ڶ���0��ʾ����(����1)
		cssAsc: "sortUp",
		cssDesc: "sortDown",
		widgets: ["zebra"]
	});
});
