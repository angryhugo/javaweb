$(document).ready(function() {
	$("tr").mouseover(function() {
		$(this).addClass("over");
	});

	$("tr").mouseout(function() {
		$(this).removeClass("over");
	});
	
	$("tr:even").addClass("even");
	
	$("#theTable").tablesorter({
		sortList:[[0,0]],//第一个0表示按照第一列排序 第二个0表示升序(降序：1)
		cssAsc: "sortUp",
		cssDesc: "sortDown",
		widgets: ["zebra"]
	});
});
