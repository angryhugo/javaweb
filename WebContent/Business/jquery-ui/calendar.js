$(function() {
	var dates = $("#sdate").datepicker({
		defaultDate: "-1w",//ǰһ���·ݿ�ʼ
		numberOfMonths: 2,//��ʾ�����ĸ���
		onSelect: function(selectedDate) {
			var option = (this.id == "sdate") ? "minDate" : "maxDate",
			date = $.datepicker.parseDate($.datepicker._defaults.dateFormat, selectedDate);
			dates.not(this).datepicker("option", option, date);
		}
	});
});
